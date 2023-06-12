package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P035_BJ2839_설탕배달 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int five = 0; int three = 0;
		int a = N/5;
		for (int i = 0; i <= 2; i++) {
			if(a>=i) {
				if ((N-5*(a-i)) %3 == 0) {
					five = a-i;
					break;
				} 
			}
		}if(five == 0) {
			if(N%3 !=0) three = -1;
			else three = N/3;
		}else three = (N-(5*five))/3;
		System.out.println(five + three);
	}
	

}
