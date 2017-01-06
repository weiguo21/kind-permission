package com.kind.common.task;

import com.kind.common.task.dto.FlightAmountDto;
import com.kind.common.task.dto.HotelAmountDto;
import com.kind.common.task.dto.ShoppingDto;
import com.kind.common.task.dto.TotalAmountDto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weiguo.liu on 2017/1/6.
 */
public class CalculateService {
    static final String HOTEL_KEY = "hotel_param";
    static final String FLIGHT_KEY = "flight_param";
    private FlightService flightService;
    private HotelService hotelService;

    public TaskMainGroup<TotalAmountDto> calculatePriceTaskGroup(final TaskContext context) {
        flightService = FlightService.getBean();
        hotelService = HotelService.getBean();
        TaskMainGroup<TotalAmountDto> taskMainGroup = new TaskMainGroup<TotalAmountDto>();
        //生成算价任务
        @SuppressWarnings("unchecked")
        final Map<String, Object> taskMap = (Map<String, Object>) context.get("taskMap");
        for (Map.Entry<String, Object> entry : taskMap.entrySet()) {
            final String taskName = entry.getKey();
            final Object request = entry.getValue();
            taskMainGroup.addTask(new Task<Boolean>() {
                @Override
                public Boolean execute(TaskContext context) {
                    ShoppingDto shoppingDto = (ShoppingDto) request;
                    if ("F".equalsIgnoreCase(shoppingDto.getType())) {
                        FlightAmountDto flightAmount = flightService.calculate(shoppingDto.getPrice(), shoppingDto.getQuantity());
                        context.put(taskName, flightAmount);
                    }
                    if ("H".equalsIgnoreCase(shoppingDto.getType())) {
                        HotelAmountDto hotelAmount = hotelService.calculate(shoppingDto.getPrice(), shoppingDto.getQuantity());
                        context.put(taskName, hotelAmount);
                    }
                    return true;
                }
            });
        }
        taskMainGroup.putContext(context).putGetResult(new Task<TotalAmountDto>() {
            @Override
            public TotalAmountDto execute(TaskContext context) {
                FlightAmountDto flightAmountDto = (FlightAmountDto) context.get(FLIGHT_KEY);
                HotelAmountDto hotelAmountDto = (HotelAmountDto) context.get(HOTEL_KEY);
                TotalAmountDto totalAmountDto = new TotalAmountDto();
                totalAmountDto.setHotelAmount(hotelAmountDto.getHotelAmount());
                totalAmountDto.setFlightAmount(flightAmountDto.getFlightAmount());
                totalAmountDto.setTotalAmount(hotelAmountDto.getHotelAmount() + flightAmountDto.getFlightAmount());
                return totalAmountDto;
            }
        });

        return taskMainGroup;
    }

    public TotalAmountDto calculate() {
        final TaskContext context = new TaskContext();
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put(HOTEL_KEY, new ShoppingDto("H", 200, 3));
        paramsMap.put(FLIGHT_KEY, new ShoppingDto("F", 1000, 2));
        context.put("taskMap", paramsMap);
        // 2. 生成算价任务组
        TaskMainGroup<TotalAmountDto> taskMainGroup = this.calculatePriceTaskGroup(context);

        //3. 并发执行算价任务组
        TotalAmountDto totalAmountDto = taskMainGroup.getResult(paramsMap.keySet().size());

        if (totalAmountDto == null) {
            System.out.println("ERROR:计算价格发生异常");
        }
        return totalAmountDto;
    }

    public static void main(String[] args) {
        TotalAmountDto total = new CalculateService().calculate();
        System.out.println(String.format("总价=%s,酒店价格=%s,机票价格=%s", total.getTotalAmount(), total.getHotelAmount(), total.getFlightAmount()));
    }
}
