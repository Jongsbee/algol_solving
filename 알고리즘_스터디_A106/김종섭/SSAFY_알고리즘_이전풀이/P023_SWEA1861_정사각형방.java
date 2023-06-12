package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P023_SWEA1861_정사각형방 {
	static int [][] dsnb = new int [][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

	public static void main(String[] args) throws Exception {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sbr = new StringBuilder();
		Set	<String> list = new HashSet<>();
		String s = "";
		int T = Integer.parseInt(bfr.readLine());
		for (int i = 0; i < T; i++) {
			int no = Integer.parseInt(bfr.readLine());
			int [][] arr = new int [no+2][no+2];
			for (int j=0; j<no+2; j++) {
				Arrays.fill(arr[j], 0);
			}
			for (int j = 0; j < no; j++) {	
				String [] s2 = bfr.readLine().split(" ");
				for (int j2 = 0; j2 < no; j2++) {
					arr[j+1][j2+1] = Integer.parseInt(s2[j2]);
				}
				
			}// 배열생성 완료
			
			for (int j = 0; j < no; j++) {
				for (int j2 = 0; j2 < no; j2++) {
					for (int k = 0; k < 2; k++) {
						for (int k2 = 0; k2 < 2; k2++) {
							//arr[j+1+dsnb[k][0]][j2+1];
						}
					}
					
				}
			}
			 
			
			
		} // end of T
	} // end of main

}
