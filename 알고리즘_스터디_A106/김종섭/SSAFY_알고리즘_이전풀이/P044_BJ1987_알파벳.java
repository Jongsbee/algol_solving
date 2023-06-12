package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P044_BJ1987_알파벳 {
	public static boolean[] isSelected;
	public static int max;
	public static List<Character> list;
	public static char[][] board;

	public static void Subset(int x, int y) {
		
		if(list.contains(board[x][y])) {
			max = Math.max(max, list.size());
			return;
		}
		else {
			list.add(board[x][y]);
			max = Math.max(max, list.size());
		}
		
		Subset(x, y+1);
		Subset(x, y-1);
		Subset(x+1, y);
		Subset(x-1, y);
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] s = br.readLine().split(" ");
		int R = Integer.parseInt(s[0])	;
		int C = Integer.parseInt(s[1]);
		board = new char [R+2][C+2];
		
		list = new ArrayList<>();
		list.add('8');
		max = Integer.MIN_VALUE;
		for (int i = 0; i < R+2; i++) {
			Arrays.fill(board[i], '8');
		}
		for (int i = 0; i < R; i++) {
			String s2 = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i+1][j+1] = s2.charAt(j);
			}
		}
		
		
		//2. 
		Subset(1,1);
		System.out.println(max-1);
	}

}
