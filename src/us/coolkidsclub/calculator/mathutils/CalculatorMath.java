package us.coolkidsclub.calculator.mathutils;

import us.coolkidsclub.calculator.gui.CalculatorGUI;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>CalculatorMath<h1>
 * <p>
 * This is a CalculatorMath
 * <p>
 * @author Zachary
 * @author Ivan
 * @since 2019-12-13
 */
public class CalculatorMath {	

	/**
	 * This method is run when the "equal" button is pressed and decides what math to do
	 * @param s The text in the display
	 * @return String The text to be output
	 */
	public static void doMath(String s) {
		//TODO remove error where there is an tiny extra decimal
		//TODO add additional functions
		//TODO add PEMDAS
		//TODO look into BigDecimal to add precision
		List<Double> nums = new ArrayList<Double>();
		List<String> operators = new ArrayList<String>();
		Double num = 0d;
		String output = "undefined";
		int decimalPlaces = 0;
		
		//for loop adds numbers and operators in the String to their respective Lists
		for (int i = 0; i < s.length(); i++) {
<<<<<<< HEAD

			if (Character.getNumericValue(s.charAt(i)) <= 9) {
=======
			if (s.charAt(i) == '0') { 
>>>>>>> parent of 5e4ed79... Heavily simplified parts of doMath().
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
			
			else if (s.charAt(i) == '.') { decimalPlaces = 1; }
			else if (s.charAt(i) == '+') { operators.add("+"); nums.add(num); num = 0.0; decimalPlaces = 0;}
			else if (s.charAt(i) == '-') { operators.add("-"); nums.add(num); num = 0.0; decimalPlaces = 0;}
			else if (s.charAt(i) == '*') { operators.add("*"); nums.add(num); num = 0.0; decimalPlaces = 0;}
			else if (s.charAt(i) == '/') { operators.add("/"); nums.add(num); num = 0.0; decimalPlaces = 0;}
		}
		
		nums.add(num); //adding the last number to nums
		num = 0.0;
		
		//for loop actually does the math
		for (int i = 0; i < operators.size(); i++) {
			if (operators.get(i).equals("*")) {
				nums.set(0, nums.get(0) * nums.get(i + 1));
			}
			else if (operators.get(i).equals("/")) {
				nums.set(0, nums.get(0) / nums.get(i + 1));
			}
			else if (operators.get(i).equals("+")) {
				nums.set(0, nums.get(0) + nums.get(i + 1));
			}
			else if (operators.get(i).equals("-")) {
				nums.set(0, nums.get(0) - nums.get(i + 1));
			}
		}
		nums.set(0, nums.get(0));
		output = String.valueOf(nums.get(0));
		
		System.out.println(output); //putting output in console for debugging purposes
		CalculatorGUI.display = output; //putting output on display
	}
	
	/**
<<<<<<< HEAD
	 * This method is used to round valueToRound double value to the nearest thousandth
	 * 		@param valueToRound The number to be rounded
	 * 		@return double The rounded value
=======
	 * This method is used to round a double value to the nearest thousandth
	 * @param a The number to be rounded
	 * @return double The rounded value
>>>>>>> parent of 5e4ed79... Heavily simplified parts of doMath().
	 */	
	public double round(double a) {
		return ((double)((int)(a * 1000)) / 1000);
	}
}
