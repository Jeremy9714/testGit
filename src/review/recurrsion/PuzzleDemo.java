package review.recurrsion;

public class PuzzleDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[][] map = new int[8][7];
		for(int i=0;i<8;++i) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		for(int i=0;i<7;++i) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		map[3][1]=1;
		map[3][2]=1;
		for(int i=0;i<8;++i) {
			for(int j=0;j<7;++j) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println(pathFinder(map,1,1));
		for(int i=0;i<8;++i) {
			for(int j=0;j<7;++j) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	//查找路线
	public static boolean pathFinder(int[][] map,int i, int j) {
		if(map[6][1]==2) {
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
				//向上一格
				}else if(pathFinder(map,i-1,j)) {
					return true;
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
