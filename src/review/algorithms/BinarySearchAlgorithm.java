package review.algorithms;

public class BinarySearchAlgorithm {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {1,3,4,7,9,10,24,33,55};
		int index = binarySearch(arr,0,arr.length-1,55);
		System.out.println(arr[index]);
	}
	
	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		while(left<=right) {
			int mid = (left+right)/2;
			if(arr[mid]>findVal) {
				right=mid-1;
			}else if(arr[mid]<findVal){
				left=mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}
}
