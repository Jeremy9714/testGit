
public class ClassDemo{

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		A a = new B();
		//多态
		a.print();
		a.testAbstract();

	}
}
interface functions{//接口
	public void interfaceTest();//接口内的方法，省略abstract关键字
	int temp=0;//接口内定义的任何字段都是static和final的
}
abstract class A{//抽象类
	abstract void print();
	abstract void testAbstract();
}
class B extends A{
	protected void print() {
		System.out.println("B的输出");
	}
	protected void testAbstract() {
		System.out.println("B的抽象方法");
	}
}
class C extends B{
	public void print() {
		System.out.println("C的输出");
	}
	protected void testAbstract() {
		System.out.println("C的抽象方法");
	}
}