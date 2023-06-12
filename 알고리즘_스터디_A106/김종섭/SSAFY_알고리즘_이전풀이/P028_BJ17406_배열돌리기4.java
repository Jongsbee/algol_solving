package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P028_BJ17406_배열돌리기4 {
	
	static final int[][] rightDir= {{1,0},{0,1}, {-1,0}, {0,-1}}; //하, 우, 상, 좌
    
	public static void main(String[] args) throws Exception {
		int N,M,K,r,c,s,firstX,firstY,lastX,lastY,x,y,idx,nx,ny,sum; // 많다...
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] test = br.readLine().split(" ");
		N = Integer.parseInt(test[0]); 
		M = Integer.parseInt(test[1]); 
		K = Integer.parseInt(test[2]); // N,M,K 값을 입력받는다. (여기서는 5 6 2)
		
		int[][] map = new int[N][M]; // 크기가 N*M 인 배열을 만들고
		
		for(int i =0; i<N; i++) {	// 배열 값들을 2차행렬 map 에 각각 받는다.
			String[] st = br.readLine().split(" ");
			for(int j = 0; j<M; j++) {
				map[i][j]=Integer.parseInt(st[j]);
			}
		}
		int min = Integer.MAX_VALUE;
		int[][] ans = new int[N][M]; // N*M 크기의 배열을 하나 더 만든다.
		for(int q = 0; q<K; q++) {   // K번의 연산을 수행하는데
			String[] rotate = br.readLine().split(" "); // r, c, s 의 값을 받고, r과 c는 1씩을 빼주어 배열의 index로 바로 활용한다
			r = Integer.parseInt(rotate[0])-1;
			c = Integer.parseInt(rotate[1])-1;
			s = Integer.parseInt(rotate[2]);

			firstX = (r-s); firstY = (c-s); lastX = (r+s); lastY = (c+s); // x값의 범위는 firstX ~ lastX | y값의 범위는 firstY ~ lastY 이다. 
			for (int i = 0; i < N; i++) {								// 배열 ans 를 0으로 초기화한다.
				Arrays.fill(ans[i], 0);
			}
			
			for (int i = 0; i < s; i++) {       // [r][c] 를 중심으로 각각 s만큼 커진 배열이므로 s만큼 범위를 잡아준다 (여기서는 2,3 에있는 1을 중심으로 가로세로 2씩 커진 배열)
				x = firstX+i;				// x,y 값은 각각 초기값 + i (0,0) 이 (firstX, firstY) 라 생각하면 편함. 
				y = firstY+i;
				idx = 0;					// 방향을 나타내는 idx 는 초기값 0으로 잡는다. 
				while(idx <4) {
					nx = x + rightDir[idx][0];   // 현재 x값 y값을 nx, ny 로 잡는다.
					ny = y + rightDir[idx][1];   // 오른쪽으로 가니깐 --> 하, 우, 상, 좌
					if(nx<i+firstX || nx > lastX-i || ny<i+firstY || ny>lastY-i) idx++; // nx가 주어진 범위를 벗어난다면 (first~Last) 방향을 바꾼다.
					else {
						ans[x][y] = map[nx][ny]; // 범위 안에서라면 nx,ny 의 값을 ans 에 저장한다.
						x = nx;  y = ny;			// 그 후 x,y 의 값을 nx, ny 로 초기화 한 후 while 로 돌아간다.
					}	
				}
			}ans[r][c] = map[r][c];			// for문을 돌렸을 때, 포함되지 않는 중앙의 값을 마지막으로 선언해준다. (무조건 중앙값이 남도록 되어있음!)
			
			for(int i = firstX; i<=lastX; i++) {	// map 의 값을 ans 값으로 덮어씌운다.
				for(int j = firstY; j<=lastY;j++) { // 모든 범위를 다 돌은것이 아니므로, first~last 까지만 덮어씌운다.
					map[i][j]=ans[i][j];
				}
			}
			System.out.println(Arrays.deepToString(map));
			for (int i = 0; i < N; i++) {	// for문을 통하여 배열 map 의 행값을 더한다.
				sum = 0;					// 행하나를 돌때마다 sum을 초기화
				for (int j = 0; j < M; j++) {
					sum += map[i][j];
				}if(min > sum) min = sum;	// min 값이 sum보다 클때, min값에 sum을 넣는다.
//				System.out.println(min);
			}
			
		}System.out.println(min); // end of for(q)

		
	} // end of main

}
