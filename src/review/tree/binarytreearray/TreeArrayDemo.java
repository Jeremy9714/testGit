package review.tree.binarytreearray;

public class TreeArrayDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {1,2,3,4,5,6,7};
		BinaryTreeArray treeArray = new BinaryTreeArray(arr);
		treeArray.preOrder(0);
		System.out.println();
		treeArray.infixOrder(0);
		System.out.println();
		treeArray.postOrder(0);
		System.out.println();
	}
}

class BinaryTreeArray{
	private int[] arr;
	
	public BinaryTreeArray(int [] arr) {
		this.arr = arr;
	}
	
	public void preOrder(int index) {
		if(arr.length==0) {
			System.out.println("数组为空");
			return;
		}
		System.out.print(arr[index]+" ");
		index*=2;
		if(index+1<arr.length) {
			preOrder(index+1);
		}
		if(index+2<arr.length) {
			preOrder(index+2);
		}
	}
	public void infixOrder(int index) {
		if(arr.length==0) {
			System.out.println("数组为空");
			return;
		}
		if(index*2+1<arr.length) {
			infixOrder(index*2+1);
		}
		System.out.print(arr[index]+" ");
		if(index*2+2<arr.length) {
			infixOrder(index*2+2);
		}
	}
	public void postOrder(int index) {
		if(arr.length==0) {
			System.out.println("数组为空");
			return;
		}
		if(index*2+1<arr.length) {
			postOrder(index*2+1);
		}
		if(index*2+2<arr.length) {
			postOrder(index*2+2);
		}
		System.out.print(arr[index]+" ");
	}
}