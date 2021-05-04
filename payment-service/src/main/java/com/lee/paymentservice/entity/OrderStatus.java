package com.lee.paymentservice.entity;

/**
 * 订单状态
 * @author Lee
 * @version 1.0
 * @date 2021/5/3 17:41
 */
public enum OrderStatus {
    /**
     * 已取消
     */
    CANCLED,
    /**
     * 未支付
     */
    NON_PAYMENT,
    /**
     * 已支付
     */
    PAYMENT,
    /**
     * 已发货
     */
    DISPATCH,
    /**
     * 已收货
     */
    INSPECT,
    /**
     * 已完成
     */
    FINISH,
    /**
     * 待退款
     */
    NON_REFUND,
    /**
     * 已退款
     */
    REFUND
}
