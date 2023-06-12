package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P039_BJ1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 Scanner sc = new Scanner(System.in);
		 String []s = br.readLine().split("-");
		
		 //System.out.println(Arrays.toString(s));
		 int[] intarr = new int [s.length];
		 int sum = 0;
		 for (int i = 0; i < s.length; i++) {
			 sum = 0;
			if(s[i].contains("+")) {
				String[] s2 = s[i].split("\\+");
				//System.out.println(Arrays.toString(s2));
				for (int j = 0; j < s2.length; j++) {
					sum += Integer.parseInt(s2[j]);
				}intarr[i] = sum;
			}else {
				intarr[i] = Integer.parseInt(s[i]);
			}
		}//System.out.println(Arrays.toString(intarr));
		 int total = intarr[0];
		 for (int i = 1; i < intarr.length; i++) {
			total -= intarr[i];
		}System.out.println(total);
	}

}
