package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P049_SWEA1238_Contact {
//	public static Map<Integer, ArrayList<Integer>> graph;
	public static int [][] graph;
	public static int[] isVisited;
	
	public static int bfs(int node) {
		
//		Queue<Integer> visited = new LinkedList<Integer>();
		Queue<Integer> needVisit = new LinkedList<Integer>();
		
		needVisit.offer(node);
		int depth = 1;
		isVisited[node] = depth;
		
		while(!needVisit.isEmpty()) {
			node = needVisit.poll();
			
			for (int i = 0; i <= 100; i++) {
				if(graph[node][i]==1 && isVisited[i]==0) {
					needVisit.offer(node);
					isVisited[i] = isVisited[node] + 1;
				}
			}
			depth = Math.max(depth, isVisited[node]);
		}
		for (int i = 100; i >= 0; i--) {
			if(isVisited[i] == depth) return i;
		}
		
		return -1;
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		graph = new HashMap<>();
		graph = new int[101][101];
		isVisited = new int [101];
		for (int i = 1; i <= 10; i++) {
			String [] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			
			String [] s2 = br.readLine().split(" ");
			for (int j = 0; j < N/2; j++) {
				int from = Integer.parseInt(s2[2*j]);
				int to = Integer.parseInt(s2[2*j+1]);
				
				graph[from][to] = 1;
			}
			
			int ans = bfs(M);
			System.out.println("#" + i + " " + ans);
		}

	}

}
