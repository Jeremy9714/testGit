package review.sortalgorithm;

import java.util.Arrays;

public class InsertSortDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] array = {5,4,3,2,1};
		insertSort(array);
	}
	public static void insertSort(int[] array) {
		System.out.println("原数组为 "+Arrays.toString(array));
		for(int i=1;i<array.length;++i) {
			int val=array[i];
			int index=i;
			for(int j=i-1;j>=0;--j) {
				if(val<array[j]) {
					array[index--]=array[j];
				}
			}
			array[index]=val;
			System.out.println("第"+i+"次选择排序的结果为 "+Arrays.toString(array));
		}
		System.out.println("排序后的数组为 "+Arrays.toString(array));
	}
}
