package 김종섭;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P025_BJ16926_배열돌리기1 {

	static final char[]dir= {'우', '하', '좌', '상'};
	static final int[]dx= {0,1,0,-1};//우,하,좌,상
	static final int[]dy= {1,0,-1,0};//우,하,좌,상
	
		
	public static void main(String[] args) throws Exception {
		long startTime=System.nanoTime();
		//System.setIn(new FileInputStream("input.txt"));
		//Scanner sc = new Scanner(new File("input.txt"));
		//Scanner sc = new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder(100);
		
		//int T=sc.nextInt();//테스트케이스
		//for(int tc=1;tc<=T;tc++) {
			String line[] = br.readLine().split(" ");
			int N=Integer.parseInt(line[0]);//행
			int M=Integer.parseInt(line[1]);//열
			int R=Integer.parseInt(line[2]);//회전수
			int data[][]=new int[N][M];
			for(int i=0;i<N;i++) {		
				String line2[] = br.readLine().split(" ");
				for(int j=0;j<M;j++) {
					data[i][j]=Integer.parseInt(line2[j]);
					//System.out.printf("%d ",data[i][j]);
				}
				//System.out.println();
			}//데이터 초기화 완료
			
			////////// TO DO //////////////
			// api 도 시간이 걸린다
			int min = N>M?M:N;
			int grpNo = min/2;
			//int grpNo=Math.min(N, M)/2;//회전해야 할 그룹 갯수			
			
			for(int i=0;i<R;i++) {
				System.out.printf("====%d회전===\n",i+1);
				for(int j=0;j<grpNo;j++) {
					System.out.printf("\t====%d그룹===\n",j+1);
					int x=j;//시작 위치가 (0,0) (1,1) (2,2)...이기 때문에
					int y=j;
					int temp=data[x][y];//스와핑을 위해 현재 데이터 값을 보관
					int idx=0;//방향
					while(idx<4) {//우하좌상 순서로 처리
						System.out.println("\t\twhile..."+idx+" : "+dir[idx]+"측 방향 탐색");
						int nx=x+dx[idx];
						int ny=y+dy[idx];
						System.out.printf("\t\t\t(%d,%d)인접 (%d,%d)에 값이 있느냐?",x,y,nx,ny);
						//if(nx>=j && nx<N-j && ny>=j && ny<M-j) {//범위내의 경우는 스와핑으로 값을 변경
						if(nx<j || nx>=N-j || ny<j || ny>=M-j) {// 기존 &&을 || 으로 변경
							//System.out.println("없음,방향 바꿔 탐색하겠음\n");
							idx++;//범위를 벗어나면 방향 전환하여 조건에 맞을때까지 탐색
							
						}
						else {
							//System.out.printf("네,%s에 있음 (%d,%d)값을 (%d,%d)에 넣기 \n",dir[idx], nx,ny,x,y);
							data[x][y]=data[nx][ny];
							x=nx;
							y=ny;
							
						}
					}//while을 나갈 때는 스타트 지점의 값만 빼고 모든 값이 한칸씩 전진된 상태
					System.out.printf("\tfor>>>temp값 %d을 (%d,%d)에 넣기\n",temp,j+1,j);
					data[j+1][j]=temp;//한 그룹 처리가 완료되는 시점에 스타트 지점의 값을 x-1 한 위치에 저장해야 함.
				}//end j 모든 그룹 처리 완료
			}//end i
			//결과 확인 
			for(int i=0;i<N;i++) {					
				for(int j=0;j<M;j++) {					
					//System.out.printf("%d ",data[i][j]); -- printf 는 시간이 많이걸린다
					System.out.print(data[i][j] + " ");
				}
				System.out.println();
			}
			
			///////////////////////////////
			
			// sb.append("#");
			// sb.append(tc);
			// sb.append(" ");
			
			// sb.append("\n");
	//	}//end of tc
		//System.out.println(sb);
		long endTime=System.nanoTime();
		System.out.println("\n"+((endTime-startTime)*0.000000001)+"초");
	}
	

}
/*
4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

 */
