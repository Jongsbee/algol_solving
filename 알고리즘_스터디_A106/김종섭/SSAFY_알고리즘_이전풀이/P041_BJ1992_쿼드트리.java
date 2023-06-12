package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P041_BJ1992_쿼드트리 {
	public static int N;
	public static StringBuilder sb = new StringBuilder(); 
	public static char[][] arr;
	
	public static boolean isCompressible(int locx, int locy, int size) {
		// top - down 방식으로 접근 (기존 절차지향적 사고로는 로직자체가 구현이 안됨... 인터넷 풀이 참고)
		// 벌로.. 분할정복 문제 2~3개 풀어보기 ㅠㅠ
		// 전체 압축할 수 있는지 알아보는 메서드를 만든다.

		for (int i = locx; i < locx + size; i++) {
			for (int j = locy; j < locy + size; j++) {
				if(arr[i][j] != arr[locx][locy]) return false; 
			}
		}
		
		return true;
	}
		
	public static void divide(int locx, int locy, int size) {
		
		// 실행부 - 압축할 수 있다면 그대로 print
		// 종료조건 - size 가 1이되면, compressible 이 무조건 true 이므로 만족
		if(isCompressible(locx, locy, size)) {
			sb.append(arr[locx][locy]);
			return;
		}
		
		// 반복부- 압축할 수 없다면, 네개의 함수로 나눈다.
		else {
			sb.append("(");
			divide(locx, locy, size/2);
			divide(locx, locy + size/2, size/2);
			divide(locx + size/2, locy, size/2);
			divide(locx + size/2, locy + size/2, size/2);
			sb.append(")");
		}	
		 
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<int[]> loc = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		arr = new char [N][N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		divide(0,0,N);
		System.out.println(sb);

	}

}
