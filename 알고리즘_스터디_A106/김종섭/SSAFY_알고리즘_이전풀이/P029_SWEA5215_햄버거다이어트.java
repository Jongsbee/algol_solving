package 김종섭;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class P029_SWEA5215_햄버거다이어트 {
	

	public static void main(String[] args) throws Exception{


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			String [] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]); // N : 5
			L = Integer.parseInt(s[1]); // L : 1000
			// N번 for
			Ti = new int [N];
			Ki = new int [N];
			
			for (int j = 0; j < N; j++) {
				String [] s2 = br.readLine().split(" ");
				Ti[j] = Integer.parseInt(s2[0]);
				Ki[j] = Integer.parseInt(s2[1]);
			}
			
			maxTaste = 0;
			subset(0,0,0);
			// 저장 완료
			System.out.println("#" + i + " " + maxTaste);
		} // 
	} 
	
	static int N, L, maxTaste;
	static int [] Ti, Ki;
	public static void subset(int index, int taste, int kcal) { 
		// index : 부분집합에 고려할 대상 원소의 인덱스, taste : 해당 인덱스에서의 맛의 합, kcal : 해당 인덱스에서의 칼로리의 합
		
		if(kcal > L) return; // 칼로리가 최대치보다 높다면, 패스
		
		if(index == N) {     // index 가 마지막일때 (다 돌렸을 때) maxTaste 값에 taste 의 최대값을 저장한다.
			if(taste > maxTaste) {
				maxTaste = taste;
			}return;
		}
		
		// 원소를 선택하였을 경우
		subset(index+1, taste + Ti[index], kcal + Ki[index]);
		// 원소를 선택하지 않았을 경우
		subset(index+1, taste, kcal);
	}
}


