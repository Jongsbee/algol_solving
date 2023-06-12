package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P031_BJ3040_백설공주와일곱난쟁이 {

	public static void main(String[] args) throws Exception{

		//1. 수지 - main
		Scanner sc = new Scanner(System.in);
		int[] shorts = new int[9]; // 9명의 난쟁이
		int sum = 0; // 전체 9명의 합에서 가짜 두명을 빼면 100
		for(int i=0;i<9;i++) {
			shorts[i] = sc.nextInt(); // 숫자가 안크니까 .. scanner
			sum += shorts[i];
		}
		
		for(int i=0;i<9;i++) {
			for(int j=i+1;j<9;j++) {
				int tmp = shorts[i]+shorts[j];
				// 두명을 골라 뺏을때 100 이랑 같으면 ?! 걔네가 가짜다
				if(sum -tmp == 100) {
					shorts[i] = 0;
					shorts[j] = 0; // 얘네 둘을 빼줘야한다
					for(int k=0;k<9;k++) { // 찾았을때 출력해버려 !
						if(k!=i && k!=j) {
							System.out.println(shorts[k]);
						}
					}
				}
			}
		}

		//2. 종섭 - 추가풀이 - 백준통과
/*		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int [] arr = new int [9]; //
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i]= Integer.parseInt(br.readLine());
			sum += arr[i];  // 9명의 모자의 숫자합을 모두 더한다.
		}
		
		int lastI=0, lastJ=0; // 범인 두놈의 위치를 lastI, lastJ 로 잡고
		for (int i = 0; i < 9; i++) {
			for (int j = i+1; j < 9; j++) {
				if(arr[i] +arr[j]==(sum-100)) { //총합에서 100을 뺀 값이, 범인 두놈의 모자 숫자의 합이다.
					lastI = i; lastJ = j;       // 범인 색출완료!
				}
			}
		}
		arr[lastI] = 0; arr[lastJ] = 0; // 두녀석의 모자 값을 0으로 만들어준다.
		for (int i = 0; i < 9; i++) {
			if(arr[i]!=0) System.out.println(arr[i]); // 0을 제외한 숫자 출력
		}
*/
	}

}
