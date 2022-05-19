package com.company.main.model;

import com.company.main.enums.OrderType;

// Pojo class for sell and buy order
public class Order {
    String orderId;
    String time;
    String stock;
    OrderType orderType;
    double price;
    int quantity;

    public Order(String orderId, String time, String stock, OrderType orderType, double price, int quantity) {
        this.orderId = orderId;
        this.time = time;
        this.stock = stock;
        this.orderType = orderType;
        this.price = price;
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
