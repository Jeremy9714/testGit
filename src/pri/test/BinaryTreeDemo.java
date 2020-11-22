package pri.test;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7};
		ArrayBinaryTree binaryTree = new ArrayBinaryTree(arr);
		binaryTree.preOrder();

	}

}

class ArrayBinaryTree{
	private int[] arr;
	public ArrayBinaryTree(int[] arr) {
		this.arr = arr;
	}
	
	public void preOrder() {
		this.preOrder(0);
	}
	
	public void preOrder(int index) {
		if(arr==null||arr.length==0) {
			System.out.println("数组为空，遍历失败");
		}
		System.out.println(arr[index]);
		if(index*2+1<arr.length) {
			preOrder(index*2+1);
		}
		if(index*2+2<arr.length) {
			preOrder(index*2+2);
		}
	}
}
