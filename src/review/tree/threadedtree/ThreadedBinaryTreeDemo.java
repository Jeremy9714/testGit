package review.tree.threadedtree;

public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Node root = new Node(1,"宋江");
	}

}

class ThreadedTree {
	private Node root;
	private Node pre;

	public void setRoot(Node node) {
		this.root = node;
	}

	public void preThreadedTree() {
		preThreadedTree(root);
		pre = null;
		System.out.println("前序线索化完毕");
	}
	private void preThreadedTree(Node node) {
		if (node == null) {
			System.out.println("该节点不存在");
			return;
		}
		// 前驱节点
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		// 后继节点
		if (pre != null && pre.getRight() == null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
		// 更新前一个节点
		pre = node;
		// 左子树
		if (node.getLeft() != null && node.getLeftType() == 0) {
			preThreadedTree(node.getLeft());
		}
		// 右子树
		if (node.getRight() != null && node.getRightType() == 0) {
			preThreadedTree(node.getRight());
		}
	}

	public void infixThreadedTree() {
		infixThreadedTree(root);
		pre = null;
		System.out.println("中序线索化完毕");
	}
	private void infixThreadedTree(Node node) {
		if (node == null) {
			System.out.println("该节点不存在");
			return;
		}
		//左子树
		if (node.getLeft() != null && node.getLeftType() == 0) {
			infixThreadedTree(node.getLeft());
		}
		//前驱节点
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		//后继节点
		if (pre != null && pre.getRight() == null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
		//更新前一个节点
		pre = node;
		//右子树
		if (node.getRight() != null && node.getRightType() == 0) {
			infixThreadedTree(node.getRight());
		}
	}

	public void postThreadedTree() {
		postThreadedTree(root);
		pre = null;
		System.out.println("后序线索化完毕");
	}
	private void postThreadedTree(Node node) {
		if (node == null) {
			System.out.println("该节点不存在");
			return;
		}
		//左子树
		if (node.getLeft() != null && node.getLeftType() == 0) {
			postThreadedTree(node.getLeft());
		}
		//右子树
		if (node.getRight() != null && node.getRightType() == 0) {
			postThreadedTree(node.getRight());
		}
		//前驱节点
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		//后继节点
		if (pre != null && pre.getRight() == null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
		//更新前一个节点
		pre = node;
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