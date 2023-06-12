package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P057_BJ10026_적록색약 {
	public static boolean [][] isVisited, isVisited2;
	public static int[][] dsnb = new int [][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
	public static int dr, dc, count1, count2, N;
	public static char [][] map, map2;
	public static Queue<int[][]> queue;
	public static boolean isRed;
	
	public static void bfs(int x, int y, char character) {
		
		for (int i = 0; i < 4; i++) {
			dr = dsnb[i][0];
			dc = dsnb[i][1];
			if(x+dr < 0 || y + dc < 0 || x+dr >= N || y + dc >= N) continue;
			else {
				if(isVisited[x + dr][y + dc]) continue;
				else {
					if(map[x + dr][y + dc] == map[x][y]) {
						isVisited[x + dr][y + dc] = true;
						bfs(x + dr,y +dc,character);
					}
				}
				
			}

		}
	}
	
	public static void bfs2(int x, int y, char character) {
		
		for (int i = 0; i < 4; i++) {
			dr = dsnb[i][0];
			dc = dsnb[i][1];
			if(x+dr < 0 || y + dc < 0 || x+dr >= N || y + dc >= N) continue;
			else {
				if(isVisited2[x + dr][y + dc]) continue;
				else {
					if(map2[x + dr][y + dc] == map2[x][y]) {
						isVisited2[x + dr][y + dc] = true;
						bfs2(x + dr,y +dc,character);
					}
				}
				
			}

		}
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isVisited = new boolean [N][N]; isVisited2 = new boolean [N][N];
		map = new char [N][N];          map2 = new char [N][N];

		for (int i = 0; i < N; i++) {
			char [] arr = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = arr[j];
				if(arr[j] == 'G') map2[i][j] = 'R';
				else map2[i][j] =arr[j];
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if(isVisited[i][j]) continue;
				else {
					isVisited[i][j] = true;
					bfs(i,j,map[i][j]);
					count1 += 1;
				}

			}
			
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(isVisited2[i][j]) continue;
				else {
					isVisited2[i][j] = true;
					bfs2(i,j,map2[i][j]);
					count2 += 1;
				}

			}
			
		}
		
		
		System.out.println(count1 + " " + count2);
		

	}

}
