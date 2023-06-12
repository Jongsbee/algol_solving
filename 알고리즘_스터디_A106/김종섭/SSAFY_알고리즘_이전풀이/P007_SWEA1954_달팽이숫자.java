package 김종섭;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class P007_SWEA1954_달팽이숫자 {
	static int[][] dnsb = {{0,1}, {1,0}, {0, -1}, {-1,0}}; // dnsb = 동남서북


	public static void main(String[] args) throws NumberFormatException, IOException {
		// 언젠간... 먼 훗날에~~ 		
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bfr.readLine());
		
		for (int i=1; i<=T; i++) {
			int snail = 1, x = 0, y = 0;
			int N = Integer.parseInt(bfr.readLine());
			int [][] snailcute = new int [N][N];
			snailcute [0][0] = 1;
			
			for(int jj=0; jj<N/2.0;jj++) {
					// 달팽이가 동쪽으로 기어간다
					for (int k1 =0; k1<N-(2*jj)-1; k1++) {
						y += dnsb[0][0];
						x += dnsb[0][1];
						snail += 1;
						snailcute[y][x] = snail;
						
					}if (snail >= N*N) break;
					// 달팽이가 남쪽으로 기어간다
					for (int k2 =0; k2<N-(2*jj)-1; k2++) {
						
						y += dnsb[1][0];
						x += dnsb[1][1];
						snail += 1;
						snailcute[y][x] = snail;
					}if (snail >= N*N) break;
					// 달팽이가 서쪽으로 기어간다
					for (int k3 =0; k3<N-(2*jj)-1; k3++) {
						
						y += dnsb[2][0];
						x += dnsb[2][1];
						snail += 1;
						snailcute[y][x] = snail;
						
					}if (snail >= N*N) break;
					// 달팽이가 북쪽으로 기어간다
					for (int k4 =0; k4<N-(2*jj)-2; k4++) {
						
						y += dnsb[3][0];
						x += dnsb[3][1];
						snail += 1;
						snailcute[y][x] = snail;
						
					}if (snail >= N*N) break;
					// 오른쪽으로 한번 밍기적
						y += dnsb[0][0];
						x += dnsb[0][1];
						snail += 1;
						snailcute[y][x] = snail;
						if (snail >= N*N) break;
				
			}
			System.out.println("#" + i);
			for (int j=0; j<N; j++) {
				for (int k=0; k<N; k++) {
					System.out.print(snailcute[j][k] + " ");
					if (k==N-1) {
						System.out.println();
					}
				}
			}
		}
		
 
	}

}
