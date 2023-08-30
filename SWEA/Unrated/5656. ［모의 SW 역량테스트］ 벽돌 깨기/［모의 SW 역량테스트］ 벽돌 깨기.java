import java.util.*;
import java.io.*;

public class Solution {
	
	private static int T;
	private static int N, W, H;
	private static int[] order;
	private static int[][] arr;
	private static int[][] copied;
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
		
			order = new int[N];
			arr = new int[H][W];
			copied = new int[H][W];
			
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			copyArray(copied, arr);
			makeOrder(0);

			System.out.println("#" + tc + " " + min);
		}
	}
	
	static void makeOrder(int size) {
		if(size == N) {
			for(int i=0; i<N; i++) {
				pop(order[i]);
			}
			
			int tmp = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(arr[i][j] != 0) tmp++;
				}
			}
			min = Math.min(tmp, min);
			
			copyArray(arr, copied);
			return;
		}
		
		for(int i=0; i<W; i++) {
			order[size] = i;
			makeOrder(size+1);
		}
	}
	
	static void pop(int x) {
		
		// x번째 줄에 구슬을 떨어트린다
		Queue<int[]> q = new ArrayDeque();
		for(int j=0; j<H; j++) {
			if(arr[j][x] != 0) {
				q.offer(new int[] {j, x});
				break;
			} 
		}
		
		while(!q.isEmpty()) {
			int[] front = q.poll();
			int ty = front[0];
			int tx = front[1];
			int num = arr[ty][tx];
			
			if(num == 1) {
				arr[ty][tx] = 0;
				continue;
			}
			
			for(int j=1; j<num; j++) {
				if(tx-j >= 0 && arr[ty][tx-j] != 0) {
					q.offer(new int[] {ty, tx-j});
				}
				if(tx+j < W && arr[ty][tx+j] != 0) {
					q.offer(new int[] {ty, tx+j});
				}
			}
			for(int j=1; j<num; j++) {
				if(ty+j < H) {
					q.offer(new int[] {ty+j, tx});
				}
				if(ty-j >= 0) {
					q.offer(new int[] {ty-j, tx});
				}
			}
			
			arr[ty][tx] = 0;
		}
		
		// 0이 된 만큼 밑으로 당기기
		for(int i=0; i<W; i++) {
			// 모든 열에 대하여
			Queue<Integer> q2 = new ArrayDeque();
			for(int j=H-1; j>=0; j--) {
				// 0이 아니면   queue에 담는다.
				if(arr[j][i] != 0) {
					q2.offer(arr[j][i]);
				}
			}
			
			// 그리고 아래부터 채운다
			for(int j=H-1; j>=0; j--) {
				if(!q2.isEmpty()) {
					arr[j][i] = q2.poll();
				}else {
					arr[j][i] = 0;
				}
			}
			
		}
	}
	
	static void copyArray(int[][] arr, int[][] copied) {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				arr[i][j] = copied[i][j];
			}
		}
	}
	
}
