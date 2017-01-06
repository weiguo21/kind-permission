package com.kind.common.exception;

/**
 * Created by weiguo.liu on 2017/1/6.
 */
public enum ExceptionCode {
    UNDEF_ERROR("500", "不好意思,系统繁忙,请稍后再试!"),
    REMOTE_INVOKE("0001", "【%s】接口调用异常，接口地址【%s】！"),
    NO_MATCH_ORDER_BY_NO("0004", "订单号为%s的订单不存在"),
    NO_MATCH_ORDER_BY_ID("0005", "订单ID为%s的订单不存在"),
    NO_MATCH_ORDERMAIN_BY_ID("0005", "订单ID为%s的订单的主订单不存在"),
    NOT_FLIGHT_POLICY_SUPP("0006", "没有此供应商ID为%s的政策信息"),
    NOT_CARRIER("0007", "没有此承运人编码为%s的信息"),
    NO_MATCH_ORDER_OP_STATUS("0008", "订单操作状态%s不存在"),
    NO_MATCH_GOODS_TIME_PRICE("0012", "商品时间价格表无数据"),
    NO_MATCH_ORDER_BY_STATUS("0010", "订单状态不满足支付要求"),
    UNDEF_REMOTE_INVOKE("0012", "接口调用异常，接口地址【%s】！%s"),
    //退款1800-1900
    REFUND_FAIL("1801", "%s"),
    REFUND_FAIL_CALLBACK("1802", "%s"),

    //禁售规则
    SALES_RULE_DISABLE_FAIL("2100", "%s"),

    //支付1900-1999
    TO_PAY_FAIL("1901", "保存支付信息失败,%s"),
    PAYMENT_OUT_OF_TIME("1902", "支付超时，%s"),
    PAYMENT_CALlBACK_FAIL("1903", "%s"),
    RISK_CUSTOMER_BLACK_LIST_ERROR("2001", "该会员%s未支付订单过多,禁止继续下单,请尽快支付或取消!"),
    NOT_CUSTOMER_ORDER_ERROR("2002", "禁止非会员下单,请先登录!");

    private ExceptionCode(String code, String messageFmt) {
        this.code = code;
        this.messageFmt = messageFmt;
    }

    /**
     * 编码
     */
    private String code;

    /**
     * 消息格式字符串
     */
    private String messageFmt;

    public String errMessage(Object... vars) {
        return String.format(this.messageFmt, vars);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessageFmt() {
        return messageFmt;
    }

    public void setMessageFmt(String messageFmt) {
        this.messageFmt = messageFmt;
    }

    public static void main(String[] args) {
        System.out.println(ExceptionCode.REFUND_FAIL.errMessage());
    }
}
