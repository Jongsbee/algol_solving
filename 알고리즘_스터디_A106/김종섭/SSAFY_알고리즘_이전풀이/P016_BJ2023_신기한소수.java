package 김종섭;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class P016_BJ2023_신기한소수 {
	//https://www.acmicpc.net/problem/2023
	static int N;
	static String s;
	public static SosuList[] arr = new SosuList[9];
	public static StringBuilder sbr = new StringBuilder();
	
	public static class SosuList {
	public List<String> lists = new ArrayList<>();
	}
	
	public static void Sosu(int number) {

		arr[number] = new SosuList();
		 
		if(number == 1) {
			arr[number].lists.add("2");
			arr[number].lists.add("3");
			arr[number].lists.add("5");
			arr[number].lists.add("7");
		}
		else {
			for (int i = 0; i < arr[number-1].lists.size(); i++) {
				for (int j = 0; j < 5; j++) {
					s = arr[number-1].lists.get(i).concat(Integer.toString(2*j+1));
					if(isSosu(Integer.parseInt(s))) arr[number].lists.add(s);
				}
			}
		}
		
		
		if(number == N) {
			for (int j = 0; j < arr[N].lists.size(); j++) {
				sbr.append(arr[N].lists.get(j)).append("\n");
			}System.out.println(sbr);
			return;
		}
		
		Sosu(number+1);
	}
	
	public static boolean isSosu (int N) {
		switch (N) {
		case 0:
		case 1:
			return false;
		case 2:
			return true;
		default:
			for (int i = 2; i < N; i++) {
				if(N%i==0) return false;
			}
		}return true;
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bfr.readLine());
		Sosu(1);
		
	}

}
