package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P036_BJ1074_Z {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int r = Integer.parseInt(s[1]);
		int c = Integer.parseInt(s[2]);
		
		String binR = Integer.toBinaryString(r);
		String binC = Integer.toBinaryString(c);
		int sumR = 0; int sumC = 0;

		for (int i = 0; i < binR.length(); i++) {
			sumR += 2*((binR.charAt(i)-'0') * Math.pow(4, (binR.length()-i-1)));
		}	
		for (int i = 0; i < binC.length(); i++) {
			sumC += (binC.charAt(i)-'0') * Math.pow(4, (binC.length()-i-1));
		}

		System.out.println(sumC + sumR);
	}

}
