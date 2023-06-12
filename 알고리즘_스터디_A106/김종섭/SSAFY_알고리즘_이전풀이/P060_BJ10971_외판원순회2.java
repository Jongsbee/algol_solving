package 김종섭;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class P060_BJ10971_외판원순회2 {
	public static int [][] arr;
	public static int N, min, sum, first;
	public static PriorityQueue<Edge>[] list;
	public static int[] id;
	public static boolean[] isVisited;
	
	public static class Edge implements Comparable<Edge> {
		public int node1;
		public int weight;
		
		public Edge(int node1, int weight) {
			this.node1 = node1;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [node1=" + node1 + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
		
	}
	
/*	public static int root (int a) {
		if(id[a] == a) return a;
		else {
			while(a != id[a]) {
				id[a] = id[id[a]];
				a = id[a];
			}
			return a;
		}
	}
	
	public static void Union (int a, int b) {
		if(root(a) == root(b)) return;
		else {
			id[root(b)] = root(a);
		}
	}*/
	
	public static void whypanone (int index, int start) {
		
		if(index == N) {
				Edge edge2 = list[first].poll();
				sum += edge2.weight;
			return;
		}
		
		while(!list[start].isEmpty()) {
			Edge edge1 = list[start].poll();
			if(isVisited[edge1.node1]) continue;
			else {
				isVisited[edge1.node1] = true;
				sum += edge1.weight;
				whypanone(index + 1, edge1.node1);
				break;
			}
		}
		
	}
	

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		id = new int [N];
		list = new PriorityQueue[N];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
		for (int i = 0; i < N; i++) {
			String [] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
				if(Integer.parseInt(s[j]) != 0) list[i].add(new Edge (j, Integer.parseInt(s[j])));
			}
		}
		
		for (int i = 0; i < N; i++) {
			isVisited = new boolean [N];
			isVisited[i] = true;
			sum = 0;
			first = i;
			whypanone(0, i);
			min = Math.min(min, sum);
		}
		
		
		
		System.out.println(min);
		
		

	}

}
