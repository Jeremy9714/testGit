package review.stack;

public class StackArrayDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		StackArray s = new StackArray(5);
		
		for(int i=0;i<5;++i) {
			s.push(i);
		}
		s.list();
		System.out.println("栈顶为"+s.head());
	}
}
//数组模拟栈
class StackArray{
	private int[] stack;
	private int top;
	private int size;
	
	public StackArray(int size) {
		this.size = size;
		this.top=-1;
		this.stack = new int[size];
	}
	
	public void push(int item) { 
		if(isFull()) {
			System.out.println("栈已满");
			return;
		}
		stack[++top]=item;
	}
	//出栈
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("栈为空");
		}
		return stack[top--];
	}
	//入栈
	public boolean isFull() {
		return top==size-1;
	}
	//遍历栈
	public void list() {
		if(isEmpty()) {
			System.out.println("栈为空");
			return;
		}
		for(int i=top;i>=0;--i) {
			System.out.println(stack[i]);
		}
		System.out.println();
	}
	//返回栈顶的元素
	public int head() {
		if(isEmpty()) {
			throw new RuntimeException("栈为空");
		}
		return stack[top];
	}
	public boolean isEmpty() {
		return top==-1;
	}
}