import java.util.Stack;

public class TestNode {

	public static void main(String[] args) {
		
		LinkedNode node1 = new LinkedNode(1,"宋江","及时雨");
		LinkedNode node2 = new LinkedNode(2,"卢俊义","玉麒麟");
		LinkedNode node3 = new LinkedNode(3,"吴用","智多星");
		LinkedNode node4 = new LinkedNode(4,"公孙胜","入云龙");
		LinkedNodeDemo nodeDemo = new LinkedNodeDemo();
		//nodeDemo.add(node1);
		//nodeDemo.add(node2);
		//nodeDemo.add(node3);
		//nodeDemo.add(node4);
		
		//按照字节no的顺序添加字节
		nodeDemo.addByOrder(node3);
		nodeDemo.addByOrder(node1);
		nodeDemo.addByOrder(node4);
		nodeDemo.addByOrder(node2);
		//nodeDemo.addByOrder(node2);
		System.out.println("修改前的链表");
		nodeDemo.listNode();
		System.out.println();
		
		//修改链表
		LinkedNode node5 = new LinkedNode(2,"卢俊义~","玉麒麟儿");
		nodeDemo.update(node5); //修改字节内容
		nodeDemo.listNode();
		System.out.println(getLength(nodeDemo.getHead()));
		System.out.println();
		
		//删除链表元素
		nodeDemo.delete(5);
		nodeDemo.listNode();
		System.out.println(getLength(nodeDemo.getHead()));//获取链表元素个数
		
		//输出倒数第k的字节
		System.out.println(findLastIndexNode(nodeDemo.getHead(),3));
		System.out.println();
		
		//反转链表
		System.out.println("反转后的链表元素");
		reversedLinkedNode(nodeDemo.getHead());//反转链表
		nodeDemo.listNode();
		System.out.println();
		
		//反转输出
		System.out.println("反转输出的链表");
		reversedList(nodeDemo.getHead());//反转输出链表，链表本身不变
		System.out.println();
		System.out.println("正常输出的链表");
		nodeDemo.listNode();
		
		
	}
	//获取链表长度
	public static int getLength(LinkedNode head) {
		if(head.next == null)
			return 0;
		int length = 0;
		LinkedNode cur = head.next;
		while(cur!=null) {
			length+=1;
			cur = cur.next;
		}
		return length;
	}
	
	//获取链表中倒数第k个字节
	public static LinkedNode findLastIndexNode(LinkedNode head, int index) {
		if(head.next==null) {
			return null;
		}
		int size = getLength(head);
		if(index<=0||index>size) {
			return null;
		}
		LinkedNode cur = head.next;
		for(int i=0;i<size-index;++i) {
			cur = cur.next;
		}
		return cur;
	}

	//反转链表
	public static void reversedLinkedNode(LinkedNode head) {
		if(head.next==null||head.next.next==null) {
			System.out.println("无需反转");
		}
		LinkedNode reverseHead = new LinkedNode(0,"","");
		LinkedNode cur = head.next;
		LinkedNode next = null;
		while(cur!=null) {
			next = cur.next;
			cur.next = reverseHead.next;
			reverseHead.next = cur;
			cur = next;
		}
		head.next = reverseHead.next;
	}

	//反转输出链表
	public static void reversedList(LinkedNode head) {
		if(head.next==null||head.next.next==null) {
			System.out.println(head.next);
		}
		Stack<LinkedNode> s = new Stack<LinkedNode>();
		LinkedNode cur = head.next;
		while(cur!=null) {
			s.push(cur);
			cur=cur.next;
		}
		while(s.size()!=0) {
			System.out.println(s.pop());
		}
	}
}

//单链表
class LinkedNode{
	public int no;
	public String name;
	public String nickName;
	public LinkedNode next;//指向下一个字节
	
	public LinkedNode(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	
	@Override
	public String toString() {
		return "[" + no +"\t" + name + "\t" + nickName + "]";
	}
}

class LinkedNodeDemo{
	private LinkedNode head = new LinkedNode(0,"",""); //头节点
	
	public LinkedNode getHead() {
		return head;
	}	
	
	//添加节点
	public void add(LinkedNode node) {
		LinkedNode temp = head;
		while(true) {
			if(temp.next==null) {
				break;
			}
			temp=temp.next;
		}
		temp.next = node;
	}			
	
	//按照节点no大小添加节点
	public void addByOrder(LinkedNode node) {
		LinkedNode temp = head;
		//boolean flags = false;
		while(true) {
			if(temp.next==null) {
				break;
			}
			if(temp.next.no>node.no) {
				break;
			}else if(temp.next.no==node.no){
				System.out.printf("无法重复添加字节%d\n",node.no);
				return;
			}else {
				temp=temp.next;
			}
		}
		node.next = temp.next;
		temp.next = node;
	}

	//更新节点
	public void update(LinkedNode node) {
		LinkedNode temp = head.next;
		boolean flags = false;
		while(true) {
			if(temp==null) {
				break;
			}
			if(temp.no==node.no) {
				flags=true;
				break;
			}
			temp = temp.next;
		}
		if(flags) {
			temp.name = node.name;
			temp.nickName = node.nickName;
		}else {
			System.out.println("找不到该字节");
		}
	}
	
	//删除节点
	public void	 delete(int no) {
		LinkedNode temp = head;
		boolean flags = false;
		while(true) {
			if(temp.next==null) {
				break;
			}
			if(temp.next.no==no) {
				flags=true;
				break;
			}
			temp = temp.next;
		}
		if(flags) {
			temp.next=temp.next.next;
		}else {
			System.out.printf("找不到no为%d的字节\n",no);
		}
	}
	
	//遍历并输出链表元素
	public void listNode() {
		if(head.next == null) {
			System.out.println("链表为空");
		}
		LinkedNode temp = head.next;
		while(true) {
			if(temp==null) {
				return;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}

}
