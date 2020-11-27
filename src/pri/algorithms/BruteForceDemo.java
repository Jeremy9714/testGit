package pri.algorithms;

public class BruteForceDemo {

	public static void main(String[] args) {
		String str1 = "硅硅谷 尚硅谷你尚硅尚硅谷你尚硅谷你尚硅你好";
		String str2 = "尚硅谷你尚硅你";
		System.out.println(BruteForce(str1,str2));

	}
	
	public static int BruteForce(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int s1Len = c1.length;
		int s2Len = c2.length;
		int ptr1=0;
		int ptr2=0;
		
		while(ptr1<s1Len&&ptr2<s2Len) {
			if(c1[ptr1]==c2[ptr2]) {
				ptr1++;
				ptr2++;
			}else {
				ptr1 = ptr1-(ptr2-1);
				ptr2=0;
			}
		}
		if(ptr2==s2Len) {
			return ptr1-ptr2;
		}else {
			return -1;
		}
	}
}
