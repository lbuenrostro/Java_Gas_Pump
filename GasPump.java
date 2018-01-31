package com.company;

public class GasPump {
    //Instance variables//
    public String typeOfGas;

    public GasPump(String typeOfGas) {
        this.typeOfGas = typeOfGas;
    }

    public double prePay(String typeofGas, Double money) {
        Double gallons = 0.0;
        if (typeOfGas.equals("regular")) {
            gallons = (money / 2.07);
        } else if (typeOfGas.equals("mid-grade")) {
            gallons = (money / 2.18);
        } else if (typeOfGas.equals("premium")) {
            gallons = (money / 2.23);
        }
        return Math.round(gallons);
    }

    public double payAfter(String typeOfGas, Double gallons) {
        Double money = 0.0;
        if (typeOfGas.equals("regular")) {
            money = (gallons * 2.09);
        } else if (typeOfGas.equals("mid-grade")) {
            money = (gallons * 2.19);
        } else if (typeOfGas.equals("premium")) {
            money = (gallons * 2.29);
        }
        return Math.round(money);
    }
}