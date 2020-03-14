완전 탐색을 해결 하는 방법은 여러가지 있다

1. a[] 사용하는 경우

2. back tracking 사용 하는 경우


문제에 따라 더 쉽게 풀리는 방법이 있을 뿐, 모두 완전 탐색이다. 어떤 경우에 무엇을 사용하는 것이 쉬울지 아래 문제 풀어보면서 비교 및 연습



**back tracking**

boj_15686_v2(치킨배달), boj_15684(사다리조작), boj_14502(연구소)



**a[]**

boj_15685(치킨배달), boj_15683(감시)

</br>

------

</br>



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

</br>

-------

</br>



종종 완전 탐색으로 시간초과 나는 경우 있다(n^2, 예를 들어 n=100000)

이럴 때, 이진검색(binary search, log n)과 for문(n) 이용해서 nlogn 복잡도로 해결한다

아래는 이진검색 code

ex) boj 2467

* Java

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

</br>

* Python

```python
def binartSearch(arr, target):
    beg = 0
    end = len(arr) - 1
    result = -1

    while beg <= end:
        mid = int((beg + end) / 2)
        if arr[mid] < target:
            beg = mid + 1
        elif arr[mid] > target:
            end = mid - 1
        else:
            result = mid
            break

    return result
```

</br>

------

</br>



### 주의 !

1. a[]을 무엇으로 정의했는가? -> 가장 중요!

2. func() 함수에서 a배열에 값 집어 넣을 때 if문 위치 중요하다 -> if문에 a[dep]에 값이 안들어가져 있는 상태일 때가 종종 있다

   ex) division.java

3. func() 함수에서 모든 경우의 수를 만든 다음 if문으로 출력만 제한하는 경우

   ex) 숫자 만들기 문제에서 합이 0인 경우의 식만을 출력하라고 하는 경우

   func() 함수에서 모든 경우의 수를 만들기 전에 for문에서 a배열을 만들 때 if문으로 커팅 하는 경우

   ex) 좋은 수열 문제

   두 경우를 구분하는 기준은, 끝까지 a배열에 값을 넣어보지 않아도 판별이 되는 경우에는 후자. 다 넣어보고 판별해야 하는 경우는 전자

4. a배열에 값을 집어 넣을 때, 큰 값 부터 넣는 경우엔 for문을 돌 때 마지막 값부터 넣는다. base case에 도착해서는 a배열을 처음부터 꺼낸다

   ex) 부등호 문제

   작은 값 부터 넣는 경우엔 for문 돌 때 처음 값부터 넣고 base case에서는 마찬가지로 a배열을 처음부터 꺼낸다

1. 순열에서 check 배열(or visited 배열)의 크기는 a배열의 크기와 다르다. a배열의 크기는 depth만큼. check 배열의 크기는 node 개수 만큼

2. a[] 꼭 필요한가? parameter로 들고 다닐 수도 있지 않을까? -> 생각 유연하게 해야한다

   이유 : a배열을 읽을 때 for문을 한 번 돌기 때문에 그만큼 시간 복잡도 증가한다. 대개 nPr같은 경우, if(return 내포)문을 제외한 for문에서만을 의미한다따라서 for문을 n만큼 돈다고 한다면 시간 복잡도는 nPr * n이 되는 것이기 때문에 parameter로 들고 가는 것이 더 낫다

   ex) SWEA, 1952, 수영장 문제 (a[]만든다면 읽는동안 시간 초과나는 경우 50개 중 40개 발생. 답은 맞다)

