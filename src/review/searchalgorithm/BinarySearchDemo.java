package review.searchalgorithm;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchDemo {
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {1,1,3,4,4,5,6,6,8};
		List<Integer> list = binarySearch(arr, 0, arr.length-1,1);
		System.out.println(list);
	}
	public static List<Integer> binarySearch(int[] arr, int left, int right, int val) {
		int mid = (left+right)/2;
		int midVal = arr[mid];
		if(left>right) {
			return new ArrayList<Integer>();
		}
		if(midVal<val) {
			return binarySearch(arr,mid+1,right,val);
		}else if(midVal>val) {
			return binarySearch(arr, left, mid-1,val);
		}else {
			List<Integer> res = new ArrayList<Integer>();
			res.add(mid);
			int temp = mid-1;
			while(temp>=left && arr[temp]==val) {
				res.add(temp);
				temp--;
			}
			temp = mid+1;
			while(temp<=right && arr[temp]==val) {
				res.add(temp);
				temp++;
			}
			return res;
		}
	}
}
