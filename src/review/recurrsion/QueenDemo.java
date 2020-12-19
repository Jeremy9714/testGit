package review.recurrsion;

public class QueenDemo {
	final int MAX = 8;
	int[] chess = new int[MAX];
	int count = 0;
	int judgeCount = 0;

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		QueenDemo queenDemo = new QueenDemo();
		queenDemo.queen(0);
		System.out.println(queenDemo.count);
		System.out.println(queenDemo.judgeCount);
	}

	// 摆放皇后
	private void queen(int n) {
		if(n==MAX) {
			print();
			return;
		}	
		for(int i=0;i<MAX;++i) {
			chess[n] = i; 
			if(judge(n)) {
				queen(n+1);
			}
		}
	}

	// 拍断是否可以摆放
	private boolean judge(int n) {
		judgeCount++;
		for(int i=0;i<n;++i) {
			if(chess[i]==chess[n] || Math.abs(chess[n]-chess[i])==(n-i)) {
				return false;
			}
		}
		return true;
	}
	
	//输出摆放顺序
	private void print() {
		count++;
		for(int i=0;i<MAX;++i) {
			System.out.print(chess[i]+" ");
		}
		System.out.println();
	}
}
