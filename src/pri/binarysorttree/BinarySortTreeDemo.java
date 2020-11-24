package pri.binarysorttree;

public class BinarySortTreeDemo {

	public static void main(String[] args) {
		
		int[] arr = {7,3,10,12,5,1,9,2};
		BinarySortTree tree = new BinarySortTree();
		for(int i=0;i<arr.length;++i) {
			tree.add(new Node(arr[i]));
		}

		tree.infixOrder();
		System.out.println();
		//tree.search(13);
		tree.delNode(7);
		/*tree.delNode(5);
		tree.delNode(3);
		tree.delNode(1);*/
		tree.infixOrder();
	}

}

class BinarySortTree{
	private Node root;
	
	public void add(Node node) {
		if(root==null) {
			root = node;
		}else {
			root.add(node);
		}
	}
	
	public void infixOrder() {
		if(root==null) {
			System.out.println("树为空");
		}else {
			this.root.infixOrder();
		}
	}
	
	public Node search(int value) {
		if(root==null) {
			System.out.println("树为空");
			return null;
		}else {
			Node deletedNode = root.search(value);
			if(deletedNode ==null) {
				System.out.println("找不到该节点");
			}else {
				System.out.println("已找到要删除的节点: " + deletedNode );
			}
			return deletedNode ;
		}
	}
	
	public Node searchParent(int value) {
		if(root==null) {
			System.out.println("树为空");
			return null;
		}else {
			Node parent = root.searchParent(value);
			if(parent==null) {
				System.out.println("找不到父节点");
			}else {
				System.out.println("父节点为: " + parent);
			}
			return parent;
		}
	}
	
	//删除子树中的最小值
	public int delRightTreeMin(Node node) {
		Node target = node;
		//向左子节点递归，直到找到最小节点
		while(target.left!=null) {
			target=target.left;
		}
		//删除该节点
		delNode(target.value);
		//返回最小节点的值
		return target.value;
	}
	
	public void delNode(int value) {
		if(root==null) {
			System.out.println("树为空");
			return;
		}else {
			Node targetNode = search(value);
			//没有找到要删除的节点
			if(targetNode == null) {
				return;
			}
			//若该二叉树只有一个节点
			if(root.left==null && root.right==null) {
				root = null;
				return;
			}
			Node parent = searchParent(value);
			
			//如果要删除的节点是叶子节点
			if(targetNode.left==null && targetNode.right==null) {
				if(parent.left!=null && value==parent.left.value) {
					parent.left = null;
				}else {
					parent.right = null;
				}
			//如果要删除的节点有两颗子树
			}else if(targetNode.left!=null && targetNode.right!=null) {
				//被删除节点的值替换为其右子树最小节点的值
				int temp = delRightTreeMin(targetNode.right);
				targetNode.value = temp;
			}else {
				//如果要删除的节点只有左子节点
				if(targetNode.left!=null) {
					//如果要删除的节点是父节点的左子节点
					if(parent.left!=null && parent.left.value == value) {
						parent.left = targetNode.left;
					}else {//如果要删除的节点是父节点的右子节点
						parent.right = targetNode.left;
					}
				}else {//如果要删除的节点只有右子节点
					//如果要删除的节点是父节点的左子节点
					if(parent.left!=null && parent.left.value == value) {
						parent.left = targetNode.right;
					}else {//如果要删除的节点是父节点的右子节点
						parent.right = targetNode.left;
					}
				}
			}

		}
	}
	
}

class Node{
	int value;
	Node left;
	Node right;
	
	public Node(int value) {
		this.value = value;
	}
	
	//查找要删除的节点
	public Node search(int value) {
		if(this.value==value) {
			return this;
		}else if(value < this.value) {
			if(this.left==null) {
				return null;
			}
			return this.left.search(value);
		}else {
			if(this.right==null) {
				return null;
			}
			return this.right.search(value);
		}
	}
	
	public Node searchParent(int value) {
		if((this.left!=null && this.left.value==value)||(this.right!=null && this.right.value==value)) {
			return this;
		}else {
			if(value<this.value && this.left!=null) {
				return this.left.searchParent(value);
			}else if(value>=this.value && this.right!=null) {
				return this.right.searchParent(value);
			}else {
				return null;
			}
		}
	}
	
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	public void add(Node node) {
		if(node==null) {
			return;
		}
		if(this.value>node.value) {
			if(this.left==null) {
				this.left = node;
			}else {
				this.left.add(node);
			}			
		}else {
			if(this.right==null) {
				this.right = node;
			}else {
				this.right.add(node);
			}
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
}
