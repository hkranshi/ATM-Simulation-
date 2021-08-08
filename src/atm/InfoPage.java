package atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

import java.awt.Toolkit;

import javax.swing.JLabel;


import java.awt.Font;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class InfoPage extends JDialog implements ActionListener {
	private JTextField id;
	private JTextField name;
	private JTextField adress;
	private JTextField email;
	private JTextField phone;
	private JTextField balance;
	private JButton exit;
	int id1;
	public InfoPage(int id1) {
		this.id1=id1;
		getContentPane().setBackground(new Color(255, 51, 102));
		
		setTitle("Info Page");
		setSize(631,415);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A Smarter Way Of Banking.");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 22));
		lblNewLabel.setBounds(0, 11, 342, 73);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Success comes from having dreams");
		lblNewLabel_1.setFont(new Font("Simplified Arabic Fixed", Font.ITALIC, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(22, 95, 278, 37);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblThatAreBigger = new JLabel("that are bigger than your fears.");
		lblThatAreBigger.setForeground(Color.WHITE);
		lblThatAreBigger.setFont(new Font("Simplified Arabic Fixed", Font.ITALIC, 14));
		lblThatAreBigger.setBounds(22, 116, 278, 58);
		getContentPane().add(lblThatAreBigger);
		
		JLabel lblterryLitwiller = new JLabel("-Terry Litwiller");
		lblterryLitwiller.setForeground(Color.WHITE);
		lblterryLitwiller.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 14));
		lblterryLitwiller.setBounds(22, 185, 193, 37);
		getContentPane().add(lblterryLitwiller);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 16));
		lblUserId.setForeground(new Color(102, 0, 153));
		lblUserId.setBounds(310, 84, 97, 27);
		getContentPane().add(lblUserId);
		
		id = new JTextField();
		id.setBounds(417, 84, 163, 20);
		getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(102, 0, 204));
		lblUsername.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 16));
		lblUsername.setBounds(310, 125, 97, 20);
		getContentPane().add(lblUsername);
		
		name = new JTextField();
		name.setBounds(416, 123, 164, 20);
		getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(102, 0, 255));
		lblAddress.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 16));
		lblAddress.setBounds(310, 164, 97, 20);
		getContentPane().add(lblAddress);
		
		adress = new JTextField();
		adress.setBounds(417, 154, 163, 37);
		getContentPane().add(adress);
		adress.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(102, 0, 255));
		lblEmail.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 16));
		lblEmail.setBounds(310, 211, 97, 20);
		getContentPane().add(lblEmail);
		
		email = new JTextField();
		email.setBounds(417, 211, 163, 20);
		getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(new Color(102, 0, 255));
		lblPhone.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 16));
		lblPhone.setBounds(310, 242, 97, 27);
		getContentPane().add(lblPhone);
		
		phone = new JTextField();
		phone.setBounds(417, 245, 163, 20);
		getContentPane().add(phone);
		phone.setColumns(10);
		
		JLabel lblCurrentBalance = new JLabel("Current Balance");
		lblCurrentBalance.setForeground(new Color(102, 0, 255));
		lblCurrentBalance.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 16));
		lblCurrentBalance.setBounds(222, 287, 193, 14);
		getContentPane().add(lblCurrentBalance);
		balance = new JTextField();
		balance.setBounds(417, 284, 163, 20);
		getContentPane().add(balance);
		balance.setColumns(10);
		
		exit = new JButton("EXIT");
		exit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		exit.setForeground(new Color(153, 0, 204));
		exit.setBounds(343, 327, 103, 25);
		getContentPane().add(exit);
		setModal(true);

	info();
			setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InfoPage(Loginp.iD);
	}

	@Override

		public void actionPerformed(ActionEvent e) {
			Object ob=e.getSource();
				if(ob==exit){
					dispose();
				}

			}
	void info(){
				String st="select * from information where ID=?";
				Connection con=Database.connect();
				try{
					PreparedStatement ps=con.prepareStatement(st);
					ps.setInt(1, Loginp.iD);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						//String name=rs.getString("ename");
						//jname.setText(name);
					id.setText(""+rs.getInt("ID"));
						name.setText(rs.getString("Name"));
						adress.setText(rs.getString("Address"));
						email.setText(rs.getString("Email"));
							phone.setText(""+rs.getString("Phone"));
							balance.setText(""+rs.getDouble("Balance"));
			
					}
				}
				catch(SQLException se){
					se.printStackTrace();
				}
		// TODO Auto-generated method stub
	
			
}
}