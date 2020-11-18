package pri.test;
import java.io.*;

public class IODemo {

	public static void main(String[] args) {
		Task1();
		System.out.println();
		Task2();
		
	}
	
	public static void Task2() {
		File file = new File("test.txt");
		try {
			FileOutputStream output = new FileOutputStream(file);
			byte[] content = "这是一句话".getBytes();
			output.write(content);
			output.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			FileInputStream input = new FileInputStream(file);
			byte[] result = new byte[1000];
			int len = input.read(result);
			System.out.println("文件中的信息为: \n" + new String(result,0,len));
			input.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public static void Task1() {
		File file = new File("D:/Desktop/","test.txt");
		if(file.exists()) {
			file.delete();
			System.out.println("原文件已删除");
		}else {
			try {
				file.createNewFile();
				System.out.println("文件已创建");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		file.delete();
		file = new File("test.txt");
		if(file.exists()) {
			String name = file.getName();
			long length = file.length();
			boolean hidden = file.isHidden();
			System.out.printf("文件名:%s, 文件大小:%s, 文件是否被隐藏: %s",name, length, hidden);
		}else {
			System.out.println("文件不存在");
		}		
	}

}
