package pri.algorithms;

public class BinarySearchDemo {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		System.out.println(BinarySearch(arr,9));
	}
	
	public static int BinarySearch(int[] arr,int value) {
		int left = 0;
		int right = arr.length-1;
		//int mid = (left+right)/2;
		while(left<=right) {
			int mid = (left+right)/2;
			if(arr[mid]==value) {
				return mid;
			}else if(value<arr[mid]) {
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		return -1;
	}
}
