package airlineManagementSystem;

import javax.swing.*;



import java.awt.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener  {
	
	private static final long serialVersionUID = 1L;

	public Home() {
		setLayout(null);
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
            JLabel image = new JLabel(i1);
            image.setBounds(0,0,1600,800);
            add(image);
            JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
            heading.setBounds(500,40,1000,40);
            heading.setForeground(Color.BLUE);
            heading.setFont(new Font("Tahoma",Font.PLAIN,36));
            image.add(heading);
            
            JMenuBar menubar = new JMenuBar();
            setJMenuBar(menubar);
            
            JMenu details=new JMenu("Details");
            menubar.add(details);

            JMenuItem flightDetails = new JMenuItem("Flight Details");
            flightDetails.addActionListener(this);
            details.add(flightDetails);
            
            JMenuItem customerDetails = new JMenuItem("ADD Customer Details");
            customerDetails.addActionListener(this);
            details.add(customerDetails);
            
            JMenuItem bookflight = new JMenuItem("Book Flight");
            bookflight.addActionListener(this);
            details.add(bookflight);
            
            JMenuItem jouneryDetails = new JMenuItem("Journey Details");
            jouneryDetails.addActionListener(this);
            details.add(jouneryDetails);
            
            JMenuItem cancelDetails = new JMenuItem("Cancellation");
            cancelDetails.addActionListener(this);
            details.add(cancelDetails);
            
            JMenu tickets =new JMenu("Tickets");
            menubar.add(tickets);
            
            JMenuItem boardingpass = new JMenuItem("Boarding Pass");
            boardingpass.addActionListener(this);
            tickets.add(boardingpass);
            
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		String text = ae.getActionCommand();
		if(text.equals("ADD Customer Details")) {
			new AddCustomer();
		} else if(text.equals("Flight Details")) {
			new flightinfo();
		}  else if(text.equals("Journey Details")) {
			new JouneryDetails();
		} else if(text.equals("Book Flight")) {
			new BookFlight();
		}else if(text.equals("Boarding Pass")) {
			new BoardingPass();
		}else if(text.equals("Cancellation")) {
			new Cancel();}
		
	}
	
    public static void main(String [] args) {
    	new Home();
    }}