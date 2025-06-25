/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author anjeet
 */

public class FlightInfo extends JFrame{
    public FlightInfo(){
        setLayout(null);
        JLabel heading = new JLabel("Flights Details");
        heading.setFont(new Font("TAHOMA",Font.CENTER_BASELINE,40));
        heading.setBounds(250,10,400,60);
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JTable table = new JTable();
        
        try{
            Conn c = new Conn();
            String query = "select * from flightinfo";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(SQLException ae){
            ae.printStackTrace();
        }
        
        JScrollPane jsp  = new JScrollPane(table);
        jsp.setBounds(0,70,800,520);
        add(jsp);
        
        setTitle("AirLIne | Flight Information");
        setSize(800,600);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new FlightInfo();
    }
}
