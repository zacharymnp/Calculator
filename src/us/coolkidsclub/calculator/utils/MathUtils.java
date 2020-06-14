package us.coolkidsclub.calculator.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MathUtils {

    static ArrayList<String> operationsList = new ArrayList<>();

    /**
     * This method is run when the "equal" button is pressed and decides what math to do.
     *      @param s The input string.
     * 		@return String The text to be output.
     */
    public static String doMath(String s) {
        //TODO add additional functions
        //TODO add PEMDAS
        //TODO look into BigDecimal to add precision
        List<Double> nums = new ArrayList<Double>();
        List<String> operators = new ArrayList<String>();
        double num = 0d;
        String output = "undefined";
        int decimalPlaces = 0;

        operationsList.add(".");
        operationsList.add("+");
        operationsList.add("-");
        operationsList.add("*");
        operationsList.add("/");

        //for loop adds numbers and operators in the String to their respective Lists
        for (int i = 0; i < s.length(); i++) {

            if (!operationsList.contains(String.valueOf(s.charAt(i)))) {
                double currentNumber = Double.parseDouble(String.valueOf(s.charAt(i)));
                if (currentNumber <= 9) {
                    if (decimalPlaces == 0) {
                        num *= 10; num += currentNumber;
                    } else {
                        num += currentNumber/(Math.pow(10, decimalPlaces));
                        decimalPlaces++;
                    }
                }
            }
            
            switch (s.charAt(i)) {
                case '.':
                    decimalPlaces = 1;
                    break;
                case '+':
                    operators.add("+"); nums.add(num); num = 0.0; decimalPlaces = 0;
                    break;
                case '-':
                    operators.add("-"); nums.add(num); num = 0.0; decimalPlaces = 0;
                    break;
                case '*':
                    operators.add("*"); nums.add(num); num = 0.0; decimalPlaces = 0;
                    break;
                case '/':
                    operators.add("/"); nums.add(num); num = 0.0; decimalPlaces = 0;
            }
        }


        nums.add(num); //adding the last number to nums

        //for loop actually does the math
        for (int i = 0; i < operators.size(); i++) {

            switch (operators.get(i)) { //Optimized by Ivan to make the same logic one line longer :)
                case "*":
                    nums.set(0, nums.get(0) * nums.get(i + 1));
                    break;
                case "/":
                    nums.set(0, nums.get(0) / nums.get(i + 1));
                    break;
                case "+":
                    nums.set(0, nums.get(0) + nums.get(i + 1));
                    break;
                case "-":
                    nums.set(0, nums.get(0) - nums.get(i + 1));
            }

        }

        double answer = nums.get(0);
        output = String.format("%.7f", answer); //rounding to 7 decimal places
        for (int i = output.length() - 1; i > 0; i--) { //removing unnecessary decimal places
            if (output.charAt(i) == '0') {
                output = output.substring(0, i);
            }
            else if (output.charAt(i) == '.') {
                output = output.substring(0, i);
                break;
            }
            else {
                break;
            }
        }

        System.out.println(output); //putting output in console for debugging purposes
        return output;

    }
}