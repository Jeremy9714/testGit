package pri.test;
import java.util.Random;
import static java.lang.System.out;

public class PackageTest {
	
	final double PI = 3.14;
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println(out.getClass());
		FinalData data = new FinalData();
		//data.test = new Test();
		data.test2 = new Test();
		data.test.i=10;//可以对final的引用的成员变量赋值
		//data.VALUE_2 = 100;//static定义的变量不能被修改
		//data.test3 =new Test();
		System.out.println();
		
		Child c = new Child();
		c.doit();
		Parents p = c;
		//p.doit();//由于doit方法为private修饰，所以在子类中的同名方法为新的方法，与父类中的无关
		p.doit2();
		p.doit3();
		System.out.println();
		
		FinalClass fin = new FinalClass();
		fin.a++;//final类中的成员变量可以定义为非final形式
		System.out.println(fin.a);
	}
	
	public static void showRandom() {
		System.out.println(new Random().nextInt(10));
	}
}

class Parents{
	private final void doit() {
		System.out.println("父类.doit");
	}
	final void doit2() {
		System.out.println("父类.doit2");
	}
	protected void doit3() {
		System.out.println("父类.doit3");
	}
}

class Child extends Parents{
	public final void doit() {//新的方法，非多态
		System.out.println("子类.doit");
	}
//	final void doit2() { //不能覆盖final方法
//		System.out.println("子类.doit2");
//	}
	public void doit3() {
		System.out.println("子类.doit3");
	}
}

final class FinalClass{
	int a = 3;
	void doit() {}
}

class Test{
	int i=0;
}
class FinalData{
	static Random rand = new Random();
	public final int VALUE_1 = 9;//声明一个final常量
	public static final int VALUE_2 = 10;//声明一个final、static常量
	public final Test test = new Test();//声明一个final引用
	public Test test2 = new Test();//声明一个不是final的引用
	public final int[] a = {1,2,3,4,5,6};
	public final int i4 = rand.nextInt(20);
	public static final int i5 = rand.nextInt(20);
	public String toString() {
		return "i4: "+i4+"\ti5: "+i5;
	}
	
}