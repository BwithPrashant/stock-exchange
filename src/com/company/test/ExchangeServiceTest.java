package com.company.test;

import com.company.main.service.ExchangeService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;

public class ExchangeServiceTest {

    ExchangeService exchangeService;

    public ExchangeServiceTest(){
        exchangeService = new ExchangeService();
    }

    @Test
    @DisplayName("combination of different invalid input")
    public void invalidInputTest(){
        List<String> inputList = Arrays.asList(
                "#1 09:45 BAC sell 240.12 100 123",
                "#2 09:46 BAC random 237.45 90",
                "#3 09:47 BAC buy wrond_price 110",
                "#4 09:48 BAC buy 237.80 wrong_quantity");
        for(String input : inputList){
            exchangeService.addOrder(input);
        }
    }

    @Test
    @DisplayName("buy and sell different stock names")
    public void differentStockBuyTest(){
        List<String> inputList = Arrays.asList(
                "#1 09:45 BAC sell 240.12 100",
                "#2 09:46 XYZ sell 237.45 90",
                "#3 09:47 BAC buy 238.10 110",
                "#4 09:48 BAC buy 237.80 10",
                "#5 09:49 XYZ buy 237.80 40",
                "#6 09:50 BAC sell 236.00 50");
        for(String input : inputList){
            exchangeService.addOrder(input);
        }
    }

    @Test
    @DisplayName("combination of partial and complete buy")
    public void addOrderTest(){
        List<String> inputList = Arrays.asList(
                "#1 09:45 BAC sell 240.12 100",
                "#2 09:46 BAC sell 237.45 90",
                "#3 09:47 BAC buy 238.10 110",
                "#4 09:48 BAC buy 237.80 10",
                "#5 09:49 BAC buy 237.80 40",
                "#6 09:50 BAC sell 236.00 50");
        for(String input : inputList){
            exchangeService.addOrder(input);
        }
    }

    @Test
    @DisplayName("only buy orders")
    public void allBuyest(){
        List<String> inputList = Arrays.asList(
                "#1 09:45 BAC buy 240.12 100",
                "#2 09:46 BAC buy 237.45 90",
                "#3 09:47 BAC buy 238.10 110",
                "#4 09:48 BAC buy 237.80 10",
                "#5 09:49 BAC buy 237.80 40",
                "#6 09:50 BAC buy 236.00 50");
        for(String input : inputList){
            exchangeService.addOrder(input);
        }
    }

    @Test
    @DisplayName("only sell orders")
    public void allSellTest(){
        List<String> inputList = Arrays.asList(
                "#1 09:45 BAC sell 240.12 100",
                "#2 09:46 BAC sell 237.45 90",
                "#3 09:47 BAC sell 238.10 110",
                "#4 09:48 BAC sell 237.80 10",
                "#5 09:49 BAC sell 237.80 40",
                "#6 09:50 BAC sell 236.00 50");
        for(String input : inputList){
            exchangeService.addOrder(input);
        }
    }

}
