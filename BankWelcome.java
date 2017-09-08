package bankSimulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankWelcome extends JFrame
{
	private JLabel savingsBalance, checkingBalance, cWithAmount,
		sWithAmount, sDepAmount, cDepAmount, transferAmount;
	private double savingsAmount = 10750, checkingAmount = 2489;
	private JPanel checkingPanel, savingsPanel, balancePanel,
		savingsGrid, checkingGrid, saveDepActionPanel, saveWithActionPanel;
	private final GridLayout savingsButtons, checkingButtons;
	private JButton balances, saveWithdrawal, transferButton,
		saveDeposit, checkWithdrawal, checkDeposit,sWithButton,
		sDepButton;
	private JTextField enterCWithdrawal, enterSWithdrawal, 
		enterCDeposit, enterSDeposit, enterTransfer;
	//private ContentPane savingsPane;
	private BankSavingsWith savingsWithdrawalObj;
	private BankBalance balance;
	private BankSavingsDep savingsDepObj;
	private ButtonHandlerSaveDep handleSD;
	private ButtonHandlerSaveWith handleSW;
	private ButtonHandlerMain handle;
	private ButtonHandler handler;
	private ButtonHandler1 handler1;
	public BankWelcome()
	{
		super("button");
		//welcome window
		setDefaultCloseOperation(javax.swing.
				WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Your Bank Account");
		setSize(350, 200);
		
		balances = new JButton("Look at balances");
		add(balances);
		
		checkingPanel = new JPanel();
		checkingPanel.setLayout(new FlowLayout());
		
		savingsPanel = new JPanel();
		savingsPanel.setLayout(new FlowLayout());
		
		//creates the grid for actions on checkings
		checkingGrid = new JPanel();
		checkingButtons = new GridLayout(3,3);
		checkingGrid.setLayout(checkingButtons);
		
		//creates the grid for actions on savings
		savingsGrid = new JPanel();
		savingsButtons = new GridLayout(3,3);
		savingsGrid.setLayout(savingsButtons);
		
		//panel that shows all the buttons and balance for both account
		balancePanel = new JPanel();
		//balancePanel.setLayout(new BoxLayout(balancePanel, BoxLayout.PAGE_AXIS));
		balancePanel.setLayout(new BorderLayout());
		
		//buttons for the checking account
		checkWithdrawal = new JButton("Withdrawal");
		checkDeposit = new JButton("Deposit");
		
		savingsBalance = new JLabel("Savings Balance $"+savingsAmount);//shows the user balance
		checkingBalance = new JLabel("Checking Balance $" +checkingAmount);//shows user balance
		
		//buttons for the savings account
		transferButton = new JButton("Transfer");
		saveWithdrawal = new JButton("Withdrawal");
		saveDeposit = new JButton("Deposit");
		
		//fields for the actions buttons for savings withdrawal
		sWithAmount = new JLabel("Amount Withdrawal: ");
		sWithButton = new JButton("Withdrawal");
		saveWithActionPanel = new JPanel();
		saveWithActionPanel.setLayout(new BorderLayout());
		enterSWithdrawal = new JTextField(20);
		savingsWithdrawalObj= new BankSavingsWith();
		
		//fields for the action buttons for savings deposit
		saveDepActionPanel = new JPanel();
		sDepAmount = new JLabel("Amount Deposit: ");
		sDepButton = new JButton("Deposit");
		saveDepActionPanel.setLayout(new BorderLayout());
		enterSDeposit = new JTextField(20);
		savingsDepObj = new BankSavingsDep();
		
		handleSW = new ButtonHandlerSaveWith();//handles when action save withdrawal subtract
		handleSD = new ButtonHandlerSaveDep();//handles action for save dep adding to current balance
		handler = new ButtonHandler();//handler for savings withdrawal
		handler1 = new ButtonHandler1();//handler for savings deposit
		
		ButtonHandlerMain handle = new ButtonHandlerMain();
		balances.addActionListener(handle);//balances button that shows all options		
	}//end class
	public class ButtonHandlerMain implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			balancesOfAll();
			
			/**ButtonHandler handler = new ButtonHandler();
			saveWithdrawal.addActionListener(handler);
			
			ButtonHandler1 handler1 = new ButtonHandler1();
			saveDeposit.addActionListener(handler1);**/
			setVisible(false);
		}//end action event
	}
	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			savingsWithdrawalObj.setVisible(true);
			saveWithActionPanel.add(sWithAmount, BorderLayout.WEST);
			saveWithActionPanel.add(enterSWithdrawal, BorderLayout.CENTER);
			saveWithActionPanel.add(sWithButton, BorderLayout.EAST);

			savingsWithdrawalObj.getContentPane().add(saveWithActionPanel);
			
			//handleSW = new ButtonHandlerSaveWith();
			sWithButton.addActionListener(handleSW);
			balance.setVisible(false);
		}
	}
	private class ButtonHandler1 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			savingsDepObj.setVisible(true);
			saveDepActionPanel.add(sDepAmount, BorderLayout.WEST);
			saveDepActionPanel.add(enterSDeposit, BorderLayout.CENTER);
			saveDepActionPanel.add(sDepButton, BorderLayout.EAST);
			savingsDepObj.getContentPane().add(saveDepActionPanel);
			
			//handleSD = new ButtonHandlerSaveDep();
			sDepButton.addActionListener(handleSD);
		}
	}
	private class ButtonHandlerSaveWith implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				double savingsWith = Double.parseDouble(enterSWithdrawal.getText());
				if(savingsWith<=savingsAmount && savingsWith>0)
				{
					savingsAmount = savingsAmount-savingsWith;
					System.out.println(savingsAmount);
					savingsBalance.setText("Savings Balance $"+savingsAmount);
					balancesOfAll();
				}
				else
					System.out.println("Enter Valid Amount");
			}
			catch(NumberFormatException ex) 
			{
			    ex.printStackTrace();
			    // handle the error
			}
		}
	}
	public class ButtonHandlerSaveDep implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				double savingsDep = Double.parseDouble(enterSDeposit.getText());
				if(savingsDep>0)
				{
					savingsAmount = savingsAmount+savingsDep;
					System.out.println(savingsAmount);
					savingsBalance.setText("Savings Balance $"+savingsAmount);
					balancesOfAll();
				}
				else
					System.out.println("Enter Valid Amount");
			}
			catch(NumberFormatException ex) 
			{
			    ex.printStackTrace();
			    // handle the error
			}
		}
	}
	private void balancesOfAll()
	{
		balance = new BankBalance();//calls different class where can login
		balance.setVisible(true);//make the GUI visible
		//grid layout that has all the buttons
		savingsGrid.add(saveWithdrawal);
		savingsGrid.add(saveDeposit);
		
		//add checking buttons to the Gridlayout of checkings
		checkingGrid.add(checkWithdrawal);
		checkingGrid.add(checkDeposit);
		
		//add savings buttons to the grid layout of savings
		savingsPanel.add(savingsBalance);
		savingsPanel.add(savingsGrid);
		
		//add checkings buttons to the grid layout of checkings
		checkingPanel.add(checkingBalance);
		checkingPanel.add(checkingGrid);
		
		balancePanel.add(savingsPanel, BorderLayout.NORTH);
		balancePanel.add(checkingPanel, BorderLayout.CENTER);
		balancePanel.add(transferButton, BorderLayout.SOUTH);
		balance.getContentPane().add(balancePanel);
		
		//ButtonHandlerMain handle = new ButtonHandlerMain();
		balances.addActionListener(handle);//end actionlistener	
		
		saveWithdrawal.addActionListener(handler);
		
		saveDeposit.addActionListener(handler1);
	}
}


