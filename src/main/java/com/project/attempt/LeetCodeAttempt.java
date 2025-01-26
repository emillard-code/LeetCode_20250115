package com.project.attempt;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        System.out.println(minimizeXOR(3, 5));
        System.out.println(minimizeXOR(1, 12));

    }

    // This method will return an int x with specifications as per challenge instructions.
    public static int minimizeXOR(int num1, int num2) {

        // First, we convert num1 and num2 to their binary forms.
        // num3Binary will be the String that contains the binary form of the answer int x.
        StringBuilder num1Binary = new StringBuilder(Integer.toBinaryString(num1));
        StringBuilder num2Binary = new StringBuilder(Integer.toBinaryString(num2));
        StringBuilder num3Binary = new StringBuilder();

        // To keep them the same length and make looping through them easier later, we will
        // append '0's to the front of the shorter binary string if their lengths are not equal.
        if (num1Binary.length() < num2Binary.length()) {

            while (num1Binary.length() != num2Binary.length()) {
                num1Binary.insert(0, '0');
            }

        } else if (num1Binary.length() > num2Binary.length()) {

            while (num1Binary.length() != num2Binary.length()) {
                num2Binary.insert(0, '0');
            }

        }

        // These int variables will keep track of how many set bits ('1's) are in each binary string.
        // We will need these values to perform some of our later logic.
        int setBitsNum1 = 0;
        int setBitsNum2 = 0;

        for (int i = 0; i < num1Binary.length(); i++) {
            if (num1Binary.charAt(i) == '1') { setBitsNum1++; }
            if (num2Binary.charAt(i) == '1') { setBitsNum2++; }
        }

        // According to the challenge specifications, our answer (int x) must have the
        // same number of set bits as num2, so we use setBitsNum2 as the limit for how many
        // '1's the num3Binary string (binary form of int x) may have. The same specifications
        // also mentioned that a XOR operation between num1 and int x must be the smallest it can be.
        // In a XOR operation, if the bits are both the same, then '0' is generated. Otherwise, if they
        // are different then '1' is generated. With this in mind, we will do our best to have num3Binary
        // have '1's in the leftmost positions where num1 also has them, so that their XOR operation have
        // '0' being generated at those indexes instead. This ensures the XOR operation with the smallest
        // value as the leftmost bits have the most weight in deciding the overall value of the binary string.
        // If num1 has equal or more set bits than num2, then we can simply do a single loop to set as many bits
        // in num3Binary to match the set bits in num 1, so that their resultant XOR is as small as can be.
        if (setBitsNum1 >= setBitsNum2) {

            for (int i = 0; i < num1Binary.length(); i++) {

                if (setBitsNum2 > 0 && num1Binary.charAt(i) == '1') {
                    num3Binary.append('1');
                    setBitsNum2--;
                } else {
                    num3Binary.append('0');
                }

            }

        // If num1 has less set bits than num2 however, then we will have to set bits in num3Binary to
        // match with every set bit in num1 and then set even more bits to match the total number of set
        // bits with num2. So after the first loop, we have a second loop that iterates from the right of
        // the string and sets the bits of the rightmost '0's to '1's, as the rightmost bits have the
        // least weight in deciding the value of the overall binary string. Hence, we'll set those bits
        // to match the number of set bits in num2 while still keeping the XOR to its minimum value.
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

        // Once we have performed the required logics, we revert num3Binary to int x
        // as the challenge specifications asked for the int form of the resulting binary.
        int x = Integer.parseInt(num3Binary.toString(), 2);

        // We then return x.
        return x;

    }

    // Helper method to perform a XOR operation between two binary strings.
    // Was not needed in the end but is kept just in case.
    private static String xorOperation(String binary1, String binary2) {

        StringBuilder binaryXor = new StringBuilder();

        for (int i = 0; i < binary1.length(); i++) {

            if (binary1.charAt(i) == binary2.charAt(i)) { binaryXor.append('0'); }
            else { binaryXor.append('1'); }

        }

        return binaryXor.toString();

    }

}
