package atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Button;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Canvas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;


import atm.Database;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

public class Add extends JDialog implements ActionListener {
	private JTextField id;
	private JTextField username;
	private JTextField address;
	private JTextField email;
	private JTextField phone;
	private JTextField balance;
	private JLabel idt;
	private JLabel usernamet;
	private JLabel addresst;
	private JLabel emailt;
	private JLabel phonet;
	private JLabel balancet;
	private JLabel lblPassword;
	private JScrollPane scrollPane;
	private JButton add;
	private JButton browse;
	private JPasswordField password;

	static int iD;
	static String name, emi,adress,number,pass;
	static double account;

	
	
	public Add() {
		setForeground(new Color(255, 0, 255));
		getContentPane().setBackground(new Color(127, 255, 212));
		setBackground(new Color(255, 99, 71));
		getContentPane().setLayout(null);

		idt = new JLabel("Customer ID");
		idt.setFont(new Font("Tahoma", Font.BOLD, 14));
		idt.setForeground(new Color(255, 0, 255));
		idt.setBounds(47, 39, 89, 24);
		getContentPane().add(idt);

		usernamet = new JLabel("Username");
		usernamet.setForeground(new Color(255, 0, 255));
		usernamet.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernamet.setBounds(47, 110, 89, 24);
		getContentPane().add(usernamet);

		addresst = new JLabel("Address");
		addresst.setForeground(new Color(255, 0, 255));
		addresst.setFont(new Font("Tahoma", Font.BOLD, 14));
		addresst.setBounds(47, 156, 89, 24);
		getContentPane().add(addresst);

		emailt = new JLabel("Email");
		emailt.setForeground(new Color(255, 0, 255));
		emailt.setFont(new Font("Tahoma", Font.BOLD, 14));
		emailt.setBounds(47, 227, 60, 30);
		getContentPane().add(emailt);

		phonet = new JLabel("Phone");
		phonet.setForeground(new Color(255, 0, 255));
		phonet.setFont(new Font("Tahoma", Font.BOLD, 14));
		phonet.setBounds(47, 288, 60, 24);
		getContentPane().add(phonet);

		balancet = new JLabel("Balance");
		balancet.setForeground(new Color(255, 0, 255));
		balancet.setFont(new Font("Tahoma", Font.BOLD, 14));
		balancet.setBounds(47, 339, 60, 24);
		getContentPane().add(balancet);

		id = new JTextField();
		id.setBounds(289, 43, 86, 20);
		getContentPane().add(id);
		id.setColumns(10);

		username = new JTextField();
		username.setBounds(289, 114, 86, 20);
		getContentPane().add(username);
		username.setColumns(10);

		address = new JTextField();
		address.setBounds(289, 160, 168, 63);
		getContentPane().add(address);
		address.setColumns(10);

		email = new JTextField();
		email.setBounds(289, 234, 86, 20);
		getContentPane().add(email);
		email.setColumns(10);

		phone = new JTextField();
		phone.setBounds(289, 292, 86, 20);
		getContentPane().add(phone);
		phone.setColumns(10);

		balance = new JTextField();
		balance.setBounds(289, 343, 86, 20);
		getContentPane().add(balance);
		balance.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		getContentPane().add(scrollPane);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Add.class.getResource("/image/download.jpg")));
		label.setBounds(563, 62, 149, 123);
		getContentPane().add(label);

		password = new JPasswordField();
		password.setBounds(289, 83, 86, 20);
		getContentPane().add(password);

		lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 0, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(47, 85, 89, 14);
		getContentPane().add(lblPassword);

		add = new JButton("Add");
		add.setForeground(new Color(255, 255, 255));
		add.setBackground(new Color(255, 0, 255));

		add.setBounds(277, 407, 89, 23);
		getContentPane().add(add);

		browse = new JButton("Browse");
		browse.setForeground(new Color(255, 255, 255));
		browse.setBackground(new Color(255, 0, 255));
		browse.setBounds(583, 196, 89, 23);
		getContentPane().add(browse);
		setSize(800,500);
		add.addActionListener(this);
		browse.addActionListener(this);
		setModal(true);

		this.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent w){
				id.requestFocusInWindow();
			}
		});

		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Add();

	}

	@Override
	public void actionPerformed(ActionEvent e) {


		Object ob=e.getSource();
		if (ob==browse){
			dispose();
		}
		else if(ob==add){

			iD=Integer.parseInt(id.getText());
			name=username.getText();
			emi=email.getText();
			adress=address.getText();
			account=Double.parseDouble(balance.getText());
			number=phone.getText();
			pass=password.getText();
			int ai=Loginp.iD;
			String st="insert into information(ID,Name,Address,Email,"+"Phone,Balance,Password,AdminId)values(?,?,?,?,?,?,?,?)";
			Connection cc=Database.connect();
			try{
				PreparedStatement ps=cc.prepareStatement(st);
				ps.setInt(1, iD);
				ps.setString(2, name);
				ps.setString(3, adress);
				ps.setString(4, emi);
				ps.setString(5, number);
				ps.setDouble(6, account);
				ps.setString(7, pass);
				ps.setInt(8, ai);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "information added");
				dispose();
			}
			catch(SQLException se){
				se.printStackTrace();
			}

			// TODO Auto-generated method stub	
		}

	}
}
