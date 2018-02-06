package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting {
	
	public static List<Integer> bubbleSort(List<Integer> arr) {
		int temp = 0;
		for (int i = 0; i < arr.size() - 1; i++) {
			for (int j = 0; j < arr.size() - 1; j++) {
				if (arr.get(j) > arr.get(j + 1)) {
					temp = arr.get(j);
					arr.set(j, arr.get(j + 1));
					arr.set(j + 1, temp);
				}
			}			
		}
		return arr;
	}
	
	public static List<Integer> selectionSort(List<Integer> arr) {
		for (int i = 0; i < arr.size() - 1; i++) {
			int min = arr.get(i);
			int index = i;
			for (int j = i + 1; j < arr.size(); j++) {
				if (min > arr.get(j)) {
					min = arr.get(j);
					index = j;
				}
			}
			arr.set(index, arr.get(i));
			arr.set(i, min);
		}
		return arr;
	}
	
	public static List<Integer> quickSort(List<Integer> arr) {
		if (arr.size() < 2) {
			return arr;
		}
		int pivot = arr.get(0);
		List<Integer> less = new ArrayList<>();
		List<Integer> middle = new ArrayList<>();		// 엄청 중요하다 ! 중복 원소 예외 처리 !
		List<Integer> greater = new ArrayList<>();
		for (int element : arr) {
			if (element < pivot) {
				less.add(element);
			}
			if (element >  pivot) {
				greater.add(element);
			}
			if (element == pivot) {
				middle.add(element);
			}
		}
		List<Integer> newArr = new ArrayList<>();
		newArr.addAll(quickSort(less));
		newArr.addAll(middle);
		newArr.addAll(quickSort(greater));
		return newArr;
	}
	
	// divide conquer로 sum 만들기
	public static int sumByDivideConqur(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		if (arr.length <= 1) {
			return arr[0];
		}
		int midIndex = arr.length / 2;
		int[] less = new int[midIndex];
		int[] greater = new int[arr.length - midIndex];
		for (int i = 0; i < midIndex; i++) {
			less[i] = arr[i];
		}
		for (int i = 0; i < arr.length - midIndex; i++) {
			greater[i] = arr[midIndex + i];
		}
		return sumByDivideConqur(less) + sumByDivideConqur(greater);
	}
	
	public static void main(String[] args) {
		List<Integer> arrList = Arrays.asList(1,10,3,0,0,0,0,15,-1,10,9);
		int[] arr = new int[10000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		System.out.println(Collections.max(arrList));
//		System.out.println(arrList);
//		List<Integer> newArrList = new ArrayList<>();
//		System.out.println(sumByDivideConqur(arr));
//		newArrList = quickSort(arrList);
//		System.out.println(quickSort(newArrList));
//		System.out.println(bubbleSort(arrList));
//		System.out.println(selectionSort(arrList));
//		System.out.println(Collections.max(arrList));		// 최대값
//		System.out.println(Collections.min(arrList));		// 최소값
	}

}
