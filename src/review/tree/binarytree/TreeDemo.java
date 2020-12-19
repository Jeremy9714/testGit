package review.tree.binarytree;

public class TreeDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		BinaryTree tree = new BinaryTree();
		
		Node root = new Node(1,"宋江");
		Node node1 = new Node(2,"吴用");
		Node node2 = new Node(3,"卢俊义");
		Node node3 = new Node(4,"林冲");
		tree.setRoot(root);
		root.setLeft(node1);
		root.setRight(node2);
		node2.setRight(node3);
		System.out.println("前序遍历");
		tree.preOrder();
		System.out.println("中序遍历");
		tree.infixOrder();
		System.out.println("后序遍历");
		tree.postOrder();
	}

}
class BinaryTree{
	private Node root;
	
	public void setRoot(Node root) {
		this.root = root;
	}
	public void preOrder() {
		if(this.root!=null) {
			this.root.preOrder();
		}else {
			System.out.println("二叉树为空");
		}
		System.out.println();
	}
	public void infixOrder() {
		if(this.root!=null) {
			this.root.infixOrder();
		}else {
			System.out.println("二叉树为空");
		}
		System.out.println();
	}
	public void postOrder() {
		if(this.root!=null) {
			this.root.postOrder();
		}else {
			System.out.println("二叉树为空");
		}
		System.out.println();
	}
}

class Node{
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
		if(this.left!=null) {
			this.left.preOrder();
		}
		if(this.right!=null) {
			this.right.preOrder();
		}
	}
	
	public void infixOrder() {
		if(this.left!=null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if(this.right!=null) {
			this.right.infixOrder();
		}
	}
	
	public void postOrder() {
		if(this.left!=null) {
			this.left.postOrder();
		}
		if(this.right!=null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}
}