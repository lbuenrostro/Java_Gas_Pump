package com.company;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//import java.math.BigDecimal;

public class GasPump {
    //Instance variables//
    public String typeOfGas;
    //Transaction copy path//
    String filepath = "/home/basecamp/IdeaProjects/Java_Gas_Pump/src/com/company/Transaction.txt";

    public GasPump(String typeOfGas) throws IOException {
        this.typeOfGas = typeOfGas;
    }

    public double prePay(String typeofGas, Double money) throws IOException {
        Double gallons = 0.0;
        Double sale_num = Math.round(money * 100.0) / 100.0;
        String sale = sale_num.toString();
        if (typeOfGas.equals("regular")) {
            gallons = (money / 2.07);
        } else if (typeOfGas.equals("mid_grade")) {
            gallons = (money / 2.18);
        } else if (typeOfGas.equals("premium")) {
            gallons = (money / 2.23);
        }

        saveRecord(typeofGas, sale, filepath);
        loadInventory(typeOfGas, gallons);
        return Math.round(gallons * 100.0) / 100.0;
    }

    public double payAfter(String typeOfGas, Double gallons) throws IOException {
        Double money = null;

        if (typeOfGas.equals("regular")) {
            money = (gallons * 2.09);
        } else if (typeOfGas.equals("mid_grade")) {
            money = (gallons * 2.19);
        } else if (typeOfGas.equals("premium")) {
            money = (gallons * 2.29);
        }

        money = Math.round(money * 100.0) / 100.0;
        saveRecord(typeOfGas, money.toString(), filepath);
        loadInventory(typeOfGas, gallons);
        return money;
    }
///transaction file
    public static void saveRecord(String name, String price, String filepath) throws IOException {
        FileWriter writer = new FileWriter(filepath, true);
        writer.write("\n" + name + ", " + price);
        writer.close();
    }

    public static void loadInventory(String typeOfGas, Double gallons) throws IOException {
        Scanner input;
        File file = new File("/home/basecamp/IdeaProjects/Java_Gas_Pump/src/com/company/Inventory.txt");

        input = new Scanner(file);


        while (input.hasNextLine()) {
            String regular = input.nextLine();
            String mid_grade = input.nextLine();
            String premium = input.nextLine();
            ArrayList regularlist = new ArrayList<String>(Arrays.asList(regular.split(", ")));
            ArrayList mid_gradelist = new ArrayList<String>(Arrays.asList(mid_grade.split(", ")));
            ArrayList premiumlist = new ArrayList<String>(Arrays.asList(premium.split(", ")));
            if (typeOfGas.equals("regular")) {
                double total = Double.parseDouble(regularlist.get(1).toString());
                double new_total =  Math.round(total -= gallons);
                String new_amount = Double.toString(new_total);
                regular = regular.replace(regularlist.get(1).toString(), new_amount);
            } else if (typeOfGas.equals("mid_grade")) {
                double total = Double.parseDouble(mid_gradelist.get(1).toString());
                double new_total = Math.round(total -= gallons);
                String new_amount = Double.toString(new_total);
                mid_grade = mid_grade.replace(mid_gradelist.get(1).toString(), new_amount);
            } else if (typeOfGas.equals("premium")) {
                double total = Double.parseDouble(premiumlist.get(1).toString());
                double new_total = Math.round(total -= gallons);
                String new_amount = Double.toString(new_total);
                premium = premium.replace(premiumlist.get(1).toString(), new_amount);
            }
            change_inventory(regular, mid_grade, premium);

        }
        input.close();
    }

    public static void change_inventory(String regular, String mid_grade, String premium) throws IOException {
        FileWriter writer = new FileWriter("/home/basecamp/IdeaProjects/Java_Gas_Pump/src/com/company/Inventory.txt");
        writer.write(regular);
        writer.write("\n" + mid_grade);
        writer.write("\n" + premium);
        writer.close();
    }
}

