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
		}
	}

}
