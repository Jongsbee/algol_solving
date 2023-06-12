package 김종섭;

import java.util.Arrays;
import java.util.Scanner;

public class P001_SWEA1289_원재의메모리복구하기 {

	// 1. 알고리즘을 모르는 원재의 복구방법
	
	public static void main(String[] args) {
		 
		Scanner scann = new Scanner(System.in);
		int T = scann.nextInt();
		
		for (int i=1; i<=T;  i++) {
			String str = scann.next();
			int [] arr = new int [str.length()];
			int count = 0;
			int count2 = 0;
			
			for (int j=0; j<str.length(); j++) {
				arr[j] = str.charAt(j)-'0';
					
			}
			for (int j=0; j<str.length(); j++) {
				if(arr[0] == 1) { 
					count2 = 1;
					if(j>0 && arr[j-1] != arr[j] ) {
						count += 1;
					}
					
				}else if (arr[0] == 0){ 
					count2 = 0;
					if(j>0 && arr[j-1] != arr[j] ) {
						count += 1;
					}
					
				}
			}
			System.out.println("#" + i + " " + (count + count2));
			
		}
		
	}

}
