/**
 * 字符串操作
 * @author Chenyang
 *
 */
public class Alphabet {

	public static void main(String[] args) {
		// indexOf & lastIndexOf 
		String s = new String("university");
		String str = "ver";
		System.out.println(s.length()+"\t"+s.indexOf(str));        
		System.out.println(s.lastIndexOf("i"));
		System.out.println(s.lastIndexOf(""));	//lastIndexOf()方法参数为空字符串时，返回字符串长度
		System.out.println(s.charAt(2));
		String newstring = s.replace("i", "ii");
		//str.trim() 
		System.out.println(newstring);
		
		String A = new String("hello");
		String B = new String("hello");
		System.out.println((A==B) + "\t" + A.equals(B));
	}

}
