package us.coolkidsclub.calculator.gui;

import us.coolkidsclub.calculator.mathutils.CalculatorMath;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalculatorGUI extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	public static String display = "";
	public static boolean additionalButtonsVisible = false;
	
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
	 * Toggles the the visibility of additional functions.
	 */
	public static void toggleAdditionalFunctions() {
		zeroButton.setVisible(additionalButtonsVisible);
		oneButton.setVisible(additionalButtonsVisible);
		twoButton.setVisible(additionalButtonsVisible);
		threeButton.setVisible(additionalButtonsVisible);
		fourButton.setVisible(additionalButtonsVisible);
		fiveButton.setVisible(additionalButtonsVisible);
		sixButton.setVisible(additionalButtonsVisible);
		sevenButton.setVisible(additionalButtonsVisible);
		eightButton.setVisible(additionalButtonsVisible);
		nineButton.setVisible(additionalButtonsVisible);
		leftParenthesisButton.setVisible(!additionalButtonsVisible);
		rightParenthesisButton.setVisible(!additionalButtonsVisible);
		sineButton.setVisible(!additionalButtonsVisible);
		cosineButton.setVisible(!additionalButtonsVisible);
		tangentButton.setVisible(!additionalButtonsVisible);
		factorialButton.setVisible(!additionalButtonsVisible);
		logButton.setVisible(!additionalButtonsVisible);
		naturalLogButton.setVisible(!additionalButtonsVisible);
		exponentButton.setVisible(!additionalButtonsVisible);
		squareRootButton.setVisible(!additionalButtonsVisible);
		additionalButtonsVisible = !additionalButtonsVisible;

		additionalButtonsVisible = !additionalButtonsVisible;
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
			CalculatorMath.doMath(display);
		}
		else if (clickedButton.getText() == "Additional Functions") {
			toggleAdditionalFunctions();
		}
		else if (display.length() < 14) {
			display = display.concat(clickedButton.getText());
		}
		else {
			display = "Go away";
		}
		repaint();
	}
	
	/**
	 * This method is run to create the calculator itself
	 */
	public static void initialize() {
		
	CalculatorGUI Calculator = new CalculatorGUI();
	JFrame CalculatorFrame = new JFrame();
	CalculatorFrame.getContentPane().add(Calculator);
	CalculatorFrame.setSize(416, 599);
	CalculatorFrame.setVisible(true);
	CalculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	CalculatorFrame.setResizable(false);
	Calculator.setLayout(null); //we may want to use a layout, so that we don't need to worry about absolute positioning
	
	equalsButton.addActionListener(Calculator);
	Calculator.add(equalsButton);
	equalsButton.setBounds(200, 450, 100, 110);
	deleteButton.addActionListener(Calculator);
	Calculator.add(deleteButton);
	deleteButton.setBounds(300, 50, 100, 70);
	oneButton.addActionListener(Calculator);
	Calculator.add(oneButton);
	oneButton.setBounds(0, 340, 100, 110);
	twoButton.addActionListener(Calculator);
	Calculator.add(twoButton);
	twoButton.setBounds(100, 340, 100, 110);
	threeButton.addActionListener(Calculator);
	Calculator.add(threeButton);
	threeButton.setBounds(200, 340, 100, 110);
	fourButton.addActionListener(Calculator);
	Calculator.add(fourButton);
	fourButton.setBounds(0, 230, 100, 110);
	fiveButton.addActionListener(Calculator);
	Calculator.add(fiveButton);
	fiveButton.setBounds(100, 230, 100, 110);
	sixButton.addActionListener(Calculator);
	Calculator.add(sixButton);
	sixButton.setBounds(200, 230, 100, 110);
	sevenButton.addActionListener(Calculator);
	Calculator.add(sevenButton);
	sevenButton.setBounds(0, 120, 100, 110);
	eightButton.addActionListener(Calculator);
	Calculator.add(eightButton);
	eightButton.setBounds(100, 120, 100, 110);
	nineButton.addActionListener(Calculator);
	Calculator.add(nineButton);
	nineButton.setBounds(200, 120, 100, 110);
	zeroButton.addActionListener(Calculator);
	Calculator.add(zeroButton);
	zeroButton.setBounds(100, 450, 100, 110);
	pointButton.addActionListener(Calculator);
	Calculator.add(pointButton);
	pointButton.setBounds(0, 450, 100, 110);
	plusButton.addActionListener(Calculator);
	Calculator.add(plusButton);
	plusButton.setBounds(300, 450, 100, 110);
	minusButton.addActionListener(Calculator);
	Calculator.add(minusButton);
	minusButton.setBounds(300, 340, 100, 110);
	timesButton.addActionListener(Calculator);
	Calculator.add(timesButton);
	timesButton.setBounds(300, 230, 100, 110);
	dividedByButton.addActionListener(Calculator);
	Calculator.add(dividedByButton);
	dividedByButton.setBounds(300, 120, 100, 110);
	additionalFunctionsButton.addActionListener(Calculator);
	Calculator.add(additionalFunctionsButton);
	additionalFunctionsButton.setBounds(0, 0, 416, 50);
	leftParenthesisButton.addActionListener(Calculator);
	Calculator.add(leftParenthesisButton);
	leftParenthesisButton.setBounds(0, 340, 100, 110);
	rightParenthesisButton.addActionListener(Calculator);
	Calculator.add(rightParenthesisButton);
	rightParenthesisButton.setBounds(100, 340, 100, 110);
	exponentButton.addActionListener(Calculator);
	Calculator.add(exponentButton);
	exponentButton.setBounds(200, 340, 100, 110);
	squareRootButton.addActionListener(Calculator);
	Calculator.add(squareRootButton);
	squareRootButton.setBounds(100, 450, 100, 110);
	naturalLogButton.addActionListener(Calculator);
	Calculator.add(naturalLogButton);
	naturalLogButton.setBounds(100, 230, 100, 110);
	logButton.addActionListener(Calculator);
	Calculator.add(logButton);
	logButton.setBounds(0, 230, 100, 110);
	factorialButton.addActionListener(Calculator);
	Calculator.add(factorialButton);
	factorialButton.setBounds(200, 230, 100, 110);
	sineButton.addActionListener(Calculator);
	Calculator.add(sineButton);
	sineButton.setBounds(0, 120, 100, 110);
	cosineButton.addActionListener(Calculator);
	Calculator.add(cosineButton);
	cosineButton.setBounds(100, 120, 100, 110);
	tangentButton.addActionListener(Calculator);
	Calculator.add(tangentButton);
	tangentButton.setBounds(200, 120, 100, 110);
	}
}
