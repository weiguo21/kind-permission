package com.kind.common.task.dto;

/**
 * Created by weiguo.liu on 2017/1/6.
 */
public class TotalAmountDto {
    private Integer hotelAmount;
    private Integer flightAmount;
    private Integer totalAmount;

    public Integer getHotelAmount() {
        return hotelAmount;
    }

    public void setHotelAmount(Integer hotelAmount) {
        this.hotelAmount = hotelAmount;
    }

    public Integer getFlightAmount() {
        return flightAmount;
    }

    public void setFlightAmount(Integer flightAmount) {
        this.flightAmount = flightAmount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
}
