package review.sortalgorithm;

import java.util.Arrays;

public class SelectSortDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] array = {5,3,1,2,4};
		int[] res = selectSort(array);
		System.out.println(Arrays.toString(res));
	}
	public static int[] selectSort(int[] array) {
		System.out.println("原数组为 "+Arrays.toString(array));
		for(int i=0;i<array.length-1;++i) {
			int index=0;
			int min=999;
			for(int j=i;j<array.length;++j) {
				if(array[j]<min) {
					min = array[j];
					index = j;
				}
			}
			array[index]=array[i];
			array[i]=min;
			System.out.println("第"+(i+1)+"次选择排序的结果为 "+Arrays.toString(array));
		}
		return array;
	}
}
