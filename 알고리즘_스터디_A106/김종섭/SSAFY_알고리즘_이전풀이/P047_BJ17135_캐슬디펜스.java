package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P047_BJ17135_캐슬디펜스 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] s= br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int D = Integer.parseInt(s[2]);
		
		int [][]arr = new int [N+1][M];
		for (int i = 0; i < N+1; i++) {
			String [] s2 = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(s2[j]);
			}
		}
		
		
	}

}
