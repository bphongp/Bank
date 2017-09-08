package bankSimulation;

import javax.swing.JFrame;
public class BankTest
{
	public static void main(String[] args)
	{ 
		 BankLogin textFieldFrame = new BankLogin(); 
		 textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 //350,100
		 textFieldFrame.setSize(350, 100); 
		 textFieldFrame.setVisible(true);
	} 
}