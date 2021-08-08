package atm;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import atm.DepositPage;
import atm.WithdrawPage;
import atm.BalancePage;
import atm.Password;
import atm.InfoPage;
import atm.TransferPage;

public class User2 extends JDialog implements ActionListener {
	private JButton deposit;
	private JButton change;
	private JButton withdraw;
	static JButton balance;
	static JButton check;
	private JButton info;
	int loginid;
static int id;
	public User2(int id) {
		this.id=id;
		loginid=Loginp.iD;
		getContentPane().setBackground(new Color(0, 206, 209));
		getContentPane().setLayout(null);
		
		JLabel lblGreatWorksarePerformedl = new JLabel("Great works are performed");
		lblGreatWorksarePerformedl.setForeground(Color.WHITE);
		lblGreatWorksarePerformedl.setFont(new Font("Arial Unicode MS", Font.BOLD, 17));
		lblGreatWorksarePerformedl.setBounds(26, 353, 262, 53);
		getContentPane().add(lblGreatWorksarePerformedl);
		
		JLabel lblL = new JLabel("not by strength,");
		lblL.setForeground(new Color(255, 255, 255));
		lblL.setFont(new Font("Arial Unicode MS", Font.BOLD, 17));
		lblL.setBounds(36, 398, 220, 24);
		getContentPane().add(lblL);
		
		JLabel lblButPreserverance = new JLabel("but preserverance.");
		lblButPreserverance.setForeground(new Color(255, 255, 255));
		lblButPreserverance.setFont(new Font("Arial Unicode MS", Font.BOLD, 17));
		lblButPreserverance.setBounds(36, 427, 181, 24);
		getContentPane().add(lblButPreserverance);
		
		JLabel lbldrsamuelJohnson = new JLabel("-Dr.Samuel Johnson");
		lbldrsamuelJohnson.setForeground(Color.WHITE);
		lbldrsamuelJohnson.setFont(new Font("Arial Unicode MS", Font.BOLD, 18));
		lbldrsamuelJohnson.setBounds(29, 481, 208, 32);
		getContentPane().add(lbldrsamuelJohnson);
		
		JLabel lblASmarterWay = new JLabel("A Smarter Way Of Banking.");
		lblASmarterWay.setForeground(Color.WHITE);
		lblASmarterWay.setFont(new Font("Arial Unicode MS", Font.BOLD, 23));
		lblASmarterWay.setBounds(240, 34, 328, 47);
		getContentPane().add(lblASmarterWay);
		
		JLabel lblNewLabel = new JLabel("user 2");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Arial Unicode MS", Font.BOLD, 29));
		lblNewLabel.setBounds(507, 154, 208, 53);
		getContentPane().add(lblNewLabel);
		
		deposit = new JButton("Deposit Money");
		deposit.setBackground(new Color(240, 230, 140));
		deposit.setFont(new Font("Arial Black", Font.BOLD, 13));
		deposit.setBounds(350, 269, 187, 32);
		getContentPane().add(deposit);
		
		change = new JButton("Change Password");
		change.setBackground(new Color(240, 230, 140));
		change.setFont(new Font("Arial Black", Font.BOLD, 13));
		change.setBounds(600, 269, 193, 32);
		getContentPane().add(change);
		
		withdraw = new JButton("Withdraw Money\r\n");
		withdraw.setBackground(new Color(240, 230, 140));
		withdraw.setFont(new Font("Arial Black", Font.BOLD, 13));
		withdraw.setBounds(350, 364, 187, 32);
		getContentPane().add(withdraw);
		
		balance = new JButton("Balance Transfer");
		balance.setBackground(new Color(240, 230, 140));
		balance.setFont(new Font("Arial Black", Font.BOLD, 13));
		balance.setBounds(600, 364, 193, 32);
		getContentPane().add(balance);
		
		check = new JButton("Check Balance");
		check.setBackground(new Color(240, 230, 140));
		check.setFont(new Font("Arial Black", Font.BOLD, 13));
		check.setBounds(350, 451, 187, 31);
		getContentPane().add(check);
		
		info = new JButton("Information");
		info.setBackground(new Color(255, 255, 153));
		info.setFont(new Font("Arial Black", Font.BOLD, 13));
		info.setBounds(608, 450, 181, 32);
		getContentPane().add(info);
		// TODO Auto-generated constructor stub
		setSize(1000, 700);
		deposit.addActionListener(this);
		change.addActionListener(this);
		check.addActionListener(this);
		withdraw.addActionListener(this);
		balance.addActionListener(this);
		info.addActionListener(this);
		setVisible(true);
	}
	public static void main(String arg[]){
		
		 new User2(id);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();

		if(ob==deposit){
			new DepositPage();
		}
		else if(ob==change){
			new Password();
		}
		else if(ob==withdraw){
			new WithdrawPage();
		}
		else if(ob==balance){
			new TransferPage();
		}
		else if(ob==check){
			new BalancePage();
			
			
		}
		else if(ob==info){
			new InfoPage(Loginp.iD);
		}
		
		
	}
}
