package com.day22;

import java.util.Stack;

/**
 * Solution class to find the number of days until a warmer temperature.
 */
class DailyTemperatures {

    /**
     * For each day, finds the number of days you have to wait until a warmer temperature.
     * If no warmer day exists in the future, returns 0 for that day.
     *
     * @param temperatures Array of daily temperatures
     * @return Array where each element represents days to wait for a warmer temperature
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n]; // Result array initialized with 0s by default
        Stack<Integer> stack = new Stack<>(); // Stack stores indices of days

        for (int i = 0; i < n; i++) {
            // Check if current temperature is warmer than temperature at top of stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop(); // Get previous day index
                answer[prevIndex] = i - prevIndex; // Calculate days waited
            }
            stack.push(i); // Push current day index
        }
        return answer;
    }

    /**
     * Main method to test the dailyTemperatures method.
     */
    public static void main(String[] args) {
    	DailyTemperatures sol = new DailyTemperatures();
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = sol.dailyTemperatures(temps);

        System.out.print("Days to wait for warmer temperature: ");
        for (int days : result) {
            System.out.print(days + " ");
        }
    }
}

