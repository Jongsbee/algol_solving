package 김종섭;

import java.util.Arrays;
import java.util.Scanner;


public class P006_SWEA2805_농작물수확하기 {

	public static void main(String[] args) {
		 
		Scanner scann = new Scanner(System.in);
		int T = scann.nextInt();
		
		for(int i=1; i<=T; i++) {
			int sum = 0;
			int N = scann.nextInt();
			
			int [][] arr1 = new int [N][N];
			char [][] arr2 = new char [N][N];
			
			for (int j=0; j<N; j++) {
				arr2[j] = scann.next().toCharArray();
				for (int k=0; k<N; k++) {
					arr1[j][k] = arr2[j][k]-'0';
				}
			}
			
			for (int j=0; j<N; j++) {
				if (j <= N/2) {
					for (int k=N/2-j; k<=N/2+j ; k++) {
							sum += arr1[j][k];
						}
					}
				else if (j>N/2){
					for (int k=j-N/2; k<=3*N/2-j-1 ; k++) {
						sum += arr1[j][k];
						System.out.println(sum);
					}
				}

			}System.out.println("#" + i + " " + sum);
		}	
	}
}
