package 김종섭;

import java.util.Arrays;
import java.util.Scanner;

public class 삼성시의_버스노선 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <=	 T; i++) {
			int N = sc.nextInt();
			int [][] bus = new int [N][2];
			for (int j = 0; j < N; j++) {
				bus[j][0] = sc.nextInt();
				bus[j][1] = sc.nextInt();
			}
			
			int P = sc.nextInt();
			int [] count = new int [P];
			for (int j = 0; j < P; j++) {
				int Ci = sc.nextInt();
				for (int j2 = 0; j2 < N; j2++) {
					if(Ci >= bus[j2][0] && Ci <= bus[j2][1]) count[j]+=1;
					
				}
			}
			
			System.out.print("#" + i + " ");
			for (int j = 0; j < P; j++) {
				System.out.print(count[j] + " ");
			}
			System.out.println();
			
		}
	}

}
