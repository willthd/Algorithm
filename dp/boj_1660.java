package practice;

import java.util.Arrays;
import java.util.Scanner;

// 백준, 1660, 캡틴 이다솜
public class Main3{
    public static int sum(int input) {
      int sum = 0;
      for (int i = 1; i <= input; i++) {
          sum += i;
      }
      return sum;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int number = 0;
        for (int i = 1; ; i++){
            number += sum(i);
            if (number > n)
                break;
            for (int target = number; target <= n; target++){
            		// dp[target]은 이 전까지의 기준 숫자로 계산 했을 때 최소값, dp[target - number] + 1은 새로운 기준 숫자로 계산했을 때 최소
                dp[target] = Math.min(dp[target], dp[target - number]+1);
            }
        }
        System.out.println(dp[n]);
    }
}
