import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) {
		
		// 冒泡排序
		int arr[] = {63,4,24,1,3,15};
		System.out.println(Arrays.toString(arr));
		BubbleSort bSorter = new BubbleSort();
		bSorter.sort(arr);
		System.out.println();
		
		//直接选择排序
		int arr2[] = {63,4,24,1,3,15};
		System.out.println(Arrays.toString(arr2));
		SelectSort sSorter = new SelectSort();
		sSorter.sort(arr2);
		System.out.println();
		
		//反转排序
		int arr3[] = {63,4,24,1,3,15};
		System.out.println(Arrays.toString(arr3));
		ReverseSort rSorter = new ReverseSort();
		rSorter.sort(arr3);
	}

}

class BubbleSort{
	public void sort(int[] arr) {
		for(int i=1; i<arr.length;++i) {//外层循环用于控制排序轮数
			for(int j=0;j<arr.length-i;++j) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp; 
				}
			}
			showArray(arr);
		}
	}
	public static void showArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}

class SelectSort{
	public void sort(int[] arr) {
		int index;
		for(int i=1; i<arr.length;++i) {
			index=0;
			for(int j=1;j<arr.length-i;++j) {
				if(arr[j]>arr[index])
					index = j;
			}
			int temp = arr[arr.length-i];
			arr[arr.length-i] = arr[index];
			arr[index] = temp;
			
			BubbleSort.showArray(arr);
		}
	}
}

class ReverseSort{
	public void sort(int[] arr) {
		int temp;
		int len = arr.length;
		for(int i=0;i<len/2;++i) {
			temp=arr[i];
			arr[i]=arr[len-1-i];
			arr[len-1-i]=temp;
			BubbleSort.showArray(arr);
		}
	}
}