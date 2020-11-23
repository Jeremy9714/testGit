package pri.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTreeDemo {

	public static void main(String[] args) {

		int[] arr = { 13, 7, 8, 3, 29, 6, 1 };
		Node root = createHuffmanTree(arr);

		preOrder(root);
	}

	public static Node createHuffmanTree(int[] arr) {
		List<Node> nodes = new ArrayList<Node>();
		for (int ele : arr) {
			nodes.add(new Node(ele));
		}
		Node leftNode;
		Node rightNode;
		Node newNode;

		while (nodes.size() > 1) {
			Collections.sort(nodes);
			System.out.println(nodes);
			leftNode = nodes.get(0);
			rightNode = nodes.get(1);
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			newNode = new Node(leftNode.value + rightNode.value);
			newNode.left = leftNode;
			newNode.right = rightNode;
			nodes.add(newNode);
		}
		return nodes.get(0);
	}

	public static void preOrder(Node root) {
		if (root == null) {
			System.out.println("根节点为空");
			return;
		}
		System.out.println("前序遍历赫夫曼树");
		root.preOrder();
	}
}

class Node implements Comparable<Node> {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
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

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node node) {
		// TODO 自动生成的方法存根
		return this.value - node.value;
	}

}