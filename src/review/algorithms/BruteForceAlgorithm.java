package review.algorithms;

public class BruteForceAlgorithm {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
		String substr = "尚硅谷你尚硅你";
		int index = bruteForce(str,substr);
		System.out.println(index);
	}
	
	public static int bruteForce(String string, String subString){
		char[] str = string.toCharArray();
		char[] sub = subString.toCharArray();
		int strLen = str.length;
		int subLen = sub.length;
		int ptr1=0;
		int ptr2=0;
		while(ptr1<strLen && ptr2<subLen) {
			if(str[ptr1]==sub[ptr2]) {
				++ptr1;
				++ptr2;
			}else {
				ptr1=ptr1-ptr2+1;
				ptr2=0;
			}
		}
		if(ptr2==subLen) {
			return ptr1-ptr2;
		}else {
			return -1;
		}
	}
}
