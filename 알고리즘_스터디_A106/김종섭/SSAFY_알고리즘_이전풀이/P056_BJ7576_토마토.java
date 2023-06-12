package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P056_BJ7576_토마토 {

	public static Queue<int[]> tomatomato = new ArrayDeque<int[]>();
	public static int countZero, countTime, size, dr, dc, N, M;
	public static int[] rtomato = new int [2];
	public static int[][] dsnb = new int [][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
	public static int[][] tomatoBox;
	public static boolean [][] isRotten;
	public static boolean noMoreTomato;
	
	public static void rottenTomato () {
		
		if(tomatomato.isEmpty()) {
			noMoreTomato = true;
			return;
		}
		size = tomatomato.size();
		countTime += 1;
		for (int i = 0; i < size; i++) {
			rtomato = tomatomato.poll();
			for (int j = 0; j < 4; j++) {
				dr = dsnb[j][0]; dc = dsnb[j][1];
				
				if(rtomato[0]+dr < 0 || rtomato[1]+dc < 0 || rtomato[0]+dr >= N || rtomato[1]+dc >= M) continue;
				else {
					if(isRotten[rtomato[0]+dr][rtomato[1]+dc] || tomatoBox[rtomato[0]+dr][rtomato[1]+dc] == -1|| tomatoBox[rtomato[0]+dr][rtomato[1]+dc] == 1) continue;
					else {
						isRotten[rtomato[0]+dr][rtomato[1]+dc] = true;
						tomatoBox[rtomato[0]+dr][rtomato[1]+dc] = 1;
						tomatomato.offer(new int []{rtomato[0]+dr, rtomato[1]+dc});
						countZero -=1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] s = br.readLine().split(" ");
		
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		tomatoBox = new int [N][M];
		isRotten = new boolean [N][M];
		countTime = 0;
		for (int i = 0; i < N; i++)  {
			String [] s2 = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				tomatoBox[i][j] = Integer.parseInt(s2[j]);
				if(Integer.parseInt(s2[j]) == 0) countZero += 1;
				if(Integer.parseInt(s2[j]) == 1) tomatomato.offer(new int[] {i,j});
			}
		}
		if(!tomatomato.isEmpty()) {
			isRotten[tomatomato.peek()[0]][tomatomato.peek()[1]] = true;
			while(!noMoreTomato) {
				rottenTomato();
			}
			if(countZero == 0) System.out.println(countTime-1);
			else System.out.println(-1);
		}
		else {
			System.out.println(-1);
		}
		
		
	}

}
