package 김종섭;

import java.io.*;
import java.util.*;

public class P024_BJ2563_색종이 {

	public static void main(String[] args) throws Exception {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sbr = new StringBuilder();
		Set	<String> list = new HashSet<>();
		
		int T = Integer.parseInt(bfr.readLine());
		for (int i = 0; i < T; i++) {
			String [] s1 = new String [2];
			s1 = bfr.readLine().split(" ");
			int N = Integer.parseInt(s1[0]);
			int M = Integer.parseInt(s1[1]);
			
			for (int j = 0; j < 10; j++) {
				for (int j2 = 0; j2 < 10; j2++) {
					list.add((j+N) + "." +(j2+M));
				}	
			}
 
		}System.out.println(list.size());

	}

}
