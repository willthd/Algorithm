## and others
---

> 주의 해야 할 부분


* input 값에 따라 int는 그 값을 나타내지 못하는 경우가 있다. 따라서 max input값을 꼭 확인해보고 출력을 못한다면 long으로 대체한다

* 입력이 아래와 같을 경우

  ```
3
26 40 83
49 60 57
13 89 99
```

  2번째 줄 부터 4번째 줄 까지 nextLine으로 입력받아 split할 필요 없이 이렇게 받으면 된다

  ```java
  Scanner sc = new Scanner(System.in);
	int input = sc.nextInt();
	int[][] grid = new int[input][3];
	for (int i = 0; i < input; i++) {
		for (int j = 0; j < 3; j++) {
			grid[i][j] = sc.nextInt();
		}
	}
  ```

* 무한 for문 이렇게도 쓸 수 있다

  ```java
  for (int i = 0; ; i++) {

  }
  ```
