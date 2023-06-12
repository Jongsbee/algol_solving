package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P061_BJ4485_녹색옷입은애가젤다지_다익스트라 {
	
	public static int dr, dc, T, size;
	public static boolean [][] isVisited;
	public static int[][] graph, darkRufi;
	public static int[][] dsnb = new int [][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
	public static Queue<int[]> list = new ArrayDeque<int[]>();
	
	
	public static void pathFinding() {
		size = list.size();
		while(!list.isEmpty()) {
			int [] Loc = list.poll();
			for (int i = 0; i < 4; i++) {
				dr = dsnb[i][0]; dc = dsnb[i][1];
				if(Loc[0] + dr < 0 || Loc[1] + dc < 0 ||Loc[0] + dr >= T ||Loc[1] + dc >= T ) continue;
				else {
					if(graph[Loc[0]][Loc[1]] + darkRufi[Loc[0] + dr][Loc[1] + dc] < graph[Loc[0] + dr][Loc[1] + dc]) {
						graph[Loc[0] + dr][Loc[1] + dc] = graph[Loc[0]][Loc[1]] + darkRufi[Loc[0] + dr][Loc[1] + dc];
						list.add(new int[] {Loc[0] + dr, Loc[1] + dc});
					}
				}
			}
		}
		return;
	}
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while(true) {
			T = Integer.parseInt(br.readLine());
			if(T == 0) break;
			darkRufi = new int [T][T];
			for (int i = 0; i < T; i++) {
				String [] s = br.readLine().split(" ");
				for (int j = 0; j < T; j++) {
					darkRufi[i][j] = Integer.parseInt(s[j]);
				}
			}
			isVisited = new boolean [T][T];
			isVisited[0][0] = true;
			graph = new int [T][T];
			for (int i = 0; i < T; i++) {
				Arrays.fill(graph[i], Integer.MAX_VALUE);
			}
			graph[0][0] = darkRufi[0][0];
			list.add(new int [] {0,0});
			pathFinding();
			sb.append("Problem ").append(tc).append(": ").append(graph[T-1][T-1]);
			sb.append("\n");
			tc += 1;
		} // end of while
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb);
	}

}
