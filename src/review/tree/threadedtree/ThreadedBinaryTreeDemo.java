package review.tree.threadedtree;

public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}

class ThreadedTree {
	private Node root;
	private Node pre;
	
	public void setRoot(Node node) {
		this.root=node;
	}
	
	public void preThreadedTree(Node node) {
		
	}
	public void infixThreadedTree() {
		infixThreadedTree(root);
		pre = null;
		System.out.println("中序线索化完毕");
	}
	private void infixThreadedTree(Node node) {
		if(node==null) {
			System.out.println("该节点不存在");
			return;
		}
		if(node.getLeft()!=null&&node.getLeftType()==0) {
			infixThreadedTree(node.getLeft());
		}
		if(node.getLeft()==null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		if(pre!=null&&pre.getRight()==null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
		pre = node;
		if(node.getRight()!=null&&node.getRightType()==0) {
			infixThreadedTree(node.getRight());
		}
	}
}

class Node {
	private Node left;
	private Node right;
	private int leftType;
	private int rightType;
	private int no;
	private String name;

	public Node(int no, String name) {
		this.no = no;
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
}