package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_13일의_금요일 {
	public static int[] days;
	
	public static boolean isMoonYear(int year) {
		if(year % 4 == 0) {
			if(year%100 == 0) {
				if(year%400 == 0)return true;
				else return false; 
			}else return true;
		}return false;
		
	}
	public static boolean isFriday (int day) {
		if(day % 7 == 4) return true;
		return false;
	}
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int day = 0; // 기준 : 2018년 12월 31일
		int count = 0;
		days = new int [] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for (int i = 2019; i <= N; i++) {
			for (int j = 0; j < 12; j++) {
				// 월일때
				day += 13; 
				if(isFriday(day)) count += 1;
				day += days[j]-13;
				if(isMoonYear(i) && j == 1) day += 1;
			}
			
		}System.out.println(count);
	}

}
