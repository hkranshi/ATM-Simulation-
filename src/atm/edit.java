package atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Button;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class edit extends JDialog implements ActionListener {
	private JTextField id;
	private JTextField name;
	private JTextField address;
	private JTextField email;
	private JTextField phone;
	private JTextField balance;
	private JButton load;
	private JButton edit;
	static int iD;
	public edit() {
		getContentPane().setBackground(new Color(240, 230, 140));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Id");
		lblNewLabel.setForeground(new Color(0, 100, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(37, 38, 100, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setForeground(new Color(0, 100, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(37, 75, 88, 25);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(0, 100, 0));
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(37, 111, 100, 27);
		getContentPane().add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(0, 100, 0));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(37, 172, 72, 24);
		getContentPane().add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(new Color(0, 100, 0));
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(37, 218, 72, 23);
		getContentPane().add(lblPhone);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBalance.setForeground(new Color(0, 100, 0));
		lblBalance.setBounds(37, 252, 72, 25);
		getContentPane().add(lblBalance);
		
		id = new JTextField();
		id.setBounds(251, 40, 177, 20);
		getContentPane().add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(251, 75, 177, 20);
		getContentPane().add(name);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(251, 116, 177, 49);
		getContentPane().add(address);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(251, 176, 177, 20);
		getContentPane().add(email);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(251, 221, 177, 20);
		getContentPane().add(phone);
		
		balance = new JTextField();
		balance.setColumns(10);
		balance.setBounds(251, 256, 177, 20);
		getContentPane().add(balance);
		
		load =  new JButton("Load");
		load.setBackground(new Color(0, 100, 0));
		load.setForeground(new Color(255, 255, 255));
		load.setBounds(448, 39, 89, 23);
		getContentPane().add(load);
		
		edit = new JButton("Edit");
		edit.setForeground(new Color(255, 255, 255));
		edit.setBackground(new Color(0, 100, 0));
		edit.setBounds(248, 308, 89, 23);
		getContentPane().add(edit);
		edit.addActionListener(this);
		load.addActionListener(this);
		setModal(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent w){
				id.requestFocusInWindow();
			}
		});
		
		setSize(800, 400);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		new edit();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if (ob==load){
iD=Integer.parseInt(id.getText());
			
			String st="select * from information where ID=?";
			Connection con=Database.connect();
			try{
				PreparedStatement ps=con.prepareStatement(st);
				ps.setInt(1, iD);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					//String name=rs.getString("ename");
					//jname.setText(name);
					name.setText(rs.getString("Name"));
					address.setText(rs.getString("Address"));
					email.setText(rs.getString("Email"));
						phone.setText(""+rs.getString("Phone"));
						balance.setText(""+rs.getInt("Balance"));
		
				}
			}
			catch(SQLException se){
				se.printStackTrace();
			}
					
		}
		else if(ob==edit){
			
			String st="update information set ID='"+id.getText()+"' ,Name='"+name.getText()+"',Address='"+address.getText()+"',Email='"+email.getText()+"',Phone='"+phone.getText()+"',Balance='"+balance.getText()+"' where ID='"+id.getText()+"'";            
			Connection cc=Database.connect();
			try{
			 
				PreparedStatement ps=cc.prepareStatement(st);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(this, "information edit");
			dispose();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		}
		
		// TODO Auto-generated method stub
		
	}
}
