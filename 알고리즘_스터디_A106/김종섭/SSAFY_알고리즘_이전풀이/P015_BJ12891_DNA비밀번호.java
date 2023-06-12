package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

// https://www.acmicpc.net/problem/12891
public class P015_BJ12891_DNA비밀번호 {
	// 완료
	public static void main(String[] args) throws Exception {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		String [] s1 = new String [2];
		s1 = bfr.readLine().split(" ");
		int N = Integer.parseInt(s1[0]); int M = Integer.parseInt(s1[1]);
		
		char [] dnaList = bfr.readLine().toCharArray();
		int [] pass = new int[4];
		int [] word = new int[4];
		String []s2 = bfr.readLine().split(" ");
		for (int j = 0; j < pass.length; j++) {
			pass[j] = Integer.parseInt(s2[j]);
			 
		}
		
		Queue<Character> list = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			list.offer(dnaList[i]);
			switch (dnaList[i]) {
			case 'A':
				word[0]++;
				break;
			case 'C':
				word[1]++;
				break;
			case 'G':
				word[2]++;
				break;
			case 'T':
				word[3]++;
				break;
			}
		}
		if(pass[0] > word[0] || pass[1] > word[1] || pass[2] > word[2] || pass[3] > word[3]) sum = 0;
		else sum += 1;
		char out = 'A'; char in = 'A';
		
		for (int i = M; i < N; i++) {
			out = list.poll();
			switch (out) {
			case 'A':
				word[0]--;
				break;
			case 'C':
				word[1]--;
				break;
			case 'G':
				word[2]--;
				break;
			case 'T':
				word[3]--;
				break;
			}
			list.offer(dnaList[i]);
			switch (dnaList[i]) {
			case 'A':
				word[0]++;
				break;
			case 'C':
				word[1]++;
				break;
			case 'G':
				word[2]++;
				break;
			case 'T':
				word[3]++;
				break;
			}
			if(pass[0] > word[0] || pass[1] > word[1] || pass[2] > word[2] || pass[3] > word[3]) continue;
			else sum += 1;
		}

		System.out.println(sum);
		
	}
}
