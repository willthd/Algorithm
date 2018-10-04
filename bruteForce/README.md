부등호, n-queen, 좋은 수열(상) 문제가 여기선 어려운 편



```java
public static void f(int dep) {
    if (dep == r) {
        //여기서 check()하면 시간 더 오래 걸린다. 시간 초과 나는 경우도 있다
        
        // return 잊지 말기 
        return;
    }
    for (int i = 0; i < n; i++) {
        //여기서 check()하면 시간 더 빠르다
    }
}
```





-------





종종 완전 탐색으로 시간초과 나는 경우 있다(n^2, 예를 들어 n=100000)

이럴 때, 이진검색(binary search, log n)과 for문(n) 이용해서 nlogn 복잡도로 해결한다

아래는 이진검색 code

ex) boj 2467

```java
import java.util.*;

// 일반적으로 biSearch1을 이용해 이진 탐색을 하는데, 근사값을 구할 경우에는 제대로 찾지 못하는 경우가 있다.
// 이 때 biSearch2를 사용했더니 됐는데...biSearch2가 더 촘촘한 것인지, 아님 특정 biSearch2로 예외가
// 있는 test case가 없엇던 것인지...
public class Main {
	public static void main(String[] args) {
		// 배열이 정렬된 상태여야 한다
		int[] arr = { -99, -2, -1, 4, 98, 101, 103, 104, 106};
		System.out.println(biSearch1(99, arr));
		System.out.println(biSearch2(99, arr));
	}
	
	public static int biSearch2(int find, int arr[]){
	    int l = 0;
	    int r = arr.length;
	    int mid = 0;
	    while (r - l >= 1){
	        mid = (l+r)/2; 
	        System.out.println(l + " " + mid + " " + r);
	        if (arr[mid] == find) return mid; 
	        else if (arr[mid] < find){
	            l = mid+1; 
	        }
	        else{
	            r = mid; 
	        }
	    }
	    return arr[mid]; 
	}

	public static int biSearch1(int find, int arr[]) {
		int mid = 0;
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			mid = (left + right) / 2;
			System.out.println(left + " " + mid + " " + right);
			if (arr[mid] == find) {
				return mid;
			}
			if (arr[mid] < find) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return arr[mid];
	}
}
```
