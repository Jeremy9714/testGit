package review.tree.search;

public class BinartSearchTreeDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		BinaryTree tree = new BinaryTree();

		Node root = new Node(1, "宋江");
		Node node1 = new Node(2, "吴用");
		Node node2 = new Node(3, "卢俊义");
		Node node3 = new Node(4, "林冲");
		Node node4 = new Node(5, "关胜");
		Node node5 = new Node(6, "张飞");
		Node node6 = new Node(7, "刘备");
		tree.setRoot(root);
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node2.setLeft(node5);
		node2.setRight(node6);
		
		tree.preOrderSearch(4);
		tree.infixOrderSearch(4);
		tree.postOrderSearch(4);
		
		tree.delNode(3);
		tree.preOrder();
	}
}

class BinaryTree {
	private Node root;

	public void setRoot(Node root) {
		this.root = root;
	}

	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("二叉树为空");
		}
		System.out.println();
	}
	
	public void preOrderSearch(int no) {
		System.out.println("开始前序查找");
		if (this.root==null) {
			System.out.println("二叉树为空");
		}else {
			Node res = this.root.preOrderSearch(no);
			if(res==null) {
				System.out.println("未找到该节点");
			}else {
				System.out.println(res);
			}
		}
		System.out.println();
	}
	
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("二叉树为空");
		}
		System.out.println();
	}

	public void infixOrderSearch(int no) {
		System.out.println("开始中序查找");
		if (this.root==null) {
			System.out.println("二叉树为空");
		}else {
			Node res = this.root.infixOrderSearch(no);
			if(res==null) {
				System.out.println("未找到该节点");
			}else {
				System.out.println(res);
			}
		}
		System.out.println();
	}
	
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("二叉树为空");
		}
		System.out.println();
	}
	
	public void postOrderSearch(int no) {
		System.out.println("开始后序查找");
		if (this.root==null) {
			System.out.println("二叉树为空");
		}else {
			Node res = this.root.postOrderSearch(no);
			if(res==null) {
				System.out.println("未找到该节点");
			}else {
				System.out.println(res);
			}
		}
		System.out.println();
	}
	
	public void delNode(int no) {
		if(root.getNo()==no) {
			this.root=null;
			System.out.println("已删除二叉树");
		}else {
			int res = this.root.delNode(no);
			if(res==0) {
				System.out.println("未找到该节点");
			}else {
				System.out.println();
			}
		}
	}
}

class Node {
	private int no;
	private String name;
	private Node left;
	private Node right;

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

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node(int no, String name) {
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + "]";
	}

	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}
	
	public Node preOrderSearch(int no) {
		System.out.print("当前的节点为:"+this.no+"("+this.name+")"+" -> ");
		if(this.no==no) {
			return this;
		}
		Node res = null;
		if(this.left!=null) {
			res = this.left.preOrderSearch(no);
		}
		if(res!=null) {
			return res;
		}
		if(this.right!=null) {
			res = this.right.preOrderSearch(no);
		}
		return res;
	}

	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	
	public Node infixOrderSearch(int no) {
		Node res = null;
		if(this.left!=null) {
			res = this.left.infixOrderSearch(no);
		}
		if(res!=null) {
			return res;
		}
		System.out.print("当前的节点为:"+this.no+"("+this.name+")"+" -> ");
		if(this.no==no) {
			return this;
		}
		if(this.right!=null) {
			res = this.right.infixOrderSearch(no);
		}
		return res;
	}
	
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}
	
	public Node postOrderSearch(int no) {
		Node res = null;
		if(this.left!=null) {
			res = this.left.postOrderSearch(no);
		}
		if(res!=null) {
			return res;
		}
		if(this.right!=null) {
			res = this.right.postOrderSearch(no);
		}
		if(res!=null) {
			return res;
		}
		System.out.print("当前的节点为:"+this.no+"("+this.name+")"+" -> ");
		if(this.no==no) {
			return this;
		}
		return res;
	}
	
	public int delNode(int no) {
		int res = 0;
		if(this.left!=null&&this.left.no==no) {
			System.out.println("已删除编号为"+this.left.no+"的节点");
			this.left=null;
			return 1;
		}
		if(this.right!=null&&this.right.no==no) {
			System.out.println("已删除编号为"+this.right.no+"的节点");
			this.right=null;
			return 1;
		}
		if(this.left!=null) {
			res = this.left.delNode(no);
		}
		if(res!=0) {
			return res;
		}
		if(this.right!=null) {
			res = this.right.delNode(no);
		}
		return res;
	}
}
