package review.searchalgorithm;

import java.util.Arrays;

public class FibonacciSearchDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {1,8,10,89,1000,1234,2345,3456,4567,5678};
		int res = fibonacciSearch(arr,1000);
		System.out.println(res);
		
		int[] fib = fibArray(20);
		int[] temp = padArray(arr,fib);
		res = fibonacciSearch2(temp,0,arr.length-1,fib,6,5678);
		System.out.println(res);
		
	}
	public static int[] padArray(int[] arr, int[] fib) {
		int k = 0;
		int length = arr.length;
		while(length-1>fib[k]) {
			++k;
		}
		int[] temp = Arrays.copyOf(arr, fib[k]);
		for(int i=length;i<temp.length;++i) {
			temp[i] = arr[length-1];
		}
		return temp;
	}
	public static int fibonacciSearch2(int[] arr, int left, int right, int[] fib, int k, int val) {
		if(left>right) {
			return -1;
		}
		int mid = fib[k-1]-1+left;
		int midVal = arr[mid];
		if(midVal>val) {
			k-=1;
			return fibonacciSearch2(arr,left, mid-1,fib,k,val);
		}else if(midVal<val) {
			k-=2;
			return fibonacciSearch2(arr,mid+1,right,fib,k,val);
		}else {
			if(mid<=right) {
				return mid;
			}else {
				return right;
			}
		}
	}
	
	public static int fibonacciSearch(int[] arr, int val) {
		int[] fib = fibArray(20);
		int low = 0;
		int mid = 0;
		int high = arr.length-1;
		int k=0;
		while(high>fib[k]) {
			++k;
		}
		int[] temp = Arrays.copyOf(arr, fib[k]);
		for(int i=high+1;i<temp.length;++i) {
			temp[i] = arr[high];
		}
	
		while(low<=high) {
			mid = fib[k-1]-1+low;
			int midVal = temp[mid];
			if(midVal<val) {
				low=mid+1;
				k-=2;
			}else if(midVal>val) {
				high = mid-1;
				k-=1;
			}else {
				if(mid<=high) {
					return mid;
				}else {
					return high;
				}
			}
		}
		return -1;
	}
	
	public static int[] fibArray(int size) {
		int[] fib = new int[size];
		fib[0]=1;
		fib[1]=1;
		for(int i=2;i<size;++i) {
			fib[i] = fib[i-1]+fib[i-2];
		}
		return fib;
	}
}
