package review.stack;

public class CalculatorDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String expression = "12-11*4/11-13*10-8+130-100*2";
		int result = calculator(20,20,expression);
		System.out.println("结果为"+result);
	}
	
	public static int calculator(int numSize, int operSize, String expression) {
		StackDemo numStack = new StackDemo(numSize); //数字栈
		StackDemo operStack = new StackDemo(operSize); //符号栈
		int index=0;
		int num1=0;
		int num2=0;
		int oper=0;
		int res=0;
		while(true) {
			if(index==expression.length()) {
				break;
			}
			char c = expression.substring(index, index+1).charAt(0);
			index++;
			if(operStack.isOper(c)) {
				if(operStack.isEmpty()) {
					operStack.push(c);
				}else {
					if(operStack.priority(c)>operStack.priority(operStack.peak())) {
						operStack.push(c);
					}else {
						while(!operStack.isEmpty()&&operStack.priority(c)<=operStack.priority(operStack.peak())) {
							num2=numStack.pop();
							num1=numStack.pop();
							oper=operStack.pop();
							res = numStack.calculation(num1,num2,oper);
							numStack.push(res);
						}
						operStack.push(c);
					}
				}
			}else {
				String str = String.valueOf(c);
				while(index!=expression.length()&&!numStack.isOper(expression.substring(index, index+1).charAt(0))) {
					str += expression.substring(index, index+1);
					++index;
				}
				
				if(!operStack.isEmpty()&&operStack.peak()=='-') {
					operStack.pop();
					operStack.push('+');
					numStack.push(-Integer.parseInt(str));
				}else {
					numStack.push(Integer.parseInt(str));
				}
			}
		}
		
		while(true) {
			if(operStack.isEmpty()) {
				break;
			}
			num2=numStack.pop();
			num1=numStack.pop();
			oper=operStack.pop();
			res=numStack.calculation(num1, num2, oper);
			numStack.push(res);		
		}
		return res;
	}
}

class StackDemo{
	private int top;
	private int[] stack;
	private int size;
	
	public StackDemo(int size) {
		this.size=size;
		this.stack = new int[size];
		this.top=-1;
	}
	
	public void push(int oper) {
		if(isFull()) {
			System.out.println("栈已满");
			return;
		}
		top++;
		stack[top]=oper;
	}
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("栈为空");
		}
		return stack[top--];
	}
	public int peak() {
		return stack[top];
	}
	public boolean isFull() {
		return top==size-1;
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public boolean isOper(int oper) {
		return priority(oper)!=-1;
	}
	public int priority(int oper) {
		if(oper=='*'||oper=='/') {
			return 2;
		}else if(oper=='-') {
			return 1;
		}else if(oper=='+') {
			return 0;
		}else {
			return -1;
		}
	}
	public int calculation(int num1, int num2, int oper) {
		int res=0;
		if(oper=='+') {
			res = num1+num2;
		}else if(oper=='-') {
			res=num1-num2;
		}else if(oper=='*') {
			res=num1*num2;
		}else {
			res=num1/num2;
		}
		return res;
	}
}