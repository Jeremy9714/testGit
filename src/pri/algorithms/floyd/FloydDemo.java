package pri.algorithms.floyd;

import java.util.Arrays;

public class FloydDemo {

	public static void main(String[] args) {
		
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
	private char[] vertex;
	private int[][] pre;
	private int[][] dis;
	
	public Graph(int length, char[] vertex, int[][] weight) {
		this.vertex = vertex;
		this.dis = weight;
		this.pre = new int[length][length];
		
		for(int i=0;i<length;++i) {
			Arrays.fill(pre[i], i);
		}
	}
	
	public void showGraph() {
		for(int i=0;i<vertex.length;++i) {
			for(int j=0;j<vertex.length;++j) {
				System.out.print(vertex[pre[i][j]]+" ");
			}
			System.out.println();
			for(int j=0;j<vertex.length;++j) {
				System.out.print(vertex[i]+"到"+vertex[j]+"的距离为"+dis[i][j]+" ");
			}
			System.out.println();
			System.out.println();
		}
	}
	
	public void floyd() {
		int vLen = vertex.length;
		int len=0;//保存距离
		//对中间顶点进行遍历
		for(int k=0;k<vLen;++k) {
			//对出发顶点进行遍历
			for(int i=0;i<vLen;++i) {
				//对终点进行遍历
				for(int j=0;j<vLen;++j) {
					//出发顶点到终点的距离为出发顶点到中间顶点的距离与中间顶点到终点的距离之和
					len = dis[i][k]+dis[k][j];
					//判断该距离与从出发顶点直接到终点的距离大小
					if(len<dis[i][j]) {
						//更新最短距离
						dis[i][j] = len;
						//更新前驱顶点
						pre[i][j] = pre[k][j];
					}
				}
			}
		}
	}
}