package pri.threadedtree;

public class ThreadedBinaryTree {

	public static void main(String[] args) {
		

	}

}

class Node{
	private int no;
	private String name;
	private Node leftNode;
	private Node rightNode;
	
	public Node(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	
	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + "]";
	}
	
	//前序查找的方法
	public Node preOrderSearch(int no) {
		System.out.println("前序比较中，当前节点为: "+this.getNo());
		if(this.no == no) {
			return this;
		}
		Node temp = null;
		if(this.leftNode!=null) {
			temp = this.leftNode.preOrderSearch(no);
		}
		if(temp!=null) {
			return temp;
		}
		if(this.rightNode!=null) {
			temp = this.rightNode.preOrderSearch(no);
		}
		return temp;
	}
	//中序查找的方法
	public Node infixOrderSearch(int no) {
		Node temp = null;
		if(this.leftNode!=null) {
			temp = this.leftNode.infixOrderSearch(no);
		}
		if(temp!=null) {
			return temp;
		}
		System.out.println("中序比较中，当前节点为: "+this.getNo());
		if(this.no == no) {
			return this;
		}
		if(this.rightNode!=null) {
			temp = this.rightNode.infixOrderSearch(no);
		}
		return temp;
	}
	//后序查找的方法
	public Node postOrderSearch(int no) {
		Node temp = null;
		if(this.leftNode!=null) {
			temp = this.leftNode.postOrderSearch(no);
		}
		if(temp!=null) {
			return temp;
		}
		if(this.rightNode!=null) {
			temp = this.rightNode.postOrderSearch(no);
		}
		if(temp!=null) {
			return temp;
		}
		System.out.println("后序比较中，当前节点为: "+this.getNo());
		if(this.no == no) {
			return this;
		}
		return null;
	}
	
	//前序遍历的方法
	public void preOrder() {
		System.out.println(this);
		if(this.leftNode!=null) {
			this.leftNode.preOrder();
		}
		if(this.rightNode!=null) {
			this.rightNode.preOrder();
		}
	}
	//中序遍历的方法
	public void infixOrder() {
		if(this.leftNode!=null) {
			this.leftNode.infixOrder();
		}
		System.out.println(this);
		if(this.rightNode!=null) {
			this.rightNode.infixOrder();
		}
	}
	//后序遍历的方法
	public void postOrder() {
		if(this.leftNode!=null) {
			this.leftNode.postOrder();
		}
		if(this.rightNode!=null) {
			this.rightNode.postOrder();
		}
		System.out.println(this);
	}
	
	//删除指定no的元素
	public void delNode(int no) {
		if(this.leftNode!=null && this.leftNode.no==no) {
			System.out.println("已删除节点 "+this.leftNode);
			this.leftNode=null;
			return;
		}
		if(this.rightNode!=null && this.rightNode.no==no) {
			System.out.println("已删除节点 "+this.rightNode);
			this.rightNode=null;
			return;
		}
		//向左子树递归删除
		if(this.leftNode!=null) {
			this.leftNode.delNode(no);
		}
		//向右子树递归删除
		if(this.rightNode!=null) {
			this.rightNode.delNode(no);
		}
	}
}