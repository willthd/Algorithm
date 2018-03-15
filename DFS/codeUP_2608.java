import java.util.*;

// codeUp, 2608, 동아리 회장 선거
// 중복 순열
public class Main {
	static int n;
  static int a[21];
  static void f(int w){
    if(w==n){
      for(int i=0;i<n;i++){
        if(a[i]==0)System.out.print("O");
        else System.out.print("X");
      }
      System.out.println("");
      return;
    }
    for(int i=0;i<2;i++){
      a[w]=i;
      f(w+1);
    }

  }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		print(0, "");
	}
}
