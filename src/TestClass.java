
public class TestClass {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new CreateObject();
		{
			String c1 = new String("abc");
			String c2 = new String("abc");
			String c3 = c1;
			System.out.println(c1==c2);	//判断两个对象引用的地址是否相等
			System.out.println(c1.equals(c2));
			System.out.println(c1==c3);
			System.gc();//强制启动垃圾回收器
		}
		TestDemo td = new TestDemo();
		td.setValue(23);
		System.out.println(td.getValue());
		
		Rectangle r = new Rectangle(3,4);
		r.showArea();
	}

}
class CreateObject{
	public CreateObject() {
		System.out.println("无参构造函数");
	}
}

class TestDemo{
	private int id;
	void setValue(int num) {
		this.id = num;
	}
	int getValue() {
		return id;
	}
}

class Rectangle{
	private int length;
	private int height;
	Rectangle(int l, int h){
		this.length = l;
		this.height = h;
	}
	void showArea(){
		System.out.println("面积为"+length*height);
	}
	
}
