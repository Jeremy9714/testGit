
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
	}

}
