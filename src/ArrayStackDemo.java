import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		//数组模拟栈
		ArrayStack s = new ArrayStack(10);
		String key = "";
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("show表示显示栈");
			System.out.println("push表示添加数据到栈");
			System.out.println("pop表示从栈里取出数据");
			System.out.println("exit表示退出程序");
			System.out.println("请输入选择");
			key = scanner.next();
			switch(key) {
			case "show":
				s.showStack();
				break;
			case "push":
				System.out.println("请输入要添加的值");
				int value = scanner.nextInt();
				s.push(value);
				break;
			case "pop":
				try {
					int res = s.pop();
					System.out.printf("pop出的元素为%d\n",res);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				scanner.close();
				loop=false;
				break;
			default:
				break;
			}
		}
		System.out.println("程序结束");
		
	}

}

class ArrayStack{
	private int size;
	private int[] stack;
	private int top = -1;
	public ArrayStack(int size) {
		this.size = size;
		stack = new int[this.size];
	}
	public boolean isFull() {
		return top==size-1;
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public void push(int value) {
		if(isFull()) {
			System.out.println("栈已满,无法添加");
			return;
		}
		top++;
		stack[top] = value;
	}
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("栈为空,无法取出");
		}
		return stack[top--];
	}
	public void showStack() {
		if(isEmpty()) {
			System.out.println("栈为空，没有数据");
			return;
		}
		for(int i=top;i>=0;--i) {
			System.out.printf("stack[%d]的数据为: %d \n",i,stack[i]);
		}
			
	}
}