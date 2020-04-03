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

			if (Character.getNumericValue(s.charAt(i)) <= 9) {
				if (decimalPlaces == 0) {
					num *= (double) s.charAt(i); num += (double) s.charAt(i);
				}
				else {
					num += (double) s.charAt(i)/(Math.pow(10, decimalPlaces));
					decimalPlaces++;
				}
			}

			switch (s.charAt(i)) {
				case '.': {
					decimalPlaces = 1;
				}
				case '+': {
					operators.add("+"); nums.add(num); num = 0.0; decimalPlaces = 0;
				}
				case '-': {
					operators.add("-"); nums.add(num); num = 0.0; decimalPlaces = 0;
				}
				case '*': {
					operators.add("*"); nums.add(num); num = 0.0; decimalPlaces = 0;
				}
				case '/': {
					operators.add("/"); nums.add(num); num = 0.0; decimalPlaces = 0;
				}
			}
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
	 * This method is used to round valueToRound double value to the nearest thousandth
	 * 		@param valueToRound The number to be rounded
	 * 		@return double The rounded value
	 */	
	public double round(double valueToRound) {
		return ((double)((int)(valueToRound * 1000)) / 1000);
	}
}
