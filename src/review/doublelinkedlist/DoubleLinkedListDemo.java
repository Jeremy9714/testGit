package review.doublelinkedlist;

/**
 * 
 * @author Chenyang
 * 双向链表
 */
public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		DualLinkedList d = new DualLinkedList();
		d.add(new Node(1,"宋江","及时雨"));
		d.add(new Node(2,"公孙瓒","老二"));
		d.add(new Node(3,"吴用","智多星"));
		d.add(new Node(4,"林冲","豹子头"));
		d.list();
		
		d.del(3);
		d.list();
		
		d.addByOrder(new Node(3,"吴用","智多星"));
		d.list();
		
		d.update(new Node(2,"公孙瓒","入云龙"));
		d.list();
	}
}
//双向链表
class DualLinkedList{
	Node head = new Node(0,"","");
	//添加节点
	public void add(Node node) {
		Node cur = head;
		while(cur.next!=null) {
			cur=cur.next;
		}
		cur.next=node;
		node.pre=cur;
	}
	//按顺序添加节点
	public void addByOrder(Node node) {
		Node cur = head;
		while(true) {
			if(cur.next==null) {
				break;
			}
			if(node.no<cur.next.no) {
				break;
			}else if(node.no==cur.next.no) {
				System.out.println("无法添加相同编号的节点");
				return;
			}else {
				cur=cur.next;
			}
			node.next=cur.next;//更新插入节点的后指针
			node.pre=cur;//更新插入节点的前指针
			if(cur.next!=null) { //更新原后节点的前指针
				cur.next.pre=node;
			}
			cur.next=node;//更新当前节点的后指针
			
		}
	}
	//删除节点
	public void del(int no) {
		if(head.next==null) {
			System.out.println("链表为空");
			return;
		}
		boolean flag = false;
		Node cur = head.next;
		while(true) {
			if(cur==null) {
				break;
			}
			if(cur.no==no) {
				flag=true;
				break;
			}
			cur=cur.next;
		}
		if(flag) {
			cur.pre.next=cur.next;
			if(cur.next!=null) {
				cur.next.pre=cur.pre;
			}
		}else {
			System.out.printf("未找到编号为%d的节点\n",no);
		}
	}
	//更新节点
	public void update(Node node) {
		boolean flag = false;
		Node cur = head.next;
		while(true) {
			if(cur==null) {
				break;
			}
			if(cur.no==node.no) {
				flag=true;
				break;
			}
			cur=cur.next;
		}
		if(flag) {
			cur.name=node.name;
			cur.nickname=node.nickname;
		}else {
			System.out.printf("不存在编号为%d的节点\n",node.no);
		}
	}
	//遍历节点
	public void list() {
		if(head.next==null) {
			System.out.println("链表为空");
			return;
		}
		Node cur = head.next;
		while(cur!=null) {
			System.out.println(cur);
			cur=cur.next;
		}
		System.out.println();
	}
	
}

//节点
class Node{
	public Node pre;
	public Node next;
	public int no;
	public String name;
	public String nickname;
	public Node(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}