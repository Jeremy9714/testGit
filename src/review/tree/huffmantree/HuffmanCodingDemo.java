package review.tree.huffmantree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCodingDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str = "i like like like java do you like a java";
		System.out.println("原字符串为: " + str);
		byte[] bytes = str.getBytes();

		byte[] zipContent = encode(bytes);
		System.out.println("赫夫曼编码后的字节串为: " + Arrays.toString(zipContent));

		// printMap(); //显示编码表
		// System.out.println(zipContents.toString()); //显示赫夫曼编码后的二进制字符串

		String originContent = decode(zipContent);
		System.out.println("解码后的字符串为: " + originContent);
	}

	// 对文件进行赫夫曼编码
	public static void zipFile(String srcFile, String destFile) {
		try {
			InputStream is = new FileInputStream(srcFile);
			byte[] content = new byte[is.available()];
			is.read(content);
			byte[] huffmanBytes = encode(content);
			OutputStream os = new FileOutputStream(destFile);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(huffmanBytes);
			oos.writeObject(encodedMap);
			System.out.println("压缩完毕");
			oos.close();
			os.close();
			is.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 对文件进行赫夫曼解码
	public static void unZipFile(String srcFile, String destFile) {
		try {
			InputStream is = new FileInputStream(srcFile);
			ObjectInputStream ois = new ObjectInputStream(is);
			byte[] bytes = (byte[]) ois.readObject();
			Map<Byte,String> map = (Map<Byte,String>) ois.readObject();
			byte[] origin = getOrigin(bytes);
			OutputStream os = new FileOutputStream(destFile);
			os.write(origin);
			System.out.println("解压完毕");
			os.close();
			ois.close();
			is.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 整个还原字符串过程
	public static String decode(byte[] bytes) {
		byte[] res = getOrigin(bytes);
		// System.out.println(Arrays.toString(res));
		return new String(res);
	}

	// 解码
	public static byte[] getOrigin(byte[] bytes) {
		StringBuilder stringBuilder = new StringBuilder();
		boolean flag = false;
		int j = 0;
		for (; j < bytes.length - 1; ++j) {
			String str = byteToString(bytes[j]);
			// System.out.println(str);
			stringBuilder.append(str);
		}
		// 最后一个字节转二进制字符串
		int last = bytes[j];
		String lastStr = Integer.toBinaryString(last);
		if (stringBuilder.length() + lastStr.length() < zipContents.length()) {
			while (stringBuilder.length() + lastStr.length() != zipContents.length()) {
				stringBuilder.append("0");
			}
		} else if (stringBuilder.length() + lastStr.length() > zipContents.length()) {
			if (last > 0) {
				last |= 256;
			}
			lastStr = Integer.toBinaryString(last);
			lastStr = lastStr.substring(lastStr.length() - 8);
		}
		stringBuilder.append(lastStr);
		// System.out.println(stringBuilder.toString());

		Map<String, Byte> map = new HashMap<>();
		for (Map.Entry<Byte, String> entry : encodedMap.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}

		List<Byte> list = new ArrayList<>();
		for (int i = 0; i < stringBuilder.length();) {
			flag = true;
			int count = 1;
			Byte b = null;

			while (flag) {
				String key = stringBuilder.substring(i, i + count);
				b = map.get(key);
				if (b == null) {
					++count;
				} else {
					flag = false;
				}
			}
			list.add(b);
			i += count;
		}
		byte[] res = new byte[list.size()];
		int count = 0;
		while (list.size() > 0) {
			res[count++] = list.remove(0);
		}
		return res;
	}

	// 字节转二进制字符串
	public static String byteToString(byte b) {
		int temp = b;
		if (temp > 0) {
			temp |= 256;
		}
		String str = Integer.toBinaryString(temp);
		return str.substring(str.length() - 8);

	}

	// 编码
	public static byte[] encode(byte[] bytes) {
		// byte[] bytes = arr.getBytes();
		// System.out.println(Arrays.toString(bytes));
		List<Data> list = getDatas(bytes);
		Data root = createHuffmanTree(list);
		Map<Byte, String> map = getCodes(root);
		bytes = getEncodedContent(bytes, map);
		return bytes;
	}

	// 统计字节串中各字符出现次数，创建对应节点，并保存到数列中
	public static List<Data> getDatas(byte[] bytes) {
		List<Data> list = new ArrayList<>();
		Map<Byte, Integer> map = new HashMap<>();
		for (byte ele : bytes) {
			if (map.containsKey(ele)) {
				map.put(ele, map.get(ele) + 1);
			} else {
				map.put(ele, 1);
			}
		}
		for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
			list.add(new Data(entry.getKey(), entry.getValue()));
		}
		return list;
	}

	// 根据数列创建赫夫曼树并返回根节点
	public static Data createHuffmanTree(List<Data> list) {
		while (list.size() > 1) {
			Collections.sort(list);
			Data leftData = list.remove(0);
			Data rightData = list.remove(0);
			Data parent = new Data(null, leftData.weight + rightData.weight);
			parent.left = leftData;
			parent.right = rightData;
			list.add(parent);
		}
		return list.get(0);
	}

	// 字节串各个字符对应的赫夫曼编码
	public static Map<Byte, String> encodedMap = new HashMap<>();

	// 获取赫夫曼树的所有子节点的赫夫曼码
	public static Map<Byte, String> getCodes(Data root) {
		if (root == null) {
			System.out.println("树为空");
			return null;
		}
		StringBuilder path = new StringBuilder();
		getCodes(root.left, path, "0");
		getCodes(root.right, path, "1");
		return encodedMap;
	}

	public static void getCodes(Data data, StringBuilder path, String str) {
		StringBuilder stringBuilder = new StringBuilder(path);
		stringBuilder.append(str);
		if (data != null) {
			if (data.data == null) {
				getCodes(data.left, stringBuilder, "0");
				getCodes(data.right, stringBuilder, "1");
			} else {
				encodedMap.put(data.data, stringBuilder.toString());
			}
		}
	}

	static StringBuilder zipContents = new StringBuilder();

	public static byte[] getEncodedContent(byte[] content, Map<Byte, String> map) {
		// StringBuilder zipContents = new StringBuilder();
		for (byte ele : content) {
			zipContents.append(map.get(ele));
		}
		// System.out.println("压缩码: " + zipContent.toString());
		// System.out.println(zipContent.length());
		int len = (zipContents.length() + 7) / 8;
		byte[] res = new byte[len];
		for (int i = 0, index = 0; i < zipContents.length(); i += 8) {
			String str = "";
			if (i + 8 > zipContents.length()) {
				str = zipContents.substring(i);
			} else {
				str = zipContents.substring(i, i + 8);
			}
			res[index++] = (byte) Integer.parseInt(str, 2);
		}
		return res;
	}

	public static void printMap() {
		for (Map.Entry<Byte, String> entry : encodedMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}

class Data implements Comparable<Data> {
	Byte data;
	int weight;
	Data left;
	Data right;

	public Data(Byte data, int weight) {
		this.data = data;
		this.weight = weight;
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
		return "Node [data=" + data + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(Data o) {
		// TODO 自动生成的方法存根
		return weight - o.weight;
	}
}