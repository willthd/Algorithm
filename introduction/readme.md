## Introduction
---

> 알고리즘이란?
>
> 어떤 명령을 하기 위한 집합

### Big O notation


* 알고리즘은 시간이 아니라 연산 휫수가 어떻게 증가하는지로 측정하는데, 이 때 Big O 표기법을 사용한다

* Big O 표기법은 최악의 경우에 대한 것이다 (한 번에 찾는 경우가 있지만 최선의 경우라 할지라도 Big O 표기법은 달라지지 않는다)

* 상수는 무시한다

* 순서 (위로 갈수록 빠르다)

  O(logn) - 이진 탐색

  O(n) - 단순 탐색

  O(nlogn) - 퀵 정렬

  O(n^2) - 선택 정렬

  O(n!) - 외판원 문제

![chart](./chart.png)





### 알고리즘 풀 때, 중요도



1. 정확한 알고리즘을 설계했는지
2. 알고리즘 돌아가는데 걸린 시간
3. 알고리즘 돌아가는데 소요되는 메모리
4. 알고리즘을 설계하는데 얼마나 걸렸는지



### 1억번 돌면 약 1초 걸린다

10억은 약 (2^30)



### Max, Min 표현(정수 가정)

max = -10^9, -(int)1e9, Integer.MIN_VALUE(-2^31) 이런식으로 표현

min = 10^9, (int)1e9, Integer.MAX_VALUE(2^31 - 1) 이런식으로 표현

java에서 정수는 32bit. 그 중 1bit은 sign bit이니까 31bit로만 표현. 그리고 양수의 절대값이 1보다 작은 이유는 양수 영역에서 0을 포함하기 때문



### Comparator 사용방법

백준 11286 code 참조

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
	public int compare(Integer a, Integer b){
		if (Math.abs(a) == Math.abs(b)) {
			return Integer.compare(a, b);
		} else {
			return Integer.compare(Math.abs(a), Math.abs(b));
		}
	}
});
```

