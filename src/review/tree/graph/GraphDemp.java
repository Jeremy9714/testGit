package review.tree.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphDemp {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*
		 * for(int i=65;i<70;++i) { graph.addVertex((char)i+""); }
		 */
		String[] vertices = { "A", "B", "C", "D", "E", "F", "G", "H" };
		int len = vertices.length;
		Graph graph = new Graph(len);
		for (String s : vertices) {
			graph.addVertex(s);
		}
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 1);
		graph.addEdge(1, 3, 1);
		graph.addEdge(1, 4, 1);
		graph.addEdge(3, 7, 1);
		graph.addEdge(4, 7, 1);
		graph.addEdge(2, 5, 1);
		graph.addEdge(2, 6, 1);
		graph.addEdge(5, 6, 1);
		graph.show();

		graph.dfs();
		graph.bfs();
	}

}

class Graph {
	private boolean[] isVisited;
	private List<String> vertices;
	private int[][] edges;
	private int numOfEdges;

	public Graph(int n) {
		this.vertices = new ArrayList<String>(n);
		this.edges = new int[n][n];
		this.isVisited = new boolean[n];
		this.numOfEdges = 0;
	}
	// 深度优先查找(确保访问全部节点)
	public void dfs() {
		System.out.println("深度优先");
		isVisited = new boolean[numOfVertices()];
		for (int i = 0; i < numOfVertices(); ++i) {
			if (!isVisited[i]) {
				dfs(i);
			}
		}
		System.out.println();
	}

	// 深度优先查找
	public void dfs(int n) {
		isVisited[n] = true;
		System.out.print(getValueByIndex(n) + (n + 1) + "->");
		for (int i = 0; i < numOfVertices(); ++i) {
			if (getEdge(n, i) != 0 && !isVisited[i]) {
				dfs(i);
			}
		}
	}
	
	// 广度优先查找(确保访问全部节点)
	public void bfs() {
		System.out.println("广度优先");
		isVisited = new boolean[numOfVertices()];
		for(int i=0;i<numOfVertices();++i) {
			if(!isVisited[i]) {
				bfs(i);
			}
		}
		System.out.println();
	}
	// 广度优先查找
	public void bfs(int n) {
		isVisited[n] = true;
		List<Integer> list = new ArrayList<>();
		list.add(n);
		System.out.print(vertices.get(n)+(n+1)+"->");
		while (!list.isEmpty()) {
			int cur = list.remove(0);
			for (int i = 0; i < numOfVertices(); ++i) {
				if (getEdge(cur, i) != 0&&!isVisited[i]) {
					list.add(i);
					isVisited[i] = true;
					System.out.print(vertices.get(i)+(i+1)+"->");
				}
			}
		}
	}

	public void addVertex(String vertex) {
		vertices.add(vertex);
	}

	public void addEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}

	public int numOfVertices() {
		return vertices.size();
	}

	public int numOfEdges() {
		return numOfEdges;
	}

	public String getValueByIndex(int i) {
		return vertices.get(i);
	}

	public int getEdge(int v1, int v2) {
		return edges[v1][v2];
	}

	public void show() {
		for (int[] row : edges) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
	}
}