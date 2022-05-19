package com.company;

import com.company.main.service.ExchangeService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Driver class to load data and execute
public class Driver {

    public static void main(String[] args) {
        ExchangeService exchangeService = new ExchangeService();

        try (BufferedReader br = new BufferedReader(new FileReader("src/resource/data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                exchangeService.addOrder(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
