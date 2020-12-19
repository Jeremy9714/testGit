package review.queue;

import java.util.Scanner;

public class QueueDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Queue queue = new Queue(5);
		char key =' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("输入s显示队列");
			System.out.println("输入e退出程序");
			System.out.println("输入i添加元素");
			System.out.println("输入g取出元素");
			System.out.println("输入f显示队首元素");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'e':
				scanner.close();
				loop=false;
				break;
			case 'i':
				System.out.println("请输出要添加的数值");
				int num = scanner.nextInt();
				queue.addItem(num);
				break;
			case 'g':
				try {
					int res = queue.getItem();
					System.out.println(res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'f':
				try {
					int res = queue.getFront();
					System.out.println(res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				break;
			}
		}
		System.out.println("退出程序");
	}
}

//队列
class Queue{
	private int maxSize; //队列的体积
	private int front; //头指针
	private int rear; //尾指针
	private int[] arr; //存放数值
	
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
		this.front = -1; //头指针指向队列头部的前一个位置
		this.rear = -1; //尾指针指向队列最后一个元素
	}
	//入队列
	public void addItem(int item) {
		if(isFull()) {
			System.out.println("队列已满");
			return;
		}
		++rear;
		arr[rear]=item;	
	}
	//出队列
	public int getItem() {
		if(isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		front++;
		int res = arr[front];
		arr[front]=0;
		return res;
	}
	//遍历队列
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("队列为空");
			return;
		}
		for(int i=0;i<arr.length;++i) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}
	//显示队列的头数据
	public int getFront() {
		if(isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return arr[front+1];
	}
	//判断队列是否已满
	public boolean isFull() {
		return rear==maxSize-1;
	}
	//判断队列是否为空
	public boolean isEmpty() {
		return rear==front;
	}
	public int getSize() {
		return arr.length;
	}
}
