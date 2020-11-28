package pri.algorithms.dijkstra;

import java.util.Arrays;

public class DijkstraDemo {

	public static void main(String[] args) {
		char[] vertices = {'A','B','C','D','E','F','G'};
		int[][] weight =new int[vertices.length][vertices.length];
		final int N = 65535; //表示不可以连接
		weight[0] = new int[]{N,5,7,N,N,N,2};
		weight[1] = new int[]{5,N,N,9,N,N,3};
		weight[2] = new int[]{7,N,N,N,8,N,N};
		weight[3] = new int[]{N,9,N,N,N,4,N};
		weight[4] = new int[]{N,N,8,N,N,5,4};
		weight[5] = new int[]{N,N,N,4,5,6,N};
		weight[6] = new int[]{2,3,N,N,4,6,N};
		
		Graph graph = new Graph(vertices,weight);
		graph.showGraph();
		graph.Dijkstra(6);
		graph.show();
	}

}

class Graph{
	char[] vertices;
	int[][] weight;
	VisitedVertex vv; //已经访问过的顶点的集合
	public Graph(char[] vertices,int[][] weight){
		this.vertices = vertices;
		this.weight = weight;
	}
	
	public void showGraph() {
		for(int[] line:weight) {
			System.out.println(Arrays.toString(line));
		}
	}
	
	//迪杰斯特拉算法
	public void Dijkstra(int index) {
		vv = new VisitedVertex(vertices.length,index);
		update(index);
		//遍历顶点知道全部顶点都被访问过
		for(int i=1;i<vertices.length;++i){
			//移动到下一个顶点
			index = vv.updateArr();
			//将顶点更新为已访问
			vv.updateVisited(index);
			update(index);
		}
	}
	
	//更新指定下标的顶点到其邻接定点的距离及其邻接定点的前驱顶点
	private void update(int index) {
		int len=0;
		for(int j=0;j<weight[index].length;j++) {
			//距离等于出发顶点到该顶点的距离加上该顶点到其邻接顶点的距离
			len = vv.getDis(index)+weight[index][j];
			//如果该邻接顶点未被访问过，并且距离小于从保存的出发顶点到该顶点的距离
			if(!vv.in(j)&&len<vv.getDis(j)) {
				//更新该邻接顶点到出发顶点的距离
				vv.updateDis(j, len);
				//更新该邻接顶点的前驱顶点下标
				vv.updatePre(j, index);	
			}		
		}
	}
	
	public void show() {
		System.out.print("顶点:       ");
		for(char c:vertices) {
			System.out.printf("%-3c",c);
		}
		System.out.println();
		vv.show();
	}
}
	

//已访问的顶点的集合
class VisitedVertex{
	private int[] isVisited;
	private int[] pre_visited;
	private int[] dis;
	
	/**
	 * 构造器
	 * @param length 顶点个数
	 * @param index 出发顶点下标
	 */
	public VisitedVertex(int length, int index) {
		this.isVisited = new int[length];
		this.pre_visited = new int[length];
		this.dis = new int[length];
		
		//将除法顶点到除自身以外顶点的距离初始化为最大
		Arrays.fill(dis, 65535);
		dis[index] = 0;
		//设置出发顶点已被访问过
		isVisited[index] = 1;
	}
	//判断指定下标的顶点是否被访问过
	public boolean in(int index) {
		return isVisited[index]==1;
	}
	//更新出发点到各个定点的距离
	public void updateDis(int index, int len) {
		dis[index] = len;
	}
	//更新顶点的前驱节点为index
	public void updatePre(int pre, int index) {
		pre_visited[pre] = index;
	}
	//更新顶点的访问状态
	public void updateVisited(int index) {
		isVisited[index] = 1;
	}	
	//获取出发顶点到指定顶点的距离
	public int getDis(int index) {
		return dis[index];
	}
	//移动到下一个顶点(距离出发顶点最近的为访问过的顶点)
	public int updateArr() {
		int index=0;
		int min = 65535;
		for(int i=0;i<isVisited.length;++i) {
			//选择一个距离最近的顶点移动
			if(isVisited[i]==0&&getDis(i)<min) {
				min = getDis(i);
				index = i;
			}
		}
		/*//将此顶点标记为已访问过
		isVisited[index]=1;*/
		return index;
	}
	
	public void show() {
		System.out.print("是否访问过: ");
		for(int i:isVisited) {
			System.out.printf("%-3d",i);
		}
		System.out.println();
		System.out.print("前驱顶点:   ");
		for(int i:pre_visited) {
			System.out.printf("%-3d",i);
		}
		System.out.println();
		System.out.print("最短距离:   ");
		for(int i:dis) {
			System.out.printf("%-3d",i);
		}
		
	}
}
