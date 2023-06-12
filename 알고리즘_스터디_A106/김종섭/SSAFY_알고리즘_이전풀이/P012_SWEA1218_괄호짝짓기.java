package 김종섭;

import java.io.*;
import java.util.Arrays;

public class P012_SWEA1218_괄호짝짓기 {
	

    public static void main(String[] args) throws Exception {
		//1. 스택을 모르는 나는 한마리 달팽이... 반드시 강해져서 돌아옵니다...
    	BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    	
    	
    	
    	for(int k=1; k<=10; k++ ) {
    		int [] arr = new int[] {0,0,0,0};
	    	int T = Integer.parseInt(bfr.readLine());
	    	
	    	for (int i = 0; i < T; i++) {
				char val = (char)bfr.read();
				switch (val) {
				case '(':
					arr[0] += 1;
					break;
				case ')':
					arr[0] += -1;
					break;
				
				case '[':
					arr[1] += 1;
					break;
				
				case ']':
					arr[1] += -1;
					break;
				
				case '{':
					arr[2] += 1;
					break;
				
				case '}':
					arr[2] += -1;
					break;
				
				case '<':
					arr[3] += 1;
					break;
				
				case '>':
					arr[3] += -1;
					break;
				}if(i==T-1) {
					String s = bfr.readLine();
				}
			}
	    	
	    	for (int i = 0; i < arr.length; i++) {
				if(arr[i]!=0) {
					System.out.println("#" + k + " " + 0);
					break;
				}
				if(i == arr.length-1 && arr[i] ==0) {
					System.out.println("#" + k + " " + 1);
					break;
				}
			}
    	}// end of for
    
    	
    	
	}

}
    	
	


