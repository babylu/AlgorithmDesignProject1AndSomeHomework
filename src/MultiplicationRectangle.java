import java.math.BigDecimal;
import java.util.Scanner;


public class MultiplicationRectangle {

	public static void main(String[] args) {
		System.out.println("Please input number a:");
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
		System.out.println("Please input number b:");
		long b = in.nextLong();
		BigDecimal result = MultiplicationRectangle(a,b);
		System.out.println("The result is:" + result.toBigInteger());
	}
	
	public static BigDecimal MultiplicationRectangle(long a, long b){
		//change a & b into array
		int aLength = intLength(a), bLength = intLength(b);
		int[] aArray = new int[aLength] ;
		int[] bArray = new int[bLength];
		long aDivide = a;

		for(int i= aLength-1;i>= 0;i--){
			aArray[i] = (int) (aDivide%10);
			aDivide = aDivide/10;
			
		}
		long bDivide = b; 
		for(int j= bLength-1;j>= 0;j--){
			bArray[j] = (int) (bDivide%10);
			bDivide = bDivide/10;
			
		}
		
		//multiply a & b
		int c[][] = new int[aLength][bLength];
		for(int k=0; k< aLength; k++){
			for(int l=0; l<bLength; l++){
				c[k][l] = aArray[k] * bArray[l];
			}
		}
		
		//count result
		BigDecimal result = new BigDecimal(0);
		int times = aLength + bLength -2;
		for(int m= times; m>=0; m--){
			for(int n=0; n< aLength; n++){
				for(int p=0; p< bLength; p++){
					if(n+p == m){
						result = result.add(BigDecimal.valueOf((c[n][p]*Math.pow(10,(times-m)))));
					}
				}
			}
		}
		return result;
	}
	
	public static int intLength(long number){
		long divide = number;
		int length = 0;
		while(divide != 0){
			divide = divide/10;
			length ++;
		}
		return length;
	}
}
