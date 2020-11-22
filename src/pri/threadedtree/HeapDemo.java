package pri.threadedtree;

import java.util.Arrays;

public class HeapDemo {

	public static void main(String[] args) {
		int[] arr = {4,6,8,5,9,2,-1,90,22,3,77};
		//int[] arr = {4,6,8,5,9};
		heapSort(arr);
	}
	
	//堆排序的方法
	public static void heapSort(int[] arr) {
		int temp = 0;
		System.out.println("堆排序");
		
		for(int i=arr.length/2-1;i>=0;i--) {
			adjustHeap(arr,i,arr.length);
			//System.out.println(Arrays.toString(arr));
		}
		
		for(int j=arr.length-1;j>0;j--) {
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr,0,j);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	//将以指定索引的数组值为根节点的子树变成大顶堆
	public static void adjustHeap(int[] arr, int target, int length) {
		//保存当前节点的值
		int temp = arr[target];
		
		for(int k=2*target+1;k<length;k=k*2+1) {
			//若左子节点的值小于右子节点的值,将下标指向右子节点
			if(k+1<length && arr[k]<arr[k+1] ){
				++k;
			}
			//比较子节点和当前节点的大小
			if(arr[k]>temp) {
				//若大于当前节点，将当前节点的值变成子节点的值
				arr[target] = arr[k];
				//更新指针
				target = k;
			}else {
				break;
			}	
		}
		//将当前指针指向的节点的值赋为原当前节点的值
		arr[target] = temp;
		//System.out.println(Arrays.toString(arr));
	}
}
