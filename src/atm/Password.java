/**
 * 
 */
package atm;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JPasswordField;

/**
 * @author dell
 *
 */
public class Password extends JDialog implements ActionListener{
	private JButton change;
	private JPasswordField old;
	private JPasswordField newp;
	private JPasswordField confirm;

 int id;
	public Password() {
		
		getContentPane().setBackground(new Color(250, 128, 114));
		setTitle("Password");
		getContentPane().setLayout(null);
		
		JLabel lblASmarterWay = new JLabel("A Smarter Way Of Banking");
		lblASmarterWay.setForeground(new Color(255, 255, 255));
		lblASmarterWay.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 26));
		lblASmarterWay.setBounds(188, 56, 361, 56);
		getContentPane().add(lblASmarterWay);
		
		JLabel lblOldPassword = new JLabel("Old  Password ");
		lblOldPassword.setForeground(new Color(245, 245, 245));
		lblOldPassword.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblOldPassword.setBounds(107, 200, 259, 29);
		getContentPane().add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New  Password");
		lblNewPassword.setForeground(new Color(255, 255, 255));
		lblNewPassword.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewPassword.setBounds(107, 269, 167, 14);
		getContentPane().add(lblNewPassword);
		
		JLabel lblNewLabel_1 = new JLabel("Confirm Password");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1.setBounds(107, 326, 167, 23);
		getContentPane().add(lblNewLabel_1);
		
		change = new JButton("Change");
		change.setFont(new Font("Arial Unicode MS", Font.BOLD, 15));
		change.setBounds(308, 409, 107, 29);
		getContentPane().add(change);
		
		old = new JPasswordField();
		old.setBounds(438, 200, 180, 26);
		getContentPane().add(old);
		
		newp = new JPasswordField();
		newp.setBounds(438, 259, 180, 29);
		getContentPane().add(newp);
		
		confirm = new JPasswordField();
		confirm.setBounds(438, 326, 180, 23);
		getContentPane().add(confirm);
		// TODO Auto-generated constructor stub
		setSize(700, 600);
		setVisible(true);
		change.addActionListener(this);
		setModal(true);

		this.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent w){
				old.requestFocusInWindow();
			}
		});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Password();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==change){
			id=Loginp.iD;
			String o=old.getText();
			String cu=newp.getText();
			String co=confirm.getText();
			boolean b=cu.equals(co);
			String st="update information set Password ='"+confirm.getText()+"' where ID='"+Loginp.iD+"'";            
			Connection cc=Database.connect();
			try{
			 if(b==true){
				PreparedStatement ps=cc.prepareStatement(st);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(this, "Password Change");
			dispose();
			 }
			 else{
				 JOptionPane.showMessageDialog(this, "Invalid");
			 }
		}
		catch(SQLException se){
			se.printStackTrace();
		}
			}
			
			
		}
		// TODO Auto-generated method stub
		
	}

