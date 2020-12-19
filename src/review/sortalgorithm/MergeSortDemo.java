package review.sortalgorithm;

import java.util.Arrays;

public class MergeSortDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr  = {3,6,1,7,2,8,4,5,9};
		int[] temp = new int[arr.length];
		divide(arr,0,arr.length-1,temp);
		System.out.println(Arrays.toString(arr));
	}
	//分割
	public static void divide(int[] arr, int left, int right, int[] temp) {
		if(left<right) {
			int mid = (left+right)/2;
			divide(arr,left,mid,temp);
			divide(arr,mid+1,right,temp);
			mergeSort(arr,left,mid,right,temp);
		}
	}
	
	//合并
	public static void mergeSort(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left;
		int j = mid+1;
		int t =0;
		while(i<=mid&&j<=right) {
			temp[t++]=arr[i]<arr[j]?arr[i++]:arr[j++];
		}
		while(i<=mid) {
			temp[t++]=arr[i++];
		}
		while(j<=right) {
			temp[t++]=arr[j++];
		}
		int tempLeft = left;
		t = 0;
		arr[tempLeft++] = temp[t++];
	}
}
