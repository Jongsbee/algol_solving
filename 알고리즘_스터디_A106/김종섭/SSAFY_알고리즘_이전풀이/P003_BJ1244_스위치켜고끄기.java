package 김종섭;

import java.util.Arrays;
import java.util.Scanner;

public class P003_BJ1244_스위치켜고끄기 {
	
	public static void main(String[] args) {
		// 미완
		Scanner scann = new Scanner(System.in);
		int T = scann.nextInt();
		int [] arr1 = new int [T];
		 
		// 1. 테스트 케이스 
		
		for (int i=0; i<T; i++) {
			int S = scann.nextInt();	
			arr1[i] = S;
		}
		//---------------------- 완료 ----------------------
		// 2. 남학생 여학생 
		int N = scann.nextInt( );
			
		for (int m=0; m < N; m++) {
			int gender = scann.nextInt();   // 남학생 = 1, 여학생 = 2
			int switch1 = scann.nextInt();   // 몇번째 배열위치 선택

			// 남학생인 경우
			if (gender == 1) {
				for (int j=1; j <= T; j++) {
					if (j % switch1 == 0) {
						arr1[switch1*j-1] = (arr1[switch1*j-1] +1) % 2;
						System.out.println("점검");		
					}
				System.out.println(Arrays.toString(arr1));
				}	// 여학생인 경우
			}else if (gender == 2){
				for (int j=0; j < Math.min(switch1, T-switch1); j++) {
					if (arr1[switch1-1-j] == arr1[switch1-1+j]) {
							arr1[switch1-1-j] = (arr1[switch1-1-j]+1)% 2;
							arr1[switch1-1+j] = (arr1[switch1-1+j]+1)% 2;
						}
					}
				}
			}
		
		for (int i = 0; i < arr1.length; i++) {
			
			if (i == 0) System.out.print(arr1[i]);
			else if (i % 20 == 0) System.out.print("\n" + arr1[i]);
			else System.out.print(" " + arr1[i]);
			

		}
		
	}

}
