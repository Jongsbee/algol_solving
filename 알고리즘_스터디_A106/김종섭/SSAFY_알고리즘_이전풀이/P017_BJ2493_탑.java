package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P017_BJ2493_탑 {

	// https://www.acmicpc.net/problem/2493
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int [] arr = new int [N+1];
		int [] answer = new int [N+1];
		for (int i = 0; i < N; i++) {
			arr[i+1] = Integer.parseInt(s[i]);
		}
		int t = 2; int max = arr[1];
		for (int i = 1; i <N; i++) {
			if(arr[i]<arr[i+1]) {
				if(arr[i+1]>max) {
					max = arr[i+1];
					answer[i+1] = 0;
				}else {
					t=2;
					while(arr[i+1]>=arr[i+1-t]) {
						t++;
					}
					answer[i+1] = i+1-t;
				} 
				
			}
			else {
				answer[i+1] = i;
			}
		}for (int i = 1; i <= N; i++) {
			if(i==N) sb.append(answer[i]);
			else sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
		
	}

}
