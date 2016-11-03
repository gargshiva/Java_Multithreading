package com.sapient.ace.corejava;

public class LargestAndSecondLargest {
	public static void main(String[] args) {
		int[] arr = new int[] { 99, 19, 2, 78, 191, 82, 1 };
		LargestAndSecondLargest.findLargestAndSecondLargest(arr);
	}

	public static void findLargestAndSecondLargest(int[] arr) {
		int largest, secondLargest;
		if (arr[0] > arr[1]) {
			largest = arr[0];
			secondLargest = arr[1];
		} else {
			largest = arr[1];
			secondLargest = arr[0];
		}

		for (int i = 2; i < arr.length; ++i) {
			if (arr[i] > largest) {
				secondLargest = largest;
				largest = arr[i];
			} else if (arr[i] > secondLargest) {
				secondLargest = arr[i];
			}
		}

		System.out.println("Largest = " + largest);
		System.out.println("Second Largest = " + secondLargest);
	}
}
