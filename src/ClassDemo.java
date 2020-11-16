
public class ClassDemo{

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		A a = new B();
		//多态
		a.print();
		a.testAbstract();
		
		Circle c = new Oval();
		c.interfaceInheritTest();
		//接口也可以进行向上转型
		functions[] f = {new Circle(),new Triangle(),c};
		
		for(int i=0;i<f.length;++i) {
			f[i].interfaceTest();
		}
	}
}
interface functions{//接口
	public void interfaceTest();//接口内的方法，省略abstract关键字
	int temp=0;//接口内定义的任何字段都是static和final的
}
//接口也可以继承
interface SubFunctions extends functions{
	public void interfaceInheritTest();
}

class Shape{
	void doSomething() {}
}
class Circle extends Shape implements SubFunctions{//类可以继承多个接口
	public void interfaceTest() {
		System.out.println("Circle的接口测试");
	}
	public void interfaceInheritTest() {
		System.out.println("CirCle类的接口继承测试");
	}
}
class Triangle extends Shape implements functions{
	public void interfaceTest() {
		System.out.println("Triangle的接口测试");
	}
	void doSomething() {
		System.out.println("Triangle重写父类方法");
	}
	void readTemp() {
		System.out.println(temp);
	}
}
class Oval extends Circle implements SubFunctions{
	public void interfaceTest() {
		System.out.println("Oval的接口测试");
	}
	public void interfaceInheritTest() {
		System.out.println("Oval类的接口继承测试");
	}
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