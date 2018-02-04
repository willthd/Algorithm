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
	
	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(1,10,3,0,0,0,0,15,-1,10,9);
		System.out.println(arr);
		List<Integer> newArrList = new ArrayList<>();
		newArrList = quickSort(arr);
		System.out.println(quickSort(newArrList));
//		System.out.println(bubbleSort(arr));
//		System.out.println(selectionSort(arr));
//		System.out.println(Collections.max(arr));		// 최대값
//		System.out.println(Collections.min(arr));		// 최소값
	}

}
