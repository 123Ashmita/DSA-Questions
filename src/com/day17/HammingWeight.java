package com.day17;

/**
 * This class provides a method to calculate the Hamming Weight,
 * also known as the number of set bits (1s) in the binary representation of an integer.
 */
public class HammingWeight {

    /**
     * Calculates the number of set bits (1s) in a 32-bit integer.
     *
     * @param n the input integer
     * @return the number of set bits in the binary representation of n
     */
    public static int hammingWeight(int n) {
        int ans = 0;

        // Iterate through all 32 bits of the integer
        for (int i = 0; i < 32; i++) {
            // Right shift 'n' by 'i' positions and perform bitwise AND with 1
            // If the result is 1, the i-th bit is set
            if (((n >> i) & 1) == 1)
                ++ans;
        }

        return ans;
    }

    /**
     * Main method to test the hammingWeight function.
     */
    public static void main(String[] args) {
        int n = 11; // Binary: 1011 → has 3 set bits
        System.out.println("Number of set bits : " + hammingWeight(n));
    }
}
