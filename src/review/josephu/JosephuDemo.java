package review.josephu;

public class JosephuDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		CircleLinkedList c = new CircleLinkedList();
		int size = 10;
		c.addNode(size);
		c.show();
		c.Josephu(1, 3, size);
		c.show();
	}
}

class CircleLinkedList{
	Node first = null; //指向起始节点
	
	//添加节点构建环形链表
	public void addNode(int num) {
		if (num<1){
			System.out.println("至少要有一个节点");
			return;
		}
		Node cur = null;
		
		for(int i=0;i<num;++i) {
			Node node = new Node(i+1);
			if(i==0) {
				first=node;
				first.setNext(first);
				cur=node;
			}else {
				cur.setNext(node);
				node.setNext(first);
				cur=node;
			}
		}
	}
	//约瑟夫问题
	public void Josephu(int start, int step, int size) {
		if(start<1||start>size||first==null) {
			System.out.println("无效的参数");
			return;
		}
		//first节点的前一个节点
		Node helper = first;
		while(true) {
			if(helper.getNext()==first) {
				break;
			}
			helper = helper.getNext();
		}
		//指向起始节点
		for(int i=0;i<start-1;++i) {
			helper=helper.getNext();
			first=first.getNext();
		}
		while(true) {
			//只剩一个
			if(helper==first) {
				break;
			}
			for(int i=0;i<step-1;++i) {
				helper=helper.getNext();
				first=first.getNext();
			}
			System.out.printf("编号为%d的节点被移除\n",first.getNo());
			first=first.getNext();
			helper.setNext(first);
		}
		System.out.printf("最后出圈的是编号为%d的节点\n",first.getNo());
		System.err.println();
	}
	//遍历环形链表
	public void show() {
		Node cur = first;
		while(true) {
			System.out.printf("编号%d\n",cur.getNo());
			if(cur.getNext()==first) {
				break;
			}else {
				cur=cur.getNext();
			}
		}
		System.out.println();
	}
}

class Node{
	private int no;
	private Node next;
	public Node(int no) {
		this.no=no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getNext() {
		return next;
	}
}