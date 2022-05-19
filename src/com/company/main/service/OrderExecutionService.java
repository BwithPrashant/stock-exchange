package com.company.main.service;

import com.company.main.model.ExecutionReport;
import com.company.main.model.Order;
import com.company.main.reportGeneratorClient.ReportGenerator;
import com.company.main.reportGeneratorClient.internal.ConsoleReportGenerator;

import java.util.LinkedList;

public class OrderExecutionService {
    //It contains list of sell orders sorted on price in ascending. If price is same, sort on timestamp in ascending order.
    LinkedList<Order> sellOrders;

    //It contains list of buy orders sorted on price in descending. If price is same, sort on timestamp in ascending order.
    LinkedList<Order> buyOrders;

    // Interface to send report. Here we have injected console report generator to output the report to sysout.
    // We can extend further to send report to a file or external system.
    ReportGenerator reportGenerator;

    public OrderExecutionService(){
        sellOrders = new LinkedList<Order>();
        buyOrders = new LinkedList<Order>();
        reportGenerator = new ConsoleReportGenerator();
    }

    public void addOrder(Order order){
        switch (order.getOrderType()){
            case BUY: executeBuyOrder(order);break;
            case SELL: executeSellOrder(order);break;
            default:return;
        }
    }

    /*
        Buy order tries to match with the seller orders available and execute the sell.
        If Buy is partially/ fully executed ,generate report to console
        If Buy is partially executed , add it to the buyOrderList , which can be processed when a sell order arrives.
    */
    private void executeBuyOrder(Order buyOrder){

        int i=0;
        while(buyOrder.getQuantity() > 0 && sellOrders.size() > 0 && i< sellOrders.size()){

            Order sellOrder = sellOrders.get(i++);
            if(!sellOrder.getStock().equals(buyOrder.getStock())){
                break;
            }
            if(sellOrder.getPrice() > buyOrder.getPrice()){
                break;
            }
            int quantityDiff = buyOrder.getQuantity() - sellOrder.getQuantity();
            if(quantityDiff >= 0){
                ExecutionReport executionReport = new ExecutionReport(buyOrder.getOrderId(),sellOrder.getPrice(), sellOrder.getQuantity(),
                        sellOrder.getOrderId());
                reportGenerator.sendReport(executionReport);
                sellOrders.remove(sellOrder);
                buyOrder.setQuantity(quantityDiff);
            }else{
                ExecutionReport executionReport = new ExecutionReport(buyOrder.getOrderId(),sellOrder.getPrice(), buyOrder.getQuantity(),
                        sellOrder.getOrderId());
                reportGenerator.sendReport(executionReport);
                sellOrder.setQuantity(0-quantityDiff);
                buyOrder.setQuantity(0);
            }
        }

        if(buyOrder.getQuantity() > 0){
            insertInBuyOrders(buyOrders, buyOrder);
        }
    }

    /*
        Sell order tries to match with the buy orders available and execute the sell.
        If Sell is partially/ fully executed ,generate report to console
        If Sell has still stock quantity available , add it to the sellOrderList , which can be processed when a sell order arrives.
    */
    private void executeSellOrder(Order sellOrder){

        int i=0;
        while(sellOrder.getQuantity()>0 && buyOrders.size()>0 && i< buyOrders.size()){
            Order buyOrder = buyOrders.get(i);
            if(!sellOrder.getStock().equals(buyOrder.getStock())){
                break;
            }
            if(buyOrder.getPrice() < sellOrder.getPrice()){
                break;
            }

            int quantityDiff = buyOrder.getQuantity() - sellOrder.getQuantity();
            if(quantityDiff <= 0){
                ExecutionReport executionReport = new ExecutionReport(buyOrder.getOrderId(),sellOrder.getPrice(), buyOrder.getQuantity(),
                        sellOrder.getOrderId());
                reportGenerator.sendReport(executionReport);
                buyOrders.remove(buyOrder);
                sellOrder.setQuantity(0-quantityDiff);
            }else{
                ExecutionReport executionReport = new ExecutionReport(buyOrder.getOrderId(),sellOrder.getPrice(), sellOrder.getQuantity(),
                        sellOrder.getOrderId());
                reportGenerator.sendReport(executionReport);
                buyOrder.setQuantity(quantityDiff);
                sellOrder.setQuantity(0);
                break;
            }
        }
        if(sellOrder.getQuantity() > 0){
            insertInSellOrders(sellOrders, sellOrder);
        }
    }

    // Insert a buy order in already sorted buyorders list
    private void insertInBuyOrders(LinkedList<Order> list , Order order){
        if (list.size() == 0) {
            list.add(order);
            return;
        }
        int i = list.size()-1;
        while (i>=0 && list.get(i).getPrice() < order.getPrice()) {
            i--;
        }
        list.add(i+1, order);
    }

    // Insert a sell order in already sorted sellorders list
    private void insertInSellOrders(LinkedList<Order> list , Order order){
        if (list.size() == 0) {
            list.add(order);
            return;
        }
        int i = list.size()-1;
        while (i>=0 && list.get(i).getPrice() > order.getPrice()) {
            i--;
        }
        list.add(i+1, order);
    }
}
