package review.algorithms;

import java.util.Arrays;
import java.util.Collections;

public class KruskalAlgorithm {

	private static final int INF = Integer.MAX_VALUE;
	private char[] vertices;
	private int[][] matrix;
	private int numOfEdges;

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*char[] vertices = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int[][] matrix = { { 0, 12, INF, INF, INF, 16, 14 }, { 12, 0, 10, INF, INF, 7, INF },
				{ INF, 10, 0, 3, 5, 6, INF }, { INF, INF, 3, 0, 4, INF, INF }, { INF, INF, 5, 4, 0, 2, 8 },
				{ 16, 7, 6, INF, 2, 0, 9 }, { 14, INF, INF, INF, 8, 9, 0 } };*/
		
		char[] vertices = {'A','B','C','D','E'};
		int[][] matrix = {{0,1,2,INF,INF},{1,0,3,4,INF},{2,3,0,INF,6},{INF,4,INF,0,5},{INF,INF,6,5,0}};
		KruskalAlgorithm demo = new KruskalAlgorithm(vertices, matrix);
		Edge[] res = demo.kruskal();
		for (Edge ele : res) {
			System.out.println(ele);
		}
	}

	private Edge[] kruskal() {
		int[] ends = new int[vertices.length];
		Edge[] res = new Edge[vertices.length - 1];
		Edge[] edges = getEdges();
		Arrays.sort(edges);
		// System.out.println(Arrays.toString(edges));
		int index = 0;

		for (int i = 0; i < edges.length; ++i) {
			Edge curEdge = edges[i];
			char h1 = curEdge.start;
			char h2 = curEdge.end;
			int s1 = getIndex(h1);
			int s2 = getIndex(h2);
			int m = getEnd(ends, s1);
			int n = getEnd(ends, s2);
			if (m != n) {
				ends[m] = n;
				res[index++] = curEdge;
			}
		}
		return res;
	}

	private int getEnd(int[] ends, int index) {
		while (ends[index] != 0) {
			index = ends[index];
		}
		return index;
	}

	private Edge[] getEdges() {
		Edge[] edges = new Edge[numOfEdges];
		int index = 0;
		for (int i = 0; i < vertices.length; ++i) {
			for (int j = i + 1; j < vertices.length; ++j) {
				if (this.matrix[i][j] != INF) {
					edges[index++] = new Edge(vertices[i], vertices[j], matrix[i][j]);
				}
			}
		}
		return edges;
	}

	public KruskalAlgorithm(char[] vertices, int[][] matrix) {
		int len = vertices.length;
		this.vertices = new char[len];
		for (int i = 0; i < len; ++i) {
			this.vertices[i] = vertices[i];
		}
		this.matrix = new int[len][len];
		for (int i = 0; i < len; ++i) {
			for (int j = i + 1; j < len; ++j) {
				this.matrix[i][j] = matrix[i][j];
				if (this.matrix[i][j] != INF) {
					this.numOfEdges++;
				}
			}
		}
	}

	private int getIndex(char ch) {
		for (int i = 0; i < vertices.length; ++i) {
			if (vertices[i] == ch) {
				return i;
			}
		}
		return -1;
	}

	private void print() {
		for (int i = 0; i < vertices.length; ++i) {
			for (int j = 0; j < vertices.length; ++j) {
				System.out.printf("%d\t", this.matrix[i][j]);
			}
			System.out.println();
		}
	}
}

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
	public int compareTo(Edge o) {
		// TODO 自动生成的方法存根
		return this.weight - o.weight;
	}

	@Override
	public String toString() {
		return "" + start + end + "[" + weight + "]";
	}

}