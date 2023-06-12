package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class P052_SWEA3124_최소스패닝트리 {
	
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
	
	public static boolean isConnected (int a, int b) {
		if(root(a) == root(b)) return true;
		return false;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			String [] s1 = br.readLine().split(" ");
			int V = Integer.parseInt(s1[0]);
			int E = Integer.parseInt(s1[1]);
			
			id = new int [V+1];
			for (int j = 0; j <= V; j++) {
				id[j] = j;
			}

			int [][] map = new int [E][3];
			for (int j = 0; j < E; j++) {
				String [] s2 = br.readLine().split(" ");
				map[j][0] = Integer.parseInt(s2[0]); // from
				map[j][1] = Integer.parseInt(s2[1]); // to
				map[j][2] = Integer.parseInt(s2[2]); // weight
			}
			
			Arrays.sort(map, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[2] - o2[2];
				}	
			}); // 저장
			
			long count = 0;
			for (int j = 0; j < E; j++) {
				if(isConnected(map[j][0], map[j][1])) {
					continue;
				}else {
					Union(map[j][0], map[j][1]);
					count += map[j][2];
				}
			}
			
			System.out.println("#" + i + " " + count);
			
		}

	}

}
