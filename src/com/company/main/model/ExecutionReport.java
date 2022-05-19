package com.company.main.model;

// Pojo class for output of sell/buy orders
public class ExecutionReport {
    private String buyOrderId;
    private double sellPrice;
    private int quantity;
    private String sellOrderId;

    public ExecutionReport(String buyOrderId, double sellPrice, int quantity, String sellOrderId) {
        this.buyOrderId = buyOrderId;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
        this.sellOrderId = sellOrderId;
    }

    public String getBuyOrderId() {
        return buyOrderId;
    }

    public void setBuyOrderId(String buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSellOrderId() {
        return sellOrderId;
    }

    public void setSellOrderId(String sellOrderId) {
        this.sellOrderId = sellOrderId;
    }

    @Override
    public String toString() {
        return buyOrderId + " " + sellPrice + " " + quantity + " " + sellOrderId;
    }
}
