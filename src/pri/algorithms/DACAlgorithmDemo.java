package pri.algorithms;

public class DACAlgorithmDemo {

	public static void main(String[] args) {
		Tower(3, 'A', 'B', 'C');

	}

	public static void Tower(int num, char a, char b, char c) {
		// 只有一张盘时，直接移动
		if (num == 1) {
			System.out.println("第1个盘从" + a + "->" + c);
		} else {// 当盘数大于等于2时，将所有盘看成两部分，最下面的盘和上面的所有盘
			// 第一步，将上面的盘从a移动到b
			Tower(num - 1, a, c, b);
			// 第二步，将最下面的盘从a移动到c
			System.out.println("第" + num + "个盘从" + a + "->" + c);
			// 最后一步，将放到b的上面的盘移动到c
			Tower(num - 1, b, a, c); 
		}
	}

}
