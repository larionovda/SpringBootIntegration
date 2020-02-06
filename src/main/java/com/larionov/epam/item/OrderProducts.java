package com.larionov.epam.item;

public class OrderProducts {
    private Long orderId;
    private Long productId;
    private int count;

    public OrderProducts(Long orderId, Long productId, int count) {
        this.orderId = orderId;
        this.productId = productId;
        this.count = count;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
