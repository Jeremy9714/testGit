import java.util.Date;
public class Regular {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String A = new String("192.168.0.1");
		String[] firstArray = A.split("\\.");
		for (String a:firstArray) System.out.println(a);
		
		String[] secondArray = A.split("\\.", 2);
		for (String a:secondArray) System.out.println(a);
		{
			Date date = new Date();
			String str = String.format("%te", date);
			System.out.println("today is: " + str);
			String calender = String.format("%tT", date);
			System.out.println(calender);
			String time = String.format("%tc", date);
			System.out.println(time);
			String form = String.format("%tF", date);
			System.out.println(form);
		}

		{
			String str3 = String.format("%d", 200/2);
			String str4 = String.format("%b", 3>5);
			String str5 = String.format("%x", 400);
			System.out.println(str3 + "\t" + str4 + "\t" + str5);
			String str6 = String.format("%b", 0);//java中不能用0和1作为布尔值
			System.out.println(str6);
		}
	}

}
