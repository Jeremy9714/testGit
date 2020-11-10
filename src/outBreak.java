
public class outBreak {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Loop:for(int i = 0; i<6; ++i) {
			for (int j = 0; j<6; ++j) {
				if (j==4) break Loop;
				System.out.println("i: " + i + " j: " + j);
			}
		}
	}

}
