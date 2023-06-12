package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P058_SWEA1251_하나로_프림인접리스트 {
	
	public static class Edge implements Comparable<Edge>{
		int node1, node2; // 섬번호로 표기할거니깐 int로 선언
		long weight;
		
		public Edge(int node1, int node2, long weight) {
			this.node1 = node1;
			this.node2 = node2;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) { // 요거 long으로 바꿔야하는데...
			return (int) (this.weight - o.weight);
		}
		
	}
	public static int E, N;
	static int [][] combi = new int [2][3], arr;
	public static PriorityQueue<Edge> pqueue;		
	public static boolean [] isVisited;
	
	
	public static void Combinaton(int index, int start) { // 모든 간선의 정보를 저장하기 위해, 조합을 선택
		
		if(index == 2) { // 2개를 뽑은 후, PriorityQueue에 간선 정보를 모두 넣기
			long distance = (long) Math.pow((Math.pow(combi[0][0]-combi[1][0], 2) + Math.pow(combi[0][1]-combi[1][1], 2)), 0.5);
			// 정점 끼리의 거리를 node로 저장 => root(x^2 + y^2)
			Edge e = new Edge(combi[0][2], combi[1][2], distance);
			pqueue.offer(e);
			return;
		}
		
		for (int i = start; i < N; i++) {
			combi[index] = arr[i];
			Combinaton(index + 1, start + 1);
			
		}
		
		
	}
	

	public static void main(String[] args) throws Exception{
		// E * L^2 만큼 지불
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine()); // 정점의 수
			E = N*(N-1)/2;   // 간선의 수 NC2
			arr = new int [N][3];
			String [] x = br.readLine().split(" ");
			String [] y = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {// 섬 N개의 좌표를 arr에 2차원 배열 형태로 저장
				arr[i][0] = Integer.parseInt(x[i]);
				arr[i][1] = Integer.parseInt(y[i]);
				arr[i][2] = i;   // 섬의 index 번호(정점의 번호) 를 넣어준다
			}
			
			 
			
		}
		
	}

}
