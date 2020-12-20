package review.tree.heapsort;

import java.util.Arrays;

public class HeapSortDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = { 4, 6, 8, 5, 9, 2, 10 };
		heapSort1(arr);
		System.out.println(Arrays.toString(arr));
		
		heapSort2(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	//大顶堆
	public static void heapSort1(int[] arr) {
		System.out.print("大顶堆排序: ");
		for (int i = arr.length / 2 - 1; i >= 0; --i) {
			bigAdjust(arr, i, arr.length);
		}
		for (int j = arr.length - 1; j > 0; --j) {
			int temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			bigAdjust(arr, 0, j);
		}
	}
	public static void bigAdjust(int[] arr, int i, int length) {
		int temp = arr[i];
		for (int j = 2 * i + 1; j < length; j = j * 2 + 1) {
			if (j + 1 < length && arr[j] < arr[j + 1]) {
				++j;
			}
			if (arr[j] > temp) {
				arr[i] = arr[j];
				i = j;
			} else {
				break;
			}
		}
		arr[i] = temp;
	}
	
	//小顶堆
	public static void heapSort2(int[] arr) {
		System.out.print("小顶堆排序: ");
		for (int i = arr.length / 2 - 1; i >= 0; --i) {
			smallAdjust(arr, i, arr.length);
		}
		for (int j = arr.length - 1; j > 0; --j) {
			int temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			smallAdjust(arr, 0, j);
		}
	}
	public static void smallAdjust(int[] arr, int i,int length) {
		int temp = arr[i];
		for(int j = 2*i+1;j<length;j=2*j+1) {
			if(j+1<length&&arr[j+1]<arr[j]) {
				j++;
			}
			if(arr[j]<temp) {
				arr[i] = arr[j];
				i = j;
			}else {
				break;
			}
		}
		arr[i] = temp;
	}
}
