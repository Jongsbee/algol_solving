package 김종섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P040_BJ15683_감시 {
	static int[][] direction = new int [][] {{0,1},{-1,0},{0,-1},{1,0}};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<int[]> loc = new ArrayList<>();
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[][] map = new int [N+2][M+2];
		int[][] ans = new int [N+2][M+2];
		for (int i = 0; i < N+2; i++) {
			Arrays.fill(map[i], 6);
			Arrays.fill(ans[i], 6);
		}
		for (int i = 0; i < N; i++) {
			String[] s3 = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i+1][j+1] = Integer.parseInt(s3[j]);
				ans[i+1][j+1] = Integer.parseInt(s3[j]);
				switch (Integer.parseInt(s3[j])) {
				case 1: case 2: case 3: case 4: case 5:
					loc.add(new int[] {i+1,j+1});
					break;

				default:
					break;
				}
			}
		}// 입력 완료
	
		//2. for을 돌면서 바꿔주자
		int dx = 0, dy = 0, X = 0, Y = 0;

			for (int j = 0; j < loc.size(); j++) { // 카메라
				X = loc.get(j)[0]; Y = loc.get(j)[1];
				int countCase = 0; int maxCase = 0;
					switch (map[X][Y]) {
					case 1:
						for (int k = 0; k < 4; k++) { // 방향
							dx = direction[k][0]; dy = direction[k][1];
							while(map[X+dx][Y+dy] != 6) {
								switch (map[X+dx][Y+dy]) {
								case 0:
									
									break;
								case 1:case 2:case 3:case 4:case 5: 
									break;
								}
								ans[X+dx][Y+dy] = 8;
							}
							X = X+dx;  Y = Y+dy;
						}
							
						break;
					case 2:
						
						
						break;
					case 3:
						
						break;
					case 4:
							
						break;
					case 5:
						for (int k = 0; k < ans.length; k++) {
							while(map[X+dx][Y+dy] != 6) {
								switch (map[X+dx][Y+dy]) {
								case 0:
									ans[X+dx][Y+dy] = 8;
									break;
								case 1:case 2:case 3:case 4:case 5: 
									break;
								}
								X = X+dx;  Y = Y+dy;
							}
						}
					}
			}
			int count = 0;
			
			//System.out.println(Arrays.deepToString(ans));
			for (int j = 0; j < N+2; j++) {
				for (int j2 = 0; j2 < M+2; j2++) {
					if(ans[j][j2] == 0) count += 1;
					ans[j][j2] = map[j][j2];
				}
			}if(min >= count) min = count;

		
		
		System.out.println(min);
		
	}

}
