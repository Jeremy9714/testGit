package review.linkedlist;

import java.util.Stack;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		LinkedList linkedList = new LinkedList();
		linkedList.addNode(new Node(1,"宋江","及时雨"));
		linkedList.addNode(new Node(2,"公孙瓒","老二"));
		linkedList.addNode(new Node(4,"林冲","豹子头"));
		linkedList.list();
		linkedList.addNodeByOrder(new Node(3,"吴用","智多星"));
		//linkedList.addNodeByOrder(new Node(0,"吴用","智多星"));
		linkedList.list();
		linkedList.updateNode(new Node(2,"公孙瓒","入云龙"));
		linkedList.list();
		//linkedList.addNodeByOrder(new Node(2,"公孙瓒","入云龙"));
		//linkedList.updateNode(new Node(5,"公孙瓒","入云龙"));
		System.out.println(getLength(linkedList.getHead()));
		System.out.println(findLastIndexNode(linkedList.getHead(),4));
		System.out.println();
		
		reversedLinkedList(linkedList.getHead());
		linkedList.list();
		reversedList(linkedList.getHead());
		
	}
	//返回链表长度
	public static int getLength(Node head) {
		Node cur = head;
		int count=0;
		while(cur.next!=null){
			cur=cur.next;
			count++;
		}
		return count;
	}
	//找到倒数第k个节点的信息
	public static Node findLastIndexNode(Node head, int index) {
		if(head.next==null) {
			System.out.println("链表为空");
			return null;
		}
		int size = getLength(head);
		if(index<0||index>size) {
			return null;
		}
		Node cur = head;
		for(int i=0;i<size-index+1;++i) {
			cur=cur.next;
		}
		return cur;
	}
	//反转链表
	public static void reversedLinkedList(Node head) {
		if(head.next==null||head.next.next==null) {
			System.out.println("无需反转");
			return;
		}
		Node newHead = new Node(0,"","");
		Node cur = head.next;
		Node next=null;
		while(cur!=null) {
			next=cur.next;
			cur.next=newHead.next;
			newHead.next=cur;
			cur=next;
		}
		head.next=newHead.next;
	}
	//反转打印列表
	public static void reversedList(Node head) {
		if(head.next==null || head.next.next==null) {
			System.out.println(head.next);
		}
		Stack<Node> stack = new Stack<Node>();
		Node cur = head.next;
		while(cur!=null) {
			stack.push(cur);
			cur=cur.next;
		}
		while(stack.size()!=0) {
			stack.pop();
		}
	}
}
//单链表
class LinkedList{
	private Node head = new Node(0,"","");
	//添加节点(无排序)
	public void addNode(Node node) {
		Node temp = head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next = node;
	}
	//添加节点(按照一定顺序)
	public void addNodeByOrder(Node node) {
		Node temp = head;
		while(true) {
			if(temp.next==null) {
				break;
			}
			if(temp.next.no>node.no) {
				break;
			}else if(temp.next.no==node.no) {
				System.out.printf("无法重复添加no为%d的节点\n",node.no);
				return;
			}else {
				temp=temp.next;
			}
		}
		node.next=temp.next;
		temp.next=node;
	}
	//删除节点
	public void deleteNode(int no) {
		if (head.next==null) {
			System.out.println("链表为空");
		}
		Node temp = head;
		while(temp.next!=null) {
			if(temp.next.no==no) {
				temp.next=temp.next.next;
				System.out.printf("已删除no为%d的节点\n",no);
				return;
			}
			temp = temp.next;
		}
		System.out.println("未找到该节点");
	}
	//更新节点
	public void updateNode(Node node) {
		Node temp = head.next;
		boolean flag = false;
		while(true) {
			if(temp==null) {
				break;
			}
			if(temp.no==node.no) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			temp.name=node.name;
			temp.nickname=node.nickname;
		}else {
			System.out.println("该节点不存在");
		}
	}
	//遍历节点
	public void list() {
		if(head.next==null) {
			System.out.println("链表为空");
			return;
		}
		Node temp = head.next;
		while(true) {
			if(temp==null) {
				break;
			}
			System.out.println(temp);
			temp=temp.next;
		}	
		System.out.println();
	}
	//返回头节点
	public Node getHead() {
		return head;
	}
}
//节点
class Node{
	public Node next;
	public int no;
	public String name;
	public String nickname;
	public Node(int no, String name, String nickname) {
		this.no=no;
		this.name = name;
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}