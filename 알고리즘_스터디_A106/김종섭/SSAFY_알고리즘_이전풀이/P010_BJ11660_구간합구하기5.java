package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P010_BJ11660_구간합구하기5 {
	// 시간오버
	public static void main(String[] args) throws Exception {
		

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		String [] arr1 = bfr.readLine().split(" ");

		
		int N = Integer.parseInt(arr1[0]);
		int M = Integer.parseInt(arr1[1]);
		
		String [][] arr2 = new String [N][N];
		
		int [][] arr3 = new int [N][N];

//		int [] arr4 = new int [N*N];
		for(int i=0; i<N; i++) {
			arr2[i] = bfr.readLine().split(" ");
			for (int j=0; j<N; j++) {
				arr3[i][j] = Integer.parseInt(arr2[i][j]);
			}
		}
	
//		for(int i=0; i<N*N; i++) { // 배열 arr4 에 한줄로 저장
//			arr4[i] = arr3[i/N][i%N];
//		}
		
		StringBuilder stb = new StringBuilder();
		for (int i=0; i<M; i++) {
			
			String [] arr5 = bfr.readLine().split(" ");
			int x1 = Integer.parseInt(arr5[0]);
			int y1 = Integer.parseInt(arr5[1]);
			int x2 = Integer.parseInt(arr5[2]);
			int y2 = Integer.parseInt(arr5[3]);
			
			
			int sum = 0;
			for (int k=y1-1; k<=y2-1; k++) {
				for (int j=x1-1; j<=x2-1; j++) { // N 은4
					sum += arr3[k][j];
				}

			}	
			stb.append(sum).append("\n");
		}
		System.out.println(stb);
	}
}
