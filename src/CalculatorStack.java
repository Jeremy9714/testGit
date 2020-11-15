
public class CalculatorStack {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str = "7+3*2+6-9/3+2";
		int result = calculator(10,10,str);
		System.out.printf("表达式%s的值为%d\n",str,result);
	}
	
	//计算方法
	public static int calculator(int numSize, int opSize, String expression) {
		ArrayStack2 numStack = new ArrayStack2(numSize);
		ArrayStack2 opStack = new ArrayStack2(opSize);
		int index=0;//当前指向的字符
		int num1=0;
		int num2=0;
		int oper=0;
		int res=0;//结果
		char ch=' ';//字符用于保存当前操作符
		while(true) {
			//读到最后一位字符后结束循环
			if(index==expression.length()) {
				break;
			}
			//当前操作符
			ch=expression.substring(index,index+1).charAt(0);
			index++; //指针向后移动一位
			
			//判断操作符是否为运算符
			if(opStack.isOper(ch)) {
				//判断运算符栈是否为空
				if(!opStack.isEmpty()) {
					//比较运算符和栈中最顶端运算符的优先级
					if(opStack.priority(ch)<opStack.priority(opStack.peak())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = opStack.pop();
						res = numStack.cal(num1, num2, oper);
						numStack.push(res);//结果入栈
						if(opStack.priority(ch)<opStack.priority(opStack.peak())) {
							num1 = numStack.pop();
							num2 = numStack.pop();
							oper = opStack.pop();
							res = numStack.cal(num1, num2, oper);
							numStack.push(res);
						}
					}
					//opStack.push(ch);
				}
				opStack.push(ch);//运算符入栈
			}else {//若字符为数字，直接入栈
				numStack.push(ch-'0');
				//System.out.println("so far so good");
			}
		}
		
		//字符串解析完毕后，对两个栈进行计算
		while(true) {
			//当运算符栈为空时，结束运算
			if(opStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = opStack.pop(); 
			res = numStack.cal(num1, num2, oper);
			//System.out.println(res);
			numStack.push(res);
		}
		return res;
	}
}

class ArrayStack2{
	private int size;
	private int[] stack;
	private int top = -1;
	
	public ArrayStack2(int size) {
		this.size = size;
		stack = new int[this.size];
	}
	public boolean isFull() {
		return top==size-1;
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public void push(int value) {
		if(isFull()) {
			System.out.println("栈已满,无法添加");
			return;
		}
		top++;
		stack[top] = value;
	}
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("栈为空,无法取出");
		}
		return stack[top--];
	}
	public void showStack() {
		if(isEmpty()) {
			System.out.println("栈为空，没有数据");
			return;
		}
		for(int i=top;i>=0;--i) {
			System.out.printf("stack[%d]的数据为: %d \n",i,stack[i]);
		}			
	}
	public int peak() {
		return stack[top];
	}
	//计算运算符的由优先级
	public int priority(int oper) {
		if(oper=='*'||oper=='/')
			return 2;
		else if(oper=='-')
			return 1;
		else if(oper=='+')
			return 0;
		else
			return -1;
	}
	//判断操作符是否是一个运算符
	public boolean isOper(char val) {
		return priority(val)!=-1;
	}
	//计算方法
	public int cal(int num1, int num2, int oper) {
		int res=0;
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2/num1;
			break;
		default:
			break;
		}
		return res;
	}
}