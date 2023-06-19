package com.just.code.code.dsalgo.company.amazon;

public class NumberConversion {
    /*
    6 -> 6%2 = 0, 6/2=3
         3%2 = 1, 3/2=1
         1%2 = 1, 1/2=0
        = 110
     */
    public static String decimalToBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n % 2);
            n = n / 2;
        }
        return sb.toString();
    }

    /*
    110 -> 0*(2^0) + 1*(2^1) + 1*(2^2) = 0 + 2 + 4 = 6
     */
    public static int binaryToDecimal(String num) {
        int n = 0;
        int k = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int cur = num.charAt(i) - '0';
            n += cur << k; //can simply multiply each time by 2 also
            k++;
        }
        return n;
    }

    /*
    1024, 16 -> 1024%16 = 0, 1024/16=64
                64%16 = 0, 64/16=4
                4%16  = 4, 4/16=0
            = 400
     */
    public static String decimalToBaseN(int num, int base) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.insert(0, (num % base));
            num = num / base;
        }
        return sb.toString();
    }

    /*
    400 -> 0*(base^0) + 0*(base^1) + 4*(base^2) = 0 + 0 + 4*256 = 1024
     */
    public static int baseNToDecimal(String num, int base) {
        int n = 0;
        int mul = 1;
        for (int i = num.length() - 1; i >= 0; i--) {
            int cur = num.charAt(i) - '0';
            n += cur * mul;
            mul *= base;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println("intToBinary: " + decimalToBinary(6));
        System.out.println("binaryToInt: " + binaryToDecimal("110"));
        System.out.println("decimalToBaseN: " + decimalToBaseN(1024, 16));
        System.out.println("baseNToDecimal: " + baseNToDecimal("400", 16));
    }
}
