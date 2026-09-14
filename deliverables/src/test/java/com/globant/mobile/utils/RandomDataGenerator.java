package com.globant.mobile.utils;

public class RandomDataGenerator {

    private RandomDataGenerator() {
    }

    public static String generarEmailRandom() {
        long numeroRandom = System.currentTimeMillis();
        return "usuario" + numeroRandom + "@test.com";
    }
}
