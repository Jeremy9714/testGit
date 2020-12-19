package review.stack;

public class StackLinkedListDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int size = 5;
		StackLinkedList s = new StackLinkedList(size);
		for(int i=1;i<6;++i) {
			s.push(new Node(i));
		}
		s.list();
		s.pop();
		s.pop();
		System.out.println(s.head());
		System.out.println();
		s.list();
	}
}

class StackLinkedList{
	private Node top=null;//栈顶
	private int count;//个数
	private int size;//容积
	
	public StackLinkedList(int size) {
		this.size=size;
		this.count=0;
	}
	
	public Node head() {
		if(isEmpty()) {
			throw new RuntimeException("栈为空");
		}
		return top;
	}
	public void push(Node node) {
		if(isFull()) {
			System.out.println("栈已满");
			return;
		}
		if(isEmpty()) {
			top=node;
		}else {
			node.setNext(top);
			top=node;
		}
		++count;
	}
	public Node pop() {
		if(isEmpty()) {
			throw new RuntimeException("栈为空");
		}
		Node res = top;
		top=top.getNext();
		--count;
		return res;
	}
	public void list() {
		if(isEmpty()) {
			System.out.println("栈为空");
			return;
		}
		Node temp = top;
		for(int i = count;i>0;--i) {
			System.out.println(temp);
			temp=temp.getNext();
		}
		System.out.println();
	}
	public boolean isEmpty() {
		return count==0;
	}
	public boolean isFull() {
		return count==size;
	}
}
class Node{
	private int no;
	private Node next;

	public Node(int no) {
		this.no = no;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getNo() {
		return no;
	}
	@Override
	public String toString() {
		return "Node [no=" + no + "]";
	}	
	
}