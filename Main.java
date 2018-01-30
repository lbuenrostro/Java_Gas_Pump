package com.company;

import java.util.Scanner;

public class Main {

    public static void LoadPrice(){
        System.out.println("Type\t\tPrice\tGallons");
        System.out.println("Regular\t\t2.00\t5000");
        System.out.println("Mid-Grade\t2.00\t5000");
        System.out.println("Premium\t\t2.00\t5000");

    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("\nWELCOME to Violet Flowers Gas Station!!\n");
        LoadPrice();
        System.out.println("\n[1]Pre Pay or [2]Pay After");
    }
}
