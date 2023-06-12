package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P053_SWEA7465_창용마을무리의개수 {
	
	public static int[] id;
	
	public static int root(int a) {
		if(id[a] == a) return a;
		else {
			while(a != id[a]) a = id[a];
			return a;
		}
	}
	
	public static void Union (int a, int b) {
		id[root(a)] = root(b);
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			String [] s1 = br.readLine().split(" ");
			int N = Integer.parseInt(s1[0]);
			int M = Integer.parseInt(s1[1]);
			
			id = new int [N+1];
			for (int j = 0; j <= N; j++) {
				id[j] = j;
			}
			
			
			for (int j = 0; j < M; j++) {
				String [] s2 = br.readLine().split(" ");
				int a = Integer.parseInt(s2[0]);
				int b = Integer.parseInt(s2[1]);
				Union(a,b);
			}
			int count = 0;
			for (int j = 0; j <= N; j++) {
				id[j] = root(j);
			}
			Arrays.sort(id);
			for (int j = 0; j < N; j++) {
				if(id[j] == id[j+1]) continue;
				else count += 1;
			}
			
			System.out.println("#" + i + " " + count);
		}
		
		

	}

}
