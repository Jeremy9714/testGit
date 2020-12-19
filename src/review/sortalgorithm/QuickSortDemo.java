package review.sortalgorithm;

import java.util.Arrays;

public class QuickSortDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] array = {-9,78,0,23,-567,70,-3 };
		System.out.println(Arrays.toString(array));
		quickSort(array, 0, array.length - 1);
	}

	public static void quickSort(int[] arr, int left, int right) {
		int pivot = arr[left];
		int l = left;
		int r = right;
		if(left==right) {
			//System.out.println(pivot);
			return;
		}
		while(l!=r) {
			while(arr[r]>=pivot&&l<r) {
				r--;
			}
			while(arr[l]<=pivot&&l<r) {
				l++;
			}
			if(l<r) {
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
			}
		}
		arr[left] = arr[l];
		arr[l] = pivot;
		
		System.out.println(Arrays.toString(arr)+" "+l+" "+r);
		if(r>left) {
			quickSort(arr,left,l-1);
		}
		if(l<right) {
			quickSort(arr,r+1,right);
		}
	}

}
