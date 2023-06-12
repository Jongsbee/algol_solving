package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P038_SWEA5644_무선충전 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int map [][] = new int [10][10];
		for (int t = 1; t <= T; t++) {
			String[] s1 = br.readLine().split(" ");
			int time = Integer.parseInt(s1[0]);
			int BC = Integer.parseInt(s1[1]);
			for (int i = 0; i < 10; i++) {
				Arrays.fill(map[i], 0);
			}
			int [] A = new int [time+1];
			int [] B = new int [time+1];
			
			String[] sA = br.readLine().split(" ");
			String[] sB = br.readLine().split(" ");
			for (int i = 1; i <= time; i++) {
				A[i] = Integer.parseInt(sA[i]);
				B[i] = Integer.parseInt(sB[i]);
			}
			int[][] AP = new int [BC][4];
			for (int i = 0; i < BC; i++) {
				String[] sAP = br.readLine().split(" ");
				for (int j = 0; j < 4; j++) {
					AP[i][j] = Integer.parseInt(sAP[j]);
				}
				AP[i][0]--;
				AP[i][1]--;
			} // 입력 끝
			
			//2. 
			for (int k = 0; k < AP.length; k++) {
				for (int i = 0; i < BC; i++) {
					for (int j = AP[i][0]-AP[i][2]; j <= AP[i][0]+AP[i][2]; j++) {
						
					}
				}
				
			}
			
			
			//3. A와 B tracing
			int LocAx = 0, LocAy = 0, LocBx = 9, LocBy = 9;
			int sumA = 0; int sumB = 0;
			
			for (int i = 0; i <= time; i++) {
				switch (A[i]) {
				case 0:
					sumA += map[LocAx][LocAy];
					break;
				case 1:
					LocAy--;
					sumA += map[LocAx][LocAy];
					break;
				case 2:
					LocAx++;
					sumA += map[LocAx][LocAy];
					break;
				case 3:
					LocAy++;
					sumA += map[LocAx][LocAy];
					break;
				case 4:
					LocAx--;
					sumA += map[LocAx][LocAy];
					break;
				default:
					break;
				}
				switch (B[i]) {
				case 0:
					sumB += map[LocBx][LocBy];
					break;
				case 1:
					LocBy--;
					sumB += map[LocBx][LocBy];
					break;
				case 2:
					LocBx++;
					sumB += map[LocBx][LocBy];
					break;
				case 3:
					LocBy++;
					sumB += map[LocBx][LocBy];
					break;
				case 4:
					LocBx--;
					sumB += map[LocBx][LocBy];
					break;
				default:
					break;
				}
				
			}
			
		}
	}

}
