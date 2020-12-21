package review.tree.huffmantree;

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
		byte[] zipContent = encode(str);
		System.out.println("赫夫曼编码后的字节串为: " + Arrays.toString(zipContent));
		//System.out.println((byte)Integer.parseInt("1111110", 2));
		String originContent = decode(zipContent);
		System.out.println("解码后的字符串为: " + originContent);
	}
	
	//整个还原字符串过程
	public static String decode(byte[] bytes) {
		byte[] res = getOrigin(bytes);
		//System.out.println(Arrays.toString(res));
		return new String(res);
	}
	
	//解码
	public static byte[] getOrigin(byte[] bytes) {
		StringBuilder stringBuilder = new StringBuilder();
		boolean flag=false;
		for(int i=0;i<bytes.length;++i) {
			flag=(i==bytes.length-1);
			String str = byteToString(bytes[i],!flag);
			//System.out.println(str);
			stringBuilder.append(str);
		}
		//System.out.println(stringBuilder.toString());
		
		Map<String,Byte> map = new HashMap<>();
		for(Map.Entry<Byte, String> entry:encodedMap.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}
		
		List<Byte> list = new ArrayList<>();
		for(int i=0;i<stringBuilder.length();) {
			flag=true;
			int count=1;
			Byte b = null;
			
			while(flag) {
				String key = stringBuilder.substring(i, i+count);
				b=map.get(key);
				if(b==null) {
					++count;
				}else {
					flag=false;
				}
			}
			list.add(b);
			i+=count;
		}
		byte[] res = new byte[list.size()];
		int count=0;
		while(list.size()>0) {
			res[count++]=list.remove(0);
		}
		return res;
	}
	//字节转二进制字符串
	public static String byteToString(byte b,boolean flag) {
		int temp = b;
		if(flag&&temp>0) {
			temp|=256;
		}
		String str = Integer.toBinaryString(temp);
		if(!flag) {
			return str;
		}else {
			return str.substring(str.length()-8);
		}
	}
	
	//编码
	public static byte[] encode(String arr) {
		byte[] bytes = arr.getBytes();
		//System.out.println(Arrays.toString(bytes));
		List<Data> list = getDatas(bytes);		
		Data root = createHuffmanTree(list);
		Map<Byte,String> map = getCodes(root);
		bytes = getEncodedContent(bytes,map);
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
	
	//字节串各个字符对应的赫夫曼编码
	public static Map<Byte,String> encodedMap = new HashMap<>();
	//获取赫夫曼树的所有子节点的赫夫曼码
	public static Map<Byte,String> getCodes(Data root) {
		if(root==null) {
			System.out.println("树为空");
			return null;
		}
		StringBuilder path = new StringBuilder();
		getCodes(root.left,path,"0");
		getCodes(root.right,path,"1");
		return encodedMap;
	}	
	public static void getCodes(Data data, StringBuilder path, String str) {
		StringBuilder stringBuilder = new StringBuilder(path);
		stringBuilder.append(str);
		if(data !=null) {
			if(data.data==null) {
				getCodes(data.left,stringBuilder,"0");
				getCodes(data.right,stringBuilder,"1");
			}else {
				encodedMap.put(data.data, stringBuilder.toString());
			}
		}
	}
	
	public static byte[] getEncodedContent(byte[] content,Map<Byte,String> map) {
		StringBuilder zipContent = new StringBuilder();
		for(byte ele:content) {
			zipContent.append(map.get(ele));
		}
		//System.out.println(zipContent.length());
		int len = (zipContent.length()+7)/8;
		byte[] res = new byte[len];
		for(int i=0,index=0;i<zipContent.length();i+=8) {
			String str="";
			if(i+8>zipContent.length()) {
				str=zipContent.substring(i);
			}else {
				str=zipContent.substring(i,i+8);
			}
			res[index++]= (byte) Integer.parseInt(str, 2);
		}
		return res;
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