package bankSimulation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class BankLogin extends JFrame implements ActionListener 
{
   private final JButton  loginButton;
   private final JTextField userNameField;
   private final JPasswordField passwordField;
   private final JLabel promptUser, promptPassword;
   private final JPanel loginPanelUser, loginPanelPassword,
   		loginPanel;

   // set up GUI and event handling
   public BankLogin()
   {
      super("Banking");

    //create panel for user part of layout
      loginPanelUser = new JPanel();
      //create panel for pw part of layout
      loginPanelPassword = new JPanel();
      
      loginPanelUser.setLayout(new BorderLayout());//set panels to border
      loginPanelPassword.setLayout(new BorderLayout());//set to borderlayout
      
      userNameField = new JTextField(15);//create text field to enter user
      passwordField = new JPasswordField(15);//create password field to enter pw
      promptUser = new JLabel("Username ");//Label to prompt user to enter username
      promptPassword = new JLabel("Password ");//label to prompt user to enter password
      loginButton = new JButton("Login");//login button that will have action
      
      //set up the username promp and text field
      loginPanelUser.add(promptUser, BorderLayout.WEST);
      loginPanelUser.add(userNameField, BorderLayout.EAST);
      
      //set up the password prompt and textfield
      loginPanelPassword.add(promptPassword, BorderLayout.WEST);
      loginPanelPassword.add(passwordField, BorderLayout.EAST);
      
      //make new panel to put other panels in
      loginPanel = new JPanel();
      loginPanel.setLayout(new BorderLayout());
      
      //add other panels to the main panel login
      add(loginPanelUser, BorderLayout.NORTH);
      add(loginPanelPassword, BorderLayout.CENTER);
      add(loginButton, BorderLayout.SOUTH);
      
      //make action listen for the login button
      loginButton.addActionListener(this);
   }
   // handle button events
   @Override
   public void actionPerformed(ActionEvent event)
   {
	   //read in the string user enters
	   String userName = userNameField.getText();
	   		@SuppressWarnings("deprecation")
	   String password = passwordField.getText();
	   		//given that we have a username & password use event handlers
	   		if(userName.equalsIgnoreCase("bphongp") && password.equals("cake"))
	   		{
	   			BankWelcome successfulLogin = new BankWelcome();//calls different class where can login
	   			successfulLogin.setVisible(true);//make the GUI visible
	   		}
	   		else
	   		{
	   			JOptionPane.showMessageDialog(this, "Send Nudes", "Error 404",
	   						JOptionPane.ERROR_MESSAGE);
	   		}
	   	setVisible(false);
   }//end action handler method
} // end class BorderLayoutFrame



