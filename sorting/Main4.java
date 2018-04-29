package practice;

import java.util.*;

// SWEA, 1952, 수영장
public class Main4 {

	// O(n^2)
	// 자신과 그 다음 수를 비교해 그 다음 수가 더 작으면 왼쪽으로 옮기고 자신은 오른쪽으로 옮긴다. 이 과정 n - 1번 반복
	static void bubble(int a[]) {
		for (int i = a.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	// O(n^2)
	// 배열을 다 돌고 가장 큰 값을 마지막에 위치, 그 이후 배열의 크기를 작아진 상태에서 0부터 끝까지 돌고 그 다음 위치에 위치시킴
	static void selection(int a[]) {
		int max;
		int n;
		for (int i = a.length - 1; i >= 0; i--) {
			max = (int) -1e9;
			n = 0;
			for (int j = 0; j <= i; j++) {
				if (max < a[j]) {
					max = a[j];
					n = j;
				}
			}
			int temp = a[i];
			a[i] = a[n];
			a[n] = temp;
		}
	}

	// O(n^2)
	// 1부터 끝까지 한번 도는데, 그 값 기준으로 왼쪽에 있는 배열의 값들을 비교해 기준보다 작으면 하나씩 오른쪽으로 옮겨감. insertion
	// sort는 항상 기준 왼쪽은 정렬되어 있는 상태
	// http://marobiana.tistory.com/85
	static void insertion(int[] a) {
		// 1부터 시작
		for (int i = 1; i < a.length; i++) {
			int standard = a[i]; // 기준
			int n = i - 1; // 비교할 대상
			while (n >= 0 && standard < a[n]) {
				a[n + 1] = a[n]; // 비교대상이 큰 경우 오른쪽으로 밀어냄
				n--;
			}
			a[n + 1] = standard; // 기준
		}
	}

	// O(nlogn)
	// 피벗 가운데 잡고 왼쪽엔 그것보다 작은값, 오른쪽엔 그것 보다 큰 값 정렬. left : 처음부터 피벗 전까지, right : 피벗이후부터 마지막까지 재귀 돌림
	// 최악의 경우는 기준 원소가 가장 큰 값 또는 가장 작은 값일 경우
	static void quick(int[] a, int left, int right) {
		int l = left;
		int r = right;
		int pivot = a[(left + right) / 2];

		while (l <= r) {
			while (a[l] < pivot) {
				l++;
			}
			while (a[r] > pivot) {
				r--;
			}
			if (l <= r) {
				int temp = a[l];
				a[l] = a[r];
				a[r] = temp;
				l++;
				r--;
			}
		}
		if (left < r) {
			quick(a, left, r);
		}
		if (right > l) {
			quick(a, l, right);
		}
	}

	
	// O(nlogn)
//	http://zeddios.tistory.com/38
	static void mergeSort(int arr[], int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	// 정렬된 두 배열(arr[l..mid]), (arr[mid+1..r])를 합병한다.
	// 정렬된 하나의 배열(arr[l..r])을 도출한다.
	static void merge(int arr[], int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int k = left;
		int temp[] = new int[arr.length];
		while (i <= mid && j <= right) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		// 왼쪽 배열의 나머지들
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		// 오른쪽 배열의 나머지들
		while (j <= right) {
			temp[k++] = arr[j++];
		}
		for (int index = left; index < k; index++) {
			arr[index] = temp[index];
		}
	}

	public static void main(String[] args) {
		int a[] = { 10, -1, 4, 6, 5, 9, 220, 0, -47, 5 };
//		bubble(a);
//		selection(a);
//		insertion(a);
//		quick(a, 0, a.length - 1);
		mergeSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}