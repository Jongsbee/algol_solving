package 김종섭;

import java.util.Arrays;
import java.util.Scanner;

public class P005_SWEA1210_Ladder1 {

	public static void main(String[] args) {
		 
		 
		int [][] ladder = new int [100][100];
		Scanner scann = new Scanner(System.in);
		
		for (int i=1; i<=10; i++) {
			int startx = 0, starty = 99;
			int t = scann.nextInt();
			for (int j=0; j<100; j++) {
				for (int k=0; k<100; k++) {
					ladder[j][k] = scann.nextInt();
				}
			}
			
			for (int j=0; j<100; j++) {
				if (ladder[99][j] == 2) {
					startx = j;
					break; 
				}
			}
			// ---------------------------- startx 구했엉  -------------------------------------
			

			int jj =0;
			while (jj>=0) {
				
					// 좌측
				if (startx != 0 && ladder[starty][startx-1]==1) {
					if(startx >= 1) {
					startx -= 1;
					for (int m=1; m<100;m++) {
						if (startx == 0) { 
							starty -= 1;
							break;
						}
						else if (ladder[starty][startx-1]==1 ) {

							startx -= 1;
						}
						else {
							starty -= 1;
							break;
						}
					}
					}
				}
				// 우측으로
				else if (startx != 99 && ladder[starty][startx+1]==1) {
					if (startx <= 98) {
					startx += 1;
					for (int m=1; m<100;m++) {
						if (startx == 99) {
							starty -= 1;
							break;
						}
						else if (ladder[starty][startx+1]==1) {
							startx += 1;
						}
						else {
							starty -= 1;
							break;
						}
					}
				}
				}
				// y축
				else if (ladder[starty-1][startx]==1) {
					starty -= 1;
				}
//				System.out.println(starty);
				
				if (starty == 0) {
					System.out.println("#" + i + " " + startx);
					break;
				}
			}

		}

	}

}
