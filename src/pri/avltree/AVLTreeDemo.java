package pri.avltree;

public class AVLTreeDemo {

	public static void main(String[] args) {
		//int[] arr = { 4, 3, 6, 5, 7, 8 };
		//int[] arr = {10,12,8,9,7,6};
		int[] arr = {10,7,8,9,6,11};
		AVLTree tree = new AVLTree();
		for (int i = 0; i < arr.length; ++i) {
			tree.add(new Node(arr[i]));
		}
		System.out.println("中序遍历");
		tree.infixOrder();
		System.out.println("根节点为: " + tree.getRoot());
		System.out.println(tree.getRoot().height());
		System.out.println(tree.getRoot().leftHeight() + " " + tree.getRoot().rightHeight());
		/*tree.add(new Node(2));
		tree.infixOrder();
		System.out.println(tree.getRoot().leftHeight() + " " + tree.getRoot().rightHeight());
		System.out.println(tree.getRoot());
		tree.add(new Node(1));
		tree.infixOrder();
		System.out.println(tree.getRoot().leftHeight() + " " + tree.getRoot().rightHeight());
		System.out.println(tree.getRoot());*/
	}

}

class AVLTree {
	private Node root;

	public Node getRoot() {
		return root;
	}

	public void add(Node node) {
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}

	public void infixOrder() {
		if (root == null) {
			System.out.println("树为空");
		} else {
			this.root.infixOrder();
		}
	}

	public Node search(int value) {
		if (root == null) {
			System.out.println("树为空");
			return null;
		} else {
			Node deletedNode = root.search(value);
			if (deletedNode == null) {
				System.out.println("找不到该节点");
			} else {
				System.out.println("已找到要删除的节点: " + deletedNode);
			}
			return deletedNode;
		}
	}

	public Node searchParent(int value) {
		if (root == null) {
			System.out.println("树为空");
			return null;
		} else {
			Node parent = root.searchParent(value);
			if (parent == null) {
				System.out.println("找不到父节点");
			} else {
				System.out.println("父节点为: " + parent);
			}
			return parent;
		}
	}

	// 删除子树中的最小值
	public int delRightTreeMin(Node node) {
		Node target = node;
		// 向左子节点递归，直到找到最小节点
		while (target.left != null) {
			target = target.left;
		}
		// 删除该节点
		delNode(target.value);
		// 返回最小节点的值
		return target.value;
	}

	public void delNode(int value) {
		if (root == null) {
			System.out.println("树为空");
			return;
		} else {
			Node targetNode = search(value);
			// 没有找到要删除的节点
			if (targetNode == null) {
				return;
			}
			// 若该二叉树只有一个节点
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			Node parent = searchParent(value);

			// 如果要删除的节点是叶子节点
			if (targetNode.left == null && targetNode.right == null) {
				if (parent.left != null && value == parent.left.value) {
					parent.left = null;
				} else {
					parent.right = null;
				}
				// 如果要删除的节点有两颗子树
			} else if (targetNode.left != null && targetNode.right != null) {
				// 被删除节点的值替换为其右子树最小节点的值
				int temp = delRightTreeMin(targetNode.right);
				targetNode.value = temp;
			} else {
				// 如果要删除的节点只有左子节点
				if (targetNode.left != null) {
					// 若要删除的节点为根节点
					if (parent == null) {
						// 让根节点指向被删除节点的子节点
						root = targetNode.left;
					} else {
						// 如果要删除的节点是父节点的左子节点
						if (parent.left != null && parent.left.value == value) {
							parent.left = targetNode.left;
						} else {// 如果要删除的节点是父节点的右子节点
							parent.right = targetNode.left;
						}
					}
				} else {// 如果要删除的节点只有右子节点
					// 若要删除的节点为根节点
					if (parent == null) {
						root = targetNode.right;
					} else {
						// 如果要删除的节点是父节点的左子节点
						if (parent.left != null && parent.left.value == value) {
							parent.left = targetNode.right;
						} else {// 如果要删除的节点是父节点的右子节点
							parent.right = targetNode.left;
						}
					}
				}
			}

		}
	}

}

class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}

	//左旋转
	private void leftRotate() {
		Node newNode = new Node(value);
		newNode.left = left;
		newNode.right = right.left;
		value = right.value;
		right = right.right;
		left = newNode;
	}
	
	//右旋转
	private void rightRotate()
	{
		Node newNode = new Node(value);
		newNode.right = right;
		newNode.left = left.right;
		value = left.value;
		left = left.left;
		right = newNode;
	}
	
	//左子树高度
	public int leftHeight() {
		if (left == null) {
			return 0;
		} else {
			return left.height();
		}
	}

	//右子树高度
	public int rightHeight() {
		if (right == null) {
			return 0;
		} else {
			return right.height();
		}
	}

	// 返回以指定节点为根节点的树的高度
	public int height() {
		return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
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
	
	//删除的节点的父节点
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
		
		//如果添加完新的节点后，树不再是平衡二叉树
		//当右子树高度-左子树高度>1时
		if (rightHeight() - leftHeight() > 1) {
			//如果当前节点的右子节点的左子树的高度大于右子节点的左子树的高度
			if(right.leftHeight()>right.rightHeight()) {
				//先对右子节点进行右旋转
				right.rightRotate();
			}
			leftRotate();
		}
		//当左子树高度-右子树高度>1时
		if (leftHeight() - rightHeight() > 1) {
			//如果当前节点的左子节点的右子树的高度大于左子节点的右子树的高度
			if(left.rightHeight()>left.leftHeight()) {
				//先对左子节点进行左旋转
				left.leftRotate();
			}
			rightRotate();
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