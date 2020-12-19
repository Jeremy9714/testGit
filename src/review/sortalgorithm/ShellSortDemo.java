package review.sortalgorithm;

import java.util.Arrays;

public class ShellSortDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] array = { 4, 2, 5, 6, 1, 8, 3, 7, 9 };
		shellExchangeSort(array);
		// shellMoveSort(array);
	}

	// 交换法
	public static void shellExchangeSort(int[] array) {
		int count = 1;
		System.out.println("原数组为 " + Arrays.toString(array));
		for (int gap = array.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < array.length; ++i) {
				for(int j=i-gap;j>=0;j-=gap) {
					if(array[j]>array[j+gap]) {
						int temp = array[j];
						array[j] = array[j+gap];
						array[j+gap] = temp;
					}
				}
			}
			System.out.println("第" + (count++) + "次希尔排序的结果为 " + Arrays.toString(array));
		}

	}

	// 移动法
	public static void shellMoveSort(int[] array) {
		System.out.println("原数组为 " + Arrays.toString(array));
		int count = 1;
		for (int gap = array.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < array.length; ++i) {
				int val = array[i];
				int index = i;
				if (array[i] < array[i - gap]) {
					while (index - gap >= 0 && val < array[index - gap]) {
						array[index] = array[index - gap];
						index -= gap;
					}
				}
				array[index] = val;
			}
			System.out.println("第" + (count++) + "次希尔排序的结果为 " + Arrays.toString(array));
		}
		System.out.println();
	}
}
