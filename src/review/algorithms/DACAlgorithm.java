package review.algorithms;

public class DACAlgorithm {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		tower(3,'a','b','c');
	}
	
	public static void tower(int num, char a, char b, char c) {
		if(num==1) {
			System.out.println(a+"->"+c);
		}else {
			tower(num-1,a,c,b);
			System.out.println(a+"->"+c);
			tower(num-1,b,a,c);
		}
	}
	
}
