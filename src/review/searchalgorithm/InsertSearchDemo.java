package review.searchalgorithm;

import java.util.List;
import java.util.ArrayList;

public class InsertSearchDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {1,2,3,4,5,6,7,8,9};
		List<Integer> list = insertSearch(arr,0,arr.length-1,1);
		System.out.println(list);
	}
	public static List<Integer> insertSearch(int[] arr, int left, int right, int val){
		if(left>right) {
			return new ArrayList<Integer>();
		}
		int mid = left+(val-arr[left])/(arr[right]-arr[left])*(right-left);
		int midVal = arr[mid];
		if(midVal<val) {
			return insertSearch(arr,mid+1,right,val);
		}else if(midVal>val) {
			return insertSearch(arr,left,mid-1,val);
		}else {
			List<Integer> res = new ArrayList<>();
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
