package atm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;

public class admin extends JDialog implements ActionListener

{
	int id;
	String name;
	String address;
	String email;
	String phone;
	 
	DefaultTableModel model;
	JScrollPane jsp;
	private JButton add;
	private JButton edit;
	private JButton delete;
	private JButton reset;
	private JPanel panel;
	String adid;
	static double balance;
	 int aname;
	public admin(int adname,String adid) {
		aname=adname;
		this.adid=adid;
		getContentPane().setForeground(new Color(135, 206, 250));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		setForeground(new Color(0, 0, 255));
		getContentPane().setBackground(new Color(173, 255, 47));
		setTitle("Administration Modes");
		String st="select * from information";
		try{
			Connection con=Database.connect();
			PreparedStatement ps=con.prepareStatement(st);
			ResultSet rs=ps.executeQuery();
			String column[]=new String[]{" Id","Name","Address","Email","Phone","Balance"};
			model=new DefaultTableModel();
			model.setColumnIdentifiers(column);
			JTable table=new JTable();
			table.setFont(new Font("Tahoma",Font.BOLD,14));
			table.setBackground(new Color(238,130,238));
			table.setForeground(new Color(255,0 ,0));
			table.setModel(model);
			//	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			//	table.setFillsViewportHeight(true);
			while(rs.next()){
				 id=rs.getInt("Id");
				 name=rs.getString("Name");
				 address=rs.getString("Address");
				 email=rs.getString("Email");
				 phone=rs.getString("Phone");
				 balance=rs.getDouble("Balance");
				model.addRow(new Object[]{id,name,address,email,phone,balance});
			}
			jsp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		}
		catch(SQLException se){
			se.printStackTrace();
			dispose();
			return;
		}
		getContentPane().add(jsp);
		setSize(649, 377);
		jsp.setBounds(44, 11, 550, 250);


		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBackground(new Color(255, 0, 0));
		horizontalStrut.setBounds(0, 0, 20, 1);
		getContentPane().add(horizontalStrut);
		getContentPane().setLayout(null);

		JLabel lblAdminInformation = new JLabel("Admin Information");
		lblAdminInformation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdminInformation.setBounds(651, 22, 140, 22);
		getContentPane().add(lblAdminInformation);

		add = new JButton("Add Customer");

		add.setBackground(new Color(0, 0, 255));
		add.setForeground(new Color(255, 255, 255));
		add.setFont(new Font("Tahoma", Font.BOLD, 14));
		add.setBounds(494, 283, 175, 23);
		getContentPane().add(add);

		edit = new JButton("Edit Customer");
		edit.setForeground(new Color(255, 255, 255));
		edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		edit.setBackground(new Color(0, 0, 255));
		edit.setBounds(723, 283, 151, 23);
		getContentPane().add(edit);

		delete = new JButton("Delete Customer");
		delete.setForeground(new Color(255, 255, 255));
		delete.setBackground(new Color(0, 0, 255));
		delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		delete.setBounds(494, 351, 175, 23);
		getContentPane().add(delete);

		reset = new JButton("Password Reset");
		reset.setBackground(new Color(0, 0, 255));
		reset.setFont(new Font("Tahoma", Font.BOLD, 14));
		reset.setForeground(new Color(255, 255, 255));
		reset.setBounds(723, 351, 151, 23);
		getContentPane().add(reset);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setLayout(null);
		panel.setBounds(633, 57, 226, 185);
		getContentPane().add(panel);
		
		JLabel lblAdminCode = new JLabel("Admin Name:" +adid);
		lblAdminCode.setForeground(new Color(0, 0, 205));
		lblAdminCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdminCode.setBounds(21, 38, 155, 22);
		panel.add(lblAdminCode);
		
		JLabel lblAdminName = new JLabel("Admin ID: "+adname);
		lblAdminName.setForeground(new Color(0, 0, 205));
		lblAdminName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdminName.setBounds(21, 79, 182, 29);
		panel.add(lblAdminName);
		setModal(true);
		delete.addActionListener(this);
		add.addActionListener(this);
		edit.addActionListener(this);
		reset.addActionListener(this);
		setSize(900, 500);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		new admin(Loginp.iD,"Abc");
		// TODO Auto-generated method stub

	}
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();

		if(ob==add){

			new Add();
//			static int iD;
//			static String name, emi,adress,number,pass;
//			static double account;
			model.addRow(new Object[]{Add.iD,Add.name,Add.adress,Add.emi,Add.number,Add.account,aname});
			

		}
		else if(ob==delete){

			new Delete();	
			
		}
		else if(ob==edit){
			new edit();
		}
		else if(ob==reset){
			new Reset(); 
		}
	}
}
