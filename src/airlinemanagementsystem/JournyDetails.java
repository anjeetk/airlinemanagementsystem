/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author anjeet
 */

public class JournyDetails extends JFrame implements ActionListener{
    private final JTextField tfPnr;
    private final JTable table;
    private final JButton fetch;
    JLabel lblDetails;
    public JournyDetails(){
        setLayout(null);
        JLabel heading = new JLabel("Journy Details");
        heading.setFont(new Font("TAHOMA",Font.CENTER_BASELINE,40));
        heading.setBounds(350,10,400,60);
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblPnr = new JLabel("PNR No");
        lblPnr.setBounds(60,100,100,20);
        lblPnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblPnr);
        
        tfPnr = new JTextField();
        tfPnr.setBounds(140,100,100,20);
        tfPnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfPnr);
        
        fetch = new JButton("Fetch");
        fetch.setBounds(250,100,80,20);
        fetch.setForeground(Color.white);
        fetch.setFocusable(false);
        fetch.setBackground(Color.black);
        fetch.addActionListener(this);
        add(fetch);
        
        table = new JTable();
        table.setBackground(Color.white);
//        table.setBounds(60,140,540,800);
        
        lblDetails = new JLabel();
        lblDetails.setBounds(60,130,100,20);
        add(lblDetails);
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(60,160,900,800);
        jsp.setBackground(Color.white);
        add(jsp);      
        
        setTitle("AirLIne | Journy Details");
        setSize(1000,600);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new JournyDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fetch){
            try{
                Conn c = new Conn();
                String query = "select * from reservation where PNR = '"+tfPnr.getText()+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(!rs.isBeforeFirst()){
                    JOptionPane.showMessageDialog(null,"Information not found");
                    return;
                }
                lblDetails.setText("Jounry Details of PNR "+tfPnr.getText()+"");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(SQLException ae){
                ae.printStackTrace();
            }
        }
    
    }
}
