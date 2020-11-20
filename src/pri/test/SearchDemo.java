package pri.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchDemo {
	
	public static int maxSize = 20;
	
	public static void main(String[] args) {
		int[] array = {1,8,10,89,1000,1234,2345,3456,4567,5678};
		List<Integer> list = BinarySearch(array,0,array.length-1,1);
		System.out.println(list+"");
		System.out.println();
		
		/*int[] array2 = new int[100];
		for(int i=0;i<100;++i) {
			array2[i] = i+1;
		}
		System.out.println("插入查找的结果为: "+InsertSearch(array,0,array.length-1,999));
		for(int i=1;i<6;++i) {
			System.out.println(fibMaker(i));
		}*/
		
		System.out.println(FibonacciSearch(array,5678));
	}
	
	//斐波那契查找
	public static int FibonacciSearch(int[] arr, int key) {
		int low = 0; //指向最低值的指针
		int high = arr.length-1; //指向最高值的指针
		int k = 0; //表示斐波那契数列分割值的下标
		int mid = 0;
		int f[] = fibArray();
		while(high>f[k]-1) {
			++k;
		}
		//斐波那契元素若大于查找数组的长度，则新建一个改长度的数组
		int[] temp = Arrays.copyOf(arr,f[k]);
		//复制原数组，并将多出的数值赋值为原数组中最末位的值
		for(int i=high+1;i<temp.length;++i) {
			temp[i] = arr[high];
		}
		while(low<=high) {
			mid = low+f[k-1]-1;
			int midVal = temp[mid];
			if(key<midVal) {
				high = mid-1;
				k-=1;
			}else if(key>midVal) {
				low = mid +1;
				k-=2;
			}else {
				if(mid<=high) {
					return mid;
				}else {//此时mid指针指向的元素为查找数组增长后末尾添加的元素
					return high; //说明原查找数组的末位即是答案
				}
			}
		}
		return -1;
	}
	
	//生成斐波那契数组
	public static int[] fibArray() {
		int[] fib = new int[maxSize];
		fib[0] = 1;
		fib[1] = 1;
		for(int i = 2;i<maxSize;++i) {
			fib[i] = fib[i-1]+fib[i-2];
		}
		return fib;
	}
	
	/*//斐波那契数列创建
	public static int fibMaker(int num) {
		if(num==1||num==2) {
			return 1;
		}
		return fibMaker(num-1)+fibMaker(num-2);
	}*/
	
	//插值查找
	public static int InsertSearch(int[] arr, int left, int right, int findVal) {
		if(left>right||findVal<arr[left]||findVal>arr[right]) {
			return -1;
		}
		int mid = left + (findVal - arr[left]) * (right - left) / (arr[right]-arr[left]);
		System.out.println(mid);
		int midVal = arr[mid];
		if(midVal>findVal) {
			return InsertSearch(arr,left,mid-1,findVal);
		}else if(midVal<findVal) {
			return InsertSearch(arr,mid+1,right,findVal);
		}else {
			return mid;
		}
	}
	
	//二分法查找
	public static List<Integer> BinarySearch(int[] array, int left, int right, int findVal) {
		int mid = (left+right)/2;
		int midVal = array[mid];
		if(left>right) {
			System.out.println("找不到");
			return new ArrayList<Integer>();
		}
		if(midVal>findVal) {
			return BinarySearch(array,left,mid-1,findVal);
		}else if(midVal<findVal){
			return BinarySearch(array,mid+1,right,findVal);
		}else {
			List<Integer> resList = new ArrayList<Integer>();
			resList.add(mid);
			int temp = mid-1;
			while(true) {
				if(temp<0||array[temp]!=findVal) {
					break;
				}
				resList.add(temp--);
			}
			temp = mid+1;
			while(true) {
				if(temp>right||array[temp]!=findVal) {
					break;
				}
				resList.add(temp++);
			}
			return resList;
		}			
	}
}
