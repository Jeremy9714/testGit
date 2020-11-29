package pri.algorithms.knight;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;

public class ChessBoardDemo {

	private static int X;// 棋盘列数
	private static int Y;// 棋盘行数
	private static boolean[] isVisited;
	private static boolean isFinished;

	public static void main(String[] args) {
		X = 8;
		Y = 8;
		int row = 1; //骑士的初始位置的行
		int colum = 1; //骑士的初始位置的列
		int[][] chessBoard = new int[X][Y]; //初始化棋盘
		isVisited = new boolean[X * Y]; //初始值都是false
		System.out.println("骑士周游算法，开始运行");
		long start = System.currentTimeMillis();
		KnightTour(chessBoard, row-1, colum-1, 1);
		long end = System.currentTimeMillis();
		
		System.out.println("共耗时: "+(end-start)+"毫秒");
		for(int[] line: chessBoard) {
			for(int i:line) {
				System.out.print(i+"\t");
			}
			System.out.println();
		}

	}

	private static void KnightTour(int[][] chessBoard, int row, int col, int step) {
		// 当前位置的值等于已走步数
		chessBoard[row][col] = step;
		// 改为标记为已访问
		isVisited[row * X + col] = true;
		// 获取该位置在下一步所有可以移动的位置
		ArrayList<Point> ps = next(new Point(col, row));
		//对数列元素根据所有位置的下一步的位置的数量进行非递减排序，减少回溯次数
		sortNext(ps);
		// 遍历所有位置
		while (!ps.isEmpty()) {
			Point p = ps.remove(0);
			// 判断该位置是否被访问过
			if (!isVisited[p.y * X + p.x]) {
				// 未被访问过，则进行递归，步数加一
				KnightTour(chessBoard, p.y, p.x, step+1);
			}
		}
		// 此时步数小于棋盘格子数，且未完成任务
		if (step < X * Y && !isFinished) {
			// 该位置清零
			chessBoard[row][col] = 0;
			// 重置访问状态
			isVisited[row * X + col] = false;
		} else {
			// 完成棋盘遍历
			isFinished = true;
		}

	}

	// 根据当前的位置，计算马还能走哪些位置，并放入到一个集合中
	private static ArrayList<Point> next(Point curPoint) {
		ArrayList<Point> ps = new ArrayList<>();
		Point p = new Point();
		// 判断当前位置的8点钟方向是否可以移动
		if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y - 1) >= 0) {
			ps.add(new Point(p));
		}
		// 判断当前位置的7点钟方向是否可以移动
		if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y - 2) >= 0) {
			ps.add(new Point(p));
		}
		// 判断当前位置的5点钟方向是否可以移动
		if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y - 2) >= 0) {
			ps.add(new Point(p));
		}
		// 判断当前位置的4点钟方向是否可以移动
		if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y - 1) >= 0) {
			ps.add(new Point(p));
		}
		// 判断当前位置的2点钟方向是否可以移动
		if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y + 1) < Y) {
			ps.add(new Point(p));
		}
		// 判断当前位置的1点钟方向是否可以移动
		if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y + 2) < Y) {
			ps.add(new Point(p));
		}
		// 判断当前位置的11点钟方向是否可以移动
		if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y + 2) < Y) {
			ps.add(new Point(p));
		}
		// 判断当前位置的10点钟方向是否可以移动
		if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y + 1) < Y) {
			ps.add(new Point(p));
		}
		return ps;
	}
	
	//对指定位置的所有的下一步位置的所有下一步位置进行非递减排序，减少回溯的次数
	private static void sortNext(ArrayList<Point> ps) {
		ps.sort(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				int count1 = next(o1).size();
				int count2 = next(o2).size();
				if(count1<count2) {
					return -1;
				}else if(count1 ==count2) {
					return 0;
				}else {
					return 1;
				}
			}
			
		});
	}
}
