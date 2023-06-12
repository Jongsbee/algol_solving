package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P043_SWEA1247_최적경로 {
	public static int min, N, sum=0;
	public static boolean[] isSelected;
	public static int[][] cliLoc;
	public static List<int[]> list = new ArrayList<>();
	public static int [] comLoc, homeLoc;
	
	public static void Permu(int index) {
		
		if(index == N) {
			int [] loc = new int []{comLoc[0], comLoc[1]};
			for (int i = 0; i < N; i++) {
				sum += Math.abs(list.get(i)[0]-loc[0]) + Math.abs(list.get(i)[0]-loc[0]);  	
			}
			
			return;
		}
		
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			list.add(cliLoc[i]);
			Permu(index + 1);
			isSelected[i] = false;
		}
		
		
	}
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			comLoc = new int [2];
			homeLoc = new int [2];
			cliLoc = new int [N][2];
			String [] s = br.readLine().split(" ");
			comLoc[0] = Integer.parseInt(s[0]);  comLoc[1] = Integer.parseInt(s[1]);
			homeLoc[0] = Integer.parseInt(s[2]);  homeLoc[1] = Integer.parseInt(s[3]);
			
			for (int j = 0; j < N; j++) {
				cliLoc[j][0] = Integer.parseInt(s[4+2*j]);
				cliLoc[j][1] = Integer.parseInt(s[5+2*j]);
			}	
			
/*			System.out.println(Arrays.toString(comLoc));
			System.out.println(Arrays.toString(homeLoc));
			System.out.println(Arrays.deepToString(cliLoc));*/
			
			isSelected = new boolean [N];
			
		}
		

	}

}
