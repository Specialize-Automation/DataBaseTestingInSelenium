package main;

import javax.swing.*;

public class JOptionPaneExample 
{
	public static void main(String [] args)
	{
		
		String firstNumber,secondNumber; 
		int number1, number2,sum;                

firstNumber = JOptionPane.showInputDialog ( "Enter first integer" ); 
 
secondNumber = JOptionPane.showInputDialog ( "Enter second interger" ); 

number1 = Integer.parseInt ( firstNumber); 
number2 = Integer.parseInt ( secondNumber); 

sum = number1 + number2; 

JOptionPane.showMessageDialog (null, "The sum is " + sum, "Results", JOptionPane.PLAIN_MESSAGE); 
JOptionPane.showMessageDialog (null, "The sum is " + sum, "Results", JOptionPane.INFORMATION_MESSAGE); 
JOptionPane.showMessageDialog (null, "The sum is " + sum, "Results", JOptionPane.ERROR_MESSAGE); 
JOptionPane.showMessageDialog (null, "The sum is " + sum, "Results", JOptionPane.WARNING_MESSAGE); 
System.exit ( 0 );
		
	}

}
