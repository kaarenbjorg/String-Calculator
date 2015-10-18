package is.ru.stringcalculator;
import java.util.ArrayList;

public class Calculator {

	public static int add(String text) {
		if(text.equals("")) {
			return 0;
		}
		else if(text.contains(",") || text.contains("//")) {
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers) {
	    
	    String delimeter = ",|\n";

	    if(numbers.startsWith("//")) {
	    	int delIndex = numbers.indexOf("//") + 2;
	    	delimeter = delimeter + "|" + numbers.substring(delIndex, delIndex + 1);
	    	numbers = numbers.substring(delIndex + 2);
	    	
	    	return numbers.split(delimeter);
	    } 
	    /*else if(numbers.startsWith("//[")) {
	    	String del = " ";

	    	for(int i = 0; i < numbers.length(); i++) {
	    		if(numbers.charAt(i) != ']') {
	    			del += numbers.substring(i, i + i);
	    		}
	    	}
	    	numbers = numbers.replaceAll(del, ",");

	    	return numbers.split(numbers);
	    } */
	    else 
			return numbers.split(delimeter);
	}
      
    private static int sum(String[] numbers) {
    	ArrayList <Integer> negativeNum = new ArrayList <Integer>();

 	    for(String number : numbers) {

			int negNumber = toInt(number);

 	    	if(negNumber < 0) {
 	    		negativeNum.add(negNumber);
 	    		throw new RuntimeException("Negatives not allowed: " + negativeNum);
 	    	}
 	    }

 	    int total = 0;

        for(String number : numbers) {
        	if(toInt(number) > 1000) {
        		continue;
        	}
        	total += toInt(number);
		}
		return total;
    }
}