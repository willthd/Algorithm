package practice;

import java.util.*;

public class QuickSort {
	public static void main(String[] args) {
		int arr[] = { 4, 77, 98, 30, 20, 50, 77, 22, 49, 2 };
		int arr4[] = { 1 };
		int arr2[] = { 69, 10, 30, 2, 16, 8, 31 };
		int arr3[] = { 69, 10, -1, 2, 16, 8, 31 };
		quickSort1(arr, 0, arr.length - 1);
		// quickSort2(arr2, 0, arr2.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		// for (int i = 0; i < arr2.length; i++) {
		// System.out.print(arr2[i] + " ");
		// }
	}

	public static void quickSort1(int[] data, int l, int r) {

		int left = l;
		int right = r;
		int pivot = data[(l + r) / 2];

		while(left<=right) {
			while (data[left] < pivot) {
				left++;				
			}
			while (data[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = data[left];
				data[left] = data[right];
				data[right] = temp;
				left++;
				right--;
			}
		}

		if (l < right)
			quickSort1(data, l, right);
		if (r > left)
			quickSort1(data, left, r);
	}

	public static int partition(int arr[], int left, int right) {

		int pivot = arr[(left + right) / 2];

		while (left <= right) {
			while ((arr[left] < pivot)) {
				left++;				
			}
			while ((arr[right] > pivot)) {
				right--;				
			}
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}

		return left;
	}

	public static void quickSort2(int arr[], int left, int right) {
		int pivotNewIndex = partition(arr, left, right);
		if (left < pivotNewIndex -1) {
			quickSort2(arr, left, pivotNewIndex - 1);			
		}
		if (pivotNewIndex < right) {
			quickSort2(arr, pivotNewIndex, right);			
		}
	}

	
}
