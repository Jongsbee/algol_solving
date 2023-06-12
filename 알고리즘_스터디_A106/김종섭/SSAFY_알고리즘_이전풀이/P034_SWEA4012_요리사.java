package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P034_SWEA4012_요리사 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			map = new int [N][N];
			for (int j = 0; j < N; j++) {
				String [] s = br.readLine().split(" ");
				for (int j2 = 0; j2 < N; j2++) {
					map[j][j2] = Integer.parseInt(s[j2]);	
				}
			}
			numbers = new int [N/2];
			notnumbers = new int [N/2];
			
			isSelected = new boolean[N];
			min = Integer.MAX_VALUE;
			comb(0,0);
			System.out.println("#" + i + " " + min);
			
		}
	 
		
	}

	static int[][] map;
	static int[] numbers, notnumbers;
	static boolean []isSelected;
	static int N, sum, sum2, min;
	
	
	public static void comb(int cnt, int start) {
		
		if (cnt == N/2) {
			int index = 0;
			for (int i = 0; i < N; i++) {
				if(!isSelected[i]) {
					notnumbers[index] = i;
					index++;
				}
			}
			
			sum = 0; sum2 = 0;
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < N/2; j++) {
					sum += map[numbers[i]][numbers[j]];
					sum2 += map[notnumbers[i]][notnumbers[j]];
				}
			}
			if(min > Math.abs((sum-sum2))) min = Math.abs((sum-sum2));
			//System.out.println(min);
			return;
		}

		for (int i = start; i < N; i++) {
			if(isSelected[i]) continue; 
			numbers[cnt] = i;
			isSelected[i] = true;
			comb(cnt+1, i+1);
			isSelected[i] = false;
		}
	}

}
