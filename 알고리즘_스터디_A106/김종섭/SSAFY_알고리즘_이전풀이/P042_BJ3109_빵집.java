package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P042_BJ3109_빵집 {

	public static void main(String[] args) throws Exception {
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String []s = br.readLine().split(" ");
		 int R = Integer.parseInt(s[0]);
		 int C = Integer.parseInt(s[1]);
		 
		 char [][] map = new char [R+2][C+2];
		 char [][] ans = new char [R+2][C+2];
		 
		 for (int i = 0; i < R+2; i++)  {
			 Arrays.fill(map[i], 'p');
			 Arrays.fill(ans[i], 'p');
		 }
		 
		 for (int i = 0; i < R; i++) {
			 String s2 = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i+1][j+1] = s2.charAt(j);
				ans[i+1][j+1] = s2.charAt(j);
			}
		}
		 
		 
		 int locx = 0; boolean go = false; int sum = 0;
		 for (int k = 0; k < R; k++) {
			 locx = k+1;
			 for (int i = 0; i < C; i++) {
				go = false;
				for (int j = -1; j <= 1; j++) {
					switch (map[locx+j][C-i]) {
					case 'p':
					case 'x':	
						break;	
					default:
						ans[locx+j][C-i] = 'p';
						locx = locx + j;
						go = true;
						break;
					}if(go) break;
				}if(!go) {
					// 되돌리기
					for (int j = 0; j < R+2; j++) {
						System.arraycopy(map[j], 0, ans[j], 0, R+2);
					}
					break;
				}
				
			}if(go) {
				// map 복사
				for (int i = 0; i < R+2; i++) {
					System.arraycopy(ans[i], 0, map[i], 0, C+2);
				}
				sum+=1;
			}
			
		}

		 System.out.println(sum);
	}

}
