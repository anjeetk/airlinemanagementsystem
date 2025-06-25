package airlinemanagementsystem;

import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
//import java.util.
/**
 *
 * @author anjeet
 */
public class BookFlight extends JFrame implements ActionListener{
    private JTextField tfAdhar;
    JLabel pnlname,pnlNationality,pnlAddress,pnlGender,pnlFlightName,pnlFlightCode;
    private final JButton fetchUser,fetchFlight,bookFlight;
    private Choice source,destination;
    JDateChooser tfDate;
    
    public BookFlight(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(400,20,500,35);
        heading.setFont(new Font("Times New Roman",Font.BOLD,32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblAdhar = new JLabel("Adhar");
        lblAdhar.setBounds(60,80,100,20);
        lblAdhar.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblAdhar);
        
        tfAdhar = new JTextField();
        tfAdhar.setBounds(180,80,120,20);
        add(tfAdhar);
        
        fetchUser = new JButton("Fetch User");
        fetchUser.setBounds(300,80,120,20); 
        fetchUser.setForeground(Color.WHITE);
        fetchUser.setBackground(Color.BLACK);
        fetchUser.setFont(new Font("TAHOMA",Font.PLAIN,16));
        fetchUser.addActionListener(this);
        fetchUser.setFocusable(false);
        add(fetchUser);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(60,130,100,20);
        lblName.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblName);
        
        pnlname = new JLabel();
        pnlname.setBounds(180,130,150,20);
        pnlname.setBackground(Color.white);
        pnlname.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(pnlname);
        
        JLabel lblNationality = new JLabel("Nationality");
        lblNationality.setBounds(60,180,100,20);
        lblNationality.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblNationality);
        
        pnlNationality = new JLabel();
        pnlNationality.setBounds(180,180,150,20);
        pnlNationality.setBackground(Color.white);
        pnlNationality.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(pnlNationality);  
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(60,230,100,20);
        lblAddress.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblAddress);
        
        pnlAddress = new JLabel();
        pnlAddress.setBounds(180,230,150,20);
        pnlAddress.setBackground(Color.white);
        pnlAddress.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(pnlAddress);
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(60,280,100,20);
        lblGender.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblGender);        
        
        pnlGender = new JLabel();
        pnlGender.setBounds(180,280,100,20);
        pnlGender.setBackground(Color.white);
        pnlGender.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(pnlGender);
        
        JLabel lblSource = new JLabel("Source");
        lblSource.setBounds(60,330,100,20);
        lblSource.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblSource);  
        
        source = new Choice();
        source.setBounds(180,330,120,20);
        add(source);
        
        JLabel lblDst = new JLabel("Destination");
        lblDst.setBounds(60,380,100,20);
        lblDst.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblDst);  
        
        destination = new Choice();
        destination.setBounds(180,380,120,20);
        add(destination);
        
//        Adding elements for source and destination of flights
        Conn c = new Conn();
        String query  = "select * from flightinfo";
        try{
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        fetchFlight = new JButton("Fetch Flights");
        fetchFlight.setBounds(310,380,150,20); 
        fetchFlight.setForeground(Color.WHITE);
        fetchFlight.setBackground(Color.BLACK);
        fetchFlight.setFont(new Font("TAHOMA",Font.PLAIN,14));
        fetchFlight.addActionListener(this);
        fetchFlight.setFocusable(false);
        add(fetchFlight);     
       
        JLabel lblFlightName = new JLabel("FlightName");
        lblFlightName.setBounds(60,430,100,20);
        lblFlightName.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblFlightName);
        
        pnlFlightName = new JLabel();
        pnlFlightName.setBounds(180,430,150,20);
        pnlFlightName.setBackground(Color.white);
        pnlFlightName.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(pnlFlightName);  
        
        JLabel lblFlightCode = new JLabel("Flight Code");
        lblFlightCode.setBounds(60,480,100,20);
        lblFlightCode.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblFlightCode);
        
        pnlFlightCode = new JLabel();
        pnlFlightCode.setBounds(180,480,150,20);
        pnlFlightCode.setBackground(Color.white);
        pnlFlightCode.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(pnlFlightCode);
        
        JLabel Date = new JLabel("Select Date");
        Date.setBounds(60,530,100,20);
        Date.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(Date);
        
        tfDate = new JDateChooser();
        tfDate.setBounds(180,530,100,20);
        add(tfDate);
        
        bookFlight = new JButton("Book Ticket");
        bookFlight.setBounds(310,530,150,20); 
        bookFlight.setForeground(Color.WHITE);
        bookFlight.setBackground(Color.BLACK);
        bookFlight.setFont(new Font("TAHOMA",Font.PLAIN,14));
        bookFlight.addActionListener(this);
        bookFlight.setFocusable(false);
        add(bookFlight);  
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(".\\\\icons\\details.jpg"));
        Image img = i1.getImage().getScaledInstance(300, 300, 300);
        ImageIcon image = new ImageIcon(img);
        JLabel lblImage = new JLabel(image);
        lblImage.setBounds(500,50,300,600);
        add(lblImage);
        
        setSize(830,650);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Conn c = new Conn();
        String name,adhar,nationality,address,gender,src,dst,fname,fcode,ddate;
        
        if(ae.getSource() == fetchUser){
            adhar = tfAdhar.getText();
            String query = "select * from customer where Adhar = '"+adhar+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    name = rs.getString("Name");
                    nationality = rs.getString("nationality");
                    address = rs.getString("address");
                    gender = rs.getString("gender");
                    
                    pnlname.setText(name);
                    pnlNationality.setText(nationality);
                    pnlAddress.setText(address);
                    pnlGender.setText(gender);
                }else{
                    JOptionPane.showMessageDialog(null, "No User Found");
                    setVisible(false);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == fetchFlight){
            src = source.getSelectedItem();
            dst = destination.getSelectedItem();
            String query = "select * from flightInfo where source = '"+src+"' and destination ='"+dst+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    fname = rs.getString("flight_name");
                    fcode = rs.getString("flight_code");
                    
                    pnlFlightName.setText(fname);
                    pnlFlightCode.setText(fcode);
                }else{
                    JOptionPane.showMessageDialog(null, "No Flight available from "+src+" to "+dst+".");
//                    setVisible(false);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }else{
            Random random = new Random();
            ddate = ((JTextField) tfDate.getDateEditor().getUiComponent()).getText();
            fname = pnlFlightName.getText();
            fcode = pnlFlightCode.getText();
            adhar = tfAdhar.getText();
            name = pnlname.getText(); 
            nationality = pnlNationality.getText();
            src = source.getSelectedItem(); 
            dst = destination.getSelectedItem();
            
            String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+adhar+"', '"+name+"', '"+nationality+"', '"+fname+"', '"+fcode+"', '"+src+"', '"+dst+"', '"+ddate+"')";
            try{
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");

                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        new BookFlight();
    }
}
