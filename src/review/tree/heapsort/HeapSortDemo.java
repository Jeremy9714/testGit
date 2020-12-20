package review.tree.heapsort;

import java.util.Arrays;

public class HeapSortDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = { 4, 6, 8, 5, 9, 2, 10 };
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void heapSort(int[] arr) {

		for (int i = arr.length / 2 - 1; i >= 0; --i) {
			adjust(arr, i, arr.length);
		}
		for (int j = arr.length - 1; j > 0; --j) {
			int temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjust(arr, 0, j);
		}
	}

	public static void adjust(int[] arr, int i, int length) {
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

}
