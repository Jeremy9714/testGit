package pri.avltree;

public class AVLTreeDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}

	// 查找要删除的节点
	public Node search(int value) {
		if (this.value == value) {
			return this;
		} else if (value < this.value) {
			if (this.left == null) {
				return null;
			}
			return this.left.search(value);
		} else {
			if (this.right == null) {
				return null;
			}
			return this.right.search(value);
		}
	}

	public Node searchParent(int value) {
		if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			return this;
		} else {
			if (value < this.value && this.left != null) {
				return this.left.searchParent(value);
			} else if (value >= this.value && this.right != null) {
				return this.right.searchParent(value);
			} else {
				return null;
			}
		}
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	public void add(Node node) {
		if (node == null) {
			return;
		}
		if (this.value > node.value) {
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.add(node);
			}
		} else {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
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
}