package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class P037_JO1828_냉장고 {
	

	public static int [][] rangearray;

	
	public static boolean inRange(int n, int a, int b) {
		int sum = 0;
		if(n >= a && n <= b) return true;
		return false;
	}
	
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<int[]> list = new ArrayList<>();
		
		rangearray = new int[N][2];
		for (int i = 0; i < N; i++) {
			String [] s = br.readLine().split(" ");
			rangearray[i][0] = Integer.parseInt(s[0]);
			rangearray[i][1] = Integer.parseInt(s[1]);	
			list.add(rangearray[i]);
		}
		
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[1]-o2[1];
			}
			
		});
		int sum = 1; int loc = 0;
		for (int i = 1; i < N; i++) {
			if(inRange(list.get(loc)[1], list.get(i)[0], list.get(i)[1])) {
				continue;
			}else {
				sum += 1;
				loc = i;
			}
		}System.out.println(sum);

		
	}

}
