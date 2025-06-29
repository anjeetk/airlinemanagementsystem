package airlinemanagementsystem;

/**
 *
 * @author anjeet
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;

public class Home extends JFrame implements ActionListener {

    public Home() {
        setLayout(null);
        
//        Add image for background
        URL imageUrl = ClassLoader.getSystemResource(".\\icons\\front.jpg");
        if(imageUrl == null){
            System.out.println("image not found!");
            return;
        }
        ImageIcon image = new ImageIcon(imageUrl);
        JLabel imageLabel = new JLabel(image);      
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        imageLabel.setBounds(0, 0, screenSize.width, screenSize.height);
        add(imageLabel);
        
//      Add Welcome message on image
        JLabel welcomeMsg = new JLabel("Air India Welcomes You!");
        welcomeMsg.setFont(new Font("ALGERIAN",Font.BOLD,60));
//        welcomeMsg.setForeground(Color.WHITE);
        welcomeMsg.setBounds(250,40,1000,70);
        imageLabel.add(welcomeMsg);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu details = new JMenu("Details");
        menuBar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("Flight Detail");
        details.add(flightDetails);
        flightDetails.addActionListener(this);
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Detail");
        details.add(customerDetails);
        customerDetails.addActionListener(this);
        
        JMenuItem bookFlight = new JMenuItem("Book Flight");
        details.add(bookFlight);
        bookFlight.addActionListener(this);
        
        JMenuItem journyDetails = new JMenuItem("Journy Details");
        details.add(journyDetails);
        journyDetails.addActionListener(this);
        
        JMenu ticket = new JMenu("Ticket");
        menuBar.add(ticket);
        
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);
        
        JMenuItem ticketCancelation = new JMenuItem("Cancel Ticket");
        ticket.add(ticketCancelation);
        ticketCancelation.addActionListener(this);
        
        setTitle("Air India | Home Page");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String txt= e.getActionCommand();
        if(txt.equals("Add Customer Detail")){
            new AddCustomer();
        }else if(txt.equals("Add Customer Details")){
            new AddCustomer();
        }else if(txt.equals("Flight Detail")){
            new FlightInfo();
        }else if(txt.equals("Journy Details")){
            new JournyDetails(); 
        }else if(txt.equals("Cancel Ticket")){
            new Cancel();     
        }else if(txt.equals("Book Flight")){
            new BookFlight();     
        }else if(txt.equals("Boarding Pass")){
            new BoardingPassGenerator();
        }
   }
    public static void main(String[] args) {
        new Home();
    }
}