package review.algorithms;

public class DPAlgorithm {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] weight = { 1, 4, 3, 2, 5 };
		int[] value = { 1000, 3000, 2500, 2000, 4000 };
		int capacity = 4;
		int[][] v = new int[weight.length + 1][capacity + 1];
		int[][] items = new int[weight.length + 1][capacity + 1];

		for (int i = 1; i < v.length; ++i) {
			for (int j = 1; j < v[i].length; ++j) {
				if (weight[i - 1] > j) {
					v[i][j] = v[i - 1][j];
				} else {
					if (v[i - 1][j] > v[i - 1][j - weight[i - 1]] + value[i - 1]) {
						v[i][j] = v[i - 1][j];
					} else {
						v[i][j] = v[i - 1][j - weight[i - 1]] + value[i - 1];
						// 第i个货物在容量为j的情况下需要加入
						items[i][j] = 1;
					}
				}
			}
		}
		// 放入背包
		int num = items.length - 1;
		int weights = items[0].length - 1;
		while (num > 0 && weights > 0) {
			if (items[num][weights] == 1) {
				System.out.println("放入第" + num + "个物品");
				weights -= weight[num - 1];
			}
			num -= 1;
		}
		
		for(int i=1;i<v.length;++i) {
			v[i][0]=i;
		}
		for(int j=1;j<v[0].length;++j) {
			v[0][j] = j;
		}
		
		for(int i=0;i<v.length;++i) {
			for(int j=0;j<v[i].length;++j) {
				System.out.print(v[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
