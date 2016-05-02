import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReadStringAndJudge {

	public static void main(String[] args) {
		System.out.println("Please input string:");
		Scanner in = new Scanner(System.in);
		String inputString = in.nextLine();
		String result = judgeString(inputString);
		System.out.println("The result is:\n" + result);

	}
	public static String judgeString(String inputString){
		String REGEX = "^[-+]?[0-9]+(\\.[0-9]+){1}$";
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(inputString);
		if(!m.find()){
			return "Not a decimal number";
		}
		
		char[] list = inputString.toCharArray();
		int listLength = list.length;
		
		//find decimal’s position
		int decimalPosition = listLength;
		for(int i=0;i<listLength;i++){
			if(list[i] == '.'){
				decimalPosition = i;
			}
		}
		
		String result;
		String beforeDecimal = "";
		String afterDecimal = ""; 	
		
		boolean isZero = true;
		
		//check whether the number is negative or positive
		int start = 0;
		if(list[0] == '-'){
			start = 1;
			result = "Negative decimal number\n";
		}else{
			result = "Positive decimal number\n";
		}
		
		int numberOfDigitsBeforeDecimal = decimalPosition - start;
		int numberOfDigitsAfterDecimal = listLength - decimalPosition - 1;
		
		//get every digits
		for(int j=start;j<decimalPosition;j++){
				if(list[j] != '0'){
					isZero = false;
				}
				if(j == decimalPosition-1){
					beforeDecimal = beforeDecimal + list[j];
		}else{
					beforeDecimal = beforeDecimal + list[j] + ",";
				}
		}
		for(int k=decimalPosition+1;k<listLength;k++){
			if(list[k] != '0'){
				isZero = false;
			}
			
			if(k == listLength-1){
				afterDecimal = afterDecimal + list[k];
			}else{
				afterDecimal = afterDecimal + list[k] + ",";
			}
		}
		
		//get result
		if(isZero){
			return "Zero";
		}
		result = result + numberOfDigitsBeforeDecimal + " digits before decimal: " + beforeDecimal + "\n";
		result = result + numberOfDigitsAfterDecimal + " digits After decimal: " + afterDecimal;
		return result;
		
	}
}
