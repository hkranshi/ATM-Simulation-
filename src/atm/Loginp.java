/**
 * 
 */
package atm;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;

import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.ButtonGroup;

import  atm.User2;
import atm.admin;
import javax.swing.JPasswordField;

/**
 * @author dell
 *
 */
public class Loginp extends JDialog implements ActionListener {
	private JTextField id;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton user;
	private JRadioButton admin;
	private JButton login;
	static int iD;
	String pass;
	static String name;
	private JPasswordField password;
	/**
	 * 
	 */
	public Loginp() {
		getContentPane().setBackground(new Color(255, 255, 153));

		setTitle("Login");
		getContentPane().setLayout(null);

		id = new JTextField();
		id.setBounds(432, 245, 236, 38);
		getContentPane().add(id);
		id.setColumns(10);

		user = new JRadioButton("USER");
		buttonGroup.add(user);
		user.setBackground(new Color(204, 0, 0));
		user.setForeground(new Color(0, 0, 0));
		user.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
		user.setBounds(241, 139, 109, 29);
		getContentPane().add(user);

		admin = new JRadioButton("ADMIN");
		buttonGroup.add(admin);
		admin.setBackground(new Color(204, 0, 0));
		admin.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
		admin.setBounds(432, 139, 109, 28);
		getContentPane().add(admin);

		login = new JButton("LOGIN");
		login.setBackground(new Color(204, 0, 0));
		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("Tahoma", Font.PLAIN, 14));
		login.setBounds(329, 445, 116, 29);
		getContentPane().add(login);

		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(204, 0, 0));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(297, 246, 124, 32);
		getContentPane().add(lblId);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(204, 0, 0));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(297, 332, 87, 38);
		getContentPane().add(lblPassword);

		password = new JPasswordField();
		password.setBounds(432, 332, 236, 31);
		getContentPane().add(password);
		setSize(800, 650);
		setVisible(true);
		admin.addActionListener(this);
		login.addActionListener(this);
		user.addActionListener(this);
		setModal(true);

		this.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent w){
				id.requestFocusInWindow();
			}
		});
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {
		new Loginp();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		String query=null;
		String utype=null;

		if(ob==login) {
			iD=Integer.parseInt(id.getText());
			pass=new String(password.getPassword());
			Connection con=Database.connect();
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				if(user.isSelected()) {
					query="select * from information where id=? and password=?";
					ps=con.prepareStatement(query);
					ps.setInt(1, iD);
					ps.setString(2, pass);
					rs=ps.executeQuery();
					if(rs.next()) {
						name=rs.getString("Name");
						new User2(iD);
						dispose();
					}
				}
				else if(admin.isSelected()) {
					query="select * from admin where adminid=? and password=?";
					ps=con.prepareStatement(query);
					ps.setInt(1, iD);
					ps.setString(2, pass);
					rs=ps.executeQuery();
					if(rs.next()) {
						name=rs.getString("adminName");
						new admin(iD,name);
						dispose();
					}
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
