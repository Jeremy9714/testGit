package review.tree.huffmantree;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTreeDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = { 13, 7, 8, 3, 29, 6, 1 };
		Node root = createHuffmanTree(arr);
		preOrder(root);
	}

	public static Node createHuffmanTree(int[] arr) {
		List<Node> list = new ArrayList<>();
		for (int ele : arr) {
			list.add(new Node(ele));
		}
		Collections.sort(list);
		while (list.size() > 1) {
			Node node1 = list.remove(0);
			Node node2 = list.remove(0);
			Node node = new Node(node1.no + node2.no);
			node.left = node1;
			node.right = node2;
			list.add(node);
			Collections.sort(list);
		}
		return list.remove(0);
	}

	public static void preOrder(Node root) {
		if (root == null) {
			System.out.println("树为空");
		} else {
			root.preOrder();
		}
	}
}

class Node implements Comparable<Node> {
	public int no;
	public Node left;
	public Node right;

	public Node(int no) {
		this.no = no;
	}

	public String toString() {
		return "Node ["+no+"]";
	}

	@Override
	public int compareTo(Node o) {
		// TODO 自动生成的方法存根
		return this.no - o.no;
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
}
