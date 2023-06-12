package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P032_BJ15686치킨배달 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		houseList = new ArrayList<>();
		chickenList = new ArrayList<>();
		int[][] map = new int [N][N];
		
		
		for (int i = 0; i < N; i++) {
			String[] s2 = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s2[j]);
				switch (map[i][j]) {
				case 0:
					break;
				case 1:
					houseList.add(new int[] {i,j});
					break;
				case 2:
					chickenList.add(new int[] {i,j});
					break;
				}
			}
		}
		
//		System.out.println(houseList);
//		System.out.println(chickenList);
		
		// 2. 

		chickenLoc = new ArrayList<>();
		min1 = Integer.MAX_VALUE;
		YangnyumChicken(0, 0, chickenLoc);
		System.out.println(min1);
/*		String[][] map = new String [N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split(" ");
		}
		System.out.println(Arrays.deepToString(map));*/
		
		
		
		
		
		// 3.
		// 4.
		// 5.
		//
		
	}
	static List<int[]> chickenList, houseList, chickenLoc;
	static int min1, min2, sum, M, N;
	static void YangnyumChicken (int index, int count, List<int[]> chickenLoc) {
		
		if(chickenLoc.size() > M) return;
		
		if(index == chickenList.size() ) {
			if(count != 0) {
				
			//System.out.println(chickenLoc);
					sum = 0;
					for (int j = 0; j < houseList.size(); j++) {
						min2 = Integer.MAX_VALUE;
						for (int i = 0; i < chickenLoc.size(); i++) {
						int a = Math.abs(chickenLoc.get(i)[0]-houseList.get(j)[0])
								+ Math.abs(chickenLoc.get(i)[1]-houseList.get(j)[1]);
						min2 = Math.min(a, min2);
						// sum : x 거리 + y거리의 합
					} //System.out.print(min2 + " ");
						sum += min2;
					 // min1 에는 거리합들의 최소를 넣어
				}if(min1 > sum) min1 = sum;
			}return;
		}
		chickenLoc.add(chickenList.get(index));
		YangnyumChicken(index+1, count+1, chickenLoc);
		
		chickenLoc.remove(chickenList.get(index));
		YangnyumChicken(index+1, count, chickenLoc);	
	}

}
