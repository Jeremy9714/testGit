package review.sortalgorithm;

import java.util.Arrays;

public class BubbleSortDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] array = {1,2,4,3,5};
		int[] res = bubbleSort(array);
		System.out.println(Arrays.toString(res));
	}
	public static int[] bubbleSort(int[] array) {
		System.out.println("原数组为 "+Arrays.toString(array));
		boolean flag=false;
		for(int i=0;i<array.length-1;++i) {
			for(int j=0;j<array.length-i-1;++j) {
				if(array[j]>array[j+1]) {
					flag=true;
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
			if (!flag) {
				break;
			} else {
				flag = false;
			}
			System.out.println("第"+(i+1)+"次冒泡排序的结果为 "+Arrays.toString(array));
		}
		return array;
	}
}
