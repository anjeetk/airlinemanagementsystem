package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class BoardingPassGenerator extends JFrame implements ActionListener {
    final String TITLE_PNR = "AirLine | Boarding Pass | PNR No";
    JTextField tfPnr;
    private final JButton btnPnr;

    public BoardingPassGenerator() {
        setLayout(null);

        JLabel lblPnr = new JLabel("PNR NO");
        lblPnr.setBounds(40, 20, 100, 20);
        lblPnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPnr);

        tfPnr = new JTextField();
        tfPnr.setBounds(130, 20, 100, 20);
        tfPnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfPnr);

        btnPnr = new JButton("Get Pass");
        btnPnr.setBounds(90, 70, 100, 20);
        btnPnr.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnPnr.setBackground(Color.BLACK);
        btnPnr.setForeground(Color.WHITE);
        btnPnr.addActionListener(this);
        add(btnPnr);

        setSize(300, 200);
        setTitle(TITLE_PNR);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPnr) {
            String pnr = tfPnr.getText().trim();
            if (pnr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a PNR number");
                return;
            }

            Conn c = new Conn();
            String query = "SELECT * FROM reservation WHERE pnr = '" + pnr + "'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    new BoardingPass(rs);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "No reservation found for PNR: " + pnr);
                }
            } catch (SQLException ae) {
                ae.printStackTrace();
                JOptionPane.showMessageDialog(this, "Database error: " + ae.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new BoardingPassGenerator();
    }
}

class BoardingPass extends JFrame {

    final String TITLE = "AirLine | Boarding Pass";

    public BoardingPass(ResultSet rs) {
        setLayout(null);

        String name = "", adhar = "", flightCode = "", flightName = "", source = "", destination = "";

        try {
            name = rs.getString("name");
            adhar = rs.getString("adhar");
            flightCode = rs.getString("flight_code");
            flightName = rs.getString("flight_name");
            source = rs.getString("source");
            destination = rs.getString("destination");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        JPanel pnlHeading = new JPanel();
        pnlHeading.setBounds(0,0,750,60);
        pnlHeading.setBackground(new Color(204, 229, 255));
//        pnlHeading.setBackground(Color.CYAN);
        add(pnlHeading);
        
        JLabel heading = new JLabel("Boarding Pass");
        heading.setFont(new Font("Serif", Font.BOLD, 36));
        heading.setForeground(new Color(0, 102, 204));
//        heading.setOpaque(true);
        heading.setBounds(250, 30, 300, 40);
        pnlHeading.add(heading);

        JLabel lblName = new JLabel("Name: " + name);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName.setBounds(60, 100, 300, 20);
        add(lblName);

        JLabel lblAdhar = new JLabel("Adhar: " + adhar);
        lblAdhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAdhar.setBounds(60, 140, 300, 20);
        add(lblAdhar);

        JLabel lblFlightCode = new JLabel("Flight Code: " + flightCode);
        lblFlightCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblFlightCode.setBounds(60, 180, 300, 20);
        add(lblFlightCode);

        JLabel lblFlightName = new JLabel("Flight Name: " + flightName);
        lblFlightName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblFlightName.setBounds(60, 220, 300, 20);
        add(lblFlightName);

        JLabel lblSource = new JLabel("Source: " + source);
        lblSource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSource.setBounds(60, 260, 300, 20);
        add(lblSource);

        JLabel lblDestination = new JLabel("Destination: " + destination);
        lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDestination.setBounds(60, 300, 300, 20);
        add(lblDestination);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource(".\\\\icons\\airindia.png"));
        Image img1 = i.getImage().getScaledInstance(400,400,700);
        ImageIcon img = new ImageIcon(img1);
        JLabel imgpnl = new JLabel(img);
        imgpnl.setBounds(200,100,500,200);
        add(imgpnl);
        
        setSize(750, 410);
        setTitle(TITLE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
