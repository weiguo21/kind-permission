package com.kind.common.task;

import com.kind.common.task.dto.FlightAmountDto;

/**
 * Created by weiguo.liu on 2017/1/6.
 */
public class FlightService {
    private FlightService() {
    }

    static class FlightServiceHolder {
        static FlightService bean = new FlightService();
    }

    public static FlightService getBean() {
        return FlightServiceHolder.bean;
    }

    public FlightAmountDto calculate(Integer price, Integer quantity) {
        FlightAmountDto flightAmount = new FlightAmountDto();
        flightAmount.setFlightAmount(price * quantity);
        return flightAmount;
    }
}
