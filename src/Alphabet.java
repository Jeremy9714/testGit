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
	}

}
