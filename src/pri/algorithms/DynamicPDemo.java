package pri.algorithms;

public class DynamicPDemo {

	public static void main(String[] args) {
		int[] weight = { 1, 4, 3, 2};// 物品重量
		int[] value = { 1500, 4000, 3000, 2000 };// 物品价值
		int capacity = 5;// 背包容积
		int num = value.length;

		// 创建二维数组，用于存储前n个物品中能够装入容量为m的背包中的最大价值
		int[][] v = new int[num + 1][capacity + 1];
		// 创建二维数组，用于存储满足条件时放入的物品
		int[][] path = new int[num + 1][capacity + 1];

		for (int i = 1; i < v.length; ++i) {
			for (int j = 1; j < v[i].length; ++j) {
				// 若当前物品重量大于背包容量
				if (weight[i - 1] > j) {
					// 结果则与少一个物品时相同
					v[i][j] = v[i - 1][j];
				} else {
					// 判断将该物品与其他物品一起放入的重量与不放该物品的重量，哪一个价值更高
					if (v[i - 1][j] > value[i - 1] + v[i - 1][j - weight[i - 1]]) {
						v[i][j] = v[i - 1][j];
					} else {
						v[i][j] = value[i - 1] + v[i - 1][j - weight[i - 1]];
						path[i][j] = 1;
					}
				}
			}
		}

		int i = path.length - 1;
		int j = path[0].length - 1;
		while (i > 0 && j > 0) {
			if (path[i][j] == 1) {
				System.out.printf("将第%d个物品放入到背包\n", i);
				j -= weight[i - 1];
			}
			i--;
		}

		for(i=0;i<v.length;++i) {
			for(j=0;j<v[i].length;++j) {
				System.out.print(v[i][j]+",");
			}
			System.out.println();
		}
		 

	}
}
