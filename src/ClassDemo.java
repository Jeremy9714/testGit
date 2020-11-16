
public class ClassDemo extends SubParentClass{
	
	ClassDemo(){
		System.out.println("调用子类ClassDemo的构造方法");
	}
	//重载
	public static int sum(int a) {
		System.out.println("方法1\t"+a);
		return a;
	}
	public static double sum(double a) {
		System.out.println("方法2\t"+a);
		return a;
	}
	public static int sum(int...a) {
		System.out.println("方法3\t"+a[0]);
		return a[0];
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ClassDemo c = new ClassDemo();
		System.out.println(c.getClass().getName());
		ParentClass p = c; //子类可以给父类赋值
		//ParentClass p2 = new ParentClass();
		System.out.println(p);
		//判断实例p是否为SubParentClass类的实例
		if(p instanceof SubParentClass) {
			System.out.println("successed");
			//强制类型转换
			SubParentClass s = (SubParentClass) p;
			System.out.println(s);
		}
		sum(10);
		sum(10.0);
		sum(1,2,3,4,5);
	}

}
class ParentClass{
	ParentClass(){
		System.out.println("调用Parent类的构造方法");
	}
	public String toString() {
		return this.getClass().getName();
	}
}
class SubParentClass extends ParentClass{
	SubParentClass(){
		System.out.println("调用子类SubParent类的构造方法");
	}
}
