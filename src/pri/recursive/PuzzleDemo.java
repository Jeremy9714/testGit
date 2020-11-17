package pri.recursive;

import java.util.Arrays;

public class PuzzleDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[][] map = new int[8][7];
		for(int i=0;i<7;++i) {
			map[0][i]=8;
			map[7][i]=8;
		}
		for(int i=0;i<8;++i) {
			map[i][0]=8;
			map[i][6]=8;
		}
		map[3][1]=8;
		map[3][2]=8;
		//map[1][2]=1;
		//map[2][1]=1;
		
		System.out.println(pathFinder(map,1,1));
		
		//System.out.println(Arrays.deepToString(map));
		for(int i=0;i<8;++i) {
			for(int j=0;j<7;++j) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//思路:
	//1) 0代表没有走过的路径
	//2) 1代表障碍物
	//3) 2代表找到的路径
	//4) 3代表错误的路径
	/**
	 * @param map 为棋盘
	 * @param i 为起始点的横坐标
	 * @param j 为起始点的纵坐标
	 * @return 结果
	 */
	public static boolean pathFinder(int[][] map, int i, int j) {
		if(map[6][5]==2) {
			return true;
		}else {
			//没走过的路
			if(map[i][j]==0) {
				map[i][j]=2;
				//向右一格
				if(pathFinder(map,i,j+1)) {
					return true;
				//向下一格
				}else if(pathFinder(map,i+1,j)) {
					return true;
				//向左一格
				}else if(pathFinder(map,i,j-1)) {
					return true;
				}else if(pathFinder(map,i-1,j)) {
					return true;
				//向上一格
				}else {
					map[i][j]=3;
					return false;
				}
			}else {//不能走的路
				return false;
			}
		}
		
	}
}
