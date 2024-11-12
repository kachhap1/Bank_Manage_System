package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;
    JLabel title;

    public BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/icons/atm.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 900, 900);
        add(image);


        Conn c = new Conn();
        int balance = 0;
        try {
            String query = "select * from bank where pin = '" + pinnumber + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        title = new JLabel("Your Current Account Balance is RS " + balance);
        title.setBounds(170, 250, 700, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Dialog", Font.BOLD, 16));
        image.add(title);

        back = new JButton("BACK");
        back.setBounds(350, 535, 170, 40);
        back.setForeground(Color.black);
        back.setBackground(Color.LIGHT_GRAY);
        back.setFont(new Font("Dialog", Font.BOLD, 12));
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("9533");
    }
}
