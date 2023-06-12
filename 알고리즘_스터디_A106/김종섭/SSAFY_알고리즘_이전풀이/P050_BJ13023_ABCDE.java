package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P050_BJ13023_ABCDE {
	public static int[][] graph;
	public static int N, M;
	public static boolean[] isVisited;
	public static boolean InSSa;
	public static ArrayList<Integer>[] list;
	
	
	public static void Assa(int a, int index) {
		
		//Queue<Integer> needVisit = new LinkedList<Integer>();
		//needVisit.offer(a);
		
/*		while(!needVisit.isEmpty()) {
			a = needVisit.poll();
			
			for (int i = 0; i < N; i++) {
				if(graph[a][i] == 1 && isVisited[i]==0) {
					needVisit.add(i);
					isVisited[i] = isVisited[a]+1;
					if(isVisited[i] == 5) {
						InSSa = true;
						return;
					}
				}
			}
		}*/
		
		if(index == 4) {
			InSSa = true;
		}
		if(InSSa) return;
		
/*		for (int i = 0; i < list[a].size(); i++) {
			
			if(isVisited[i]==0) {
				isVisited[i] = isVisited[a] + 1;
				Assa(i, index+1);
				isVisited[i] = 0;
			}
		}	*/
		
		for (int q : list[a]) {
			if(isVisited[q]) continue;
			isVisited[q] = true;
			Assa(q, index+1);
			isVisited[q] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		InSSa = false;
		
		list = new ArrayList[N];
		
		
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		

		graph = new int [N][N];
		for (int i = 0; i < M; i++) {
			String [] friend = br.readLine().split(" ");
			int a = Integer.parseInt(friend[0]);
			int b = Integer.parseInt(friend[1]);
//			graph[a][b] = 1; graph[b][a] = 1;
			list[a].add(b);
			list[b].add(a);
		}
		
		for (int i = 0; i < N; i++) {
			if(InSSa) break;
			isVisited = new boolean [N];
			isVisited[i] = true;
			Assa(i, 0);
			isVisited[i] = false;
		}
		if(InSSa) System.out.println(1);
		else System.out.println(0);
	}

}
