package pri.threadedtree;

public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		
		Node root = new Node(1,"Tony");
		Node node2 = new Node(3,"Frank");
		Node node3 = new Node(6,"Sean");
		Node node4 = new Node(8,"Jeremy");
		Node node5 = new Node(10,"Catherine");
		Node node6 = new Node(14,"Kevin");
		root.setLeftNode(node2);
		root.setRightNode(node3);
		node2.setLeftNode(node4);
		node2.setRightNode(node5);
		node3.setLeftNode(node6);
		ThreadedBinaryTree tree = new ThreadedBinaryTree();
		tree.setRoot(root);
		tree.postThreadedNodes();
		
		Node leftNode = node5.getLeftNode();
		Node rightNode = node5.getRightNode();
		System.out.println(leftNode + " " + rightNode);
		System.out.println("\n使用线索化的方式遍历二叉树: ");
		//tree.threadedList();
		//tree.postOrder();
	}
}

//实现了线索化功能的二叉树
class ThreadedBinaryTree{
	private Node root;
	//为了实现线索化，需要创建一个指针指向当前节点的前驱节点
	//在递归中，总是保留前一个节点
	private Node pre = null;
	
	//设置根节点
	public void setRoot(Node root) {
		this.root = root;
	}
	
	//使用中序线索化的方式遍历二叉树
	public void threadedList() {
		Node node = root;
		while(node!=null) {
			//先找到第一个节点
			while(node.getLeftType()==0) {
				node = node.getLeftNode();
			}
			
			System.out.println(node);
			
			//若当前节点的右指针指向的是后继节点，则继续遍历
			while(node.getRightType()==1) {
				node = node.getRightNode();
				System.out.println(node);
			}
			node = node.getRightNode();
		}
	}
	
	public void preThreadedNodes() {
		this.preThreadedNodes(root);
	}
	
	public void infixThreadedNodes() {
		this.infixThreadedNodes(root);
	}
	
	public void postThreadedNodes() {
		this.postThreadedNodes(root);
	}
	
	//二叉树进行前序线索化的方法
	public void preThreadedNodes(Node node) {
		if(node==null) {
			System.out.println("树中不存在此节点");
			return;
		}
		
		//线索化当前节点
		if(node.getLeftNode()==null) {
			node.setLeftNode(pre);
			node.setLeftType(1);
		}
		if(pre!=null && pre.getRightNode()==null) {
			//让前驱节点的右指针指向其后继节点(当前节点)
			pre.setRightNode(node);
			pre.setRightType(1);
		}
		//每处理一个节点, 将当前节点设置为当前节点
		pre = node;
		
		//线索化左子树
		if(node.getLeftNode()!=null && node.getLeftType()!=1) {
			preThreadedNodes(node.getLeftNode());
		}
		
		//线索化右子树
		if(node.getRightNode()!=null && node.getRightType()!=1) {
			preThreadedNodes(node.getRightNode());
		}
	}
	
	//二叉树进行中序线索化的方法
	public void infixThreadedNodes(Node node) {
		if(node==null) {
			System.out.println("树中不存在此节点");
			return;
		}
		
		//线索化左子树
		if(node.getLeftNode()!=null) {
			infixThreadedNodes(node.getLeftNode());
		}
		
		//线索化当前节点
		if(node.getLeftNode()==null) {
			node.setLeftNode(pre);
			node.setLeftType(1);
		}
		if(pre!=null && pre.getRightNode()==null) {
			//让前驱节点的右指针指向其后继节点(当前节点)
			pre.setRightNode(node);
			pre.setRightType(1);
		}
		//每处理一个节点, 将当前节点设置为当前节点
		pre = node;
		
		//线索化右子树
		if(node.getRightNode()!=null) {
			infixThreadedNodes(node.getRightNode());
		}
	}
	
	//二叉树进行后序线索化的方法
	public void postThreadedNodes(Node node) {
		if(node==null) {
			System.out.println("树中不存在此节点");
			return;
		}
		
		//线索化左子树
		if(node.getLeftNode()!=null) {
			postThreadedNodes(node.getLeftNode());
		}
		
		//线索化右子树
		if(node.getRightNode()!=null) {
			postThreadedNodes(node.getRightNode());
		}
		
		//线索化当前节点
		if(node.getLeftNode()==null) {
			node.setLeftNode(pre);
			node.setLeftType(1);
		}
		if(pre!=null && pre.getRightNode()==null) {
			//让前驱节点的右指针指向其后继节点(当前节点)
			pre.setRightNode(node);
			pre.setRightType(1);
		}
		//每处理一个节点, 将当前节点设置为当前节点
		pre = node;
	}
	
