package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P014_BJ2164_카드2 {

	public static void main(String[] args) throws Exception {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bfr.readLine());
		int answer = 0;
		
		String tt= Integer.toBinaryString(T);
		for (int i=1; i<tt.length(); i++) {
			answer += (tt.charAt(tt.length()-i)-'0')*Math.pow(2, i);
		}
		if (answer == 0) answer = T;
		System.out.println(answer);
		
	}

}
