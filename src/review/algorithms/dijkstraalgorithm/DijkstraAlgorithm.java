package review.algorithms.dijkstraalgorithm;

import java.util.Arrays;

public class DijkstraAlgorithm {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		char[] vertices = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int[][] matrix = new int[vertices.length][vertices.length];
		final int N = 65535; // 表示不可以连接
		matrix[0] = new int[] { N, 5, 7, N, N, N, 2 };
		matrix[1] = new int[] { 5, N, N, 9, N, N, 3 };
		matrix[2] = new int[] { 7, N, N, N, 8, N, N };
		matrix[3] = new int[] { N, 9, N, N, N, 4, N };
		matrix[4] = new int[] { N, N, 8, N, N, 5, 4 };
		matrix[5] = new int[] { N, N, N, 4, 5, 6, N };
		matrix[6] = new int[] { 2, 3, N, N, 4, 6, N };
		Graph graph = new Graph(vertices, matrix);
		graph.showGraph();
		
		graph.dijkstra(6); 
		graph.show();
		
	}
}

class Graph {
	char[] vertices;
	int[][] matrix;
	VisitedVertex vv;

	public Graph(char[] vertices, int[][] matrix) {
		this.vertices = vertices;
		this.matrix = matrix;
	}

	public void dijkstra(int index) {
		vv = new VisitedVertex(vertices.length, index);
		update(index);
		for (int i = 1; i < vertices.length; ++i) {
			index = vv.updateArray();
			vv.updateVisited(index);
			update(index);
		}
	}

	public void update(int index) {
		for (int i = 0; i < matrix[index].length; ++i) {
			int len = vv.getDis(index) + matrix[index][i];
			if (!vv.visited(i) && len < vv.getDis(i)) {
				vv.updateDis(i, len);
				vv.updatePre(i, index);
			}
		}
	}

	public void showGraph() {
		for (int i = 0; i < vertices.length; ++i) {
			for (int j = 0; j < vertices.length; ++j) {
				System.out.printf("%d\t", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public void show() {
		System.out.print("顶点:\t    ");
		for(char ch:vertices) {
			System.out.printf("%c  ",ch);
		}
		System.out.println();
		vv.show();
		System.out.println();
	}
}

class VisitedVertex {
	private int[] isVisited;
	private int[] preVisited;
	private int[] dis;

	public VisitedVertex(int len, int index) {
		this.isVisited = new int[len];
		this.preVisited = new int[len];
		this.dis = new int[len];
		this.isVisited[index] = 1;
		Arrays.fill(this.dis, 65535);
		this.dis[index] = 0;
	}

	public void updateVisited(int index) {
		this.isVisited[index] = 1;
	}

	public void updatePre(int index, int pre) {
		this.preVisited[index] = pre;
	}

	public void updateDis(int index, int len) {
		this.dis[index] = len;
	}

	public boolean visited(int index) {
		return this.isVisited[index] == 1;
	}

	public int getDis(int index) {
		return this.dis[index];
	}

	public int updateArray() {
		int key = -1;
		int min = 65535;
		for (int i = 0; i < isVisited.length; ++i) {
			if (!visited(i) && getDis(i) < min) {
				min = getDis(i);
				key = i;
			}
		}
		return key;
	}

	public void show() {
		System.out.print("是否访问过: ");
		for (int i : isVisited) {
			System.out.printf("%-3d", i);
		}
		System.out.println();
		System.out.print("前驱顶点:   ");
		for (int i : preVisited) {
			System.out.printf("%-3d", i);
		}
		System.out.println();
		System.out.print("最短距离:   ");
		for (int i : dis) {
			System.out.printf("%-3d", i);
		}
	}
}