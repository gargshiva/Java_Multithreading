package com.sapient.ace.corejava;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] arr = { 1, 20, 6, 4, 5 };
		MergeSort mergeSort = new MergeSort();
		mergeSort.implementMergeSort(arr);

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public void implementMergeSort(int[] arr) {
		if (arr.length == 1) {
			return;
		}

		int mid = arr.length / 2;
		int[] left = new int[mid];
		int[] right = new int[arr.length - mid];
		int i = 0;
		for (; i < mid; ++i) {
			left[i] = arr[i];
		}

		for (int j = 0; j < (arr.length - mid); ++j) {
			right[j] = arr[i];
			++i;
		}

		implementMergeSort(left);
		implementMergeSort(right);
		merge(arr, left, right);

	}

	public void merge(int[] arr, int[] left, int[] right) {
		int l = 0;
		int r = 0;
		int i = 0;

		while (l < left.length && r < right.length) {
			if (left[l] <= right[r]) {
				arr[i] = left[l];
				++l;
				++i;
			} else {
				arr[i] = right[r];
				++r;
				++i;
			}
		}

		while (l < left.length) {
			arr[i] = left[l];
			++l;
			++i;
		}

		while (r < right.length) {
			arr[i] = right[r];
			++r;
			++i;
		}

	}
}
