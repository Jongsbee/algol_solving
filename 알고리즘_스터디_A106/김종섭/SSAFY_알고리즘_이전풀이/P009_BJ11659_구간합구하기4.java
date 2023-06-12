package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P009_BJ11659_구간합구하기4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sbr = new StringBuilder();
		String [] arr1 = bfr.readLine().split(" ");
		
		int N = Integer.parseInt(arr1[0]);
		int M = Integer.parseInt(arr1[1]);
		char [] arr3 = new char [N];
		arr3 = bfr.readLine().replace(" ", "").toCharArray();
		int [] arr4 = new int [N+1];
		arr4[0] = 0; 
		int sum = 0;
		int result = 0;
		
		for (int i=0; i<N; i++) {
			sum += arr3[i]-'0';
			arr4[i+1] = sum;
		}
		
//		System.out.println(Arrays.toString(arr4));
		
		for (int i=0; i<M; i++) {
			result = 0;
			String [] arr2 = bfr.readLine().split(" ");
			int ii = Integer.parseInt(arr2[0]);
			int jj = Integer.parseInt(arr2[1]);
			
//			for (int j=ii-1; j<=jj-1; j++) {
//				sum2 += arr3[j] - '0';
//			}
			result = arr4[jj] - arr4[ii-1];
			sbr.append(result).append("\n");
		}
		
		System.out.println(sbr);
	}

}
