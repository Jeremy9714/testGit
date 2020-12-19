package review.queue;
/**
 * 
 * @author Chenyang
 * 环形队列
 */
public class CircleQueueDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
	}

}
//环形队列
class CircleQueue{
	private int maxSize; //队列的体积
	private int front; //头指针指向队列头部的元素
	private int rear; //尾指针指向队列最后一个元素的后一个位置
	private int[] arr; //存放数值
	
	public CircleQueue(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
	}
	//入队列
	public void addItem(int item) {
		if(isFull()) {
			System.out.println("队列已满");
			return;
		}
		arr[rear]=item;	
		rear=(rear+1)%maxSize;
	}
	//出队列
	public int getItem() {
		if(isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		int res = arr[front];
		//arr[front++]=0;
		front=(front+1)%maxSize;
		return res;
	}
	//遍历队列
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("队列为空");
			return;
		}
		for(int i=front;i<front+getSize();++i) {
			System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
		}
	}
	//显示队列的头数据
	public int getFront() {
		if(isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return arr[front];
	}
	//判断队列是否已满
	public boolean isFull() {
		return (rear+1)%maxSize==front;
	}
	//判断队列是否为空
	public boolean isEmpty() {
		return rear==front;
	}
	//队列元素的个数
	public int getSize() {
		return (rear+maxSize-front)%maxSize;
	}
}
