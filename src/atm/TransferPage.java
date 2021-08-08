package atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class TransferPage extends JDialog implements ActionListener{
	private JTextField wamount;
	private JTextField damount;
	private JButton exit;
	private JTextField wdate;
	public TransferPage() {
		getContentPane().setBackground(new Color(255, 127, 80));
		getContentPane().setLayout(null);
		
		JLabel lblASmarterWay = new JLabel("A Smarter Way Of Banking.");

		lblASmarterWay.setFont(new Font("Mongolian Baiti", Font.BOLD, 22));
		lblASmarterWay.setForeground(Color.WHITE);
		lblASmarterWay.setBounds(0, 11, 348, 48);
		getContentPane().add(lblASmarterWay);
		
		JLabel lblNewLabel = new JLabel("Imagination is more important");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Simplified Arabic Fixed", Font.ITALIC, 14));
		lblNewLabel.setBounds(23, 99, 239, 55);
		getContentPane().add(lblNewLabel);
		
		JLabel lblThanKnowledge = new JLabel("than knowledge.");
		lblThanKnowledge.setForeground(Color.WHITE);
		lblThanKnowledge.setFont(new Font("Simplified Arabic Fixed", Font.ITALIC, 14));
		lblThanKnowledge.setBounds(23, 139, 239, 25);
		getContentPane().add(lblThanKnowledge);
		
		JLabel lblalbertEinstein = new JLabel("-Albert Einstein");
		lblalbertEinstein.setForeground(Color.WHITE);
		lblalbertEinstein.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 14));
		lblalbertEinstein.setBounds(23, 185, 150, 31);
		getContentPane().add(lblalbertEinstein);
		
		JLabel lblReceiverId = new JLabel("Withdraw Amount");
		lblReceiverId.setForeground(new Color(0, 255, 255));
		lblReceiverId.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 16));
		lblReceiverId.setBounds(234, 76, 188, 23);
		getContentPane().add(lblReceiverId);
		
		JLabel lblAmount = new JLabel("Deposit Amount");
		lblAmount.setForeground(new Color(0, 255, 255));
		lblAmount.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 16));
		lblAmount.setBounds(272, 119, 150, 23);
		getContentPane().add(lblAmount);
		
		exit = new JButton("EXIT");
		exit.setForeground(new Color(0, 0, 128));
		exit.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 16));
		exit.setBounds(393, 241, 105, 25);
		getContentPane().add(exit);
		
		wamount = new JTextField();
		wamount.setBounds(432, 77, 136, 20);
		getContentPane().add(wamount);
		wamount.setColumns(10);
		
		damount = new JTextField();
		damount.setBounds(432, 116, 136, 20);
		getContentPane().add(damount);
		damount.setColumns(10);
		
		JLabel lblRetypePassword = new JLabel("Withdraw Date");
		lblRetypePassword.setForeground(new Color(0, 255, 255));
		lblRetypePassword.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 16));
		lblRetypePassword.setBounds(247, 153, 175, 37);
		getContentPane().add(lblRetypePassword);
		
		wdate = new JTextField();
		wdate.setBounds(432, 161, 136, 20);
		getContentPane().add(wdate);
		wdate.setColumns(10);
		
		setTitle("Tranfer Page");
		setSize(597,315);
				setVisible(true);
		exit.addActionListener(this);
		setModal(true);
		transfer();
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TransferPage();

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==exit){
			dispose();
		}
	}
			void transfer(){
			String st="select * from transactions where userid=?";
			Connection con=Database.connect();
			try{
				PreparedStatement ps=con.prepareStatement(st);
				ps.setInt(1,Loginp.iD);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					wdate.setText(rs.getString("TDate"));
					wamount.setText(""+rs.getDouble("Withdrawl"));
					damount.setText(""+rs.getDouble("Deposit"));
		
				}
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		
		
		// TODO Auto-generated method stub
		
	}
}