	//前序查找指定no的元素
	public void preOrderSerach(int no) {
		if(this.root==null) {
			System.out.println("数为空");
		}else {
			Node res = this.root.preOrderSearch(no);
			if(res!=null) {
				System.out.print("前序查找的结果为: ");
				System.out.println(res);
			}else {
				System.out.printf("前序查找找不到no为%d的节点\n",no);
			}
		}
	}
	//中序查找指定no的元素
	public void infixOrderSerach(int no) {
		if(this.root==null) {
			System.out.println("数为空");
		}else {
			Node res = this.root.infixOrderSearch(no);
			if(res!=null) {
				System.out.print("中序查找的结果为: ");
				System.out.println(res);
			}else {
				System.out.printf("中序查找找不到no为%d的节点\n",no);
			}
		}
	}
	//后序查找指定no的元素
	public void postOrderSerach(int no) {
		if(this.root==null) {
			System.out.println("数为空");
		}else {
			Node res = this.root.postOrderSearch(no);
			if(res!=null) {
				System.out.print("后序查找的结果为: ");
				System.out.println(res);
			}else {
				System.out.printf("后序查找找不到no为%d的节点\n",no);
			}
		}
	}
	
	//前序遍历
	public void preOrder() {
		if(this.root!=null) {
			this.root.preOrder();
		}else {
			System.out.println("树为空");
		}
	}
	//中序遍历
	public void infixOrder() {
		if(this.root!=null) {
			this.root.infixOrder();
		}else {
			System.out.println("树为空");
		}
	}
	//后序遍历
	public void postOrder() {
		if(this.root!=null) {
			this.root.postOrder();
		}else {
			System.out.println("树为空");
		}
	}
	
	//删除指定no的元素
	public void delNode(int no) {
		if(root!=null) {
			if(root.getNo()==no) {
				System.out.println("已删除节点 "+root);
				root=null;
			}else {
				root.delNode(no);
			}
		}else {
			System.out.println("树为空");
		}
	}
}


class Node{
	private int no;
	private String name;
	private Node leftNode;
	private Node rightNode;
	
	private int leftType;//若leftType == 0, 则表示指向的是左子树,如果是1则表示指向前驱节点
	private int rightType;//若rightType == 0, 则表示指向的是左子树，如果是1则表示指向后继节点
	
	public Node(int no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
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
		if(this.leftNode!=null && this.leftType!=1) {
			temp = this.leftNode.preOrderSearch(no);
		}
		if(temp!=null) {
			return temp;
		}
		if(this.rightNode!=null && this.rightType!=1) {
			temp = this.rightNode.preOrderSearch(no);
		}
		return temp;
	}
	//中序查找的方法
	public Node infixOrderSearch(int no) {
		Node temp = null;
		if(this.leftNode!=null && this.leftType!=1) {
			temp = this.leftNode.infixOrderSearch(no);
		}
		if(temp!=null) {
			return temp;
		}
		System.out.println("中序比较中，当前节点为: "+this.getNo());
		if(this.no == no) {
			return this;
		}
		if(this.rightNode!=null && this.rightType!=1) {
			temp = this.rightNode.infixOrderSearch(no);
		}
		return temp;
	}
	//后序查找的方法
	public Node postOrderSearch(int no) {
		Node temp = null;
		if(this.leftNode!=null && this.leftType!=1) {
			temp = this.leftNode.postOrderSearch(no);
		}
		if(temp!=null) {
			return temp;
		}
		if(this.rightNode!=null && this.rightType!=1) {
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
		if(this.leftNode!=null && this.leftType!=1) {
			this.leftNode.preOrder();
		}
		if(this.rightNode!=null && this.rightType!=1) {
			this.rightNode.preOrder();
		}
	}
	//中序遍历的方法
	public void infixOrder() {
		if(this.leftNode!=null && this.leftType!=1) {
			this.leftNode.infixOrder();
		}
		System.out.println(this);
		if(this.rightNode!=null && this.rightType!=1) {
			this.rightNode.infixOrder();
		}
	}
	//后序遍历的方法
	public void postOrder() {
		if(this.leftNode!=null && this.leftType!=1) {
			this.leftNode.postOrder();
		}
		if(this.rightNode!=null && this.rightType!=1) {
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