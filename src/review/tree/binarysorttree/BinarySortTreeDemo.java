package review.tree.binarysorttree;

public class BinarySortTreeDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = { 7, 3, 10, 12, 5, 1, 9, 32, 20, 11 };
		BinarySortTree tree = new BinarySortTree();
		for (int ele : arr) {
			tree.add(new Node(ele));
		}
		tree.infixOrder();
		tree.del(10);
		tree.infixOrder();
		
	}

}

class BinarySortTree {
	public Node root;

	public void add(Node node) {
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}

	public void infixOrder() {
		System.out.println("开始中序遍历");
		if (root == null) {
			System.out.println("树为空");
		} else {
			root.infixOrder();
		}
		System.out.println();
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
		} /*else {
			if (target.left != null) {
				if (parent == null) {
					root = target.left;
					return;
				}
				if (parent.left != null && parent.left == target) {
					parent.left = target.left;
				} else {
					parent.right = target.left;
				}
			} else {
				if (parent == null) {
					root = target.right;
					return;
				}
				if (parent.left != null && parent.left == target) {
					parent.left = target.right;
				} else {
					parent.right = target.right;
				}
			}
		}*/
	}
	
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

}

class Node {
	public int no;
	public Node left;
	public Node right;

	public Node(int no) {
		this.no = no;
	}

	public void add(Node node) {
		if (node == null) {
			return;
		}
		if (node.no < this.no) {
			if (this.left != null) {
				this.left.add(node);
			} else {
				this.left = node;
			}
		} else {
			if (node.no >= this.no) {
				if (this.right != null) {
					this.right.add(node);
				} else {
					this.right = node;
				}
			}
		}
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

	public String toString() {
		return "Node[" + this.no + "]";
	}
}