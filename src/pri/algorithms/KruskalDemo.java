package pri.algorithms;

import java.util.Arrays;

public class KruskalDemo {
	// 顶点
	private char[] vertices;
	// 权值
	private int[][] weight;
	// 边的数量
	private int edgeNum;
	private static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		char[] vertices = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int[][] weight = { { 0, 12, INF, INF, INF, 16, 14 }, { 12, 0, 10, INF, INF, 7, INF },
				{ INF, 10, 0, 3, 5, 6, INF }, { INF, INF, 3, 0, 4, INF, INF }, { INF, INF, 5, 4, 0, 2, 8 },
				{ 16, 7, 6, INF, 2, 0, 9 }, { 14, INF, INF, INF, 8, 9, 0 } };

		KruskalDemo kruskal = new KruskalDemo(vertices, weight);
		// kruskal.print();

		/*
		 * Edge[] edges = kruskal.getEdges(); System.out.println("排序前的边");
		 * System.out.println(Arrays.toString(edges)); Arrays.sort(edges);
		 * System.out.println("排序后的边"); System.out.println(Arrays.toString(edges));
		 */

		Edge[] res = kruskal.Kruskal();
		System.out.println(Arrays.toString(res));

	}

	// 构造器
	public KruskalDemo(char[] vertices, int[][] weight) {
		int vLen = vertices.length;
		this.vertices = new char[vLen];
		for (int i = 0; i < vLen; ++i) {
			this.vertices[i] = vertices[i];
		}
		this.weight = new int[vLen][vLen];
		for (int i = 0; i < vLen; ++i) {
			// 不包含同一定点之间的边,并且不包含相同的两个顶点之间的边
			for (int j = i + 1; j < vLen; ++j) {
				this.weight[i][j] = weight[i][j];
				if (weight[i][j] != INF) {
					this.edgeNum++;
				}
			}
		}
	}

	// 克鲁斯卡尔算法
	private Edge[] Kruskal() {
		int index = 0;// 数组索引
		int[] ends = new int[vertices.length];// 用于保存已有最小生成树中，每个顶点在最小生成树中的终点
		Edge[] res = new Edge[vertices.length - 1];// 结果数组，保存最后的最小生成树
		// 边的数组排序
		Edge[] edges = getEdges();
		Arrays.sort(edges);
		System.out.println("图中的边的集合: " + Arrays.toString(edges));

		// 遍历图的所有边
		for (int i = 0; i < edgeNum; ++i) {
			// 获取边的两个顶点的下标
			int p1 = getIndex(edges[i].start);
			int p2 = getIndex(edges[i].end);
			// 获取两个顶点在最小生成树中的终点
			int m = getEnd(ends, p1);
			int n = getEnd(ends, p2);
			// 终点不相同
			if (m != n) {
				// 将边的前一个顶点在已有的最小生成树中的重点设置为该边的后一个顶点
				ends[m] = n;
				res[index++] = edges[i];
			}
		}
		return res;
	}

	// 获取该顶点在最小生成树中的终点
	private int getEnd(int[] ends, int i) {
		while (ends[i] != 0) {
			i = ends[i];
		}
		return i;
	}

	// 输出邻接矩阵
	private void print() {
		for (int i = 0; i < vertices.length; ++i) {
			for (int j = 0; j < vertices.length; ++j) {
				System.out.printf("%12d", weight[i][j]);
			}
			System.out.println();
		}
	}

	// 返回顶点对应下标
	private int getIndex(char ch) {
		for (int i = 0; i < vertices.length; ++i) {
			if (vertices[i] == ch) {
				return i;
			}
		}
		return -1;
	}

	// 存储图中所有的边
	private Edge[] getEdges() {
		int index = 0;
		Edge[] edges = new Edge[edgeNum];
		for (int i = 0; i < vertices.length; ++i) {
			for (int j = i + 1; j < vertices.length; ++j) {
				if (weight[i][j] != INF) {
					edges[index++] = new Edge(vertices[i], vertices[j], weight[i][j]);
				}
			}
		}
		return edges;
	}
}

//创建一个类，用来表示边
class Edge implements Comparable<Edge> {
	char start;
	char end;
	int weight;

	public Edge(char start, char end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "边<" + start + end + ">权值为" + weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}

}
