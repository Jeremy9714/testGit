package review.hashtable;

public class HashTableDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		HashTab hashTab = new HashTab(6);
		for (int i = 20; i > 0; --i) {
			String name = i + "";
			hashTab.add(new Emp(i, name));
		}
		hashTab.show();
	}

}

class HashTab {
	int size;
	EmpList[] empListArray;

	public HashTab(int size) {
		this.size = size;
		this.empListArray = new EmpList[size];
		for(int i=0;i<size;++i) {
			empListArray[i] = new EmpList();
		}
	}

	public void add(Emp emp) {
		int no = getListNo(emp.id);
		empListArray[no].add(emp);
	}

	public void del(int id) {
		int no = getListNo(id);
		empListArray[no].delete(id);
	}

	public void show() {
		for (int i = 0; i < size; ++i) {
			System.out.printf("第%d条链表:  ", (i + 1));
			empListArray[i].list();
		}
	}

	public void findById(int id) {
		int no = getListNo(id);
		Emp res = empListArray[no].findById(id);
		if (res != null) {
			System.out.println(res);
		}
	}

	public int getListNo(int id) {
		return id % size;
	}
}

class EmpList {
	private Emp head;
	
	// 按顺序添加
	public void add(Emp emp) {
		if(head==null) {
			head=emp;
			return;
		}
		Emp cur = head;
		if (emp.id < cur.id) {
			head = emp;
			emp.next = cur;
			return;
		}else if(cur.id == emp.id) {
			System.out.println("无法添加相同编号");
			return;
		}
		while (cur.next != null) {
			if (cur.next.id > emp.id) {
				emp.next = cur.next;
				cur.next = emp;
				return;
			}
			if (cur.next.id == emp.id) {
				System.out.println("无法添加相同编号");
				return;
			}
			cur = cur.next;
		}
		cur.next = emp;
	}

	// 删除
	public void delete(int id) {
		if (head == null) {
			System.out.println("链表为空");
			return;
		}
		if (head.id == id) {
			head = head.next;
			return;
		}
		Emp cur = head;
		while (cur.next != null) {
			if (cur.next.id == id) {
				cur.next = cur.next.next;
				return;
			}
			cur = cur.next;
		}
		System.out.println("该编号不存在");
	}

	// 修改
	public void update(Emp emp) {
		if (head == null) {
			System.out.println("链表为空");
			return;
		}
		Emp cur = head;
		while (cur != null) {
			if (cur.id == emp.id) {
				cur.name = emp.name;
				return;
			}
			cur = cur.next;
		}
		System.out.println("该编号不存在，无法修改");
	}

	// 遍历
	public void list() {
		if (head == null) {
			System.out.println("链表为空");
			return;
		}
		Emp cur = head;
		while (cur != null) {
			System.out.print(cur + "  ");
			cur = cur.next;
		}
		System.out.println();
	}

	// 查找
	public Emp findById(int id) {
		if (head == null) {
			System.out.println("链表为空");
		}
		Emp cur = head;
		while (true) {
			if (cur == null) {
				break;
			}
			if (cur.id == id) {
				break;
			}
			cur = cur.next;
		}
		return cur;
	}

	public Emp getHead() {
		return head;
	}
}

class Emp {
	public int id;
	public String name;
	public Emp next;

	@Override
	public String toString() {
		return id + "(" + name + ") ";
	}

	public Emp(int id, String name) {
		this.id = id;
		this.name = name;
	}
}