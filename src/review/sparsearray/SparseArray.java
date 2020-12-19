package review.sparsearray;

import java.util.Arrays;

public class SparseArray {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[][] chessArray = new int[8][8];
		int sum=0;
		chessArray[1][2] = 1;
		chessArray[2][3] = 2;
		
		for(int[] row:chessArray) {
			for(int data: row) {
				System.out.printf("%d\t",data);
				if(data!=0) {
					sum++;
				}
			}
			System.out.println();
		}
		
		int[][] sparseArray = new int[sum+1][3];
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;
		int count=0;
		for(int i=0;i<8;++i) {
			for(int j=0;j<8;++j) {
				if(chessArray[i][j]!=0) {
					count++;
					sparseArray[count][0]=i;
					sparseArray[count][1]=j;
					sparseArray[count][2]=chessArray[i][j];
				}
			}
		}
		
		System.out.println();
		
		for(int[] row : sparseArray) {
			for(int data: row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		int[][] chessArray2 = new int[8][8];
		
		for (int i =1;i<sum+1;++i) {
			chessArray2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
		}
		
		System.out.println(Arrays.deepToString(chessArray2));
		
	}

}
