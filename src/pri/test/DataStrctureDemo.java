package pri.test;

import java.util.Scanner;

public class DataStrctureDemo {

	public static void main(String[] args) {

		HashTab hashTab = new HashTab(7);
		String key="";
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("输入add表示添加职员到链表");
			System.out.println("输入list表示显示全部链表");
			System.out.println("输入find表示查找职员");
			System.out.println("输入del表示删除职员");
			System.out.println("输入exit表示退出程序");
			key = scanner.next();
			switch(key) {
			case "add":
				System.out.println("输入要添加的员工id");
				int id = scanner.nextInt();
				System.out.println("输入要添加的员工名称");
				String name = scanner.next();
				Employee emp = new Employee(id,name);
				hashTab.add(emp);
				break;
			case "list":
				hashTab.list();
				break;
			case "find":
				System.out.println("输入要查找的职员的id");
				hashTab.findEmpById(scanner.nextInt());
				break;
			case "del":
				System.out.println("输入要删除的职员的id");
				hashTab.removeEmpByID(scanner.nextInt());
				break;
			case "exit":
				scanner.close();
				System.exit(0);
			default:
				System.out.println("无效的输入");
				break;
			}
		}
	}
}

class HashTab{
	private int size;
	private EmpLinkedList[] empLinkedListArray;
	
	public HashTab(int size) {
		this.size = size;
		empLinkedListArray = new EmpLinkedList[size];
		//记得要初始化数组中的链表
		for(int i=0;i<size;++i) {
			empLinkedListArray[i] = new EmpLinkedList();
		}
	}
	
	//将职员添加到哈希表中
	public void add(Employee emp) {
		int index = hashFun(emp.id);
		empLinkedListArray[index].add(emp);
	}
	
	//打印出哈希表中全部职员
	public void list() {
		for(int i=0;i<size;++i) {
			System.out.printf("第%d条链表: ",i+1);
			empLinkedListArray[i].list();
		}
	}
	
	//输入职员id来查找哈希表中是否含有该职员
	public void findEmpById(int id) {
		int index = hashFun(id);
		Employee emp = empLinkedListArray[index].findEmpByID(id);
		if(emp==null) {
			System.out.println("没有找到");
			return;
		}
		System.out.printf("在第%d条链表找到职员 %s \n",(index+1),emp);
	}
	
	//输入职员id来删除哈希表中对应的职员
	public void removeEmpByID(int id) {
		int index = hashFun(id);
		empLinkedListArray[index].removeEmpByID(id);
	}
	
	//按照id来选择要插入的链表序号
	private int hashFun(int id) {
		return id%size;
	}
}

class Employee{
	public int id;
	public String name;
	public Employee next;
	
	public Employee(int id, String name){
		//super();
		this.id = id;
		this.name = name;
	}
	public String toString() {
		return "员工id为: "+id+" 员工名为: "+name+" |";
	}
}

class EmpLinkedList{
	private Employee head;
	
	//添加职员到链表
	public void add(Employee emp) {
		if(head==null) {
			head = emp;
			return;
		}
		Employee curHead = head;
		while(true) {
			if(curHead.next==null) {
				break;
			}
			curHead = curHead.next;
		}
		curHead.next = emp;
	}
	
	//遍历当前链表的所有职员
	public void list() {
		if(head==null) {
			System.out.println("链表为空");
			return;
		}		
		Employee curHead = head;
		while(true) {
			System.out.print(curHead+"\t");
			if(curHead.next==null) {
				break;
			}
			curHead = curHead.next;
		}
		System.out.println();
	}
	
	//输入id来查找对应职员
	public Employee findEmpByID(int id) {
		if(head==null) {
			System.out.print("链表为空");
			return null;
		}
		Employee curHead = head;
		
		while(true) {
			if(curHead.id==id) {
				break;
			}
			if(curHead.next==null) {
				return null;
			}
			curHead = curHead.next;
		}
		return curHead;
	}

	
	//输入职员id来删除链表中对应的职员
	public void removeEmpByID(int id) {
		if(head==null) {
			System.out.print("链表为空");
			return;
		}
		if(head.id==id) {
			System.out.println("已删除职员 "+head.name);
			head=head.next;
			return;
		}
		
		Employee curHead = head;
		boolean flag = false;
		while(true) {
			if(curHead.next==null) {
				break;
			}
			if(curHead.next.id==id) {
				flag = true;
				break;
			}
			curHead = curHead.next;
		}
		if(flag) {
			curHead.next = curHead.next.next;
		}else {
			System.out.println("该职员不在链表中");
		}
	}
	
}