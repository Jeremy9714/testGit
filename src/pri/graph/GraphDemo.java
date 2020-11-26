package pri.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class GraphDemo {

	public static void main(String[] args) {
		
		int n = 5;
		String[] vertices = {"A","B","C","D","E"};
		Graph graph = new Graph(n);
		for(String vertex: vertices) {
			graph.insertVertex(vertex);
		}
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(2, 0, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		graph.showGraph();
		System.out.println("深度优先");
		graph.dfs();
		System.out.println("\n广度优先");
		graph.bfs();
	}

}

class Graph {
	private ArrayList<String> vertexList; // 存储顶点的数列
	private int[][] edges; // 存储边的二维矩阵
	private int numOfEdges; // 边的数量
	private boolean[] isVisited; //判断顶点是否被访问过

	public Graph(int i) {
		edges = new int[i][i];
		vertexList = new ArrayList<>();
		numOfEdges = 0;
	}
	
	//深度优先搜索
	private void dfs(int index) {
		System.out.print(getValueByIndex(index)+"->");
		//将此顶点标记为已访问
		isVisited[index] = true;
		//获取当前顶点的第一个邻接顶点
		int neighborIndex = getFirstNeighbor(index);
		
		while(neighborIndex!=-1) {
			//判断该邻接顶点是否被访问过
			if(!isVisited[neighborIndex]) {	
				dfs(neighborIndex);
			}
			//找当前顶点的下一个邻接顶点
			neighborIndex = getNextNeighbor(index,neighborIndex);
		}
		//System.out.println(Arrays.toString(isVisited));
	}
	
	//确保所有的顶点都能遍历(无任何邻接顶点的顶点)
	public void dfs() {
		isVisited = new boolean[vertexList.size()];
		for(int i=0;i<vertexList.size();++i) {
			if(!isVisited[i]) {
				dfs(i);
			}
		}
	}
	
	//广度优先搜索
	private void bfs(int index)
	{	
		int u; //队列的头节点下标
		int w; //头节点的邻节点
		//队列,记录节点访问的顺序
		LinkedList<Integer> queue = new LinkedList<Integer>();
		System.out.print(vertexList.get(index)+"->");
		isVisited[index] = true;
		queue.addLast(index);
		//队列为空，则结束搜索
		while(!queue.isEmpty()) {
			//头节点
			u = queue.removeFirst();
			//头节点的邻节点
			w = getFirstNeighbor(u);
			//还存在邻节点，则循环搜索
			while(w!=-1) {
				if(!isVisited[w]) {
					System.out.print(vertexList.get(w)+"->");
					isVisited[w] = true;
					//再将新的邻节点加入队列
					queue.addLast(w);
				}
				//查找是否还有邻节点
				w = getNextNeighbor(u,w);
			}	
		}
	}
	
	//确保所有的顶点都能遍历(无任何邻接顶点的顶点)
	public void bfs() {
		isVisited = new boolean[vertexList.size()];
		for(int i=0;i<vertexList.size();++i) {
			if(!isVisited[i]) {
				bfs(i);
			}
		}
	}
	
	//获取当前顶点的第一个邻接顶点
	public int getFirstNeighbor(int index) {
		for(int i=0;i<vertexList.size();++i) {
			//若找到邻接顶点则返回顶点下标
			if(edges[index][i]>0) {
				return i;
			}
		}
		return -1;//没有找到邻接顶点
	}
	
	//根据前一个邻接顶点来获取下一个邻接顶点的下标
	public int getNextNeighbor(int v1,int v2) {
		for(int i=v2+1;i<vertexList.size();++i) {
			if(edges[v1][i]>0) {
				return i;
			}
		}
		return -1;
	}
	
	//获取顶点的值
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}
	//输出图
	public void showGraph() {
		for(int[] line:edges) {
			System.out.println(Arrays.toString(line));
		}
	}
	//获取顶点的数量
	public int getNumOfVertex() {
		return vertexList.size();
	}
	//获取边的数量
	public int getNumOfEdge(){	
		return numOfEdges;
	}
	//获取一个边长的权值
	public int getWeightOfEdge(int v1, int v2) {
		return edges[v1][v2];
	}
	//加入顶点
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}
	
	//加入边
	/**
	 * 
	 * @param v1     顶点1
	 * @param v2     顶点2
	 * @param weight 添加的边的权值
	 */
	public void insertEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}
}
