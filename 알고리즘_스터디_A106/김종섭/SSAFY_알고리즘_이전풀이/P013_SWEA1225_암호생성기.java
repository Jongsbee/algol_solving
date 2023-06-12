package 김종섭;

import java.io.*;
import java.util.Arrays;

public class P013_SWEA1225_암호생성기 {

	public static void main(String[] args) throws Exception  {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String [] password = new String [8];
		
		int [] arr = new int [password.length];
		int i=0, endnum = 0;
		
		while(true) {
			StringBuilder stb = new StringBuilder();
			int T = Integer.parseInt(bfr.readLine());
			password = bfr.readLine().split(" ");
			for (int j = 0; j < password.length; j++) {
				arr[j] = Integer.parseInt(password[j]);
			}
			stb.append("#").append(T).append(" ");
			for (int j = 0; j >=0; j++) {
				switch (j%5) {
				case 0:
					arr[j%8] += -1;
					break;
				case 1:
					arr[j%8] += -2;
					break;
				case 2:
					arr[j%8] += -3;
					break;
				case 3:
					arr[j%8] += -4;
					break;
				case 4:
					arr[j%8] += -5;
					break;
				}
				if (arr[j%8] <= 0) {
					arr[j%8] = 0;
					endnum = j%8;
					break;
				}
				
			}for (int j = endnum+1; j < arr.length + endnum+1; j++) {
				stb.append(arr[j%8]).append(" ");
			}
			
			System.out.println(stb);
		if (T==10) break;}
		

	}

}
