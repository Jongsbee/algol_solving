package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P030_BJ2961_도영이가만든맛있는음식 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sourIng = new int [N]; bitterIng = new int [N];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			sourIng[i] = Integer.parseInt(s[0]);
			bitterIng[i] = Integer.parseInt(s[1]);
		}
		minCook = Integer.MAX_VALUE;
		cook(0,1,0,0);
		System.out.println(minCook);

	} // end of main
	static int[]sourIng, bitterIng;
	static int N, minCook;
	public static void cook(int index, int sour, int bitter, int count) {
		if(index == N) {
//			if(bitter != 0) { // 왜 bitter값으로 하면 안될까...
			if(count != 0) {
				if(minCook > Math.abs(sour - bitter)) {
					minCook = Math.abs(sour - bitter);
				}
			}
			return;	
		}
		// 사용
		cook(index+1, sour * sourIng[index], bitter + bitterIng[index], count+1);
		// 사용X
		cook(index+1, sour, bitter, count);
		
	}

}
