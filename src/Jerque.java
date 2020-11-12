import java.util.regex.*;
public class Jerque {

	public static void main(String[] args) {
		String str = "";
		long starTime = System.currentTimeMillis();
		for(int i=0;i<10000;++i) {
			str+=i;
		}
		long endTime = System.currentTimeMillis();
		long time = endTime - starTime;
		System.out.println("消耗时间"+time);
		
		StringBuilder builder = new StringBuilder("");			//创建字符串生成器
		starTime = System.currentTimeMillis();
		for(int i=0;i<10000;++i) {
			builder.append(i);
		}
		endTime = System.currentTimeMillis();
		time = endTime - starTime;
		System.out.println("消耗时间"+time);
		//System.out.println(builder.toString());
		
		//insert(int offset, arg)方法
		StringBuilder bf = new StringBuilder("hello");
		bf.insert(5, "world");
		System.out.println(bf.toString());
		
		//delete(int start, int end)方法
		StringBuilder sb = new StringBuilder("StringBuilder");
		sb.delete(0, 6);
		System.out.println(sb.toString());
		{
			//课后练习
			String t1 = "hello";
			System.out.println(t1.toUpperCase());
			String t2 = "HELLO";
			System.out.println(t2.toLowerCase());
			String t3 = new String("helloworld");
			String t4 = t3.substring(0,5);
			if(t1.equals(t4))
				System.out.println("两个子串相同");
			else
				System.out.println("两个子串不相同");
			
			String regx = "\\d{11}";
			String t5 = "13075312889";
			if(t5.matches(regx))
				System.out.println("合法的手机号");
			
			StringBuilder generator = new StringBuilder("");
			for(int i = 0; i<11;++i)
				generator.append(i);
			System.out.println(generator.toString());
		}
	}

}
