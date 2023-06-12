package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P008_SWEA1873_상호의배틀필드 {

	static int [][] dsnb = {{0,-1},{0,1},{-1,0},{1,0}}; // 0은 L, 1은 R, 2는 U, 3은 D
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bfr.readLine());
		for (int i=1; i<=T; i++) {
			String [] arr = bfr.readLine().split(" ");
			int H = Integer.parseInt(arr[0]);
			int W = Integer.parseInt(arr[1]);
			
			char [][] btfield = new char [H+2][W+2];
			
			for (int j=0; j<H+2; j++) { // 초기에 물로 채우고 시작한다
				Arrays.fill(btfield[j], '=');
			}
			for (int j=0; j<H; j++) { // H가3
				for (int k=0; k<W; k++) { // W는 7
					btfield[j+1][k+1] = (char)bfr.read();
					if (k==W-1) {
						String s = bfr.readLine();
					}
				}
			}
			
// ------------------------------------- 배틀필드 저장 ----------------------------------------
			int N = Integer.parseInt(bfr.readLine());

			char [] command = new char [N];
			command = bfr.readLine().toCharArray();
			
			int locx = 1, locy = 1;
			int [] direc = new int [2];
			
			for (int j=1; j<H+1; j++) {
				for (int k=1; k<W+1; k++) {
					switch (btfield[j][k]) {
					case '<': // 왼쪽 상태 저장
							locx = k; locy = j;
							direc = dsnb[0];
						break;
					case '>':
							locx = k; locy = j;
							direc = dsnb[1];
						break;
					case '^':
							locx = k; locy = j;
							direc = dsnb[2];
						break;
					case 'v':
							locx = k; locy = j;
							direc = dsnb[3];
						break;

					}
				}	
			}
			
			int missilex = locx, missiley = locy;
			boolean isMissile = false;
			
			for (int j=0; j<command.length; j++) {			
				switch (command[j]) {
				
				case 'S': // case1. Shoot
					isMissile = true; // 미사일 장전

					missilex = locx + direc[1]; 
					missiley = locy + direc[0]; // 미사일위치 초기화
						
						while (isMissile) {
							switch (btfield[missiley][missilex]) {
							case '.': 
							case '-': 
								missiley += direc[0];
								missilex += direc[1]; // 땅이나 강이면 한칸 전진
								break;
							case '*':
								btfield[missiley][missilex] = '.'; // 벽돌 파괴
								isMissile = false; // 미사일 소실
								break;
							case '=':
							case '#':             // 바운더리나 강철을 만나면 미사일 소실
								isMissile = false;
								break;
							}
						}break;
						
				case 'U': // case2. Up
					direc = dsnb[2]; // 방향을 up 방향으로 설정
					
					switch (btfield[locy + direc[0]][locx + direc[1]]) { // 한발짝 걸음 나간곳에 대하여
					case '.': 
						btfield[locy + direc[0]][locx + direc[1]] = '^'; // 평지일경우, 한걸음 나간곳에 표시
						btfield[locy][locx] = '.';                      // 원래자리에는 평지로
						locy += direc[0]; locx += direc[1]; 			// 현재 위치에 up 방향으로 +
						break;
					case '-':
					case '=':
					case '#': 
					case '*': btfield[locy][locx] = '^';              // 장애물일경우, 그냥 제자리
						break;
					}break;
					
				case 'D':
					direc = dsnb[3];
					
					switch (btfield[locy + direc[0]][locx + direc[1]]) {
					case '.': 
					btfield[locy + direc[0]][locx + direc[1]] = 'v';
					btfield[locy][locx] = '.';
					locy += direc[0]; locx += direc[1];
						break;
					case '-':
					case '=':
					case '#': 
					case '*': btfield[locy][locx] = 'v';
						break;
					}
					break;
					
				case 'R':
					direc = dsnb[1];
					
					switch (btfield[locy + direc[0]][locx + direc[1]]) {
					case '.': 
					btfield[locy + direc[0]][locx + direc[1]] = '>';
					btfield[locy][locx] = '.';
					locy += direc[0]; locx += direc[1];
						break;
					case '-':
					case '=':
					case '#': 
					case '*': btfield[locy][locx] = '>';
						break;
					}
					break;
					
				case 'L':
					direc = dsnb[0];

					switch (btfield[locy + direc[0]][locx + direc[1]]) {
					case '.':
					btfield[locy + direc[0]][locx + direc[1]] = '<';
					btfield[locy][locx] = '.';
					locy += direc[0]; locx += direc[1];
						break;
					case '-':
					case '=':
					case '#': 
					case '*': btfield[locy][locx] = '<';
						break;
					}
					break;
				}
		
			} // end 
			System.out.print("#" + i + " ");
			for(int h=1; h<H+1; h++) {
				for(int w=1; w<W+1; w++) {
					System.out.print(btfield[h][w]);
					if (w == W) {
						System.out.println();
					}
				}
				
			}
		}
	}
}
