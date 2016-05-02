import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;


public class test {

	public static void main(String[] args) {
		long a = Long.MIN_VALUE;
		String s = "9681620378779650";
		int b = Integer.MAX_VALUE;
		Random random = new Random();
		if(random.nextInt(9)+1 == 0){
			System.out.println("wrong!!!");
		}
		System.out.println(random.nextInt(9)+1);
//		System.out.println("" + b);
		BigDecimal bd = new BigDecimal(0);
		
		ArrayList[][] abc = new ArrayList[2][2];
		abc[0][0] = new ArrayList<Integer>();
		abc[0][0].add(1);
		System.out.println(abc[0][0]);
	}
	
}
