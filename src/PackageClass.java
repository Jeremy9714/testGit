
public class PackageClass {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str[] = {"89","12","10","18","35"};
		int sum = 0;
		for(String i:str) {
			int temp = Integer.parseInt(i);
			sum+=temp;
		}
		System.out.println(sum);
		Integer in = new Integer("34");
		System.out.println(in.intValue());
		System.out.println(in.toString());
		Integer in2 = Integer.valueOf("55");
		System.out.println(in2.intValue());
		
		String str1 = Integer.toString(456);
		String str2 = Integer.toBinaryString(456);
		String str3 = Integer.toHexString(456);
		String str4 = Integer.toOctalString(456);
		System.out.println("十进制"+str1);
		System.out.println("二进制"+str2);
		System.out.println("十六进制"+str3);
		System.out.println("八十进制"+str4);
		
		int maxint = Integer.MAX_VALUE; //int类型的最大值
		int minint = Integer.MIN_VALUE; //int类型的最小值
		int sizeint = Integer.SIZE; //int值的位数
		System.out.println(maxint +"\t"+minint+"\t"+sizeint);
		
		//Boolean类
		Boolean b1 = new Boolean("true");
		System.out.println(b1.booleanValue());
		
		//Character类
		Character mychar1 = new Character('A');
		Character mychar2 = new Character('a');
		System.out.println(mychar1+"是大写字母吗？ "+Character.isUpperCase(mychar1));
		System.out.println(mychar2+"是小写字母吗？ "+Character.isLowerCase(mychar2));
	}

}
