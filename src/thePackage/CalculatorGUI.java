package thePackage;

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
	public static boolean isOnAdditionalButtons = false;
	
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
	 * This method toggles the the visibility of the JButtons on the calculator, so that the additional functions can be revealed or hidden
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
			CalculatorMath.doMath(display);
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
