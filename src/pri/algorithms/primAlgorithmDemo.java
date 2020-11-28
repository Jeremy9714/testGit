package pri.algorithms;

import java.util.Arrays;

public class primAlgorithmDemo {

	public static void main(String[] args) {

		char[] data = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int vertices = data.length;
		int[][] weight = { { 10000, 5, 7, 10000, 10000, 10000, 2 }, { 5, 10000, 10000, 9, 10000, 10000, 3 },
				{ 7, 10000, 10000, 10000, 8, 10000, 10000 }, { 10000, 9, 10000, 10000, 10000, 4, 10000 },
				{ 10000, 10000, 8, 10000, 10000, 5, 4 }, { 10000, 10000, 10000, 4, 5, 10000, 6 },
				{ 2, 3, 10000, 10000, 4, 6, 10000 }, };

		MinTree minTree = new MinTree();
		Graph graph = new Graph(vertices);
		minTree.createGraph(graph, vertices, data, weight);
		minTree.showGraph(graph);
		minTree.prim(graph, 5);

	}

}

class MinTree {

	public void createGraph(Graph graph, int vertices, char[] data, int[][] weight) {
		int i, j;
		for (i = 0; i < vertices; ++i) {
			graph.data[i] = data[i];
			for (j = 0; j < vertices; ++j) {
				graph.weight[i][j] = weight[i][j];
			}
		}
	}

	/**
	 * 普利姆算法
	 * 
	 * @param graph 图
	 * @param v     从哪个顶点开始生成
	 */
	public void prim(Graph graph, int v) {
		// 标记访问过的顶点
		int[] isVisited = new int[graph.vertices];
		int meter = 0; // 记录总路程

		isVisited[v] = 1;
		// 定义两个下标表示路的两个顶点
		int h1 = -1;
		int h2 = -1;
		// 记录最小权值
		int minWeight = 10000;
		// int[][] road = new int[graph.vertices][graph.vertices];
		for (int k = 1; k < graph.vertices; ++k) {// 访问的顶点数
			// 重置最小值
			minWeight = 10000;
			// h1=-1;
			// h2=-1;
			for (int i = 0; i < graph.vertices; ++i) {// 已访问过的顶点
				for (int j = 0; j < graph.vertices; ++j) {// 未访问过的顶点
					// 判断顶点i已访问过且顶点2未被访问过，并且两个顶点之间的权值小于最小值
					if (isVisited[i] == 1 && isVisited[j] == 0 && graph.weight[i][j] < minWeight) {
						minWeight = graph.weight[i][j];
						// 记录顶点下标
						h1 = i;
						h2 = j;
					}
				}
			}
			// 未被访问的顶点标记为已访问
			isVisited[h2] = 1;
			meter += graph.weight[h1][h2];
			System.out.println("边<" + graph.data[h1] + graph.data[h2] + ">权值为: " + graph.weight[h1][h2]);
		}
		System.out.println("总路程为: " + meter);
	}

	public void showGraph(Graph graph) {
		for (int[] line : graph.weight) {
			System.out.println(Arrays.toString(line));
		}
	}
}

class Graph {
	int vertices;
	char[] data;
	int[][] weight;

	public Graph(int vertices) {
		this.vertices = vertices;
		data = new char[vertices];
		weight = new int[vertices][vertices];
	}

}