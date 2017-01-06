package com.kind.common.task;

import com.kind.common.task.dto.HotelAmountDto;

/**
 * Created by weiguo.liu on 2017/1/6.
 */
public class HotelService {
    private HotelService() {
    }

    private static class HotelServiceHolder {
        private static HotelService bean = new HotelService();
    }

    public static HotelService getBean() {
        return HotelServiceHolder.bean;
    }

    public HotelAmountDto calculate(Integer price, Integer quantity) {
        HotelAmountDto hotelAmount = new HotelAmountDto();
        hotelAmount.setHotelAmount(price * quantity);
        return hotelAmount;
    }
}
