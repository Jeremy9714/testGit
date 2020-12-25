package review.algorithms.floydalgorithm;

import java.util.Arrays;

public class FloydAlgorithm {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		char[] vertex = {'A','B','C','D','E','F','G'};
		int[][] dis = new int[vertex.length][vertex.length];
		final int N = 65535;
		dis[0] = new int[] {0,5,7,N,N,N,2};
		dis[1] = new int[] {5,0,N,9,N,N,3};
		dis[2] = new int[] {7,N,0,N,8,N,N};
		dis[3] = new int[] {N,9,N,0,N,4,N};
		dis[4] = new int[] {N,N,8,N,0,5,4};
		dis[5] = new int[] {N,N,N,4,5,0,6};
		dis[6] = new int[] {2,3,N,N,4,6,0};
		Graph graph = new Graph(vertex.length,vertex,dis);
		graph.floyd();
		graph.showGraph();
		
	}	
}

class Graph{
	private char[] vertices;
	private int[][] matrix;
	private int[][] pre;
	
	public Graph(int len, char[] vertices, int[][] matrix) {
		this.vertices = vertices;
		this.matrix = matrix;
		this.pre = new int[len][len];
		for(int i=0;i<len;++i) {
			Arrays.fill(this.pre[i], i);
		}
	}
	
	public void floyd() {
		int vLen = vertices.length;
		int len;
		for(int i=0;i<vLen;++i) {
			int mid = i;
			for(int j=0;j<vLen;++j) {
				int start = j;
				for(int k=0;k<vLen;++k) {
					int end = k;
					len = matrix[start][mid] + matrix[mid][end];
					if(len<matrix[start][end]) {
						matrix[start][end] = len;
						pre[start][end] = pre[mid][end];
					}
				}
			}
		}
	}
	
	public void showGraph() {
		for(int i=0;i<vertices.length;++i) {
			System.out.print("以"+vertices[i]+"为出发点时，各个顶点的前驱节点为: ");
			for(int j=0;j<vertices.length;++j) {
				System.out.print(vertices[pre[i][j]]+" ");
			}
			System.out.println();
			for(int j=0;j<vertices.length;++j) {
				System.out.print(vertices[i]+"到"+vertices[j]+"的距离为"+matrix[i][j]+" ");
			}
			System.out.println();
			System.out.println();
		}
		/*
		for(int i=0;i<vertices.length;++i) {
			for(int j=0;j<vertices.length;++j) {
				System.out.printf("%d\t",matrix[i][j]);
			}
			System.out.println();
		}*/
	}
}