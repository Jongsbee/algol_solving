package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P018_SWEA1228_암호문1 {

	public static void main(String[] args) throws Exception {
		// 완료
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			List<Integer> list = new ArrayList<>();
			int N = sc.nextInt(); // 원래 암호문
			for (int j = 0; j < N; j++) {
				list.add(sc.nextInt());
			}
			int N2 = sc.nextInt(); // 명령어
			for (int j = 0; j < N2; j++) {
				String I = sc.next();
				int a = sc.nextInt();
				int b = sc.nextInt();
				for (int k = 0; k < b; k++) {
					list.add(a+k, sc.nextInt());
				} 
			}
			System.out.print("#" + i + " ");
			for (int j = 0; j < 10; j++) {
				System.out.print(list.get(j) + " ");
			}System.out.println();
		}
	}
}
