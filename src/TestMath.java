import java.text.*;
public class TestMath {

	public static void main(String[] args) {
		// DecimalFormat类
		{
			DecimalFormatDemo.SimgleFormat("###,###.###", 123456.78);
			DecimalFormatDemo.SimgleFormat("0.00\u2030", 123456.78);
			DecimalFormatDemo.UseApplyFormat("###.00%", 123456.78);
			DecimalFormat myFormat = new DecimalFormat();
			myFormat.setGroupingSize(1); //小数点前每过n位为一组
			System.out.println(myFormat.format(123456.789));
			myFormat.setGroupingUsed(false);
			System.out.println(myFormat.format(123456.789));//是否支持分组
		}
	}

}

class DecimalFormatDemo{
	public static void SimgleFormat(String pattern, double value) {
		DecimalFormat myFormat = new DecimalFormat(pattern);
		String result = myFormat.format(value);
		System.out.println(value+" "+pattern+" "+result);
	}
	public static void UseApplyFormat(String pattern, double value) {
		DecimalFormat myFormat = new DecimalFormat();
		myFormat.applyPattern(pattern);
		System.out.println(value+" "+pattern+" "+myFormat.format(value));
	}
}