
public class ArrayStackDemo {

	public static void main(String[] args) {
		//数组模拟栈
		ArrayStack s = new ArrayStack(10);
		try {
			s.push(1);
			s.push(2);
			s.push(3);
			s.push(4);
			s.push(5);
			s.showStack();
			System.out.println();
			
			s.pop();
			s.pop();
			s.push(6);
			s.push(7);
			s.showStack();
			System.out.println();
			/*s.pop();
			s.pop();
			s.pop();
			s.pop();
			s.pop();
			s.pop();
			*/
		}catch(Exception e) {
			System.out.println("error");
		}finally {
			System.out.println("执行结束");
		}
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