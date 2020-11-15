
public class Josephu {

	public static void main(String[] args) {
		
		CircleSimpleLinkedList circleSimpleLinkedList = new CircleSimpleLinkedList();
		circleSimpleLinkedList.addBoy(100);
		//circleSimpleLinkedList.showList();
		
		//约瑟夫问题
		circleSimpleLinkedList.countBoy(10, 7, 100);
		
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
	
	/**
	 * @param startBoy 表示从第几个小孩开始报数
	 * @param count 表示报数的个数
	 * @param boyNum 表示小孩的个数
	 */
	public void countBoy(int startBoy, int count, int boyNum) {
		if(first==null||startBoy<1||startBoy>boyNum) {
			System.out.println("无效的参数");
			return;
		}
		Boy helper = first;
		//helper指向first的前一个节点
		while(true) {
			if(helper.getNext()==first)
				break;
			helper = helper.getNext();
		}
		//第一次报数前先将两个指针向后移动报数编号-1个位置
		for(int i=0;i<startBoy-1;++i) {
			helper = helper.getNext();
			first = first.getNext();
		}
		
		while(true) {
			if(helper==first) {
				break;
			}
			//报数时将连个指针向后移动报数个数-1个位置
			for(int i=0;i<count-1;++i) {
				helper = helper.getNext();
				first = first.getNext();
			}
			System.out.printf("出圈的小孩编号为%d \n",first.getNo());
			//将first指向的节点移除
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("最后出圈的小孩编号为%d \n",first.getNo());
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