package 김종섭;

import java.util.ArrayList;
import java.util.Scanner;

public class P002_BJ17478_재귀함수가뭔가요 {

	// 2) Solution
	static String jagure1 (int N) {
		 
		if(N<=0) return "";

		return "____".concat(jagure1(N-1));
		
	}
	
//  <[메서드 안에 for문을 사용하여, result 로 반환할 때 나는 오류..?]>
	
//	static String re1 (String [] arr2, int N) {
//		String result = "";
//		
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<4; j++) {
//					if (N<=0) { 
//						return arr2[j];
//					}
//					String unbar = "____";
//					
//					for(int k=0; k<i; k++) {
//						unbar = unbar.concat(unbar);
//					} result += unbar.concat(arr2[j]).concat("\n");
//				}
//				
//			}
//	System.out.println(result);
//	return result;	
//	}
	

	
	public static void main(String[] args) {
		
		
		Scanner scann = new Scanner(System.in);
		int T = scann.nextInt();
		String [] comgong = new String [7];
		comgong[0] = "\"재귀함수가 뭔가요?\"";
		comgong[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어."; 
		comgong[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지."; 
		comgong[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		comgong[4] = comgong[0];
		comgong[5] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		comgong[6] = "라고 답변하였지.";
		P002_BJ17478_재귀함수가뭔가요 jagure = new P002_BJ17478_재귀함수가뭔가요();
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		for (int i=0; i<T; i++) {
			for(int j=0; j<4; j++) {
					System.out.print(jagure1(i));
				System.out.println(comgong[j]);
				
			}
		}
		for(int i=4; i<7; i++) {
				System.out.print(jagure1(T));
			System.out.println(comgong[i]);
		}
		
		for (int i=1; i<=T; i++) {
					System.out.print(jagure1(T-i));
				System.out.println(comgong[6]);
				
		}
		
		
		
/*		// 1) 재귀함수를 모르는 나는 개똥벌레 8ㅅ8...
		
		Scanner scann = new Scanner(System.in);
		int T = scann.nextInt();
		String [] comgong = new String [7];
		comgong[0] = "\"재귀함수가 뭔가요?\"";
		comgong[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어."; 
		comgong[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지."; 
		comgong[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		comgong[4] = comgong[0];
		comgong[5] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		comgong[6] = "라고 답변하였지.";
		
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다." );
		for (int i=0; i<T; i++) {
			for(int j=0; j<4; j++) {
				for(int k=0; k<i; k++) {
					System.out.print("____");
				}System.out.println(comgong[j]);
				
			}
		}
		for(int i=4; i<7; i++) {
			for (int j=0; j<T; j++) {
				System.out.print("____");
			}
			System.out.println(comgong[i]);
		}
		
		for (int i=0; i<T; i++) {
				for(int k=T-1; k>i; k--) {
					System.out.print("____");
				}System.out.println(comgong[6]);
				
		}*/

		
		
		
		
	}
	

}
	