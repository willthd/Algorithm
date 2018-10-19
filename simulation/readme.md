### 에라토스테네스의 체 (소수 찾기)

```java
int n = sc.nextInt();
int sqrt = (int) Math.sqrt(n);
boolean checked[] = new boolean[n + 1];

for (int i = 2; i <= sqrt; i++) {
	if (checked[i]) {
		continue;
	}
	for (int j = i * i; j <= n; j += i) {
		checked[j] = true;
	}
}
```



### 약수 찾기

소수 찾는 방식과 동일. 마찬가지로 루트n까지만 확인하면 된다

```java
package practice;

import java.util.*;

public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				System.out.println(i + " " + n / i);
			}
		}
	}
}

//		input
//		100
		
//		output
//		2 50
//		4 25
//		5 20
//		10 10
```

