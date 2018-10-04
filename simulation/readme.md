에라토스테네스의 체

---

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

