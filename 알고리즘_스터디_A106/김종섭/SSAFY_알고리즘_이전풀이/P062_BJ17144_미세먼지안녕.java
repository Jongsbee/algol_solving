package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P062_BJ17144_미세먼지안녕 {
	
	public static int R, C, T, dr, dc, count, munji, size, freshLoc;
	public static int[] locat;
	public static int [][] map, map2;
	public static int[][] dsnb = new int [][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public static int[][] dsnb2 = new int [][] {{0,1}, {-1,0}, {0,-1}, {1,0}};
	public static Queue<int[]> locs = new ArrayDeque<int[]>();
	
	public static void misemise () {
		
		size = locs.size();
		for(int index = 0; index < size; index ++) {
			locat = locs.poll();
			count = 4;
			for (int j2 = 0; j2 < 4; j2++) { // 미세먼지가 확산되어 0이 되는지 검사
				dr = dsnb[j2][0]; dc = dsnb[j2][1];
				if(locat[0] + dr < 0 || locat[1] + dc < 0 || locat[0] + dr >= R || locat[1] + dc >= C) count -=1;
			}
			if(map[locat[0]][locat[1]] - count <= 0) continue;
			
			munji =  map[locat[0]][locat[1]]/5;
			for (int j2 = 0; j2 < 4; j2++) {
				dr = dsnb[j2][0]; dc = dsnb[j2][1];
				if(locat[0] + dr < 0 || locat[1] + dc < 0 || locat[0] + dr >= R || locat[1] + dc >= C || map[locat[0]+dr][locat[1]+dc] == -1) continue;
				map2[locat[0]+dr][locat[1]+dc] += munji;
				}
				map2[locat[0]][locat[1]] -= count * munji;
			}
		
			for (int i = 0; i < R; i++) {
				System.arraycopy(map2[i], 0, map[i],0 , C);
			}
		}
		
	

	public static void clean () {
		

		for (int i = 0; i < 4; i++) {
			
				
				
		}
		
		
		
		
		for (int i = 0; i < R; i++) {
			System.arraycopy(map2[i], 0, map[i],0 , C);
		}
	 
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		T = Integer.parseInt(s[2]);
		map = new int [R][C];
		map2 = new int [R][C];
		for (int i = 0; i < R; i++) {
			String [] s2 = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(s2[j]);
				map2[i][j] = Integer.parseInt(s2[j]);
				switch (map[i][j]) {
				case 0  : break;
				case -1 : freshLoc = i; break;
				default : locs.add(new int [] {i,j});
					break;
				}
			}
		}
		
		misemise();
		
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		
	}

}
