package com.project.solution;

public class LeetCodeSolution {

    public static void main(String[] args) {

        System.out.println(minimizeXor(3, 5));
        System.out.println(minimizeXor(1, 12));

    }

    public static int minimizeXor(int num1, int num2) {

        // Initialize result to num1. We will modify result.
        int result = num1;

        int targetSetBitsCount = Integer.bitCount(num2);
        int setBitsCount = Integer.bitCount(result);

        // Start with the least significant bit (bit 0).
        int currentBit = 0;

        // Add bits to result if it has fewer set bits than the target.
        while (setBitsCount < targetSetBitsCount) {

            // If the current bit in result is not set (0), set it to 1.
            if (!isSet(result, currentBit)) {
                result = setBit(result, currentBit);
                setBitsCount++;
            }

            // Move to the next bit.
            currentBit++;

        }

        // Remove bits from result if it has more set bits than the target.
        while (setBitsCount > targetSetBitsCount) {

            // If the current bit in result is set (1), unset it (make it 0).
            if (isSet(result, currentBit)) {
                result = unsetBit(result, currentBit);
                setBitsCount--;
            }

            // Move to the next bit.
            currentBit++;

        }

        return result;

    }

    // Helper function to check if the given bit position in result is set (1).
    private static boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    // Helper function to set the given bit position in result to 1.
    private static int setBit(int x, int bit) {
        return x | (1 << bit);
    }

    // Helper function to unset the given bit position in x (set it to 0).
    private static int unsetBit(int x, int bit) {
        return x & ~(1 << bit);
    }

}
