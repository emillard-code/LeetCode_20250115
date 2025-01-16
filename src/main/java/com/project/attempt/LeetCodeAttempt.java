package com.project.attempt;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        System.out.println(minimizeXOR(3, 5));
        System.out.println(minimizeXOR(1, 12));

    }

    public static int minimizeXOR(int num1, int num2) {

        StringBuilder num1Binary = new StringBuilder(Integer.toBinaryString(num1));
        StringBuilder num2Binary = new StringBuilder(Integer.toBinaryString(num2));
        StringBuilder num3Binary = new StringBuilder();

        if (num1Binary.length() < num2Binary.length()) {

            while (num1Binary.length() != num2Binary.length()) {
                num1Binary.insert(0, '0');
            }

        } else if (num1Binary.length() > num2Binary.length()) {

            while (num1Binary.length() != num2Binary.length()) {
                num2Binary.insert(0, '0');
            }

        }

        int setBitsNum1 = 0;
        int setBitsNum2 = 0;

        for (int i = 0; i < num1Binary.length(); i++) {
            if (num1Binary.charAt(i) == '1') { setBitsNum1++; }
            if (num2Binary.charAt(i) == '1') { setBitsNum2++; }
        }

        if (setBitsNum1 >= setBitsNum2) {

            for (int i = 0; i < num1Binary.length(); i++) {

                if (setBitsNum2 > 0 && num1Binary.charAt(i) == '1') {
                    num3Binary.append('1');
                    setBitsNum2--;
                } else {
                    num3Binary.append('0');
                }

            }

        } else {

            for (int i = 0; i < num1Binary.length(); i++) {

                if (num1Binary.charAt(i) == '1') {
                    num3Binary.append('1');
                    setBitsNum2--;
                } else {
                    num3Binary.append('0');
                }

            }

            for (int i = num2Binary.length() - 1; i > 0; i--) {

                if (setBitsNum2 == 0) { break; }

                if (num3Binary.charAt(i) == '0') {
                    num3Binary.setCharAt(i, '1');
                    setBitsNum2--;
                }

            }

        }

        int x = Integer.parseInt(num3Binary.toString(), 2);

        return x;

    }

    private static String xorOperation(String binary1, String binary2) {

        StringBuilder binaryXor = new StringBuilder();

        for (int i = 0; i < binary1.length(); i++) {

            if (binary1.charAt(i) == binary2.charAt(i)) { binaryXor.append('0'); }
            else { binaryXor.append('1'); }

        }

        return binaryXor.toString();

    }

}
