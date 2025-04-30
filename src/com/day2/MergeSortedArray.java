package com.day2;

import java.util.Arrays;

public class MergeSortedArray {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++) {
         nums1[m+i]=nums2[i];
        }
       Arrays.sort(nums1);
	
    }
	public static void main(String[] args) {
		int[] nums1= {1,2,3,4,5,6};
		int[] nums2= {9,8,7};
		int m=3;
		int n=3;
		System.out.println("Original array of nums1");
		for(int i=0;i<nums1.length;i++) {
			System.out.print(nums1[i]+" ");
		}
		System.out.println();
		System.out.println("Original array of nums2");
		for(int i=0;i<nums2.length;i++) {
			System.out.print(nums1[i]+" ");
		}
		System.out.println();
		System.out.println("merge sorted array of nums1 and nums2");
		merge(nums1,m,nums2,n);
		for(int i=0;i<nums1.length;i++) {
			System.out.print(nums1[i]+" ");
		}
	}	
}
