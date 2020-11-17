package pri.test;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class CalculatorDemo {

	public static void main(String[] args) {
		// 后缀表达式
		
		String str="14+((12+3)*10)-25";
		List<String> infix = toInfixExpression(str);
		System.out.println(infix);
		List<String> suffix = toSuffixExpression(infix);	
		System.out.println(suffix);
		System.out.println(cal(suffix));
		//System.exit(0);
			
		String suffixExpression = "4 * 5 + 30 - 6 / 2";
		List<String> list = getArrayList(suffixExpression);
		System.out.println("数组列表为:"+list);
		System.out.println(cal(list));
	}
	
	//将后缀表达式中的字符取出
	public static List<String> getArrayList(String exp){
		String[] str = exp.split(" ");
		List<String> list = new ArrayList<String>();
		for(String ele:str) {
			list.add(ele);
		}
		return list;
	}
	//计算后缀表达式
	public static int cal(List<String> list) {
		//存储数字的栈
		Stack<String> stack = new Stack<String>();
		//遍历列表
		for(String item: list) {
			//若元素为数字则压入栈中
			if(item.matches("\\d+")) {
				stack.push(item);
			}else {
				//若元素为运算符，则取出栈顶两个数字
				//进行运算，后弹出的数组用作第一个因数
				//得到的结果再压入栈中
				int num2=Integer.parseInt(stack.pop());
				int num1=Integer.parseInt(stack.pop());
				int res=0;
				if(item.equals("+")) {
					res = num1+num2;
				}else if(item.equals("-")) {
					res = num1-num2;
				}else if(item.equals("*")) {
					res = num1*num2;
				}else if(item.equals("/")) {
					res = num1/num2;
				}else {
					throw new RuntimeException("无效的符号");
				}
				//压入之前要进行类型转换
				stack.push(String.valueOf(res));
			}
		}
		//返回结果
		return Integer.parseInt(stack.pop());
	}
	//将中缀字符串中的元素保存到数组列表
	public static List<String> toInfixExpression(String exp) {
		int index=0;
		char ch;
		String s;//用来存储多位数
		List<String> ls = new ArrayList<String>();
		do {
			//当指向运算符时
			if((ch=exp.charAt(index))<48||(ch=exp.charAt(index))>57) {
				ls.add(String.valueOf(ch));
				index++;
			}else {//指向数字时
				s="";
				while(index<exp.length()&&(ch=exp.charAt(index))>=48&&(ch=exp.charAt(index))<=57) {
					s+=ch;
					index++;
				}
				ls.add(s);
			}
		}while(index<exp.length());
		
		return ls;
	}
	
	//中缀表达式转后缀表达式
	public static List<String> toSuffixExpression(List<String> ls){
		Stack<String> stack = new Stack<String>();
		List<String> suffix = new ArrayList<String>();
		
		if(ls.size()==0) {
			throw new RuntimeException("表达式为空");
			}
		
		for(String item:ls) {
			if(item.matches("\\d+")) {
				suffix.add(item);
			}else if(item.equals("(")){
				stack.push(item);
			}else if(item.equals(")")) {
				while(!stack.peek().equals("(")) {
					suffix.add(stack.pop());
				}
				//丢弃左括号
				stack.pop();
			}else {		
				//当栈不为空、栈顶元素不为左括号且栈顶运算符优先级小于等于当前运算符的优先级时
				//弹出栈顶元素并加入队列
				while(stack.size()!=0&&!stack.peek().equals("(")&&priority(stack.peek())<=priority(item)) {
					suffix.add(stack.pop());
				}
				stack.push(item);
			}
			//System.out.print(ls+"\t");
			//System.out.println("当前字符串为：" + item);
			//System.out.println("符号栈为：" + stack);
			//System.out.println("数列为：" + suffix);
			//System.out.println();
		}
		while(stack.size()!=0) {
			suffix.add(stack.pop());
		}
		return suffix;
	}
	
	public static int priority(String op) {
		int res=0;
		switch(op) {
		case "+":
			res=1;
			break;
		case "-":
			res=1;
			break;
		case "*":
			res=2;
			break;
		case "/":
			res=2;
			break;
		default:
			System.out.println("错误的运算符");
			break;
		}
		return res;
	}
	 
}
