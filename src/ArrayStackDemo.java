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
		System.out.println();
		
		{//链表
			System.out.println("链表模拟栈");
			LinkedListStack s2 = new LinkedListStack(5);
			s2.push(1);
			s2.push(2);
			s2.push(3);
			s2.push(4);
			s2.showStack();
			System.out.println();
			s2.pop();
			s2.pop();
			s2.push(5);
			//s2.peak();
			s2.push(6);
			//s2.peak();
			s2.push(7);
			s2.peak();
			//s2.push(8);
			s2.showStack();
		}
	}

}

class Node{
	int value;
	Node next;
	public Node(int value) {
		this(value,null);
	}
	
	/**
	 * 创建一个新的节点
	 * 让他的next指向，参数中的节点
	 * @param value
	 * @param newNode
	 * */
	public Node(int value, Node newNode) {
		this.value = value;
		this.next = newNode;
	}
	//返回字节的值
	public int getValue() {
		return value;
	}
}

//用链表实现的栈
class LinkedListStack{
	
	private Node header;//栈顶元素
	private int elementCount;//栈内元素个数
	private int maxSize;//栈最大容积
	public LinkedListStack(int size) {
		header = null;
		this.maxSize = size;
		elementCount = 0;
	}
	//设置top的节点
	public void setHeader(Node header) {
		this.header = header;
	}
	public boolean isFull() {
		return elementCount == maxSize;
	}
	public boolean isEmpty() {
		return elementCount == 0;
	}
	//入栈
	public void push(int value) {
		if(isFull()) {
			System.out.println("栈已满，无法再添加元素");
			return;
		}
		//将旧的头节点变成新入栈节点的next,再讲新入栈的节点变为头节点
		Node newNode = new Node(value, header);
		setHeader(newNode);
		//header = new Node(value,header);
		elementCount++; 
	}	
	//出栈
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("栈为空，无法移除元素");
		}
		elementCount--;
		int res = header.getValue();
		header = header.next;
		return res;
	}
	//返回栈顶元素
	public int peak() {
		if(isEmpty()) {
			throw new RuntimeException("栈为空,没有栈顶元素");
		}
		System.out.printf("栈顶元素为%d\n",header.getValue());
		return header.getValue();
	}
	public void showStack() {
		Node cur = header;
		int temp=elementCount;
		while(cur!=null) {
			System.out.printf("stack[%d]的值为%d\n",temp--,cur.getValue());
			cur = cur.next;
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