
public class Josephu {

	public static void main(String[] args) {
		
		CircleSimpleLinkedList circleSimpleLinkedList = new CircleSimpleLinkedList();
		circleSimpleLinkedList.addBoy(15);
		circleSimpleLinkedList.showList();

	}

}

class CircleSimpleLinkedList{
	//先创建一个first指针
	Boy first = null;
	
	//添加节点
	public void addBoy(int num) {
		if(num<1) {
			System.out.println("num的值不正确");
			return;
		}
		//建立一个指针用来指向当前节点
		Boy curBoy = null;
		for(int i=1;i<=num;++i) {
			Boy newBoy = new Boy(i);
			//添加第一个节点的情况
			if(i==1) {
				first = newBoy;
				newBoy.setNext(first);
				curBoy = newBoy;
			}else {
				//先将当前节点和新节点相连
				//再讲新节点与头结点相连
				//最后将当前指针指向新节点
				curBoy.setNext(newBoy);
				newBoy.setNext(first);
				curBoy = newBoy;
			}
		}
	}
	
	//遍历节点
	public void showList() {
		//若第一个节点为空，则输出空链表
		if(first==null) {
			System.out.println("空链表");
			return;
		}
		//创建指针指向当前节点
		Boy curBoy = first;
		while(true) {
			System.out.printf("当前小孩的编号是%d \n",curBoy.getNo());
			//若当前节点的下一个节点为头节点，则表示遍历完毕
			if(curBoy.getNext()==first)
				break;
			else {
				curBoy = curBoy.getNext();
			}
		}
	}
}

class Boy{
	private int no;
	private Boy next;
	public Boy(int no) {
		this.no = no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	public void setNext(Boy boy) {
		this.next = boy;
	}
	public Boy getNext() {
		return next;
	}
}