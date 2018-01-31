package com.company;

import java.util.Scanner;

public class Main {

    public static void Pay(Integer PayType, String GasType, Double Amount){
        if (PayType.equals(1)){
            GasPump paying = new GasPump(GasType);
            System.out.println(paying.prePay(GasType, Amount));
        } else if(PayType.equals(2)){
            GasPump paying = new GasPump(GasType);
            System.out.println(paying.payAfter(GasType, Amount));
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("\nWELCOME to Lizeth B Gas Station!!\n");
        System.out.println("What would you like today:\n--regular\n--mid-grade\n--premium\n");
        String GasType = reader.nextLine();
        System.out.println("[1]Pre Pay or [2]Pay After");
        Integer PayType = reader.nextInt();


        if (PayType.equals(1)){
            System.out.println("How much would you like to get?");
            Double money = reader.nextDouble();
            Pay(PayType, GasType, money);
        }
        else if (PayType.equals(2)){
            System.out.println("How much would you like to get?");
            Double money = reader.nextDouble();
            Pay(PayType, GasType, money);
        }
    }
}
