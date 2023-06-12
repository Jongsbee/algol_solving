package 김종섭;

import java.io.*;
import java.util.*;

public class P020_SWEA9229_한빈이와SpotMart {

	public static void main(String[] args) throws Exception {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bfr.readLine());
		for (int i = 1; i <= T; i++) {
			List<Integer> list = new ArrayList<>();
			String [] s1 = new String [2];
			s1 = bfr.readLine().split(" ");
			int N = Integer.parseInt(s1[0]);
			int M = Integer.parseInt(s1[1]);
			
			String [] s2 = new String [N];
			int max = -1;
			s2 = bfr.readLine().split(" ");
			
			for (int j = 0; j < N; j++) {
				list.add(Integer.parseInt(s2[j]));
				}
				Collections.sort(list);
			
			for (int j = 0; j <N; j++) {
				if(list.get(0) + list.get(1) > M) {
					max = -1;
					break;
					}
				for (int j2 = j+1; j2 < N; j2++) {
					if (list.get(j) + list.get(j2) > M) continue;
					else max = Math.max(max, (list.get(j) + list.get(j2)));
					}
				}
			System.out.println("#" + i + " " + max);

			}
				
		
	}

}
