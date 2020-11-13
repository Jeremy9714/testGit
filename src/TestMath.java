import java.text.*;
import java.math.BigDecimal;

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
		
		{
			//三角函数方法
			System.out.println(Math.PI);
			System.out.println(Math.sin(Math.PI/2));
			System.out.println(Math.cos(0));
			System.out.println(Math.tan(Math.PI/3));
			System.out.println(Math.toRadians(120.0));
			System.out.println(Math.toDegrees(Math.PI));
			
			//指数函数方法
			System.out.println(Math.exp(2));
			System.out.println(Math.log(2));
			System.out.println(Math.log10(10));
			System.out.println(Math.sqrt(2));
			System.out.println(Math.cbrt(8));
			System.out.println(Math.pow(2, 3));
			
			//取整函数方法
			System.out.println(Math.ceil(2.5));
			System.out.println(Math.floor(2.5));
			System.out.println(Math.rint(3.5));
			System.out.println(Math.round(2.5f)); //四舍五入
		}
		
		{
			BigDecimalDemo b = new BigDecimalDemo();
			System.out.println(b.add(-7.5, 8.9));
			System.out.println(b.sub(-7.5, 8.9));
			System.out.println(b.mul(-7.5, 8.9));
			System.out.println(b.div(10, 2));	//保留十位小数
			System.out.println(b.div(-7.5, 8.9, 5));
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
class BigDecimalDemo{
	static final int location =10;
	BigDecimal add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2);
	}
	BigDecimal sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2);
	}
	BigDecimal mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2);
	}
	BigDecimal div(double v1, double v2) {
		return div(v1,v2,location);
	}
	BigDecimal div(double v1, double v2, int b) {
		if(b<0) System.out.println("b值必须大于0");
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2,b,BigDecimal.ROUND_HALF_UP);
	}
}