package pri.algorithms;

import java.util.Arrays;

public class KMPAlgorithmDemo {

	public static void main(String[] args) {
		String str = "BBC ABCDAB ABCDABCDABDE";
		String substr = "ABCDABD";
		int[] next = kmpNext(substr);
		System.out.println(Arrays.toString(next));
		System.out.println(kmpSearch(str,substr,next));
				

	}
	
	public static int kmpSearch(String s1, String s2, int[] next) {
		for(int i=0,j=0;i<s1.length();++i) {
			while(j>0&&s1.charAt(i)!=s2.charAt(j)) {
				//kmp算法核心点
				j = next[j-1];
				//j--;
			}
			if(s1.charAt(i)==s2.charAt(j)) {
				j++;
			}
			if(j==s2.length()) {
				return i-j+1;
			}
		}
		return -1;
	}
	
	public static int[] kmpNext(String patternStr) {
		int[] next = new int[patternStr.length()];
		next[0] = 0;
		
		
		//指针i遍历字符串字符，指针j指向数组第一个字符
		for(int i=1,j=0;i<patternStr.length();++i) {
			
			//不相等时回溯
			while(j>0&&patternStr.charAt(i)!=patternStr.charAt(j)) {
				//kmp算法核心点
				j = next[j-1];
				//j--;
			}
			//当两个值相等时，部分匹配值加一
			if(patternStr.charAt(i)==patternStr.charAt(j)) {
				++j;
			}
			next[i] = j;
		}
		return next;
	}
}
