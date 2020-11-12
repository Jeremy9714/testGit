import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int arr[] = {63,4,24,1,3,15};
		System.out.println(Arrays.toString(arr));
		System.out.println();
		BubbleSort sorter = new BubbleSort();
		sorter.sort(arr);
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
	public void showArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}