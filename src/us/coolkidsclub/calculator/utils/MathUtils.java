package coolkidsclub.calculator.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathUtils {

    private static final ArrayList<Character> validCharOperations = new ArrayList<>(Arrays.asList('+', '-', '*', '/'));

    /**
     * This method is run when the "equal" button is pressed and decides what math to do.
     *      @param s The input string.
     * 		@return String The text to be output.
     */
    public static String doMath(String s) {
        //TODO add additional functions
        //TODO add PEMDAS
        List<Object> inputList = new ArrayList<Object>();
        List<Object> outputList = new ArrayList<Object>();
        List<String> operators = new ArrayList<String>();
        double num = 0d;
        String output = "undefined";
        int operatorCount = 0;
        int decimalPlaces = 0;

        //parses numbers and adds values to inputList
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '.') {
                decimalPlaces = 1;
            } else if (validCharOperations.contains(s.charAt(i))) {
                inputList.add(num); inputList.add(String.valueOf(s.charAt(i))); num = 0; decimalPlaces = 0; operatorCount++;
            } else {
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

        }
        inputList.add(num); //adding the last number to inputList

        //puts equation into reverse polish notation (operators are after operands)
        for (Object input : inputList) {

            if (input.equals("+") || input.equals("-")) {
                if (operators.size() != 0) {
                    outputList.add(operators.get(operators.size() - 1));
                    operators.remove(operators.get(operators.size() - 1));
                }
                operators.add(input.toString());
            }
            else if (input.equals("*") || input.equals("/")) {
                if (operators.size() != 0 && (operators.get(operators.size() - 1).equals("*") || operators.get(operators.size() - 1).equals("/"))) {
                    outputList.add(operators.get(operators.size() - 1));
                    operators.remove(operators.get(operators.size() - 1));
                }
                operators.add(input.toString());
            }
            else {
                outputList.add(input);
            }
        }
        //for loop puts remaining operators into outputList in reverse order
        for (int i = operators.size() - 1; i >= 0; i--) {
            outputList.add(operators.get(i));
        }

        //math performed on reverse Polish notation equation
        double firstOperand = 0;
        double secondOperand = 0;
        String operator = "undefined";
        for (int i = 0; i < operatorCount; i++) {
            for (int k = 0; k < outputList.size(); k++) {
                if (outputList.get(k).equals("+") || outputList.get(k).equals("-") || outputList.get(k).equals("*") || outputList.get(k).equals("/")) {
                    firstOperand = (double) outputList.get(k - 2);
                    secondOperand = (double) outputList.get(k - 1);
                    operator = outputList.get(k).toString();
                    switch (operator) {
                        case ("+"): outputList.set(k - 2, firstOperand + secondOperand); outputList.remove(k - 1); outputList.remove(k - 1); break;
                        case ("-"): outputList.set(k - 2, firstOperand - secondOperand); outputList.remove(k - 1); outputList.remove(k - 1); break;
                        case ("*"): outputList.set(k - 2, firstOperand * secondOperand); outputList.remove(k - 1); outputList.remove(k - 1); break;
                        case ("/"): outputList.set(k - 2, firstOperand / secondOperand); outputList.remove(k - 1); outputList.remove(k - 1); break;
                        //removes k - 1 twice b/c index falls
                    }
                    k -= 2;
                }
            }
        }

        double answer = (double) outputList.get(0);
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