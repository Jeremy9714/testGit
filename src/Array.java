import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int day[] = new int[] {31,29,31,30,31,30,31,31,30,31,30,31};
		for(int i=0;i<day.length;++i)
			System.out.println((i+1)+"月有"+day[i]+"天");
		
		final int ROW =3, COL =4;
		int num = 0;
		int a[][] = new int[ROW][COL];
		for(int i=0;i<ROW;++i) {
			for(int j=0;j<COL;++j) {
				a[i][j] = num;
				num++;
			}
		}
		System.out.println(Arrays.deepToString(a));
		//foreach方法遍历二维数组
		{
			int arr2[][] = {{3,4},{1,2}};
			int i =0;
			for(int x[]:arr2) {
				++i;
				int j=0;
				for(int y:x) {
					++j;
					if(i==arr2.length&&y==x.length) {
						System.out.println(y);
					}else {
						System.out.println(y + " ");
					}
				}
			}
		}
		
		//fill(int a[],int value)方法替换数组元素
		{
			int a1[] = new int[5];
			Arrays.fill(a1, 5);
			System.out.println(Arrays.toString(a1));
			Arrays.fill(a1, 6);
			System.out.println(Arrays.toString(a1));
			
			//fill(int a[], int frontIndex, int toIndex int value)替换指定区间的元素
			int a2[] = {45,12,2,10};
			Arrays.fill(a2, 1, 4, 666);
			System.out.println(Arrays.toString(a2));
			
			//sort()排序
			int a3[] = {5,1,6,3};
			Arrays.sort(a3);
			System.out.println(Arrays.toString(a3));
		}
		
		{
			//复制数组
			int arr[] = {23,42,12};
			int newArr[] = Arrays.copyOf(arr,4);		//新数组长度大于被复制数组长度时，用0填充
			System.out.println(Arrays.toString(newArr));
			
			int arr2[] = {23,54,64,23,11,74,26,33};
			int newArr2[] = Arrays.copyOfRange(arr2, 1, 20); //新数组长度大于被复制数组长度时，用0填充
			System.out.println(Arrays.toString(newArr2));
		}
		
		{
			//数组查询
			int arr[] = {4,25,10};
			Arrays.sort(arr);
			int index = Arrays.binarySearch(arr,0,1,8);
			System.out.println(index);
			int arr2[] = {1,3,5,7,9,11,13};
			System.out.println(Arrays.binarySearch(arr2,1,4,6));
			System.out.println(Arrays.binarySearch(arr2,1,4,5));
			System.out.println(Arrays.binarySearch(arr2,2,5,3));
			System.out.println(Arrays.binarySearch(arr2,2,5,12));
			
		}
	}

}
