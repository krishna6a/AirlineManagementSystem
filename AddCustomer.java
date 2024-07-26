package airlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField tfname, tfphone, tfAadhar, tfAddress,  tfnationality;
	JRadioButton rbmale,rbfemale;
	public AddCustomer() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
		heading.setBounds(220,20,500,35);
		heading.setFont(new Font("Tanoma",Font.PLAIN,32));
		heading.setForeground(Color.BLUE);
		add(heading);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(60,80,150,25);
		lblname.setFont(new Font("Tanoma",Font.PLAIN,16));
		add(lblname);
		
		 tfname = new JTextField();
		tfname.setBounds(220,80,150,25);
		add(tfname);
		
		JLabel lblnationality = new JLabel("Nationality");
		lblnationality.setBounds(60,120,150,25);
		lblnationality.setFont(new Font("Tanoma",Font.PLAIN,16));
		add(lblnationality);
		
		tfnationality = new JTextField();
		tfnationality.setBounds(220,120,150,25);
		add(tfnationality);
		
		JLabel lblAadhar = new JLabel("Aadhar Number");
		lblAadhar.setBounds(60,160,150,25);
		lblAadhar.setFont(new Font("Tanoma",Font.PLAIN,16));
		add(lblAadhar);
		
		tfAadhar = new JTextField();
		tfAadhar.setBounds(220,160,150,25);
		add(tfAadhar);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(60,200,150,25);
		lblAddress.setFont(new Font("Tanoma",Font.PLAIN,16));
		add(lblAddress);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(220,200,150,25);
		add(tfAddress);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(60,240,150,25);
		lblgender.setFont(new Font("Tanoma",Font.PLAIN,16));
		add(lblgender);
		
		ButtonGroup gendergroup = new ButtonGroup();
		
		rbmale = new JRadioButton("Male");
		rbmale.setBounds(220,240,70,25);
		add(rbmale);
		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(300,240,70,25);
		add(rbfemale);
		
		gendergroup.add(rbfemale);
		gendergroup.add(rbmale);
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(60,280,150,25);
		lblphone.setFont(new Font("Tanoma",Font.PLAIN,16));
		add(lblphone);
		
		 tfphone = new JTextField();
		tfphone.setBounds(220,280,150,25);
		add(tfphone);
		
		JButton save = new JButton("SAVE");
		save.setBackground(Color.BLACK);
		save.setForeground(Color.WHITE);
		save.setBounds(200,320,150,30);
		save.addActionListener(this);
		add(save);
		
		ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(450,80,280,400);
		add(lblimage);
		
		setSize(900,600);
		setLocation(300,150);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		String name=tfname.getText();
		String nationality=tfnationality.getText();
		String phone=tfphone.getText();
		String address=tfAddress.getText();
		String aadhar=tfAadhar.getText();
		String gender = null;
		if(rbmale.isSelected()) {
			gender = "Male";
		}
		else {
			gender = "Female";
		}
		try {
			Conn conn = new Conn();
			String query = "insert into passenger values('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+aadhar+"','"+gender+"')";
			conn.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
		}  catch(Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		new AddCustomer();
	}
}
