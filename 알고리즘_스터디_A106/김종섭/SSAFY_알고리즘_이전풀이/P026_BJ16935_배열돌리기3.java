package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P026_BJ16935_배열돌리기3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int R = Integer.parseInt(s[2]);
		
		int[][] map = new int[100][100];
		for(int i =0; i<N; i++) {	
			String[] st = br.readLine().split(" ");
			for(int j = 0; j<M; j++) {
				map[i][j]=Integer.parseInt(st[j]);
			}
		}
		int[][] ans = new int[100][100];	// 최대크기 : 100 by 100 -> N과 M의 값이 3~4번에서 변하므로, 미리 배열크기를 최대로 정해놓음
		int tmp=0;
		for(int r = 0; r<R; r++) {
			
			switch(br.read()-'0') {
			case 1://상하반전
				for(int x=N-1;x>=0; x--) {
					for(int y=M-1; y>=0; y--){
						ans[N-x-1][y] = map[x][y];
					}
				}
				break;
			case 2://좌우반전
				for(int x=0;x<N; x++) {
					for(int y=0; y<M; y++){
						ans[x][y] = map[x][M-y-1];
					}
				}
				break;
			case 3://오른쪽으로 90도 회전
				for(int y =0,i=0;y<M;y++,i++) {
					for(int x = N-1,j=0; x>=0; x--,j++) {
						ans[i][j]=map[x][y];
					}
				}
				tmp = N;
				N=M;
				M=tmp;
				break;
			case 4://왼쪽으로 90도 회전
				for(int y = M-1,i=0; y>=0; y--,i++) {
					for(int x = 0,j=0; x<N; x++,j++) {
						ans[i][j]=map[x][y];
					}
				}
				tmp = N;
				N=M;
				M=tmp;
				break;
			case 5:
				//1->2
				for(int x = 0, i=0; x<N/2; x++,i++) {
					for(int y = 0, j=M/2; y<M/2; y++,j++) {
						ans[i][j]=map[x][y];
					}
				}
				//2->3
				for(int x = 0, i=N/2; x<N/2; x++,i++) {
					for(int y = M/2, j=M/2; y<M; y++,j++) {
						ans[i][j]=map[x][y];
					}
				}
				//3->4
				for(int x = N/2, i=N/2; x<N; x++,i++) {
					for(int y = M/2, j=0; y<M; y++,j++) {
						ans[i][j]=map[x][y];
					}
				}
				//4->1
				for(int x = N/2, i=0; x<N; x++,i++) {
					for(int y = 0, j=0; y<M/2; y++,j++) {
						ans[i][j]=map[x][y];
					}
				}
				break;
			case 6:
				//1->4
				for(int x = N/2, i=0; x<N; x++,i++) {
					for(int y = 0, j=0; y<M/2; y++,j++) {
						ans[x][y]=map[i][j];
					}
				}
				//4->3
				for(int x = N/2, i=N/2; x<N; x++,i++) {
					for(int y = M/2, j=0; y<M; y++,j++) {
						ans[x][y]=map[i][j];
					}
				}
				//3->2
				for(int x = 0, i=N/2; x<N/2; x++,i++) {
					for(int y = M/2, j=M/2; y<M; y++,j++) {
						ans[x][y]=map[i][j];
					}
				}
				//2->1
				for(int x = 0, i=0; x<N/2; x++,i++) {
					for(int y = 0, j=M/2; y<M/2; y++,j++) {
						ans[x][y]=map[i][j];
					}
				}
				
				break;
			}//switch 종료
			
			//map 바꿔주기 (그래야 다른 변수 들어왔을 때도 연산이 제대로 작동함)
			for(int i = 0; i<100; i++) {
				for(int j = 0; j<100; j++) {
					map[i][j]=ans[i][j];
					ans[i][j]=0;
				}
			}
			
			br.read();
			
		}//for종료
		//출력
//		for(int i = 0; i<100; i++) {
//			for(int j = 0; j<100; j++) {
//				if(map[i][j]!=0)
//					System.out.print(map[i][j]+" ");
//			}
//			if(map[i][0]!=0)
//				System.out.println();
//		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M;j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
	}

}
