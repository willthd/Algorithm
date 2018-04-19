import java.util.*;
 
// 부등호
public class Main2 {
    static int n, a[];
    static String bu[];
    static boolean visited[];
    static boolean flag = false;
    
    static void func1(int dep) {
        if (flag) {
            return;
        }
        if (dep == n + 1) {
            for (int i = 0; i < n + 1; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
            flag = true;
            return;
        }
        // i는 0부터 9까지 넣고, 위에 for문에서 n부터 0까지 출력하는 경우와
        // i는 9부터 0까지 넣고, 위에 for문에서 0부터 n까지 출력하는 경우는 다르다
        // 그냥 큰 값부터 출력할 때는 i는 9부터 넣고, 작은 값 출력할 때는 0부터 넣어서 위에서 순서대로 출력한다
        for (int i = 9; i >= 0; i--) {
            if (visited[i]) {
                continue;
            }
            if (dep - 1 >= 0) {
                if (bu[dep - 1].equals("<")) {
                    // 주의! i : a[dep]을 의미한다
                    if (a[dep - 1] > i) {
                        continue;
                    }
                }
                if (bu[dep - 1].equals(">")) {
                    if (i > a[dep - 1]) {
                        continue;
                    }
                }
            }
            a[dep] = i;
            visited[i] = true;
            func1(dep + 1);
            visited[i] = false;
        }
    }
 
    static void func2(int dep) {
        if (flag) {
            return;
        }
        if (dep == n + 1) {
            for (int i = 0; i < n + 1; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
            flag = true;
            return;
        }
        // i는 0부터 9까지 넣고, 위에 for문에서 n부터 0까지 출력하는 경우와
        // i는 9부터 0까지 넣고, 위에 for문에서 0부터 n까지 출력하는 경우는 다르다
        for (int i = 0; i <= 9; i++) {
            if (visited[i]) {
                continue;
            }
            if (dep - 1 >= 0) {
                if (bu[dep - 1].equals("<")) {
                    // 주의! i : a[dep]을 의미한다
                    if (a[dep - 1] > i) {
                        continue;
                    }
                }
                if (bu[dep - 1].equals(">")) {
                    if (i > a[dep - 1]) {
                        continue;
                    }
                }
            }
            a[dep] = i;
            visited[i] = true;
            func2(dep + 1);
            visited[i] = false;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n + 1];
        bu = new String[n];
        visited = new boolean[10];
        for (int i = 0; i < n; i++) {
            bu[i] = sc.next();
        }
        func1(0);
        a = new int[n + 1];
        visited = new boolean[10];
        flag = false;
        func2(0);
    }
}
×