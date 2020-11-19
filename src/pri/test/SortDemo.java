package pri.test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SortDemo {
	static int quickCount = 0;
	public static void main(String[] args) {
		int[] array = {8,4,5,7,1,3,6,2};
		
		/*int[] array = new int[8000000];
		for(int i=0;i<array.length;++i) {
			array[i]=(int) (Math.random()*8000000);
		}*/
		/*Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String startTime = simple.format(date);
		System.out.println(startTime);*/
		
		/*long startTime = System.currentTimeMillis();
		//SeclectSort(array);
		//InsertSort(array);
		//ShellExchangeSort(array);
		QuickSort(array,0,array.length-1);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);*/
		
		/*Date date2 = new Date();
		String endTime = simple.format(date2);
		System.out.println(endTime);*/
		
		/*QuickSort(array,0,array.length-1);
		System.out.println(Arrays.toString(array));
		System.out.println();*/
		
		int[] temp = new int[array.length];
		MergeSort(array,0,array.length-1,temp);
		System.out.println(Arrays.toString(array));
		
	}
	
	//归并分割数组
	public static void MergeSort(int[] array, int left, int right, int[] temp) {
		if(left<right) {
			//System.out.println(Arrays.toString(array));
			int mid = (left+right)/2;
			MergeSort(array,left,mid,temp);
			MergeSort(array,mid+1,right,temp);		
			Merge(array,left,mid,right,temp);
			//System.out.println(Arrays.toString(array));
		}
	}
	
	//归并排序
	public static void Merge(int[] array, int left, int mid, int right, int[] temp) {
		int i = left;
		int j = mid+1;
		int t = 0;//输出数组的索引
		//任意一个数组都没有输出完的情况
		while(i<=mid && j<=right) {
			temp[t++] = array[j]>array[i]?array[i++]:array[j++];
		}
		
		//将剩余的数组中的元素添加至temp数组
		while(i<=mid) {
			temp[t++] = array[i++];
		}
		while(j<=right) {
			temp[t++] = array[j++];
		}
		
		//将temp数组的元素复制到array数组中
		int tempLeft = left;
		t = 0;
		//System.out.println("left: " + tempLeft +" right: " + right);
		while(tempLeft<=right) {
			array[tempLeft++] = temp[t++];
		}
		
	}
	
	//快速排序
	public static void QuickSort(int[] array, int left, int right) {
		int l = left;
		int r = right;
		int pivot = array[left];
		int temp;
		if(left>right) {
			//System.out.println("最终结果为: " + Arrays.toString(array));
			return;
		}
		while(l!=r) {
			while(array[r]>=pivot && l<r) {
				--r;
			}
			while(array[l]<=pivot && l<r) {
				++l;
			}
			if(l<r) {
				temp = array[l];
				array[l] = array[r];
				array[r] = temp;
			}
		}
		//当左右指针相重合时退出循环，并交换基准值位置和指针指向位置的值		
		array[left] = array[l];
		array[l] = pivot;	
		//System.out.println(left +" "+right + " " + pivot);
		//System.out.println("第" + (++quickCount) + "次快速排序结果为: " + Arrays.toString(array));
		
		if(left<r) {
			QuickSort(array, left,l-1);
		}
		if(right>l) {
			QuickSort(array, r+1,right);
		}
	}
	
	//希尔排序(移动法)
	public static void ShellMoveSort(int[] array) {
		System.out.println("原数组: " + Arrays.toString(array));
		int count=0;
		for(int gap = array.length/2;gap>0;gap/=2) {
			for(int i = gap;i<array.length;++i) {
				int j = i;
				int temp = array[j];
				if(array[j]<array[j-gap]) {
					while(j-gap>=0 && array[j-gap]>temp) {
						array[j] = array[j-gap];
						j-=gap;
					}
					array[j] = temp;
				}
			}
			System.out.println("第" + (++count) + "次希尔排序结果为: " + Arrays.toString(array));
		}
		System.out.println("最终结果为: " + Arrays.toString(array));
	}
	
	//希尔排序(交换法)
	public static void ShellExchangeSort(int[] array) { 
		System.out.println("原数组: " + Arrays.toString(array));
		int temp;
		int count = 0;
		for(int gap = array.length/2;gap>0;gap/=2) {
			//间隔
			for(int i = gap;i<array.length;++i) {
				//遍历各组中所有的元素
				for(int j = i-gap;j>=0;j-=gap) {
					//如果当前元素大于加上步长后的元素，两个元素互换
					if(array[j]>array[j+gap]) {
						temp = array[j];
						array[j] = array[j+gap];
						array[j+gap] = temp;
					}
				}
			}
			System.out.println("第" + (++count) + "次希尔排序结果为: " + Arrays.toString(array));
		}
		System.out.println("最终结果为: " + Arrays.toString(array));
	}
	
	//插入排序
	public static void InsertSort(int[] array) {
		System.out.println("原数组: " + Arrays.toString(array));
		int insertIndex;
		int insertVal;
		for(int i=1;i<array.length;++i) {
			insertIndex=i;
			insertVal=array[i];
			for(int j=i-1;j>=0;--j) {
				if(array[j]>insertVal) {
					array[insertIndex--]=array[j];
					//array[j] = insertVal;
				}
			}
			/*while(insertIndex>=1 && insertVal<array[insertIndex-1]) {
				array[insertIndex]=array[insertIndex-1];
				insertIndex--;
			}*/
			array[insertIndex] = insertVal;
			/*if(insertIndex!=i) {
				array[insertIndex]=insertVal;
			}*/
			System.out.println("第" + i + "次插入排序结果为: " + Arrays.toString(array));
		}
		System.out.println("最终结果为: " + Arrays.toString(array));
	}
	
	//选择排序
	
	
	public static void SeclectSort(int[] array) {
		System.out.println("原数组: " + Arrays.toString(array));
		int minIndex;
		int min;
		for(int i=0;i<array.length-1;++i) {
			minIndex=i;
			min=array[i];
			for(int j=i+1;j<array.length;++j) {
				if(min>array[j]) {
					min = array[j];
					minIndex = j;
				}
			}

			if(minIndex!=i) {
				array[minIndex] = array[i];
				array[i] = min;
			}
			System.out.println("第" + (i+1) + "次选择排序结果为: " + Arrays.toString(array));
		}
		System.out.println("最终结果为: " + Arrays.toString(array));
	}
	
	//冒泡排序
	
	
	public static void BubbleSort(int[] array) {
		System.out.println("原数组: " + Arrays.toString(array));
		int temp = 0;
		boolean flag = false;
		for(int i=0;i<array.length-1;++i) {
			for(int j=0;j<array.length-i-1;++j) {
				if(array[j]>array[j+1]) {
					flag=true;
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
			if(!flag) {
				break;
			}else {//重置用于下一轮循环
				flag = false;
			}
			System.out.println("第" + (i+1) + "次冒泡排序结果为: " + Arrays.toString(array));
		}
		System.out.println("最终结果为: " + Arrays.toString(array));
	}
}
