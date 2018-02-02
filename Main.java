package com.company;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.*;
import java.util.*;


public class Main {

    public static void Pay(Integer PayType, String GasType, Double Amount) throws IOException {
        if (PayType.equals(1)){
            GasPump paying = new GasPump(GasType);
            System.out.println(paying.prePay(GasType, Amount));
        } else if(PayType.equals(2)){
            GasPump paying = new GasPump(GasType);
            System.out.println(paying.payAfter(GasType, Amount));
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        System.out.println("---WELCOME to Buenrostro Gas Station!!---");
        System.out.println("\nWhat would you like today:\n--regular\n--mid_grade\n--premium");
        String GasType = reader.nextLine();
        System.out.println("\n[1]Pre Pay or [2]Pay After");
        Integer PayType = reader.nextInt();

        while(true) {
            if (PayType.equals(1)) {
                System.out.println("How much would you like to get?");
                Double money = reader.nextDouble();
                System.out.println("\n--Total--");
                Pay(PayType, GasType, money);
                System.exit(0);
            } else if (PayType.equals(2)) {
                System.out.println("How much would you like to get?");
                Double gallons = reader.nextDouble();
                System.out.println("\n--Total--");
                Pay(PayType, GasType, gallons);
                System.exit(0);
            } else {
                System.out.println("---Invalid---");
                System.exit(0);
            }
        }
    }
}
