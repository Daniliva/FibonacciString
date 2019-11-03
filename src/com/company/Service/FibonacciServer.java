package com.company.Service;

import java.util.ArrayList;
import java.util.List;

public class FibonacciServer {
    private long placeNumberWithFibonacciRow(int n) {
        double s = Math.sqrt(5.0);
        double result = Math.log(s * n) / Math.log(-(1 + s) / (1 - s)) * 2;
        return Math.round(result);
    }

    private long getBinetFormula(long n) {
        double s = Math.sqrt(5.0);
        double result = (Math.pow((1 + s) / 2, n) - Math.pow((1 / s) / 2, n)) / s;
        return Math.round(result);

    }

    public List<Long> getFibonacciRow(long lower, long upper) {
        long number = 1;
        if (lower > 0)
            number = placeNumberWithFibonacciRow((int) lower);
        long curr = getBinetFormula(number), prev = getBinetFormula(number - 1);
        return getFibonacciWhile(curr, upper, prev);
    }

    private List<Long> getFibonacciWhile(long curr, long upper, long prev) {
        List<Long> result = new ArrayList<>();
        while (curr <= upper) {
            long temp = curr;
            curr = prev + curr;
            prev = temp;
            if (curr <= upper) {
                result.add(curr);
            }
        }

        return result;
    }

}
