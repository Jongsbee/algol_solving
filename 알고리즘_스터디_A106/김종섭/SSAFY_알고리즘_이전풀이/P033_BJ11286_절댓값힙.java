package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class P033_BJ11286_절댓값힙 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(N,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1)==Math.abs(o2)) return o1-o2;
				else return Math.abs(o1)-Math.abs(o2);
			}
		});
		
		for (int i = 0; i < N; i++) {
			int X = Integer.parseInt(br.readLine());
			
			switch (X) {
			case 0:
				if(queue.size() == 0) System.out.println(0);
				else System.out.println(queue.poll());
				break;
			default:
				queue.add(X);
				break;
			} 
			
		}
		
	}

}
