package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    String pinnumber;

    public MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Indian Bank");
        heading.setBounds(130, 20, 150, 40);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Dialog", Font.BOLD, 20));
        add(heading);

        JLabel cardnumber = new JLabel();
        cardnumber.setBounds(20, 90, 400, 40);
        cardnumber.setForeground(Color.BLACK);
        cardnumber.setFont(new Font("Dialog", Font.BOLD, 16));
        add(cardnumber);

        Conn c = new Conn();
        try {
            String query = "select * from login where pin = '" + pinnumber + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                cardnumber.setText("Card Number:     " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lbministatement = new JLabel();
        lbministatement.setBounds(20, 170, 380, 200);
        lbministatement.setForeground(Color.BLACK);
        lbministatement.setFont(new Font("Dialog", Font.BOLD, 14));
        add(lbministatement);

        JLabel lbbalance = new JLabel();
        lbbalance.setBounds(20, 400, 380, 20);
        lbbalance.setForeground(Color.BLACK);
        lbbalance.setFont(new Font("Dialog", Font.BOLD, 14));
        add(lbbalance);
        
        try {
            String query = "select * from bank where pin = '" + pinnumber + "'";
            ResultSet rs = c.s.executeQuery(query);
            int balance = 0;
            while (rs.next()) {
                lbministatement.setText(lbministatement.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            lbbalance.setText("Your total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }


        JButton exit = new JButton("EXIT");
        exit.setBounds(20, 520, 150, 30);
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("Dialog", Font.BOLD, 14));
        exit.addActionListener(this);
        add(exit);

        setSize(400, 600);
        setLocation(10, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("9533");
    }
}
