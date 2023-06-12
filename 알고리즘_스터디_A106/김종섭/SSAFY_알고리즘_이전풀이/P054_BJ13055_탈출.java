package 김종섭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class P054_BJ13055_탈출 {
	
	public static boolean [][] isVisited;
	public static int [][] dochiVisited;
	public static int[][] dsnb = new int [][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
	public static char [][] map;
	public static int R, C, dr, dc, size,size2, dochiX, dochiY;
	public static Queue<int[]> waterFlow = new ArrayDeque<>();
	public static Queue<int[]> dochiwantgoHome = new ArrayDeque<>();
	public static int[] wat = new int [2];
	public static int[] dochi = new int [2];
	public static boolean dochiwin, dochicantswim;
	public static int [] cave;
	
	public static void Waterbomb () {
		
		size = waterFlow.size(); // 초기 사이즈 저장
		for (int i = 0; i < size; i++) { // 초기 사이즈만큼 poll 을 한다.
			wat = waterFlow.poll();     // 빼낸 값의 x,y 좌표를 wat으로 저장
			for (int j = 0; j < 4; j++) { // 동서남북 탐색
				dr = dsnb[j][0]; dc = dsnb[j][1]; 
				if(wat[0] + dr < 0 || wat[1] + dc < 0 || wat[0] + dr >= R || wat[1] + dc >= C) continue;
				else {
					if(isVisited[wat[0]+dr][wat[1]+dc] || map[wat[0]+dr][wat[1]+dc] == 'X' || map[wat[0]+dr][wat[1]+dc] == 'D') continue; // 방문했거나, 돌을만나면 제외
					else {
						isVisited[wat[0]+dr][wat [1]+dc] = true; // 방문지역 true 체크
						map[wat[0]+dr][wat[1]+dc] = '*';        // 물침범
						waterFlow.offer(new int [] {wat[0]+dr, wat[1]+dc});
					}
				}
			}
		}
	}
	
	public static void DochiRun() {
		size2 = dochiwantgoHome.size();
		
		if(dochiwantgoHome.size() == 0) {
			dochicantswim = true;
			return;
		}
		for (int i = 0; i < size2; i++) {
			dochi = dochiwantgoHome.poll(); // 도치 쥬금 ㅠㅠ
			if(isVisited[dochi[0]][dochi[1]]) continue;
			for (int j = 0; j < 4; j++) {
				dr = dsnb[j][0]; dc = dsnb[j][1]; 
				if(dochi[0] + dr < 0 || dochi[1] + dc < 0 || dochi[0] + dr >= R || dochi[1] + dc >= C) continue;
				else {
					if(dochiVisited[dochi[0]+dr][dochi[1]+dc] != 0|| map[dochi[0]+dr][dochi[1]+dc] == 'X' || map[dochi[0]+dr][dochi[1]+dc] == '*') continue;
					else {
						dochiVisited[dochi[0]+dr][dochi[1]+dc] = dochiVisited[dochi[0]][dochi[1]] +1;
						dochiwantgoHome.offer(new int[] {dochi[0]+dr,dochi[1]+dc});
					}
					
				}
				if(map[dochi[0]+dr][dochi[1]+dc] == 'D') {
					dochiwin = true;
					return;
				}
				
				
			}
			
		}
		
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		isVisited = new boolean [R][C];
		dochiVisited = new int [R][C];
		map = new char [R][C];
		for (int i = 0; i < R; i++) {
			char[] s2 = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = s2[j];
				switch (map[i][j]) {
				case 'D': cave = new int [] {i,j};
					break;
				case 'S': dochiwantgoHome.offer(new int [] {i,j});
					break;
				case '*': waterFlow.offer(new int[] {i,j});
					break;
				case '.': 
				default : break;
				}
			}
		}

		
		// 물이 퍼지는 상황
		
		int time = 0;
		dochiVisited[dochiwantgoHome.peek()[0]][dochiwantgoHome.peek()[1]] = 1;
	
		//

		while(!dochiwin) {
			DochiRun();
			if(dochiwin) break;
			if(dochicantswim) break;
			Waterbomb();
		}
		
		
//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		
//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(dochiVisited[i]));
//		}
		
		if(dochiwin) System.out.println(dochiVisited[cave[0]][cave[1]]-1);
		if(dochicantswim) System.out.println("KAKTUS");
	}

}
