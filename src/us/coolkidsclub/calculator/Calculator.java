package us.coolkidsclub.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>us.coolkidsgroup.calculator.original.Calculator<h1>
 * <p>
 * This is a calculator
 * <p>
 * @author Zachary
 * @author Max
 * @author Maya
 * @since 2019-12-13
 */
public class Calculator extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	public static String display = "";
	public static boolean isOnAdditionalButtons = false;
	
	public static ArrayList<String> terms = new ArrayList<String>(); //figure out how to differentiate between terms
	
	public static JButton equalsButton = new JButton("=");
	public static JButton deleteButton = new JButton("DEL");
	public static JButton oneButton = new JButton("1");
	public static JButton twoButton = new JButton("2");
	public static JButton threeButton = new JButton("3");
	public static JButton fourButton = new JButton("4");
	public static JButton fiveButton = new JButton("5");
	public static JButton sixButton = new JButton("6");
	public static JButton sevenButton = new JButton("7");
	public static JButton eightButton = new JButton("8");
	public static JButton nineButton = new JButton("9");
	public static JButton zeroButton = new JButton("0");
	public static JButton pointButton = new JButton(".");
	public static JButton plusButton = new JButton("+");
	public static JButton minusButton = new JButton("-");
	public static JButton timesButton = new JButton("*");
	public static JButton dividedByButton = new JButton("/");
	public static JButton additionalFunctionsButton = new JButton("Additional Functions");
	public static JButton leftParenthesisButton = new JButton("(");
	public static JButton rightParenthesisButton = new JButton(")");
	public static JButton sineButton = new JButton("sin");
	public static JButton cosineButton = new JButton("cos");
	public static JButton tangentButton = new JButton("tan");
	public static JButton factorialButton = new JButton("!");
	public static JButton logButton = new JButton("log");
	public static JButton naturalLogButton = new JButton("ln");
	public static JButton exponentButton = new JButton("^");
	public static JButton squareRootButton = new JButton("^.5");
	

	/**
	 * This method is run when the "equal" button is pressed and decides what math to do
	 * 		@param s The text in the display
	 * 		@return String The text to be output
	 */
	public void doMath(String s) {
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
		nums.set(0, round(nums.get(0)));
		output = String.valueOf(nums.get(0));
		
		System.out.println(output); //putting output in console for debugging purposes
		display = output; //putting output on display		
	}
	
	/**
	 * This method is used to round a double value to the nearest thousandth
	 * @param a The number to be rounded
	 * @return double The rounded value
	 */	
	public double round(double a) {
		return ((double)((int)(a * 1000)) / 1000);
	}
	
	/**
	 * This method is used to add two doubles together
	 * @param a The number to be added to
	 * @param b The number to be added by
	 * @return double The sum of the two parameters
	 */
	public static void showAdditionalFunctions() {
		if (isOnAdditionalButtons == false) {
			zeroButton.setVisible(false);
			oneButton.setVisible(false);
			twoButton.setVisible(false);
			threeButton.setVisible(false);
			fourButton.setVisible(false);
			fiveButton.setVisible(false);
			sixButton.setVisible(false);
			sevenButton.setVisible(false);
			eightButton.setVisible(false);
			nineButton.setVisible(false);
			leftParenthesisButton.setVisible(true);
			rightParenthesisButton.setVisible(true);
			sineButton.setVisible(true);
			cosineButton.setVisible(true);
			tangentButton.setVisible(true);
			factorialButton.setVisible(true);
			logButton.setVisible(true);
			naturalLogButton.setVisible(true);
			exponentButton.setVisible(true);
			squareRootButton.setVisible(true);
			isOnAdditionalButtons = true;
		}
		else {
			leftParenthesisButton.setVisible(false);
			rightParenthesisButton.setVisible(false);
			sineButton.setVisible(false);
			cosineButton.setVisible(false);
			tangentButton.setVisible(false);
			factorialButton.setVisible(false);
			logButton.setVisible(false);
			naturalLogButton.setVisible(false);
			exponentButton.setVisible(false);
			squareRootButton.setVisible(false);
			zeroButton.setVisible(true);
			oneButton.setVisible(true);
			twoButton.setVisible(true);
			threeButton.setVisible(true);
			fourButton.setVisible(true);
			fiveButton.setVisible(true);
			sixButton.setVisible(true);
			sevenButton.setVisible(true);
			eightButton.setVisible(true);
			nineButton.setVisible(true);
			isOnAdditionalButtons = false;

		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g.drawString(display, 10, 100);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton)(e.getSource());
		System.out.println(clickedButton.getText());
		if (clickedButton.getText() == "DEL") {
			if (display.equals("Go away")) {
				display = "";
			}
			else if (display.length() != 0 ) {
				display = display.substring(0, display.length() - 1);
			}
		}
		else if (clickedButton.getText() == "=") {
			doMath(display);
		}
		else if (clickedButton.getText() == "Additional Functions") {
			showAdditionalFunctions();
		}
		else if (display.length() < 14) {
			display = display.concat(clickedButton.getText());
		}
		else {
			display = "Go away";
		}
		repaint();
	}

	
	public static void main(String[] args) {

		Calculator calculator = new Calculator();
		JFrame calculatorFrame = new JFrame();
		calculatorFrame.getContentPane().add(calculator);
		calculatorFrame.setSize(416, 599);
		calculatorFrame.setVisible(true);
		calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculatorFrame.setResizable(false);
		calculator.setLayout(null); //we may want to use a layout, so that we don't need to worry about absolute positioning

		equalsButton.addActionListener(calculator);
		calculator.add(equalsButton);
		equalsButton.setBounds(200, 450, 100, 110);
		deleteButton.addActionListener(calculator);
		calculator.add(deleteButton);
		deleteButton.setBounds(300, 50, 100, 70);
		oneButton.addActionListener(calculator);
		calculator.add(oneButton);
		oneButton.setBounds(0, 340, 100, 110);
		twoButton.addActionListener(calculator);
		calculator.add(twoButton);
		twoButton.setBounds(100, 340, 100, 110);
		threeButton.addActionListener(calculator);
		calculator.add(threeButton);
		threeButton.setBounds(200, 340, 100, 110);
		fourButton.addActionListener(calculator);
		calculator.add(fourButton);
		fourButton.setBounds(0, 230, 100, 110);
		fiveButton.addActionListener(calculator);
		calculator.add(fiveButton);
		fiveButton.setBounds(100, 230, 100, 110);
		sixButton.addActionListener(calculator);
		calculator.add(sixButton);
		sixButton.setBounds(200, 230, 100, 110);
		sevenButton.addActionListener(calculator);
		calculator.add(sevenButton);
		sevenButton.setBounds(0, 120, 100, 110);
		eightButton.addActionListener(calculator);
		calculator.add(eightButton);
		eightButton.setBounds(100, 120, 100, 110);
		nineButton.addActionListener(calculator);
		calculator.add(nineButton);
		nineButton.setBounds(200, 120, 100, 110);
		zeroButton.addActionListener(calculator);
		calculator.add(zeroButton);
		zeroButton.setBounds(100, 450, 100, 110);
		pointButton.addActionListener(calculator);
		calculator.add(pointButton);
		pointButton.setBounds(0, 450, 100, 110);
		plusButton.addActionListener(calculator);
		calculator.add(plusButton);
		plusButton.setBounds(300, 450, 100, 110);
		minusButton.addActionListener(calculator);
		calculator.add(minusButton);
		minusButton.setBounds(300, 340, 100, 110);
		timesButton.addActionListener(calculator);
		calculator.add(timesButton);
		timesButton.setBounds(300, 230, 100, 110);
		dividedByButton.addActionListener(calculator);
		calculator.add(dividedByButton);
		dividedByButton.setBounds(300, 120, 100, 110);
		additionalFunctionsButton.addActionListener(calculator);
		calculator.add(additionalFunctionsButton);
		additionalFunctionsButton.setBounds(0, 0, 416, 50);
		leftParenthesisButton.addActionListener(calculator);
		calculator.add(leftParenthesisButton);
		leftParenthesisButton.setBounds(0, 340, 100, 110);
		rightParenthesisButton.addActionListener(calculator);
		calculator.add(rightParenthesisButton);
		rightParenthesisButton.setBounds(100, 340, 100, 110);
		exponentButton.addActionListener(calculator);
		calculator.add(exponentButton);
		exponentButton.setBounds(200, 340, 100, 110);
		squareRootButton.addActionListener(calculator);
		calculator.add(squareRootButton);
		squareRootButton.setBounds(100, 450, 100, 110);
		naturalLogButton.addActionListener(calculator);
		calculator.add(naturalLogButton);
		naturalLogButton.setBounds(100, 230, 100, 110);
		logButton.addActionListener(calculator);
		calculator.add(logButton);
		logButton.setBounds(0, 230, 100, 110);
		factorialButton.addActionListener(calculator);
		calculator.add(factorialButton);
		factorialButton.setBounds(200, 230, 100, 110);
		sineButton.addActionListener(calculator);
		calculator.add(sineButton);
		sineButton.setBounds(0, 120, 100, 110);
		cosineButton.addActionListener(calculator);
		calculator.add(cosineButton);
		cosineButton.setBounds(100, 120, 100, 110);
		tangentButton.addActionListener(calculator);
		calculator.add(tangentButton);
		tangentButton.setBounds(200, 120, 100, 110);
	}
}
