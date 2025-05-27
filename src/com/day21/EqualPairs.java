package com.day21;

/**
 * This class contains a method to count the number of pairs
 * (row i, column j) in a square grid such that the i-th row
 * and the j-th column are exactly the same.
 */
public class EqualPairs {

    /**
     * Counts the number of equal row-column pairs in the grid.
     *
     * @param grid A 2D square integer matrix.
     * @return The count of row-column pairs that are equal.
     */
    public static int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        // Loop through each row (r) and column (c)
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                boolean isEqual = true;

                // Compare row r with column c
                for (int i = 0; i < n; i++) {
                    if (grid[r][i] != grid[i][c]) {
                        isEqual = false; // Mismatch found
                        break;
                    }
                }

                if (isEqual) {
                    count++; // Valid pair found
                }
            }
        }

        return count;
    }

    /**
     * Main method to test the equalPairs method with a sample grid.
     */
    public static void main(String[] args) {
        int[][] grid = {
            {3, 1, 2, 2},
            {1, 4, 4, 5},
            {2, 4, 2, 2},
            {2, 4, 2, 2}
        };

        System.out.println("Equal Pairs: " + equalPairs(grid));
    }
}
