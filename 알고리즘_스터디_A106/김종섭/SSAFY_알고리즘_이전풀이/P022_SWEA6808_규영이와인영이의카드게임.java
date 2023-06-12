package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P022_SWEA6808_규영이와인영이의카드게임 {
	// 완료
	static boolean[] isSelected = new boolean[9];
	static int gyuScore, inyScore, inyWin, gyuWin;
	static int [] inyDeck = new int[9];
	static int [] iny = new int[9];
	static int [] gyu = new int[9];
	
	
	public static void permu(int index) {
		
		if(index == 9) {
			gyuScore = 0; inyScore = 0;
			for (int i = 0; i < 9; i++) {
				if(inyDeck[i] > gyu[i]) {
					inyScore += gyu[i] + inyDeck[i];
				}else gyuScore += gyu[i]  + inyDeck[i];
			}if(inyScore > gyuScore) inyWin++;
			else gyuWin++;
		}
		 
		
		for (int i = 0; i < 9; i++) {
			if(isSelected[i]) continue;
			inyDeck[index] = iny[i];
			isSelected[i] = true;
			permu(index+1);
			isSelected[i] = false;
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			List<Integer> allCard = new ArrayList<>();
			for (int j = 1; j <= 18; j++) {
				allCard.add(j);
			}
			
			gyu = new int [9];
			iny = new int [9];
			
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				gyu[j] = Integer.parseInt(s[j]);
				allCard.remove(allCard.indexOf(Integer.parseInt(s[j])));
			}
			for (int j = 0; j < 9; j++) {
				iny[j] = allCard.get(j);
			} // 입력 완료
			//System.out.println(Arrays.toString(iny));
			//System.out.println(Arrays.toString(gyu));
			inyWin = 0; gyuWin = 0;
			permu(0);
			System.out.println("#" + i + " " + gyuWin + " " + inyWin);
		} // end of T
	}

}
