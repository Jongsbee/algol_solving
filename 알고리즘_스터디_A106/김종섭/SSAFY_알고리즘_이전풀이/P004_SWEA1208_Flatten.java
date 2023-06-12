package 김종섭;

import java.io.*;
import java.util.*;

public class P004_SWEA1208_Flatten {

	public static void main(String[] args) {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 
		Scanner scann = new Scanner(System.in);
		int [] arr1 = new int [100];
		for (int i=1; i<=10; i++) {// 나중에 10으로 변경
			int T = scann.nextInt();
			int upNum = 0, downNum = 0;
			for (int j=0; j<100; j++) {
				arr1[j] = scann.nextInt();
			}

			Arrays.sort(arr1);
			// upNum 을 구하기
			System.out.print(T + " ");
			for (int j=100; j>=1; j--) {
				if(upNum != 0) break;
				int sum = 0;
				for(int k=0; k<100; k++) {
					if (arr1[99-k] > j) {
						sum += arr1[99-k]-j;
					}
					if (sum == T) {
						System.out.print(sum + " ");
						upNum = j;
						System.out.print("up eq ");
						break;
						}
					else if (sum > T) {
						System.out.print(sum + " ");
						upNum = j+1;
						System.out.print("up up ");
						break;
					}
					
				}
			}
			
			for (int j=1; j<=100; j++) {
				if(downNum != 0) break;
				int sum2 = 0;
				for(int k=0; k<100; k++) {
					if (arr1[k] <= j) {
						sum2 += j - arr1[k];
						if (sum2 == T) {
							System.out.print(sum2 + " ");
							downNum = j;
							System.out.print("down eq ");
							break;
						}
						if (sum2 > T) {
							System.out.print(sum2 + " ");
							downNum = j-1;
							System.out.print("down down ");
							break;
						}
						
					}
				}
			}
			System.out.print(upNum + " ");
			System.out.println(downNum);
			System.out.println("#"+i+" " +(upNum - downNum));
			
		}

	}
}
