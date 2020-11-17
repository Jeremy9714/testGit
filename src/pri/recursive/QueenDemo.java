package pri.recursive;

public class QueenDemo {
	final int MAX=8;
	int[] array = new int[MAX];
	int count = 0;
	int judgeCount = 0;
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		QueenDemo queenDemo = new QueenDemo();
		queenDemo.check(0);
		System.out.println(queenDemo.count);
		System.out.println(queenDemo.judgeCount);
	}
	
	//摆放皇后
	private void check(int n) {
		//摆到第八个表示皇后摆放完毕
		if(n==MAX) {
			print();
			return;
		}
		for(int i=0;i<MAX;++i) {
			array[n]=i;
			if(judge(n)) {
				//如不冲突则继续摆放下一个皇后
				check(n+1);
			}
		}
	}
	
	//判断第n个皇后的位置是否与前面摆放的皇后冲突
	private boolean judge(int n) {
		++judgeCount;
		for(int i=0;i<n;++i) {
			if(array[n]==array[i]||Math.abs(n-i)==Math.abs(array[n]-array[i])) {
				return false;
			}
		}
		return true;
	}
	
	//输出结果
	private void print() {
		++count;
		for(int i=0;i<MAX;++i) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
