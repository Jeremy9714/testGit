package review.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RPNDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str = "14 + ( ( 12 + 3 ) * 10 ) - 25 * 2";
		String s = "14.11+((12.3+3)*10.32)-25*2.7";
		List<String> infixList = getInfixArray(str);
		System.out.println(infixList);

		List<String> ls = getInfixList(s);
		System.out.println(ls);

		List<String> suffix = getSuffixList(ls);
		System.out.println(suffix);

		double result = calculate(suffix);
		System.out.println(result);

	}

	// 获取中缀字符串
	public static List<String> getInfixArray(String exp) {
		List<String> list = new ArrayList<>();
		String[] split = exp.split(" ");
		for (String ele : split) {
			list.add(ele);
		}
		return list;
	}

	// 中缀表达式中的元素保存到数组
	public static List<String> getInfixList(String exp) {
		List<String> ls = new ArrayList<String>();
		char ch = ' ';
		int index = 0;
		String str = "";

		do {
			if ((ch = exp.charAt(index))!=46 && ((ch = exp.charAt(index)) < 48 || (ch = exp.charAt(index)) > 57)) {
				ls.add(String.valueOf(ch));
				++index;
			} else {
				while (index < exp.length() && ((ch = exp.charAt(index)) > 47 && (ch = exp.charAt(index)) < 58 || (ch = exp.charAt(index)) == 46)) {
					str += ch;
					++index;
				}
				ls.add(str);
			}
			str = "";
		} while (index < exp.length());
		return ls;
	}

	// 中缀表达式数组转后缀表达式数组
	public static List<String> getSuffixList(List<String> infix) {
		Stack<String> stack = new Stack<>();
		List<String> list = new ArrayList<String>();

		if (infix.size() == 0) {
			throw new RuntimeException("表达式为空");
		}
		for (String item : infix) {
			if (item.matches("\\d+.?\\d*")) {
				list.add(item);
			} else if (item.equals("(")) {
				stack.push(item);
			} else if (item.equals(")")) {
				while (!stack.peek().equals("(")) {
					list.add(stack.pop());
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && !stack.peek().equals("(") && priority(item) <= priority(stack.peek())) {
					list.add(stack.pop());
				}
				stack.push(item);
			}
		}

		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
	}

	// 后缀表达式计算
	public static double calculate(List<String> suffix) {
		Stack<String> stack = new Stack<>();
		for (String item : suffix) {
			if (item.matches("\\d+.?\\d*")) {
				stack.push(item);
			} else {
				double num2 = Double.parseDouble(stack.pop());
				double num1 = Double.parseDouble(stack.pop());
				double res = 0;
				if (item.equals("+")) {
					res = num1 + num2;
				} else if (item.equals("-")) {
					res = num1 - num2;
				} else if (item.equals("*")) {
					res = num1 * num2;
				} else if (item.equals("/")) {
					res = num1 / num2;
				} else {
					throw new RuntimeException("无效的符号");
				}
				stack.push(String.valueOf(res));
			}
		}
		return Double.parseDouble(stack.pop());
	}

	// 运算符优先级
	public static int priority(String oper) {
		int res = 0;
		switch (oper) {
		case "+":
			res = 1;
			break;
		case "-":
			res = 1;
			break;
		case "*":
			res = 2;
			break;
		case "/":
			res = 2;
			break;
		default:
			System.out.println("错误的运算符");
			break;
		}
		return res;
	}
}
