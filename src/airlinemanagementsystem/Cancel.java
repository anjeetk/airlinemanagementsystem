package airlinemanagementsystem;

import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
//import java.util.Random;
/**
 *
 * @author anjeet
 */
public class Cancel extends JFrame implements ActionListener{
    private JTextField tfPnr;
    JLabel pnlname,pnlAdhar,pnlSource,pnlFlightName,pnlFlightCode,pnlDst,pnlDate;
    private final JButton showPnr,cancelTicket;
    JDateChooser tfDate;
    
    public Cancel(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(300,20,500,35);
        heading.setFont(new Font("Times New Roman",Font.BOLD,32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblPnr = new JLabel("PNR NO:");
        lblPnr.setBounds(60,80,100,20);
        lblPnr.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblPnr);
        
        tfPnr = new JTextField();
        tfPnr.setBounds(180,80,120,20);
        add(tfPnr);
        
        showPnr = new JButton("Show Details");
        showPnr.setBounds(300,80,140,20); 
        showPnr.setForeground(Color.WHITE);
        showPnr.setBackground(Color.BLACK);
        showPnr.setFont(new Font("TAHOMA",Font.PLAIN,14));
        showPnr.addActionListener(this);
        showPnr.setFocusable(false);
        add(showPnr);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(60,130,100,20);
        lblName.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblName);
        
        pnlname = new JLabel();
        pnlname.setBounds(180,130,150,20);
        pnlname.setBackground(Color.white);
        pnlname.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(pnlname);
        
        JLabel lblAdhar = new JLabel("Adhar");
        lblAdhar.setBounds(60,180,100,20);
        lblAdhar.setBackground(Color.white);
        lblAdhar.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblAdhar);
        
        pnlAdhar = new JLabel();
        pnlAdhar.setBounds(180,180,150,20);
        pnlAdhar.setBackground(Color.white);
        pnlAdhar.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(pnlAdhar);
        
        JLabel lblSource = new JLabel("Source");
        lblSource.setBounds(60,230,100,20);
        lblSource.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblSource); 
        
        pnlSource = new JLabel();
        pnlSource.setBounds(180,230,100,20);
        pnlSource.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(pnlSource);         

        JLabel lblDst = new JLabel("Destination");
        lblDst.setBounds(60,280,100,20);
        lblDst.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblDst); 
        
        pnlDst = new JLabel();
        pnlDst.setBounds(180,280,100,20);
        pnlDst.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(pnlDst); 
             
        JLabel lblFlightName = new JLabel("Flight Name");
        lblFlightName.setBounds(60,330,100,20);
        lblFlightName.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblFlightName);
        
        pnlFlightName = new JLabel();
        pnlFlightName.setBounds(180,330,150,20);
        pnlFlightName.setBackground(Color.white);
        pnlFlightName.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(pnlFlightName);  
        
        JLabel lblFlightCode = new JLabel("Flight Code");
        lblFlightCode.setBounds(60,380,100,20);
        lblFlightCode.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblFlightCode);
        
        pnlFlightCode = new JLabel();
        pnlFlightCode.setBounds(180,380,150,20);
        pnlFlightCode.setBackground(Color.white);
        pnlFlightCode.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(pnlFlightCode);
        
        JLabel Date = new JLabel("Booking Date");
        Date.setBounds(60,430,100,20);
        Date.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(Date);
        
        pnlDate = new JLabel();
        pnlDate.setBounds(180,430,100,20);
        pnlDate.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(pnlDate);
        
        JLabel cancelDate = new JLabel();
        cancelDate.setBounds(60,480,100,20);
        cancelDate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cancelDate);
        
        tfDate = new JDateChooser();
        tfDate.setBounds(180,480,100,20);
        tfDate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfDate);
        
        cancelTicket = new JButton("Cancel Ticket");
        cancelTicket.setBounds(310,480,150,20); 
        cancelTicket.setForeground(Color.WHITE);
        cancelTicket.setBackground(Color.BLACK);
        cancelTicket.setFont(new Font("TAHOMA",Font.PLAIN,14));
        cancelTicket.addActionListener(this);
        cancelTicket.setFocusable(false);
        add(cancelTicket);  
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(".\\\\icons\\cancel.jpg"));
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
        String name,pnr,adhar,src,dst,fname,fcode,ddate,nationality;
        if(ae.getSource() == showPnr){
            pnr = tfPnr.getText();
            String query = "select * from reservation where PNR = '"+pnr+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    name = rs.getString("Name");
                    nationality = rs.getString("nationality");
                    adhar = rs.getString("adhar");
                    src = rs.getString("source");
                    dst = rs.getString("destination");
                    fcode = rs.getString("flight_code");
                    fname = rs.getString("flight_name");
                    ddate = rs.getString("travel_data");
                    
                    pnlSource.setText(src);
                    pnlFlightName.setText(fname);
                    pnlFlightCode.setText(fcode);
                    pnlDst.setText(dst);
                    pnlDate.setText(ddate);
                    
                    pnlname.setText(name);
                    pnlAdhar.setText(adhar);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid PNR");
                    setVisible(false);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancelTicket){
            Random random = new Random();
            int cancelNo = random.nextInt(10000);
            ddate = ((JTextField) tfDate.getDateEditor().getUiComponent()).getText();
            String date = ((JTextField)tfDate.getDateEditor().getUiComponent()).getText();
            String query = "insert into cancel values ('"+cancelNo+"','"+tfPnr.getText()+"','"+pnlname.getText()+"','"+ddate+"')";
            try{
                if(c.s.executeUpdate(query) != 0){

                    JOptionPane.showMessageDialog(null, "Ticket Deleted with cancellation number "+cancelNo);
                    query = "Delete from reservation where pnr = '"+tfPnr.getText()+"'";
                    c.s.executeUpdate(query);
                    setVisible(false);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        new Cancel();
    }
}
