package airlinemanagementsystem;

/**
 *
 * @author anjeet
 */

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Main extends JFrame implements ActionListener {
    private final JLabel lblusername, lblpassword;
    JTextField tusername, tpassword;
    JButton submit, reset, close;

    public Main() {
        getContentPane().setBackground(Color.WHITE);

        lblusername = new JLabel("Username");
        lblusername.setBounds(30, 20, 100, 20);
        add(lblusername);

        tusername = new JTextField();
        tusername.setBounds(120, 20, 120, 20);
        add(tusername);

        lblpassword = new JLabel("Password");
        lblpassword.setBounds(30, 60, 100, 20);
        add(lblpassword);

        tpassword = new JPasswordField();
        tpassword.setBounds(120, 60, 120, 20);
        add(tpassword);

        submit = new JButton("Submit");
        submit.setBounds(150, 100, 90, 20);
        submit.setFocusable(false);
        add(submit);

        reset = new JButton("Reset");
        reset.setBounds(40, 100, 90, 20);
        reset.setFocusable(false);
        add(reset);

        close = new JButton("Close");
        close.setBounds(100, 130, 90, 20);
        close.setFocusable(false);
        add(close);

        submit.addActionListener(this);
        close.addActionListener(this);
        reset.addActionListener(this);

        setBackground(Color.WHITE);
        setTitle("Air India | Login Page");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            Conn c = new Conn();

            String username = tusername.getText();
            String password = tpassword.getText();

            String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    new Home();
                    setVisible(false);
                    System.out.println("Login Successfull");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else if (e.getSource() == reset) {
            tpassword.setText("");
            tusername.setText("");
        } else if (e.getSource() == close) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        // new Home();
        new Main();
    }
}