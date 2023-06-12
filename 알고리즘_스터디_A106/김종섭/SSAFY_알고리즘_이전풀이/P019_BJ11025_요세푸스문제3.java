package 김종섭;

import java.io.*;
import java.util.*;

public class P019_BJ11025_요세푸스문제3 {

	// https://www.acmicpc.net/problem/1158
	// 통과
	public static void main(String[] args) throws Exception {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sbr = new StringBuilder();
		
		Deque<Integer> list = new LinkedList<>();
		String [] s1 = new String [2];
		s1 = bfr.readLine().split(" ");
		int N = Integer.parseInt(s1[0]);
		int K = Integer.parseInt(s1[1]);
		for (int i = 1; i <= N; i++) {
			list.offerLast(i);
		}
		//System.out.println(list);
		sbr.append("<");
		int size1 = list.size(); int a = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < K-1; j++) {
				a = list.pollFirst();
				list.offerLast(a);
			}sbr.append(list.poll()).append(", ");
		}sbr.append(list.poll()).append(">");
		System.out.println(sbr);

 
	}

}
