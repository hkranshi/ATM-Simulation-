package atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Button;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;

public class Reset extends JDialog implements ActionListener  {
	private JTextField id;
	private JTextField password;
	private JButton cancel;
	private JButton reset;

	public Reset() {
		setBackground(new Color(50, 205, 50));
		getContentPane().setBackground(new Color(255, 182, 193));
		getContentPane().setLayout(null);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustomerId.setForeground(new Color(255, 0, 0));
		lblCustomerId.setBounds(22, 50, 120, 35);
		getContentPane().add(lblCustomerId);
		
		id = new JTextField();
		id.setBounds(171, 59, 168, 20);
		getContentPane().add(id);
		id.setColumns(10);
		
		password = new JTextField();
		password.setBounds(80, 204, 316, 81);
		getContentPane().add(password);
		password.setColumns(10);
		
		reset = new JButton("Reset");
		reset.setBackground(new Color(255, 0, 0));
		reset.setForeground(new Color(255, 255, 255));
		reset.setBounds(119, 137, 89, 23);
		getContentPane().add(reset);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(new Color(255, 0, 0));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(291, 137, 89, 23);
		getContentPane().add(cancel);
		reset.addActionListener(this);
		cancel.addActionListener(this);
		setModal(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent w){
				id.requestFocusInWindow();
			}
		});
		setSize(500, 350);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Reset();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob=e.getSource();
		if (ob==cancel){
		dispose();	
		}
		else if(ob==reset){
			
			String st="update information set Password='"+password.getText()+"' where  ID='"+id.getText()+"' ";
			Connection cc=Database.connect();
			try{
				PreparedStatement ps=cc.prepareStatement(st);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(this, "password reset");
			dispose();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
	}
}
