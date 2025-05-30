package com.day22;


import java.util.*;

/**
* This class solves the asteroid collision problem.
* Positive numbers move right, negative numbers move left.
* When two asteroids collide, the smaller one explodes.
*/
public class AsteroidCollision {

 /**
  * Returns the state of asteroids after all collisions.
  *
  * @param asteroids an array of integers representing asteroids
  * @return the array after all collisions
  */
 public static int[] asteroidCollision(int[] asteroids) {
     Stack<Integer> stack = new Stack<>();

     for (int asteroid : asteroids) {
         boolean destroyed = false;

         // Check for collision: right-moving asteroid in stack and left-moving current
         while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
             if (stack.peek() < -asteroid) {
                 // Top of stack explodes
                 stack.pop();
             } else if (stack.peek() == -asteroid) {
                 // Both explode
                 stack.pop();
                 destroyed = true;
                 break;
             } else {
                 // Current asteroid explodes
                 destroyed = true;
                 break;
             }
         }

         // If not destroyed, push to stack
         if (!destroyed) {
             stack.push(asteroid);
         }
     }

     // Convert stack to array
     int[] result = new int[stack.size()];
     for (int i = result.length - 1; i >= 0; i--) {
         result[i] = stack.pop();
     }

     return result;
 }

 // Example usage
 public static void main(String[] args) {
     int[] asteroids = {5, 10, -5};
     int[] result = asteroidCollision(asteroids);
     System.out.println(Arrays.toString(result)); // Output: [5, 10]
 }
}

