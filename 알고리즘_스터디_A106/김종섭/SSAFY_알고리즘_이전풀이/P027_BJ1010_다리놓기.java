package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P027_BJ1010_다리놓기 {

/*	public static long combi(int n, int m) {
		if(n<= 1) return 1l;
		return m * combi(m-1);
	}*/
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder(100);
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		for (int i = 0; i < T; i++) {
			String s[] = br.readLine().split(" ");
			int N=Integer.parseInt(s[0]); // N
			int M=Integer.parseInt(s[1]); // M
			// input
			
			// 조합 공식 : MCN -> (M!) / (N! * (M-N)!)
			//  -> M*M-1*.....*M-N+1 / N*N-1*.....*1
			
			long boonmo = 1l, boonja = 1l;
			for (int j = M,k=1; k <=Math.min(N, M-N); j--,k++) {
				boonja *= j; boonmo *= k;
			}
			System.out.println((int)boonja / boonmo);
		}
	}
}
