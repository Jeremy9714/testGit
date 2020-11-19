package pri.test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SortDemo {

	public static void main(String[] args) {

		int[] array = {2,3,4,5,1};
		int[] array2 = {2,3,4,5,1};
		int[] array3 = {5,4,3,2,1};
		
		/*int[] array = new int[80000];
		for(int i=0;i<array.length;++i) {
			array[i]=(int) (Math.random()*80000);
		}*/
		/*Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String startTime = simple.format(date);
		System.out.println(startTime);*/
		
		/*long startTime = System.currentTimeMillis();
		//SeclectSort(array);
		InsertSort(array);
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);*/
		
		/*Date date2 = new Date();
		String endTime = simple.format(date2);
		System.out.println(endTime);*/
		
		BubbleSort(array);
		System.out.println();
		SeclectSort(array2);
		System.out.println();
		InsertSort(array3);
		
	}
	
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
