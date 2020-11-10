import java.lang.IndexOutOfBoundsException;
import java.util.Scanner;
public class ArrayQueueDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ArrayQueue arr = new ArrayQueue(5);
		Boolean loop = true;
		Scanner input = new Scanner(System.in);
		char key = ' ';
		while(loop) {
			System.out.println("which option you want to take?");
			key = input.next().charAt(0);
			switch(key) {
			case 'a':
				try {
					System.out.println("plz enter a number.");
					int num = input.nextInt();
					arr.addQueue(num);
				} catch(Exception e) {
					System.out.println(e);
				}
				break;
			case 'r':
				arr.removeQueue();
				break;
			case 'd':
				arr.display();
				break;
			case 'h':
				System.out.println(arr.headQueue());
				break;
			case 't':
				System.out.println(arr.tailQueue());
				break;
			case 's':
				System.out.println(arr.queueSize());
				break;
			case 'q':
				loop = false;
				break;
			default:
				break;
			}
			System.out.println();
		}while(!loop);
	}

}

//队列
class ArrayQueue{
	private int ele;
	private int front;
	private int rear;
	private int[] queue;
	
	public ArrayQueue(int size) {
		queue = new int[size];
		front = -1;
		rear = -1;
	}
	
	public void addQueue(int num) {
		if(isFull()) {
			throw new IndexOutOfBoundsException("队列已满");
		}
		if(isEmpty()) {
			front = 0;
		}
		if(rear == queue.length -1) {
			rear =-1;
		}
		queue[++rear] = num;
		++ele;
	}
	
	public void removeQueue() {
		if(isEmpty()) {
			System.out.println("队列已空");
		}
		if(front == queue.length) {
			front = 0;
		}
		queue[front] = -1;
		++front;
		--ele;
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("队列为空");
		}
		for (int i:queue) {
			if(i == -1) {
				System.out.println("X ");
			}else
				System.out.println(i + " ");
		}
	}
	
	public int headQueue() {
		if (isEmpty()) {
			System.out.println("队列为空");
			return 0;
		}
		return queue[front];
	}
	
	public int tailQueue() {
		if (isEmpty()) {
			System.out.println("队列为空");
			return -1;
		}
		return queue[rear];
	}
	
	public int queueSize() {
		return ele;
	}
	
	public Boolean isEmpty() {
		return ele == 0;
	}
	
	public Boolean isFull() {
		return ele==queue.length;
	}
	
}