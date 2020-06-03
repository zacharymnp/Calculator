package us.coolkidsclub.calculator.utils;

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
        //TODO remove error where there is an tiny extra decimal
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

            //eventually this will replace the if else chain, but for now, it lies forgotten
//            if ((double) s.charAt(i) <= 9 && decimalPlaces == 0) {
//                num *= 10; num += (double) s.charAt(i);
//            } else {
//                num += (double) s.charAt(i)/(Math.pow(10, decimalPlaces));
//                decimalPlaces++;
//            }


//            char testOne = s.charAt(i);
//            double test = Double.parseDouble(String.valueOf(s.charAt(i)));

//
//            if (!operationsList.contains(String.valueOf(s.charAt(i)))) {
//                if (Double.parseDouble(String.valueOf(s.charAt(i))) <= 9 && decimalPlaces == 0) {
//                    num *= 10; num += (double) s.charAt(i);
//                } else {
//                    num += (double) s.charAt(i) / (Math.pow(10, decimalPlaces));
//                    decimalPlaces++;
//                }
//            }

            if (s.charAt(i) == '0') {
                if (decimalPlaces == 0) {
                    num *= 10.0;
                }
                else {
                    decimalPlaces++;
                }
            }
            else if (s.charAt(i) == '1') {
                if (decimalPlaces == 0) {
                    num *= 10.0; num += 1.0;
                }
                else {
                    num += 1.0/(Math.pow(10, decimalPlaces));
                    decimalPlaces++;
                }
            }
            else if (s.charAt(i) == '2') {
                if (decimalPlaces == 0) {
                    num *= 10.0; num += 2.0;
                }
                else {
                    num += 2.0/(Math.pow(10, decimalPlaces));
                    decimalPlaces++;
                }
            }
            else if (s.charAt(i) == '3') {
                if (decimalPlaces == 0) {
                    num *= 10.0; num += 3.0;
                }
                else {
                    num += 3.0/(Math.pow(10, decimalPlaces));
                    decimalPlaces++;
                }
            }
            else if (s.charAt(i) == '4') {
                if (decimalPlaces == 0) {
                    num *= 10.0; num += 4.0;
                }
                else {
                    num += 4.0/(Math.pow(10, decimalPlaces));
                    decimalPlaces++;
                }
            }
            else if (s.charAt(i) == '5') {
                if (decimalPlaces == 0) {
                    num *= 10.0; num += 5.0;
                }
                else {
                    num += 5.0/(Math.pow(10, decimalPlaces));
                    decimalPlaces++;
                }
            }
            else if (s.charAt(i) == '6') {
                if (decimalPlaces == 0) {
                    num *= 10.0; num += 6.0;
                }
                else {
                    num += 6.0/(Math.pow(10, decimalPlaces));
                    decimalPlaces++;
                }
            }
            else if (s.charAt(i) == '7') {
                if (decimalPlaces == 0) {
                    num *= 10.0; num += 7.0;
                }
                else {
                    num += 7.0/(Math.pow(10, decimalPlaces));
                    decimalPlaces++;
                }
            }
            else if (s.charAt(i) == '8') {
                if (decimalPlaces == 0) {
                    num *= 10.0; num += 8.0;
                }
                else {
                    num += 8.0/(Math.pow(10, decimalPlaces));
                    decimalPlaces++;
                }
            }
            else if (s.charAt(i) == '9') {
                if (decimalPlaces == 0) {
                    num *= 10.0; num += 9.0;
                }
                else {
                    num += 9.0/(Math.pow(10, decimalPlaces));
                    decimalPlaces++;
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
        nums.set(0, round(nums.get(0)));
        output = String.valueOf(nums.get(0));

        System.out.println(output); //putting output in console for debugging purposes
        return output;

    }


    /**
     * This method is used to round a double value to the nearest thousandth
     * @param a The number to be rounded
     * @return double The rounded value
     */
    public static double round(double a) {
        return ((double)((int)(a * 1000)) / 1000);
    }

}