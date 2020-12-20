package review.tree.threadedtree;

public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ThreadedTree tree = new ThreadedTree();
		Node node1 = new Node(1, "宋江");
		Node node2 = new Node(2, "吴用");
		Node node3 = new Node(3, "卢俊义");
		Node node4 = new Node(4, "林冲");
		Node node5 = new Node(5, "张飞");
		Node node6 = new Node(6, "刘备");

		tree.setRoot(node1);
		node1.setLeft(node2);
		node1.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		//tree.del(4);

		tree.infixThreadedTree();
		tree.infixThreadedList();
		
		tree.preThreadedTree();
		tree.preThreadedList();

	}

}

class ThreadedTree {
	private Node root;
	private Node pre;

	public void setRoot(Node node) {
		this.root = node;
	}
	
	public void preThreadedList() {
		if(root==null) {
			System.out.println("树为空");
			return;
		}
		System.out.print("前序线索化遍历:   ");
		Node node = root;
		System.out.print(node.getNo() + "(" + node.getName() + ")->");
		
		while(node!=null) {
			while(node.getLeft()!=null&&node.getLeftType()==0) {
				node=node.getLeft();
				System.out.print(node.getNo() + "(" + node.getName() + ")->");
			}
			while(node.getRight()!=null&&node.getRightType()==1) {
				node=node.getRight();
				System.out.print(node.getNo() + "(" + node.getName() + ")->");
			}	
		}
		System.out.println();
	}
	
	public void infixThreadedList() {
		if (root == null) {
			System.out.println("树为空");
			return;
		}
		System.out.print("中序线索化遍历:   ");
		Node node = root;
		while (node != null) {
			while (node.getLeftType() == 0) {
				node = node.getLeft();
			}
			System.out.print(node.getNo() + "(" + node.getName() + ")->");
			while (node.getRightType() == 2) {
				node = node.getRight();
				System.out.print(node.getNo() + "(" + node.getName() + ")->");
			}
			node = node.getRight();
		}
		System.out.println();
	}

	public void preThreadedTree() {
		preThreadedTree(root);
		pre = null;
		if (root != null) {
			System.out.println("前序线索化完毕");
		}
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
		if (root != null) {
			System.out.println("中序线索化完毕");
		}
	}

	private void infixThreadedTree(Node node) {
		if (node == null) {
			System.out.println("该节点不存在");
			return;
		}
		// 左子树
		if (node.getLeft() != null && node.getLeftType() == 0) {
			infixThreadedTree(node.getLeft());
		}
		// 前驱节点
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(2);
		}
		// 后继节点
		if (pre != null && pre.getRight() == null) {
			pre.setRight(node);
			pre.setRightType(2);
		}
		// 更新前一个节点
		pre = node;
		// 右子树
		if (node.getRight() != null && node.getRightType() == 0) {
			infixThreadedTree(node.getRight());
		}
	}

	public void postThreadedTree() {
		postThreadedTree(root);
		pre = null;
		if (root != null) {
			System.out.println("后序线索化完毕");
		}
	}

	private void postThreadedTree(Node node) {
		if (node == null) {
			System.out.println("该节点不存在");
			return;
		}
		// 左子树
		if (node.getLeft() != null && node.getLeftType() == 0) {
			postThreadedTree(node.getLeft());
		}
		// 右子树
		if (node.getRight() != null && node.getRightType() == 0) {
			postThreadedTree(node.getRight());
		}
		// 前驱节点
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(3);
		}
		// 后继节点
		if (pre != null && pre.getRight() == null) {
			pre.setRight(node);
			pre.setRightType(3);
		}
		// 更新前一个节点
		pre = node;
	}

	public void del(int no) {
		if (root.getNo() == no) {
			root = null;
			System.out.println("树已清空");
		} else {
			root.del(no);
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

	public void del(int no) {
		if (this.left != null && this.leftType == 0 && this.left.no == no) {
			System.out.println("已删除编号为" + no + "的节点");
			this.left = null;
			return;
		}
		if (this.right != null && this.rightType == 0 && this.right.no == no) {
			this.right = null;
			System.out.println("已删除编号为" + no + "的节点");
			return;
		}
		if (this.left != null && this.leftType == 0) {
			this.left.del(no);
		}
		if (this.right != null && this.rightType == 0) {
			this.right.del(no);
		}
	}

}