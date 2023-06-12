package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P051_SWEA3289_서로소집합 {
	public static int [] id;
	public static int root(int a) {
		if(id[a] == a) return a;
		while(id[a] != a) {
			a = id[a];
		}return a;
	}
	
	public static boolean isConnected(int a, int b) {
		if(root(a) == root(b)) return true;
		else return false;	
	}
	
	public static void Union (int a, int b) {
		id[root(b)] = root(a);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringBuilder sb = new StringBuilder();
			String [] s1 = br.readLine().split(" ");
			int n = Integer.parseInt(s1[0]);			
			int m = Integer.parseInt(s1[1]);
			
			id = new int [n+1];
			for (int j = 0; j <= n; j++) id[j] = j;

			
			for (int j = 0; j < m; j++) {
				String[] s2 = br.readLine().split(" ");
				int yeonsan = Integer.parseInt(s2[0]);
				int a = Integer.parseInt(s2[1]);
				int b = Integer.parseInt(s2[2]);
				
				switch (yeonsan) {
				case 0:
					Union(a, b);
					break;
				case 1:
					if(isConnected(a, b)) sb.append(1);
					else sb.append(0);
					break;
				}
			}
			System.out.println("#" + i + " " + sb);
			
		}

	}

}
