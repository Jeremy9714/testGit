package review.algorithms;

import java.util.Arrays;

public class KMPAlgorithm {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str = "BBC ABCDAB ABCDABCDABDE";
		String substr = "ABCDABD";
		int[] next = getNext(substr);
		int index = kmp(str, substr, next);
		System.out.println(Arrays.toString(next));
		System.out.println(index);
	}

	public static int kmp(String str, String sub, int[] next) {
		for (int i = 0, j = 0; i < str.length(); ++i) {
			while (j > 0 && str.charAt(i) != sub.charAt(j)) {
				j = next[j - 1];
			}
			if (str.charAt(i) == sub.charAt(j)) {
				j++;
			}
			if (j == sub.length()) {
				return i - j + 1;
			}
		}
		return -1;
	}

	public static int[] getNext(String str) {
		int[] next = new int[str.length()];
		next[0] = 0;
		for (int i = 1, j = 0; i < next.length; ++i) {
			while (j > 0 && str.charAt(i) != str.charAt(j)) {
				j = next[j - 1];
			}
			if (str.charAt(i) == str.charAt(j)) {
				++j;
			}
			next[i] = j;
		}
		return next;
	}
}
