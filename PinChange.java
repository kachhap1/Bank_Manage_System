package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class PinChange extends JFrame implements ActionListener {

    String pinnumber;
    JButton btchange, btback;
    JPasswordField tfnewpin, tfreenterpin;

    public PinChange(String pinnumber) {

        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/icons/atm.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel title = new JLabel("CHANGE YOUR PIN");
        title.setBounds(210, 250, 700, 35);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Dialog", Font.BOLD, 24));
        image.add(title);

        JLabel newpin = new JLabel("New PIN:");
        newpin.setBounds(150, 300, 170, 40);
        newpin.setForeground(Color.WHITE);
        newpin.setFont(new Font("Dialog", Font.BOLD, 16));
        image.add(newpin);

        tfnewpin = new JPasswordField();
        tfnewpin.setBounds(320, 300, 200, 40);
        tfnewpin.setBackground(Color.WHITE);
        tfnewpin.setFont(new Font("Dialog", Font.BOLD, 20));
        image.add(tfnewpin);

        JLabel reenterpin = new JLabel("Re-Enter New PIN:");
        reenterpin.setBounds(150, 350, 170, 40);
        reenterpin.setForeground(Color.WHITE);
        reenterpin.setFont(new Font("Dialog", Font.BOLD, 16));
        image.add(reenterpin);

        tfreenterpin = new JPasswordField();
        tfreenterpin.setBounds(320, 350, 200, 40);
        tfreenterpin.setBackground(Color.WHITE);
        tfreenterpin.setFont(new Font("Dialog", Font.BOLD, 20));
        image.add(tfreenterpin);

        btchange = new JButton("CHANGE");
        btchange.setBounds(350, 490, 170, 40);
        btchange.setForeground(Color.black);
        btchange.setBackground(Color.LIGHT_GRAY);
        btchange.setFont(new Font("Dialog", Font.BOLD, 12));
        btchange.addActionListener(this);
        image.add(btchange);

        btback = new JButton("BACK");
        btback.setBounds(350, 535, 170, 40);
        btback.setForeground(Color.black);
        btback.setBackground(Color.LIGHT_GRAY);
        btback.setFont(new Font("Dialog", Font.BOLD, 12));
        btback.addActionListener(this);
        image.add(btback);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btback) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String newpin = tfnewpin.getText();
            String renewpin = tfreenterpin.getText();
            if (!newpin.equals(renewpin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not Match");
                return;
            }
            if (newpin.equals("")) {
                JOptionPane.showMessageDialog(null, "PIN not Entered");
                return;
            } else if (renewpin.equals("")) {
                JOptionPane.showMessageDialog(null, "Re-Enter PIN not Entered");
                return;
            } else {
                try {
                    Conn c = new Conn();
                    String query = "update bank set pin = '" + renewpin + "' where pin = '" + pinnumber + "'";
                    String query1 = "update login set pin = '" + renewpin + "' where pin = '" + pinnumber + "'";
                    String query2 = "update accountdetails set pin = '" + renewpin + "' where pin = '" + pinnumber + "'";

                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "PIN Successfully Chnaged");
                    setVisible(false);
                    new Transactions(newpin).setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new PinChange("0000");
    }
}
