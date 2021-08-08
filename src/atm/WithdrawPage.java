/**
 * 
 */
package atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author dell
 *
 */
public class WithdrawPage extends JDialog implements ActionListener {
	private JTextField amount;
	private JButton withdraw;
	private JLabel lblTransactionSuccessful;
	private JLabel lblEnterAnAmount;
	private JLabel lblASmarterWay;
	int trid;
	java.sql.Date date;
	String d;
	/**
	 * 
	 */
	public WithdrawPage() {
		
		getContentPane().setBackground(new Color(152, 251, 152));
		setBackground(new Color(255, 255, 255));
		setTitle("Withdraw Page");
		getContentPane().setLayout(null);
		
		lblASmarterWay = new JLabel("A Smarter Way Of  Banking.");
		lblASmarterWay.setIcon(null);
		lblASmarterWay.setForeground(Color.BLACK);
		lblASmarterWay.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 26));
		lblASmarterWay.setBounds(186, 25, 376, 62);
		getContentPane().add(lblASmarterWay);
		
		JLabel lblL = new JLabel("To  accomplish  great  things,  we");
		lblL.setForeground(Color.BLACK);
		lblL.setFont(new Font("Arial Unicode MS", Font.BOLD, 17));
		lblL.setBounds(518, 409, 309, 32);
		getContentPane().add(lblL);
		
		JLabel lblNewLabel = new JLabel("must  not  only  act,  but  also  dream, ");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial Unicode MS", Font.BOLD, 17));
		lblNewLabel.setBounds(506, 439, 340, 26);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("not  only  plan,  but  also  believe. ");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial Unicode MS", Font.BOLD, 17));
		lblNewLabel_1.setBounds(518, 464, 295, 26);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("-Anatole France\r\n\r\n");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Arial Unicode MS", Font.BOLD, 18));
		lblNewLabel_2.setBounds(652, 523, 175, 44);
		getContentPane().add(lblNewLabel_2);
		
		lblEnterAnAmount = new JLabel("ENTER AN AMOUNT");
		lblEnterAnAmount.setFont(new Font("Arial Unicode MS", Font.BOLD, 30));
		lblEnterAnAmount.setForeground(Color.RED);
		lblEnterAnAmount.setBounds(219, 98, 412, 71);
		getContentPane().add(lblEnterAnAmount);
		
		amount = new JTextField();
		amount.setBounds(219, 185, 319, 38);
		getContentPane().add(amount);
		amount.setColumns(10);
		
		withdraw = new JButton("withdraw");
		withdraw.setForeground(Color.DARK_GRAY);
		withdraw.setFont(new Font("Arial Unicode MS", Font.BOLD, 21));
		withdraw.setBackground(new Color(255, 255, 0));
		withdraw.setBounds(309, 265, 158, 32);
		getContentPane().add(withdraw);
		
		lblTransactionSuccessful = new JLabel("Transaction Successful");
		lblTransactionSuccessful.setBackground(Color.WHITE);
		lblTransactionSuccessful.setForeground(Color.RED);
		lblTransactionSuccessful.setFont(new Font("Arial Unicode MS", Font.BOLD, 17));
		lblTransactionSuccessful.setBounds(312, 329, 209, 26);
		getContentPane().add(lblTransactionSuccessful);
		// TODO Auto-generated constructor stub
		setSize(1000, 600);
		setVisible(true);
		withdraw.addActionListener(this);
		
		setModal(true);

		this.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent w){
				amount.requestFocusInWindow();
			}
		});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new WithdrawPage();
		// TODO Auto-generated method stub

	}
	
		// TODO Auto-generated method stub
		
	
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o==withdraw){
			getID();
			java.util.Date dt=new java.util.Date();
			date=new java.sql.Date(dt.getTime());
			d=date.toString();
			double balance=Double.parseDouble(amount.getText());
			if(DepositPage.balance>=balance)
			{
			String st="insert into transactions(TID,tdate, userid,Deposit,withdrawl)values(?,?,?,?,?)";
			Connection cc=Database.connect();
			try{
				PreparedStatement ps=cc.prepareStatement(st);
				ps.setInt(1, trid);
				ps.setDate(2, date);
				ps.setInt(3,Loginp.iD);
				ps.setDouble(4, 0);
				ps.setDouble(5, balance);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "amount withdrawl");
				dispose();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			}
			else{
				JOptionPane.showMessageDialog(this, "invalid amount");
				dispose();
			}}
		}
	void getID(){
		String st="select max(tid) from transactions";
		Connection con=Database.connect();
		try{
			PreparedStatement ps=con.prepareStatement(st);
			ResultSet rs=ps.executeQuery();
			rs.next();
			trid=rs.getInt(1);
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		++trid;
	}
}