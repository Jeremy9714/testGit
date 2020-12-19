package review.sortalgorithm;

import java.util.Arrays;

public class RadixSortDemo {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {-10,2,145,-234,-2,44,233};
		System.out.println(Arrays.toString(arr));
		radixSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	public static void radixSort(int[] arr) {
		
		final int LEN = arr.length;
		int[][] positive = new int[10][LEN]; //保存正数
		int[][] negative = new int[9][LEN]; //保存负数
		int[] positiveCount = new int[10]; //计算正数每个桶的元素个数
		int[] negativeCount = new int[10]; //计算负数每个桶的元素个数
		int min=arr[0],max=arr[0];
		for(int ele:arr) {
			if(ele<min) {
				min=ele;
			}
			if(ele>max) {
				max=ele;
			}
		}
		int time1 = (min+"").length();
		int time2 = (max+"").length();
		int times = time1>=time2?time1:time2;
		int index=0;
		
		for(int i=0,n=1;i<times;++i,n*=10) {
			//入桶
			for(int j=0;j<LEN;++j) {
				int num;
				if(arr[j]>=0) {//正数
					num = (arr[j]/n)%10;
					positive[num][positiveCount[num]++]=arr[j];
				}else {//负数
					num = (Math.abs(arr[j])/n)%10;
					negative[num][negativeCount[num]++]=arr[j];
				}
			}
			
			index=0;
			//负数排序
			for(int k=negativeCount.length-1;k>=0;--k) {
				if(negativeCount[k]!=0) {
					for(int l=0;l<negativeCount[k];++l) {
						arr[index++] = negative[k][l];
					}
				}
				negativeCount[k]=0;
			}
			for(int m=0;m<positive.length;++m) {
				if(positiveCount[m]!=0) {
					for(int o=0;o<positiveCount[m];++o) {
						arr[index++] = positive[m][o];
					}
				}
				positiveCount[m]=0;
			}
			System.out.println("第" + (i+1) + "次基数排序结果为: " + Arrays.toString(arr));
		}	
	}
}
