package bankk;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.Color;

public class hm {

	JFrame frame;
	private JTextField user;
	private JPasswordField pass;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hm window = new hm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public hm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 551, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton PASS = new JRadioButton("show password");
		PASS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(PASS.isSelected()) {
				pass.setEchoChar((char)0);
			}
			else {
				pass.setEchoChar('*');
			}
			}
			
		});
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(62, 211, 216, 34);
		frame.getContentPane().add(lblNewLabel_2);
		PASS.setBounds(367, 207, 109, 23);
		frame.getContentPane().add(PASS);
		
		JLabel lblNewLabel_1 = new JLabel("ADDRESS BOOK");
		lblNewLabel_1.setBounds(141, 21, 330, 44);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 27));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("USERNAME");
		lblNewLabel_1_1.setBounds(97, 105, 142, 33);
		lblNewLabel_1_1.setFont(new Font("Sylfaen", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("PASSWORD");
		lblNewLabel_1_2.setBounds(97, 172, 142, 33);
		lblNewLabel_1_2.setFont(new Font("Sylfaen", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_1_2);
		
		user = new JTextField();
		user.setBounds(235, 109, 224, 20);
		user.setColumns(10);
		frame.getContentPane().add(user);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(204, 256, 142, 23);
		btnLogin.addActionListener(new ActionListener() {
			private int y;

			public void actionPerformed(ActionEvent e) {
				try { 
					y=0;
					String us = user.getText();
					@SuppressWarnings("deprecation")
					String ps = pass.getText();
					System.out.println(us);
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println(ps);
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/address","root","");
					System.out.println("1");
					Statement st = con.createStatement();
					System.out.println("1");
					String sql = "Select * from access1";
					System.out.println("1");
					ResultSet rs = st.executeQuery(sql);
					System.out.println("1");
					while(rs.next()){
					String username = rs.getString("username");
					System.out.println("1-");
					String password = rs.getString("password");
					System.out.println("1-");
				
					if(us.equals(username) && ps.equals(password)){
						JOptionPane.showMessageDialog(btnLogin, "NO ERROR", "LOGIN SUCCESS", -1);
					new dashboard().setVisible(true);
					System.out.println("true");
					y=1;
					SwingUtilities.windowForComponent(btnLogin).dispose();
					break;
				
					}
					else{
					user.setText("");
					pass.setText("");
					System.out.println("false");
					
					continue;
					}
				}
					if(y==0) {
						lblNewLabel_2.setText("Invalid Username and Password");						}
					
					}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnLogin, this, "Error while establishing connection failed", 0);
				}
			}
		});
		btnLogin.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		frame.getContentPane().add(btnLogin);
		
		pass = new JPasswordField();
		pass.setBounds(235, 176, 224, 20);
		frame.getContentPane().add(pass);
		
		JButton newuser = new JButton("NEWUSER");
		newuser.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		newuser.setBounds(82, 291, 104, 23);
		newuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newuser frame = new newuser();
				frame.setVisible(true);
			}
		});
		frame.getContentPane().add(newuser);
		
		JButton newuser_1 = new JButton("FORGETPASSWORD");
		newuser_1.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		newuser_1.setBounds(326, 290, 150, 23);
		newuser_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verify frame = new verify();
				frame.setVisible(true);
				SwingUtilities.windowForComponent(newuser_1).dispose();
			}
		});
		frame.getContentPane().add(newuser_1);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\Camera Roll\\WhatsApp Image 2024-06-05 at 7.28.39 AM.jpeg"));
		lblNewLabel.setBounds(0, 0, 535, 372);
		frame.getContentPane().add(lblNewLabel);
	}
}
