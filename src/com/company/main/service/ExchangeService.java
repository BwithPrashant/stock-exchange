package com.company.main.service;

import com.company.main.model.Order;
import com.company.main.enums.OrderType;

import static com.company.main.exceptions.ExceptionConstants.*;

public class ExchangeService {

    private static final int INPUT_DATA_LENGTH = 6;

    OrderExecutionService orderExecutionService;

    public ExchangeService(){
        orderExecutionService = new OrderExecutionService();
    }

    private Order parseDate(String data){

        String[] splited = data.split("\\s+");

        //input string validation

        if(splited.length != INPUT_DATA_LENGTH){
            System.out.println("Exception : "+ LESS_ARGS);
            return null;
        }
        String orderId = splited[0];
        String time = splited[1];
        String stock = splited[2];
        OrderType orderType = OrderType.INVALID;

        /*
        *  Instead of logging exception , we can throw the custom exception as well
        */

        try{
         orderType = OrderType.valueOf(splited[3].toUpperCase());
        }catch (Exception e){
            System.out.println("Exception : "+ INVALID_ORDER_TYPE);
        }
        double price = 0;
        try{
            price = Double.parseDouble(splited[4]);
        }catch (Exception e){
            System.out.println("Exception : "+ INVALID_PRICE);
        }
        int quantity = 0;
        try{
            quantity = Integer.parseInt(splited[5]);
        }catch (Exception e){
            System.out.println("Exception : "+ INVALID_QUANTITY);
        }

        return new Order(orderId, time, stock, orderType, price, quantity);
    }

    public void addOrder(String data){
        // parse and validate string data in order
        Order order = parseDate(data);
        // execute order
        if(order != null)
            orderExecutionService.addOrder(order);
    }
}
