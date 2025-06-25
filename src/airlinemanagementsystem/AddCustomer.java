package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author anjeet
 */
public class AddCustomer extends JFrame implements ActionListener{
    private JTextField tfname,tfnationality,tfAdhar,tfPhone,tfAddress;
    private JRadioButton rbMale,rbFemale;
    private JButton reset,submit;
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Customer Details");
        heading.setBounds(200,20,500,35);
        heading.setFont(new Font("Times New Roman",Font.BOLD,32));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(60,80,150,20);
        lblName.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblName);
        
        tfname = new JTextField();
        tfname.setBounds(150,80,150,20);
        add(tfname);
           
        JLabel lblNationality = new JLabel("Nationality");
        lblNationality.setBounds(60,130,150,20);
        lblNationality.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblNationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(150,130,150,20);
        add(tfnationality);
        
        JLabel lblAdhar = new JLabel("Adhar");
        lblAdhar.setBounds(60,180,150,20);
        lblAdhar.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblAdhar);
        
        tfAdhar = new JTextField();
        tfAdhar.setBounds(150,180,150,20);
        add(tfAdhar);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(60,230,150,20);
        lblAddress.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblAddress);
        
        tfAddress = new JTextField();
        tfAddress.setBounds(150,230,150,20);
        add(tfAddress);        
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(60,280,150,20);
        lblGender.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblGender);
        
        ButtonGroup genderGroup = new ButtonGroup();
        
        rbMale = new JRadioButton("Male");
        rbMale.setBounds(150,280,70,20);
        rbMale.setBackground(Color.WHITE);
        rbMale.setFocusable(false);
        genderGroup.add(rbMale);
        add(rbMale);
        
        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(230,280,70,20);
        rbFemale.setBackground(Color.WHITE);
        rbFemale.setFocusable(false);
        genderGroup.add(rbFemale);
        add(rbFemale);
        
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(60,330,150,20);
        lblPhone.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblPhone);
        
        tfPhone = new JTextField();
        tfPhone.setBounds(150,330,150,20);
        add(tfPhone);
        
        submit = new JButton("Submit");
        submit.setBounds(180,380,100,20); 
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLUE);
        submit.setFont(new Font("TAHOMA",Font.PLAIN,16));
        submit.setFocusable(false);
        add(submit);
        
        reset = new JButton("Reset");
        reset.setBounds(60,380,100,20); 
        reset.setForeground(Color.BLACK);
        reset.setBackground(Color.WHITE);
        reset.setFont(new Font("TAHOMA",Font.PLAIN,16));
        reset.setFocusable(false);
        add(reset);       
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource(".\\\\icons\\emp.png"));
        JLabel imgLabel = new JLabel(image);
        imgLabel.setBounds(370,70,200,400);
        add(imgLabel);
        
        submit.addActionListener(this);
        reset.addActionListener(this);
        
        setSize(700,550);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
            String name = tfname.getText();
            String adhar = tfAdhar.getText();
            String phone = tfPhone.getText();
            String address = tfAddress.getText();
            String nationality = tfnationality.getText();
            String gender;
            
            if(rbMale.isSelected())
                gender = "Male";
            else
                gender = "Female";
        if(ae.getSource() == submit){
            try{  
                Conn c = new Conn();
                String query = "insert into customer values('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+adhar+"','"+gender+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                JOptionPane.showMessageDialog(null,"Details Inserted successfully");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == reset){
            tfname.setText("");
            tfAdhar.setText("");
            tfPhone.setText("");
            tfAddress.setText("");
            tfnationality.setText("");
        }
    }
    public static void main(String args[]){
        new AddCustomer();
    }
}
