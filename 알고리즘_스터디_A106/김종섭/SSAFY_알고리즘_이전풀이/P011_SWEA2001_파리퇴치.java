package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class P011_SWEA2001_파리퇴치 {
		
	public static void main(String[] args) throws NumberFormatException, IOException {

		//BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		//int T = Integer.parseInt(bfr.readLine());
		
		Scanner scann = new Scanner(System.in);
		int T = scann.nextInt();

		for (int i=1; i<=T; i++) {
			
			//int N = Integer.parseInt(bfr.readLine());
			//int M = Integer.parseInt(bfr.readLine());
			
			int N = scann.nextInt();
			int M = scann.nextInt();
			int [][] arr1 = new int [N+2][N+2];
			int maxflykill = -1;
			
			for(int j=0; j<N; j++) {
					Arrays.fill(arr1[j], 0);
			}
			//System.out.println(Arrays.deepToString(arr1));
			for(int j=1; j<N+1; j++) {
				for(int k=1; k<N+1; k++) {
					//int t = Integer.parseInt(bfr.readLine());
					arr1[j][k] = scann.nextInt();
				}
			}
			
			for(int j=0; j<N-M+2; j++) { // y의 범위
				for(int k=0; k<N-M+2; k++) { // x의 범위
					int sum = 0;
					
					for(int m=j; m<M+j; m++) { //y값 더하기
						for(int n=k; n<M+k; n++) { // x값 더하기
							sum += arr1[m][n];
						}
					}maxflykill = Math.max(maxflykill, sum);
					
				}
			}
			
			System.out.println("#" + i + " " + maxflykill);
		}

	}

}
