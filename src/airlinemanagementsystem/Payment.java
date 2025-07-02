/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
/**
 *
 * @author anjeet
 */
public class Payment extends JFrame implements ActionListener{
    private final String TITLE = "AirLine | Payment Page";
    private JPanel paymentDetails;
    private final JButton payButton;
    private final JRadioButton upiBtn,cardBtn, netBankBtn;
    private final int  pnr ;
    public Payment(int pnr){
        this.pnr = pnr;
        setLayout(null);
        JPanel pnlHeading = new JPanel();
        String name = null,source = null,destination = null,date=null;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(".\\\\icons\\airindia.png"));
        Image img = i1.getImage().getScaledInstance(180, 70, 1);
        ImageIcon i2 = new ImageIcon(img);
        JLabel lblImage = new JLabel(i2);
        JLabel lblHead = new JLabel("Airline Payment Page");
        lblHead.setFont(new Font("Tahoma",Font.BOLD,40));
        pnlHeading.add(lblImage);
        pnlHeading.add(lblHead);
        pnlHeading.setBounds(0,0,800,70);
        add(pnlHeading);
        
        payButton = new JButton("Pay ₹ 4800");
        payButton.setBackground(new Color(0x0061A8));
        payButton.setForeground(Color.WHITE);
        payButton.setFocusable(false);
        payButton.addActionListener(this);
        add(payButton);
        
        JLabel summery = new JLabel("Summery ");
        summery.setFont(new Font("Times new roman",Font.PLAIN,20));
        summery.setBounds(60,100,100,20);
        add(summery);
        
        Conn c = new Conn();
        String query = "select * from reservation where pnr = 'PNR-"+pnr+"'";
        try{
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                name = rs.getString("name");
                source = rs.getString("source");
                destination = rs.getString("destination");
                date = rs.getString("travel_data");
            }else{
                JOptionPane.showMessageDialog(null,"Problem in Backend");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        JLabel lblname = new JLabel("Pasenger: "+name);
        lblname.setFont(new Font("Times new Roman",Font.PLAIN,16));
        lblname.setBounds(300,100,200,20);
        add(lblname);
        
        JLabel lblDate = new JLabel("Date: "+date);
        lblDate.setFont(new Font("Times new Roman",Font.PLAIN,16));
        lblDate.setBounds(300,160,200,20);
        add(lblDate);

        JLabel lbljourny = new JLabel("Journy: "+source+" To "+destination);
        lbljourny.setFont(new Font("Times new Roman",Font.PLAIN,16));
        lbljourny.setBounds(300,130,200,20);
        add(lbljourny);   
        
        JLabel lblpayment = new JLabel("Select Payment Method: ");
        lblpayment.setFont(new Font("Times new roman",Font.PLAIN,20));
        lblpayment.setBounds(60,200,400,20);
        add(lblpayment);
        
        ButtonGroup groupPmtBtn = new ButtonGroup();
        
        upiBtn = new JRadioButton("UPI");
        upiBtn.setBounds(300,200,100,16);
        upiBtn.setFocusable(false);
        groupPmtBtn.add(upiBtn);
        upiBtn.addActionListener(this);
        add(upiBtn);
        
        cardBtn = new JRadioButton("Credit/Debit Card");
        cardBtn.setBounds(300,230,400,16);
        cardBtn.setFocusable(false);
        groupPmtBtn.add(cardBtn);
        cardBtn.addActionListener(this);
        add(cardBtn);
        
        netBankBtn = new JRadioButton("NetBanking");
        netBankBtn.setBounds(300,260,100,16);
        netBankBtn.setFocusable(false);
        groupPmtBtn.add(netBankBtn);
        netBankBtn.addActionListener(this);
        add(netBankBtn);
        
        add(payButton);
        
        setTitle(TITLE);
        setSize(800,800);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    private void showPaymentDetailsPanel(JComponent... fields) {
            if (paymentDetails != null) {
                remove(paymentDetails);
            }
            paymentDetails = new JPanel(new GridLayout(fields.length, 2, 5, 5));
            paymentDetails.setBounds(60, 300, 700, fields.length * 30 + 30);
            paymentDetails.setBorder(BorderFactory.createTitledBorder("Payment Details"));
            
            for (JComponent field : fields) 
                paymentDetails.add(field);
            
            add(paymentDetails);
            
            payButton.setBounds(60, 330 + fields.length * 30, 700,30);
            repaint();
            revalidate();
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (cardBtn.isSelected()) {
            showPaymentDetailsPanel(
                new JLabel("Card Number:"), new JTextField(),
                new JLabel("Cardholder Name:"), new JTextField(),
                new JLabel("Expiry Date (MM/YY):"), new JTextField(),
                new JLabel("CVV:"), new JTextField()
            );
        } else if (upiBtn.isSelected()) {
            showPaymentDetailsPanel(
                new JLabel("UPI ID:"), new JTextField()
            );
        } else if (netBankBtn.isSelected()) {
            JComboBox<String> bankList = new JComboBox<>(new String[]{
                "Select Bank", "State Bank of India", "HDFC Bank", "ICICI Bank", "Axis Bank", "Kotak Mahindra"
            });
            showPaymentDetailsPanel(
                new JLabel("Bank Name:"), bankList
            );
        }if(payButton == e.getSource()){
            JOptionPane.showMessageDialog(null,"Payment Successfull with pnr PNR-"+pnr);
            setVisible(false);
        }
    }
}
