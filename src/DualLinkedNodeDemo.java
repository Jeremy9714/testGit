
public class DualLinkedNodeDemo {

	public static void main(String[] args) {
		
		System.out.println("双向链表的测试");
		DualLinkedNode node1 = new DualLinkedNode(1,"宋江","及时雨");
		DualLinkedNode node2 = new DualLinkedNode(2,"卢俊义","玉麒麟");
		DualLinkedNode node3 = new DualLinkedNode(3,"吴用","智多星");
		DualLinkedNode node4 = new DualLinkedNode(4,"公孙胜","入云龙");
		TestDualLinkedDemo nodeDemo = new TestDualLinkedDemo();
		nodeDemo.add(node1);
		nodeDemo.add(node2);
		nodeDemo.add(node3);
		nodeDemo.add(node4);
		nodeDemo.listNode();
		
		//修改节点
		System.out.println();
		//System.out.println("修改节点");
		DualLinkedNode node5 = new DualLinkedNode(2,"卢俊义~","玉麒麟儿");
		System.out.println("修改后的链表");
		nodeDemo.update(node5);
		nodeDemo.listNode();
		
		//删除节点
		System.out.println();
		nodeDemo.delete(3);
		nodeDemo.delete(1);
		nodeDemo.delete(2);
		nodeDemo.delete(4);
		System.out.println("删除后的节点");
		nodeDemo.listNode();
		
		//按照编号来添加节点
		System.out.println();
		nodeDemo.addByOrder(node3);
		nodeDemo.addByOrder(node1);
		nodeDemo.addByOrder(node4);
		nodeDemo.addByOrder(node2);
		System.out.println("按照编号添加的节点");
		nodeDemo.listNode();
	}

}

class TestDualLinkedDemo{
	private DualLinkedNode head = new DualLinkedNode(0, "", "");
	
	//返回头节点
	public DualLinkedNode getHead() {
		return head;
	}
	
	//遍历并输出链表元素
	public void listNode() {
		if(head.next == null) {
			System.out.println("链表为空");
		}
		DualLinkedNode temp = head.next;
		while(true) {
			if(temp==null) {
				return;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
	
	//添加节点
	public void add(DualLinkedNode node) {
		DualLinkedNode temp = head;
		while(true) {
			if(temp.next==null) {
				break;
			}
			temp=temp.next;
		}
		//形成一个双向链表
		temp.next = node;
		node.pre = temp;
	}			

	//按照编号来添加节点
	public void addByOrder(DualLinkedNode node) {
		DualLinkedNode temp = head;
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
		node.pre = temp;
		if(temp.next!=null) {
			temp.next.pre = node.pre;
			
		}
		temp.next = node;
	}
	
	//更新双向列表中的节点
	public void update(DualLinkedNode node) {
		DualLinkedNode temp = head.next;
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
	
	//删除双向列表中的节点
	public void	 delete(int no) {
		if(head.next==null) {
			System.out.println("链表为空,无法删除");
		}
		
		DualLinkedNode temp = head.next;
		boolean flags = false;
		while(true) {
			if(temp==null) {
				break;
			}
			if(temp.no==no) {
				flags=true;
				break;
			}
			temp = temp.next;
		}
		if(flags) {
			temp.pre.next=temp.next;
			//如果是最后一个节点，则不执行下面一条语句，否则会出现空指针
			if(temp.next!=null) {
				temp.next.pre=temp.pre;
			}			
		}else {
			System.out.printf("找不到no为%d的字节\n",no);
		}
	}
	
}


//双向链表节点
class DualLinkedNode{
	public int no;
	public String name;
	public String nickName;
	public DualLinkedNode pre;
	public DualLinkedNode next;//指向下一个字节
	
	public DualLinkedNode(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	
	@Override
	public String toString() {
		return "[" + no +"\t" + name + "\t" + nickName + "]";
	}
}
