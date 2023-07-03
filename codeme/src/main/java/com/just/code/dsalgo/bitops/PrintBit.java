package com.just.code.dsalgo.bitops;

public class PrintBit {

    public static void main(String[] args) {
        printTwoPowerBits();
    }

    private static void printTwoPowerBits() {
        System.out.println("print all binary for power of two");
        for(int i=0; i<=62; i++) {
            long k = 1L <<i;
            System.out.println("No: " + i + " power: " + k + " binary: "+ Long.toBinaryString(k) + " bitCount: " + Long.bitCount(k));
        }
    }
}
