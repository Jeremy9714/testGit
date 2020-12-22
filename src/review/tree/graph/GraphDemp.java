package review.tree.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphDemp {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*for(int i=65;i<70;++i) {
			graph.addVertex((char)i+"");
		}*/
		String[] vertices = {"A","B","C","D","E"};
		int len = vertices.length;
		Graph graph = new Graph(len);
		for(String s:vertices) {
			graph.addVertex(s);
		}
		graph.addEdges(0, 1, 1);
		graph.addEdges(0, 2, 1);
		graph.addEdges(1, 2, 1);
		graph.addEdges(1, 3, 1);
		graph.addEdges(1, 4, 1);
		graph.show();
		
	}

}

class Graph{
	private List<String> vertices;
	private int[][] edges;
	private int numOfEdges;
	public Graph(int n) {
		this.vertices = new ArrayList<String>(n); 
		this.edges = new int[n][n];
		this.numOfEdges = 0;
	}
	
	public void addVertex(String vertex) {
		vertices.add(vertex);
	}
	public void addEdges(int v1, int v2, int weight) {
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
		for(int[] row:edges) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
	}
}