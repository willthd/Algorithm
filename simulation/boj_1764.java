package practice;

import java.util.*;

// 아주 흥미로운 문제. 여기서 Set 자료구조를 사용하였는데, contains 함수를 사용할때 Set과 같은 경우
// 시간 복잡도가 O(1)이지만, list는 O(n)이므로 set을 사용하지 않으면 시간 초과가 난다
public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String arr[] = new String[m];
		Set<String> set = new HashSet<>();
		List<String> result = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			set.add(sc.next());
		}
		for (int i = 0; i < m; i++) {
			String temp = sc.next();
			arr[i] = temp;
			if (set.contains(temp)) {
				result.add(temp);
			}
		}
		System.out.println(result.size());
		Collections.sort(result);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

	}
}
