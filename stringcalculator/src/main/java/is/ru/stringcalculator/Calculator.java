package is.ru.stringcalculator;

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
	    } else 
			return numbers.split(delimeter);
	}
      
    private static int sum(String[] numbers) {
 	    for(String number : numbers) {
 	    	if(toInt(number) < 0) {
 	    		throw new RuntimeException("Negatives not allowed: ");
 	    	}
 	    }

 	    int total = 0;
        for(String number : numbers) {
        		total += toInt(number);
		}
		return total;
    }
}