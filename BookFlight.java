package airlineManagementSystem;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener {
	

	private static final long serialVersionUID = 1L;
	JTextField  tfAadhar;
	JLabel tfname,  tfnationality, tfAddress, labelgender, tffname, tffcode ;
	JButton  fetchButton ,flight ,bookflight;
	Choice source,dest;
	JDateChooser tfdate;
	
	public BookFlight() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Book Flight");
		heading.setBounds(420,20,500,35);
		heading.setFont(new Font("Tanoma",Font.PLAIN,32));
		heading.setForeground(Color.BLUE);
		add(heading);
		
		JLabel lblaadhar = new JLabel("Aadhar");
		lblaadhar.setBounds(60,80,150,25);
		lblaadhar.setFont(new Font("Tanoma",Font.PLAIN,16));
		add(lblaadhar);
		
		 tfAadhar = new JTextField();
		tfAadhar.setBounds(220,80,150,25);
		add(tfAadhar);
		
		 fetchButton = new JButton("Fetch User");
		fetchButton.setBackground(Color.BLACK);
		fetchButton.setForeground(Color.WHITE);
		fetchButton.setBounds(380,80,120,25);
		fetchButton.addActionListener(this);
		add(fetchButton);
		
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(60,120,150,25);
		lblname.setFont(new Font("Tanoma",Font.PLAIN,16));
		add(lblname);
		
		tfname = new JLabel();
		tfname.setBounds(220,120,150,25);
		add(tfname);
		
		JLabel lblnationality = new JLabel("Nationality");
		lblnationality.setBounds(60,160,150,25);
		lblnationality.setFont(new Font("Tanoma",Font.PLAIN,16));
		add(lblnationality);
		
		tfnationality = new JLabel();
		tfnationality.setBounds(220,160,150,25);
		add(tfnationality);
		
		
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(60,200,150,25);
		lblAddress.setFont(new Font("Tanoma",Font.PLAIN,16));
		add(lblAddress);
		
		tfAddress = new JLabel();
		tfAddress.setBounds(220,200,150,25);
		add(tfAddress);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(60,240,150,25);
		lblgender.setFont(new Font("Tanoma",Font.PLAIN,16));
		add(lblgender);
		
		labelgender = new JLabel();
		labelgender.setBounds(220,240,150,25);
		add(labelgender);
		
		JLabel lblsource = new JLabel("Source");
		lblsource.setBounds(60,280,150,25);
		lblsource.setFont(new Font("Tanoma",Font.PLAIN,16));
		add(lblsource);
		
		 source = new Choice();
		source.setBounds(220,280,120,25);
		add(source);
		
		
		JLabel lbldest = new JLabel("Destination");
		lbldest.setBounds(60,320,150,25);
		lbldest.setFont(new Font("Tanoma",Font.PLAIN,16));
		add(lbldest);
		
		 dest = new Choice();
		dest.setBounds(220,320,120,25);
		add(dest);
		
		try {
			Conn c =new Conn();
			String query = "select * from flight";
			ResultSet rs= c.s.executeQuery(query);
			
			while(rs.next()) {
				source.add(rs.getString("source"));
				dest.add(rs.getString("destination"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 flight = new JButton("Fetch Flights");
		flight.setBackground(Color.BLACK);
		flight.setForeground(Color.WHITE);
		flight.setBounds(360,320,120,25);
		flight.addActionListener(this);
		add(flight);
		
		JLabel lblfname = new JLabel("Flight Name");
		lblfname.setBounds(60,360,150,25);
		lblfname.setFont(new Font("Tanoma",Font.PLAIN,16));
		add(lblfname);
		
		tffname = new JLabel();
		tffname.setBounds(220,360,120,25);
		add(tffname);
		
		
		JLabel lblfcode = new JLabel("Flight code");
		lblfcode.setBounds(60,400,150,25);
		lblfcode.setFont(new Font("Tanoma",Font.PLAIN,16));
		add(lblfcode);
		
		tffcode = new JLabel();
		tffcode.setBounds(220,400,120,25);
		add(tffcode);
		
		
		JLabel lbldate = new JLabel("Date of Travel");
		lbldate.setBounds(60,440,120,25);
		lbldate.setFont(new Font("Tanoma",Font.PLAIN,16));
		add(lbldate);
		
		tfdate = new JDateChooser();
		tfdate.setBounds(220,440,120,25);
		add(tfdate);
		
		ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
		Image i2 = il.getImage().getScaledInstance(450,320, Image.SCALE_DEFAULT);
		ImageIcon image =new ImageIcon(i2);
		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(500,80,450,410);
		add(lblimage);
		
		bookflight = new JButton("Book Flight");
		bookflight.setBackground(Color.BLACK);
		bookflight.setForeground(Color.WHITE);
		bookflight.setBounds(220,480,120,25);
		bookflight.addActionListener(this);
		add(bookflight);
		
		
		setSize(1000,600);
		setLocation(250,150);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		
	if(ae.getSource() == fetchButton) {
		String aadhar = tfAadhar.getText();
	try {
		Conn conn = new Conn();
		String query ="select * from passenger where aadhar = '"+aadhar+"'";
		ResultSet rs = conn.s.executeQuery(query);
		
		if(rs.next()) {
			tfname.setText(rs.getString("name"));
			tfnationality.setText(rs.getString("nationality"));
			tfAddress.setText(rs.getString("address"));
			labelgender.setText(rs.getString("gender"));
		}else {
			JOptionPane.showMessageDialog(null,"Please enter correct aadhar");
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
	}
	else if(ae.getSource() == flight) {
		String src = source.getSelectedItem();
		String des = dest.getSelectedItem();
		try {
			Conn conn = new Conn();
			String query ="select * from flight where source = '"+src+"' and destination = '"+des+"'";
			ResultSet rs = conn.s.executeQuery(query);
			
			if(rs.next()) {
				tffname.setText(rs.getString("f_name"));
				tffcode.setText(rs.getString("f_code"));		
			}else {
				JOptionPane.showMessageDialog(null, "No Flight Found");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	else {
		Random random = new Random();
		
		String aadhar = tfAadhar.getText();
		String name =tfname.getText();
		String nationality = tfnationality.getText();
		String flightname = tffname.getText();
		String flightcode = tffcode.getText();
		String src = source.getSelectedItem();
		String des=dest.getSelectedItem();
		String ddate = ((JTextField) tfdate.getDateEditor().getUiComponent()).getText();
		
		try {
			Conn conn = new Conn();
			String query= "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"','"+aadhar+"','"+name+"','"+nationality+"','"+flightname+"','"+flightcode+"','"+src+"','"+des+"','"+ddate+"')";
			conn.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
			setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	}


	public static void main(String[] args) {
		new BookFlight();
	}
}