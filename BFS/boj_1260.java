package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준, 1260, DFS와 BFS
public class Solution {
	static int[][] graph = new int[1001][1001];
	static boolean[] visited = new boolean[1001];
	static int node;
	static int edge;
	static int start;
	
	public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for(int i = 1; i <= node; i++){
            if(graph[start][i] == 1 && visited[i] == false){
                dfs(i);
            }
        }
    }

	public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        visited[start] = true;
        System.out.print(start + " ");

        int temp;
        while(!q.isEmpty()){
            temp = q.poll();
            for(int i = 1; i <= node; i++){
                if(graph[temp][i] == 1 && visited[i] == false){
                    q.offer(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		node = sc.nextInt();
		edge = sc.nextInt();
		start = sc.nextInt();
		int first, second;
		for (int i = 0; i < edge; i++) {
			first = sc.nextInt();
			second = sc.nextInt();
			graph[first][second] = 1;
			graph[second][first] = 1;
		}

		dfs(start);
		System.out.println();
		for (int i = 1; i <= node; i++) {
			visited[i] = false;
		}
		bfs(start);
	}
}
