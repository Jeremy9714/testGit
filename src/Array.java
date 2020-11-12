import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int day[] = new int[] {31,29,31,30,31,30,31,31,30,31,30,31};
		for(int i=0;i<day.length;++i)
			System.out.println((i+1)+"月有"+day[i]+"天");
		
		final int ROW =3, COL =4;
		int num = 0;
		int a[][] = new int[ROW][COL];
		for(int i=0;i<ROW;++i) {
			for(int j=0;j<COL;++j) {
				a[i][j] = num;
				num++;
			}
		}
		System.out.println(Arrays.deepToString(a));
	}

}
