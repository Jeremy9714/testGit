package review.algorithms;

import java.util.ArrayList;
import java.util.List;

public class PrimAlgorithm {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		char[] data = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int vertices = data.length;
		int[][] weight = { { 10000, 5, 7, 10000, 10000, 10000, 2 }, { 5, 10000, 10000, 9, 10000, 10000, 3 },
				{ 7, 10000, 10000, 10000, 8, 10000, 10000 }, { 10000, 9, 10000, 10000, 10000, 4, 10000 },
				{ 10000, 10000, 8, 10000, 10000, 5, 4 }, { 10000, 10000, 10000, 4, 5, 10000, 6 },
				{ 2, 3, 10000, 10000, 4, 6, 10000 }, };
		Graph graph = new Graph(vertices);
		graph.vertices = data;
		graph.edges = weight;
		prim(graph, 4);
	}

	public static void prim(Graph graph, int start) {
		int weight = 0;
		List<Integer> minTree = new ArrayList<>();// 存放最近顶点
		boolean[] isVisited = new boolean[graph.numOfVertex];// 存放顶点的访问状态
		minTree.add(start);
		isVisited[start] = true;

		for (int k = 1; k < graph.numOfVertex; ++k) {
			int minLen = 10000;
			int minIndex = 0;
			int s=0;
			for (int index:minTree) {
				for (int i = 0; i < graph.numOfVertex; ++i) {
					int dis = graph.edges[index][i];
					if (!isVisited[i] && dis < 10000 && dis < minLen) {
						minLen = dis;
						minIndex = i;
						s=index;
					}
				}
			}
			minTree.add(minIndex);
			isVisited[minIndex] = true;
			System.out.println(
					"<" + graph.vertices[s] + graph.vertices[minIndex] + ">的权值为: " + graph.edges[s][minIndex]);
			weight += graph.edges[s][minIndex];
		}
		System.out.println("路径总长度为: " + weight);
	}

}

class Graph {
	int numOfVertex;
	char[] vertices;
	int[][] edges;

	public Graph(int num) {
		this.numOfVertex = num;
		this.vertices = new char[num];
		this.edges = new int[num][num];
	}
}