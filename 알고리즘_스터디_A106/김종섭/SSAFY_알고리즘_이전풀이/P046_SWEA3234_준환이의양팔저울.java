package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P046_SWEA3234_준환이의양팔저울 {

	public static int[] arr, list;
	public static int N, count, sum;
//	public static List<Integer> list;
	public static boolean[] isSelected;
	
	public static void Scale(int index, int direction) {
		sum = 0;
	
		if(index > 1) {
			for (int i1 = 0; i1 < index; i1++) {
				sum += list[i1];
				if(sum < 0) return;
			}
		}
		if(index == N) {
			count += 1;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			list[i] = arr[i];
			Scale(index+1, 0); // left
			Scale(index+1, 1); // right
		}
			
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			String [] s = br.readLine().split(" ");
			arr = new int [N];
			list = new int [N];
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(s[j]);
			}
			count = 0;
			isSelected = new boolean[N];
			
			for (int j = 0; j < N; j++) {
				list[0] = arr[j];
				isSelected[j] = true;
				Scale(0,0);
				isSelected[j] = false;
			}
			System.out.println(count);
		}
	}
}
