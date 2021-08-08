package atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;



import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class BalancePage extends JDialog {
	private JTextField balance;
	double bl;
	String g;
	public BalancePage() {
		getContentPane().setBackground(new Color(154, 205, 50));
		getContentPane().setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(10, 11, 46, 14);
		getContentPane().add(label);

		JLabel lblASmarterWay = new JLabel("A Smarter Way Of Banking.");

		lblASmarterWay.setFont(new Font("Mongolian Baiti", Font.BOLD, 22));
		lblASmarterWay.setBackground(new Color(240, 240, 240));
		lblASmarterWay.setForeground(Color.WHITE);
		lblASmarterWay.setBounds(10, 11, 332, 66);
		getContentPane().add(lblASmarterWay);

		JLabel lblNewLabel = new JLabel("Imagination is more important");
		lblNewLabel.setFont(new Font("Simplified Arabic Fixed", Font.ITALIC, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(32, 104, 254, 24);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("than knowledge.");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Simplified Arabic Fixed", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(32, 129, 230, 24);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("-Albert Einstein");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 12));
		lblNewLabel_2.setBounds(32, 164, 145, 34);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Account Balance");
		lblNewLabel_3.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setForeground(SystemColor.inactiveCaptionText);
		lblNewLabel_3.setBounds(352, 68, 216, 42);
		getContentPane().add(lblNewLabel_3);

		balance = new JTextField();
		balance.setBackground(new Color(175, 238, 238));
		balance.setEditable(false);
		balance.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 16));
		balance.setForeground(SystemColor.inactiveCaptionText);
		balance.setBounds(362, 117, 156, 24);
		getContentPane().add(balance);
		balance.setColumns(10);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setMnemonic('c');
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(460, 206, 89, 23);
		getContentPane().add(btnClose);

		setTitle("Balance Page");
		setSize(575,278);
		setModal(true);
		checkBalance();
		setVisible(true);
	}

	public static void main(String[] args) {
		new BalancePage();
		// TODO Auto-generated method stub

	}


	void checkBalance() {
		String st="select sum(Deposit) as dep,sum(Withdrawl) as wit from transactions where userid=?";
		Connection con=Database.connect();
		try{
			PreparedStatement ps=con.prepareStatement(st);
			ps.setInt(1, Loginp.iD);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				double d=rs.getDouble("dep");
				double w=rs.getDouble("wit");
				bl=d-w;
				g=String.format("%.2f", bl);
				balance.setText(g);
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		//			String st1="insert into information(ID,Balance)values(?,?)";
		//			Connection cc=Database.connect();
		//			try{
		//				PreparedStatement p=cc.prepareStatement(st1);
		//				p.setInt(1, Loginp.iD);
		//				p.setDouble(2, bl);
		//
		//				p.executeUpdate();
		//				dispose();
		//			}
		//			catch(SQLException se){
		//				se.printStackTrace();
		//			}
		//
	}
}
