package com.chyngyz;

import java.util.ArrayList;

/**
 * Created by Chyngyz on 12/30/2018.
 */

public interface MortgageCalculator {
    double calculateMortgage();

    double calculateBalance(short numberOfPayments);

    ArrayList<Double> getRemainingBalances();
}
