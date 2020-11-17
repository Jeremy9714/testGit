package pri.recursive;

public class RecursionDemo {
	//static int res=0;
	public static void main(String[] args) {

		test1(20);
		//System.out.println(res);
		System.out.println(factorial(5));
	}
	//递归
	public static void test1(int n) {
		if(n>2) {
			test1(n-1);
		}else {
			//res+=n;
			System.out.println(n);
		}
	}
	//阶乘
	public static int factorial(int n) {
		if(n==1)
			return 1;
		else
			return factorial(n-1)*n;
	}
}
