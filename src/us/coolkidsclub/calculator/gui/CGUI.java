package us.coolkidsclub.calculator.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static us.coolkidsclub.calculator.utils.MathUtils.doMath;

public class CGUI extends JPanel implements ActionListener { //TODO implement singleton? => it would be absolutely pointless, but it is a neat way to flex
    //TODO make the header of the calculator window have an actual name
    private static final long serialVersionUID = 1L; //what's this used for?

    public static String display = "";
    public static boolean additionalFunctionsShown = false;

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

    public static void createDisplay() {
        CGUI calculatorDisplay = new CGUI();
		JFrame calculatorFrame = new JFrame();
		calculatorFrame.getContentPane().add(calculatorDisplay);
		calculatorFrame.setSize(416, 599);
		calculatorFrame.setVisible(true);
		calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculatorFrame.setResizable(false);
		calculatorDisplay.setLayout(null); //we may want to use a layout, so that we don't need to worry about absolute positioning

		equalsButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(equalsButton);
		equalsButton.setBounds(200, 450, 100, 110);
		deleteButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(deleteButton);
		deleteButton.setBounds(300, 50, 100, 70);
		oneButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(oneButton);
		oneButton.setBounds(0, 340, 100, 110);
		twoButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(twoButton);
		twoButton.setBounds(100, 340, 100, 110);
		threeButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(threeButton);
		threeButton.setBounds(200, 340, 100, 110);
		fourButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(fourButton);
		fourButton.setBounds(0, 230, 100, 110);
		fiveButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(fiveButton);
		fiveButton.setBounds(100, 230, 100, 110);
		sixButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(sixButton);
		sixButton.setBounds(200, 230, 100, 110);
		sevenButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(sevenButton);
		sevenButton.setBounds(0, 120, 100, 110);
		eightButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(eightButton);
		eightButton.setBounds(100, 120, 100, 110);
		nineButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(nineButton);
		nineButton.setBounds(200, 120, 100, 110);
		zeroButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(zeroButton);
		zeroButton.setBounds(100, 450, 100, 110);
		pointButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(pointButton);
		pointButton.setBounds(0, 450, 100, 110);
		plusButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(plusButton);
		plusButton.setBounds(300, 450, 100, 110);
		minusButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(minusButton);
		minusButton.setBounds(300, 340, 100, 110);
		timesButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(timesButton);
		timesButton.setBounds(300, 230, 100, 110);
		dividedByButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(dividedByButton);
		dividedByButton.setBounds(300, 120, 100, 110);
		additionalFunctionsButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(additionalFunctionsButton);
		additionalFunctionsButton.setBounds(0, 0, 416, 50);
		leftParenthesisButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(leftParenthesisButton);
		leftParenthesisButton.setBounds(0, 340, 100, 110);
		rightParenthesisButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(rightParenthesisButton);
		rightParenthesisButton.setBounds(100, 340, 100, 110);
		exponentButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(exponentButton);
		exponentButton.setBounds(200, 340, 100, 110);
		squareRootButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(squareRootButton);
		squareRootButton.setBounds(100, 450, 100, 110);
		naturalLogButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(naturalLogButton);
		naturalLogButton.setBounds(100, 230, 100, 110);
		logButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(logButton);
		logButton.setBounds(0, 230, 100, 110);
		factorialButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(factorialButton);
		factorialButton.setBounds(200, 230, 100, 110);
		sineButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(sineButton);
		sineButton.setBounds(0, 120, 100, 110);
		cosineButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(cosineButton);
		cosineButton.setBounds(100, 120, 100, 110);
		tangentButton.addActionListener(calculatorDisplay);
		calculatorDisplay.add(tangentButton);
		tangentButton.setBounds(200, 120, 100, 110);
    }

    /**
     * Toggles additional functions
     */
    public static void toggleAdditionalFunctions() {
        zeroButton.setVisible(additionalFunctionsShown);
        oneButton.setVisible(additionalFunctionsShown);
        twoButton.setVisible(additionalFunctionsShown);
        threeButton.setVisible(additionalFunctionsShown);
        fourButton.setVisible(additionalFunctionsShown);
        fiveButton.setVisible(additionalFunctionsShown);
        sixButton.setVisible(additionalFunctionsShown);
        sevenButton.setVisible(additionalFunctionsShown);
        eightButton.setVisible(additionalFunctionsShown);
        nineButton.setVisible(additionalFunctionsShown);
        leftParenthesisButton.setVisible(!additionalFunctionsShown);
        rightParenthesisButton.setVisible(!additionalFunctionsShown);
        sineButton.setVisible(!additionalFunctionsShown);
        cosineButton.setVisible(!additionalFunctionsShown);
        tangentButton.setVisible(!additionalFunctionsShown);
        factorialButton.setVisible(!additionalFunctionsShown);
        logButton.setVisible(!additionalFunctionsShown);
        naturalLogButton.setVisible(!additionalFunctionsShown);
        exponentButton.setVisible(!additionalFunctionsShown);
        squareRootButton.setVisible(!additionalFunctionsShown);
        additionalFunctionsShown = !additionalFunctionsShown;
    }

    public void refreshDisplay() { //what is the point of this method?
        repaint();
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
        if (clickedButton.getText().equals("DEL")) {
            if (display.equals("Go away")) {
                display = "";
            }
            else if (display.length() != 0 ) {
                display = display.substring(0, display.length() - 1);
            }
        }
        else if (clickedButton.getText().equals("=")) {
            display = doMath(display);
            //TODO utilize stringUtils to clean display param before calling mathUtils
        }
        else if (clickedButton.getText().equals("Additional Functions")) {
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
}