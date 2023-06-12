package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P055_BJ16236_아기상어 {

	public static int N, babySize, eaten, dr, dc, locX, locY, pathCount, searchX, searchY;
	public static int[][] dsnb = new int [][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
	public static int[][] diamondStep = new int [][]{{1,-1}, {1,1}, {-1,1}, {-1,-1}};
	public static int [][] map;
	public static boolean isHungry;
	
	
	public static boolean canEat(int a, int b) {
		if(a > b) return true;
		return false;
	}
	
	
	public static void mukbang () {
		 
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < 4; j++) {
				dr = dsnb[j][0]; dc = dsnb[j][1];
//				if(locX + dr < 0 || locY + dc < 0 || locX + dr >= N || locY + dc >= N) continue; // 범위 벗어나는건 제외
//				else { // 만약 구롷지 않다면
//					if(babySize > map[locX+dr][locY+dc]) { // 먹방한다
//						eaten += 1;
//						if(babySize == eaten) {
//							babySize += 1;
//							eaten = 0;
//						}
//						pathCount += i;
//						isHungry = false; // 한마리 잡았으니 배불렁
//						return;
//					}
//					
//					
//				}

				
			}
		}
	}
	
	public static void shrimpSearch () {
		searchX = locX;
		searchY = locY;
		
		for (int i = 1; i <= N-1; i++) {
			for (int j = 0; j < 4; j++) {
				for (int j2 = 0; j2 < N-1; j2++) {
					
				}
			}
		}
		
		
	}
	
	public static void canEat() {
		
		
		
	}
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for (int i = 0; i < N; i++) {
			String [] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if(Integer.parseInt(s[j]) == 9) {
					locX = i; locY = j;
				}
			}
			
			babySize = 2; eaten = 0;
			
			for (int j = 0; j < s.length; j++) {
				isHungry = true;
			}
		}
		
		

	}

}
