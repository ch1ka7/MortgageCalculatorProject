package com.chyngyz;

import java.util.ArrayList;

/**
 * Created by Chyngyz on 12/30/2018.
 */

public class MortgageCalculator2018 implements MortgageCalculator {
    private final static byte MONTHS_INT_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator2018(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    @Override
    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getNumberOfPayments();

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    @Override
    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getNumberOfPayments();

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    @Override
    public ArrayList<Double> getRemainingBalances() {
        var balances = new ArrayList<Double>();
        for (short month = 1; month <= getNumberOfPayments(); month++) {
            balances.add(calculateBalance(month));
        }
        return balances;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_INT_YEAR;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_INT_YEAR;
    }
}
