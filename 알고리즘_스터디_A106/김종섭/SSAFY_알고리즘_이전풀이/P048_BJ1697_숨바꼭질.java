package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P048_BJ1697_숨바꼭질 {
	// 과제 늦게 제출하게 되어 죄송합니다 ㅠㅠ BFS, DFS 개념에 약해서 절차지향으로 풀어보다, 테스트케이스 10번을 fail하고 ..
	// 결국 BFS 강의와 인터넷 풀이 참고하여 문제 풀었습니다.배운것 까먹지 않도록 복습 철저히 하겠습니다!!
	public static Queue<Integer> queue = new LinkedList();
	public static int N, K;
//	public static boolean[] isVisited;
	public static int[] subinMap = new int[100001];
	// 100000 까지 숫자범위이므로, +1 된 숫자범위의 배열을 만든다. 이 배열에 방문한 순서를 하나씩 넣어줄 에정
	
/*	public static boolean isinRange(int n) {
		if (n < 0 || n > 100000 || isVisited[n])
			return false;
		return true;
	}*/

	public static int BFS(int n, int k) {
        
        queue.offer(n);
        subinMap[n] = 1; // 첫 위치를 1로 놓는다
 
        while(!(queue.isEmpty())) {
        	// Loc = 현재위치
            int Loc = queue.poll();
 
            for(int i=0; i<3; i++) {
            	// nextLoc = 다음위치
                int nextLoc = 0;
                switch (i) {
                // 왼쪽으로 가거나, 오른쪽으로 가거나, 현재위치에서 2배가 된다
				case 0:
					nextLoc = Loc - 1;
					break;
				case 1:
					nextLoc = Loc + 1;
					break;
				case 2:
					nextLoc = Loc * 2;
					break;
				}
                
                if(nextLoc == k) return subinMap[Loc]; // 도달했다면, 몇번째인지를 출력한다.             
               
                if(nextLoc >= 0 && nextLoc <= 100000) { // 범위내에 있다면
                    if(subinMap[nextLoc] == 0) { // 방문하지 않은 숫자라면
                    	queue.offer(nextLoc);    // queue 에 해당숫자를 넣고, 탐색을 반복한다
                        subinMap[nextLoc] = subinMap[Loc] + 1; // 탐색횟수 1 증가
                    }
                }
            }
        }
 
        return 0;
    }
	
/*	static double baseLog(double x, double base) {
		return Math.log(x) / Math.log(base);
	}*/

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
//		int ans = 0;
//		isVisited = new boolean [100001];
		
		
/*		if(N == 0) {
			N += 1; ans += 1;
		}*/

/*		int mult = (int) Math.round(baseLog(K*1.0/N*1.0, 2)) ;
		String binK = Integer.toBinaryString(K);
		String binN = Integer.toBinaryString(N);
		int res = (int) Math.abs((K-N*Math.pow(2, mult)));
		String binRes = Integer.toBinaryString(res);
		System.out.println(binK);
		System.out.println(binN);
		System.out.println(mult);
		System.out.println(res);
		System.out.println(binRes);
		ans += mult;
		for (int i = mult; i >= 0; i--) {
			ans += (int) res / Math.pow(2, i);
			res = (int) (res % Math.pow(2, i));
		}*/

		
		if(N >= K) System.out.println(N-K); // N이 K보다 클수도 있구나...아...
        else System.out.println(BFS(N, K));

	}

}
