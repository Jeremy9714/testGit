package review.algorithms.knightAlgorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KnightAlgorithm {

	static int X;
	static int Y;
	static boolean[] isVisited;
	static boolean isFinished;

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		X = 8;
		Y = 8;
		int[][] chessboard = new int[X][Y];
		isVisited = new boolean[X * Y];
		int row = 5;
		int col = 5;
		System.out.println("骑士周游算法，开始运行");
		knightDemo(chessboard, row-1, col-1, 1);
		for(int[] ele:chessboard) {
			System.out.println(Arrays.toString(ele));
		}
	}

	public static void knightDemo(int[][] chessboard, int row, int col, int step) {
		isVisited[row*Y+col] = true;
		chessboard[row][col] = step;
		List<Point> next = next(new Point(col,row));
		sortNext(next);
		while(!next.isEmpty()) {
			Point nextPoint = next.remove(0);
			if(!isVisited[nextPoint.y*Y+nextPoint.x]) {
				knightDemo(chessboard,nextPoint.y,nextPoint.x,step+1);
			}
		}
		if(step<X*Y&&!isFinished) {
			chessboard[row][col]=0;
			isVisited[row*Y+col]=false;
		}else {
			isFinished = true;
		}
	}

	public static List<Point> next(Point point) {
		List<Point> list = new ArrayList<>();
		Point p = new Point();
		if ((p.x = point.x - 1) >= 0 && (p.y = point.y - 2) >= 0) {
			list.add(new Point(p));
		}
		if ((p.x = point.x - 2) >= 0 && (p.y = point.y - 1) >= 0) {
			list.add(new Point(p));
		}
		if ((p.x = point.x - 2) >= 0 && (p.y = point.y + 1) < X) {
			list.add(new Point(p));
		}
		if ((p.x = point.x - 1) >= 0 && (p.y = point.y + 2) < X) {
			list.add(new Point(p));
		}
		if ((p.x = point.x + 1) < X && (p.y = point.y + 2) < X) {
			list.add(new Point(p));
		}
		if ((p.x = point.x + 2) < X && (p.y = point.y + 1) < X) {
			list.add(new Point(p));
		}
		if ((p.x = point.x + 2) < X && (p.y = point.y - 1) >= 0) {
			list.add(new Point(p));
		}
		if ((p.x = point.x + 1) < X && (p.y = point.y - 2) >= 0) {
			list.add(new Point(p));
		}
		return list;
	}
	
	public static void sortNext(List<Point> list) {
		list.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				// TODO 自动生成的方法存根
				if(next(o1).size()<next(o2).size()) {
					return -1;
				}else if(next(o1).size()==next(o2).size()) {
					return 0;
				}else {
					return 1;
				}
			}	
		});
	}
}
