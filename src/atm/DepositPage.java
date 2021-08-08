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

public class DepositPage extends JDialog implements ActionListener {
	private JTextField amount;
	private JButton deposit;
	static double balance;
	int trid;
	java.sql.Date date;
	String d;
	private JLabel lblNewLabel;
	private JLabel lblImaginationIsMore;
	private JLabel lblThanKnowledge;
	private JLabel lblalbertEinstein;
	private JLabel lblEnterAnAmount;
	public DepositPage() {
		getContentPane().setBackground(new Color(51, 0, 102));
		getContentPane().setLayout(null);

		lblNewLabel = new JLabel("A Smarter Way Of Banking.");

		lblNewLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 22));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 347, 80);
		getContentPane().add(lblNewLabel);

		lblImaginationIsMore = new JLabel("Imagination is more important ");
		lblImaginationIsMore.setFont(new Font("Simplified Arabic Fixed", Font.ITALIC, 14));
		lblImaginationIsMore.setForeground(Color.WHITE);
		lblImaginationIsMore.setBounds(20, 103, 261, 32);
		getContentPane().add(lblImaginationIsMore);

		lblThanKnowledge = new JLabel("than knowledge.");
		lblThanKnowledge.setForeground(Color.WHITE);
		lblThanKnowledge.setFont(new Font("Simplified Arabic Fixed", Font.ITALIC, 14));
		lblThanKnowledge.setBounds(20, 129, 243, 32);
		getContentPane().add(lblThanKnowledge);

		lblalbertEinstein = new JLabel("-Albert Einstein");
		lblalbertEinstein.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 12));
		lblalbertEinstein.setForeground(Color.WHITE);
		lblalbertEinstein.setBounds(20, 172, 143, 43);
		getContentPane().add(lblalbertEinstein);

		lblEnterAnAmount = new JLabel("Enter An Amount");
		lblEnterAnAmount.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 16));
		lblEnterAnAmount.setForeground(Color.PINK);
		lblEnterAnAmount.setBounds(337, 66, 220, 69);
		getContentPane().add(lblEnterAnAmount);

		amount = new JTextField();
		amount.setBounds(318, 129, 208, 32);
		getContentPane().add(amount);
		amount.setColumns(10);

		deposit = new JButton("Deposit");
		deposit.setForeground(Color.MAGENTA);
		deposit.setBackground(Color.WHITE);
		deposit.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 14));
		deposit.setBounds(408, 181, 95, 23);
		getContentPane().add(deposit);

		setTitle("Deposit Page");
		setSize(583,306);
		setVisible(true);
		deposit.addActionListener(this);
		setModal(true);

		this.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent w){
				amount.requestFocusInWindow();
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DepositPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();

		if(ob==deposit){
			getID();
			balance=Double.parseDouble(amount.getText());
			java.util.Date dt=new java.util.Date();
			date=new java.sql.Date(dt.getTime());
			d=date.toString();
			String st="insert into transactions(TID,tdate, userid,Deposit,withdrawl)values(?,?,?,?,?)";
			Connection cc=Database.connect();
			try{
				PreparedStatement ps=cc.prepareStatement(st);
				ps.setInt(1, trid);
				ps.setDate(2, date);
				ps.setInt(3,Loginp.iD);
				ps.setDouble(4, balance);
				ps.setDouble(5, 0);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "amount deposit");
				dispose();
			}
			catch(SQLException se){
				se.printStackTrace();
			}

		}
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

