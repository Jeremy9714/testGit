package review.tree.avltree;

public class AVLTreeDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {10,7,8,9,6,11};
		AVLTree tree = new AVLTree();
		for(int ele:arr) {
			tree.add(new Node(ele));
		}
		tree.infixOrder();
		//System.out.println(tree.root);
		tree.del(6);
		tree.del(7);
		tree.add(new Node(12));
		tree.infixOrder();
	}

}

class AVLTree {
	public Node root;

	public int delLeftMax(Node node) {
		Node cur = node.left;
		while (cur.right != null) {
			cur = cur.right;
		}
		int val = cur.no;
		del(val);
		return val;
	}

	public int delRightMin(Node node) {
		Node cur = node.right;
		while (cur.left != null) {
			cur = cur.left;
		}
		//System.out.println(cur);
		int val = cur.no;
		del(val);
		return val;
	}

	public void del(int no) {
		if (root == null) {
			System.out.println("树为空");
			return;
		}
		Node target = root.search(no);
		if (target == null) {
			System.out.println("该节点不存在");
			return;
		}
		if (root.left == null && root.right == null) {
			root = null;
			return;
		}
		Node parent = root.searchParent(target);
		//System.out.println(target + " " + parent);

		if (target.left == null && target.right == null) {
			if (parent.left != null && parent.left == target) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else {
			int val;
			if(target.right==null) {
				val = delLeftMax(target);
			}else {
				val = delRightMin(target);
			}
			if (parent == null) {
				root.no = val;
				return;
			}
			target.no = val;
		}
	}
	
	public void add(Node node) {
		if(root==null) {
			root=node;
		}else {
			root.add(node);
		}
	}
	
	public void infixOrder() {
		if(root==null) {
			System.out.println("树为空");
		}else {
			root.infixOrder();
		}
		System.out.println();
	}
}

class Node {
	int no;
	Node left;
	Node right;

	public Node(int no) {
		this.no = no;
	}

	public int height() {
		return Math.max(left == null ? 1 : left.height() + 1, right == null ? 1 : right.height() + 1);
	}
	
	public int leftHeight() {
		if(this.left==null) {
			return 0;
		}else {
			return this.left.height();
		}
	}
	
	public int rightHeight() {
		if(this.right==null) {
			return 0;
		}else {
			return this.right.height();
		}
	}
	
	public void leftRotate() {
		Node newRoot = new Node(no);
		newRoot.left=this.left;
		newRoot.right=this.right.left;
		this.no = this.right.no;
		this.left=newRoot;
		this.right = this.right.right;
	}
	
	public void rightRotate() {
		Node newRoot = new Node(no);
		newRoot.right = this.right;
		newRoot.left = this.left.right;
		this.no=this.left.no;
		this.left = this.left.left;
		this.right = newRoot;
	}
	
	public void add(Node node) {
		if (node == null) {
			return;
		}
		if (this.no > node.no) {
			if (this.left != null) {
				this.left.add(node);
			} else {
				this.left = node;
			}
		} else {
			if (this.right != null) {
				this.right.add(node);
			} else {
				this.right = node;
			}
		}
		
		if(leftHeight()-rightHeight()>1) {
			if(this.left.rightHeight()>this.left.leftHeight()) {
				this.left.leftRotate();
			}
			rightRotate();
		}
		if(rightHeight()-leftHeight()>1) {
			if(this.right.leftHeight()>this.right.rightHeight()) {
				this.right.rightRotate();
			}
			leftRotate();
		}
	}

	public Node searchParent(Node node) {
		if ((this.left != null && this.left == node) | (this.right != null && this.right == node)) {
			return this;
		}
		if (this.left != null && this.no > node.no) {
			return this.left.searchParent(node);
		}
		if (this.right != null && this.no < node.no) {
			return this.right.searchParent(node);
		}
		return null;
	}

	public Node search(int no) {
		if (this.no == no) {
			return this;
		}
		if (this.no > no) {
			if (this.left != null) {
				return this.left.search(no);
			}
		}
		if (this.no < no) {
			if (this.right != null) {
				return this.right.search(no);
			}
		}
		return null;
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
	
	public String toString() {
		return "Node[" + no + "]";
	}
}