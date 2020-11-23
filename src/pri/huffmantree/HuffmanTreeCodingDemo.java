package pri.huffmantree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanTreeCodingDemo {

	public static void main(String[] args) {
		String content = "i like like like java do you like a java";
		byte[] bytes = content.getBytes();
		System.out.println("原字符串长度为"+bytes.length);
		
		/*List<Node2> list = getNodes(bytes);
		// System.out.println(list);
		Node2 root = createHuffmanTree(list);
		preOrder(root);
		getCodes(root);
		System.out.println(huffmanCodes);
		byte[] res = zip(bytes, huffmanCodes);*/
		
		byte[] huffmanCodeBytes = huffmanZip(bytes);
		System.out.println("字符串为: " + Arrays.toString(huffmanCodeBytes) + " 长度为 " + huffmanCodeBytes.length);

	}
	
	public static byte[] huffmanZip(byte[] bytes) {
		//将字符串中的字符和其频率作为参数生成对象并保存到List中
		List<Node2> list = getNodes(bytes);
		//用排好序的List来构建赫夫曼树
		Node2 root = createHuffmanTree(list);
		//得到每个字符的赫夫曼编码(根据赫夫曼树)
		Map<Byte,String> huffmanCodes = getCodes(root);
		//将原字符串使用生成的赫夫曼编码来进行压缩，并将得到的压缩码转换成字符串
		byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
		return huffmanCodeBytes;
	}

	// 将原字节串按照赫夫曼编码表来进行压缩
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
		StringBuilder stringBuilder = new StringBuilder();
		for (byte b : bytes) {
			stringBuilder.append(huffmanCodes.get(b));
		}
		// System.out.println(stringBuilder.length()+"\n"+stringBuilder.toString());

		// 将该字符串转换为byte[],即八位对应一个byte
		int len;// 字节串的长度
		len = (stringBuilder.length() + 7) / 8;
		byte[] huffmanCodeBytes = new byte[len];
		int index = 0;
		String strByte;
		for (int i = 0; i < stringBuilder.length(); i += 8) {
			if (i + 8 > stringBuilder.length()) {
				strByte = stringBuilder.substring(i);
			} else {
				strByte = stringBuilder.substring(i, i + 8);
			}
			huffmanCodeBytes[index++] = (byte) Integer.parseInt(strByte, 2);
		}
		return huffmanCodeBytes;
	}

	// 将字节串中的字符按照字符种类和出现次数生成节点并保存到列表
	private static List<Node2> getNodes(byte[] bytes) {
		ArrayList<Node2> arrayList = new ArrayList<Node2>();
		HashMap<Byte, Integer> hashMap = new HashMap<>();
		for (byte ele : bytes) {
			Integer count = hashMap.get(ele);
			if (count == null) {
				hashMap.put(ele, 1);
			} else {
				hashMap.put(ele, count + 1);
			}
		}

		// 遍历映射，生成对应的节点对象
		for (Map.Entry<Byte, Integer> entry : hashMap.entrySet()) {
			arrayList.add(new Node2(entry.getKey(), entry.getValue()));
		}
		return arrayList;
	}

	// 创建赫夫曼树
	private static Node2 createHuffmanTree(List<Node2> list) {
		while (list.size() > 1) {
			Collections.sort(list);
			Node2 leftNode = list.get(0);
			Node2 rightNode = list.get(1);
			list.remove(leftNode);
			list.remove(rightNode);
			Node2 parent = new Node2(null, leftNode.weight + rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;
			list.add(parent);
		}
		return list.get(0);
	}

	static HashMap<Byte, String> huffmanCodes = new HashMap<>();
	static StringBuilder stringBuilder = new StringBuilder();

	private static Map<Byte, String> getCodes(Node2 root) {
		if (root == null) {
			System.out.println("树为空");
			return null;
		}
		getCodes(root.left, "0", stringBuilder);
		getCodes(root.right, "1", stringBuilder);
		return huffmanCodes;
	}

	private static void getCodes(Node2 node, String code, StringBuilder stringBuilder) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		stringBuilder2.append(code);

		if (node != null) {
			// 非叶子节点
			if (node.data == null) {
				getCodes(node.left, "0", stringBuilder2);
				getCodes(node.right, "1", stringBuilder2);
			} else {
				// 叶子节点，将字符和对应路径放入哈希表
				huffmanCodes.put(node.data, stringBuilder2.toString());
			}
		}
	}

	private static void preOrder(Node2 root) {
		if (root == null) {
			System.out.println("樹為空");
		} else {
			root.preOrder();
		}
	}
}

class Node2 implements Comparable<Node2> {

	Byte data;
	int weight;
	Node2 left;
	Node2 right;

	public Node2(Byte data, int weight) {
		super();
		this.data = data;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Node2 [data=" + data + ", weight=" + weight + "]";
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
	public int compareTo(Node2 node) {
		return this.weight - node.weight;
	}
}
