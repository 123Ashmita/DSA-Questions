package com.day18;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution to the "Keys and Rooms" problem.
 * Given a list of rooms where each room contains keys to other rooms, 
 * the goal is to determine if it's possible to visit all the rooms starting 
 * from room 0. Each room is numbered from 0 to n - 1.
 * 
 * Example:
 * Input: rooms = [[1], [2], [3], []]
 * Output: true
 * Explanation: Start in room 0, pick up key to room 1, then key to room 2, 
 * then key to room 3. All rooms can be visited.
 */
public class KeysAndRooms {

    /**
     * Determines if it's possible to visit all rooms starting from room 0.
     *
     * @param rooms a list of lists where each list contains the keys to other rooms
     * @return true if all rooms can be visited, false otherwise
     */
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Array to track which rooms have been visited
        boolean[] visited = new boolean[rooms.size()];
        
        // Start from room 0
        visited[0] = true;

        // Perform DFS from room 0
        dfs(rooms, 0, visited);

        // Check if all rooms have been visited
        for (boolean b : visited) {
            if (!b) return false; // If any room is unvisited, return false
        }
        return true; // All rooms were visited
    }

    /**
     * Depth-first search (DFS) to visit all rooms reachable from the current room.
     *
     * @param rooms the list of rooms with keys to other rooms
     * @param ind the index of the current room
     * @param visited array tracking whether each room has been visited
     */
    private static void dfs(List<List<Integer>> rooms, int ind, boolean[] visited) {
        // Loop through all keys in the current room
        for (int i : rooms.get(ind)) {
            if (!visited[i]) { // If the room hasn't been visited
                visited[i] = true; // Mark the room as visited
                dfs(rooms, i, visited); // Recursively visit the next room
            }
        }
    }

    /**
     * Main method to test the canVisitAllRooms method.
     */
    public static void main(String[] args) {
        // Initialize the rooms
        List<List<Integer>> rooms = new ArrayList<>();

        // Room 0 has key to room 1
        List<Integer> room0 = new ArrayList<>();
        room0.add(1);
        rooms.add(room0);

        // Room 1 has key to room 2
        List<Integer> room1 = new ArrayList<>();
        room1.add(2);
        rooms.add(room1);

        // Room 2 has key to room 3
        List<Integer> room2 = new ArrayList<>();
        room2.add(3);
        rooms.add(room2);

        // Room 3 has no keys
        List<Integer> room3 = new ArrayList<>();
        rooms.add(room3);

        // Call the method and print the result (Expected output: true)
        System.out.println(canVisitAllRooms(rooms));
    }
}
