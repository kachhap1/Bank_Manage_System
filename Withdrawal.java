package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Withdrawal extends JFrame implements ActionListener {

    JButton btwithdrawal, back;
    JTextField tfwithdrawalamount;
    String pinnumber;
    String currentamount;

    public Withdrawal(String pinnumber) {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/icons/atm.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel title = new JLabel("MAXIMUM WITHDRAWAL is RS. 10,000");
        title.setBounds(170, 250, 700, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Dialog", Font.BOLD, 16));
        image.add(title);

        JLabel subtitle = new JLabel("PLEASE ENTER YOUR AMOUNT");
        subtitle.setBounds(170, 310, 700, 40);
        subtitle.setForeground(Color.WHITE);
        subtitle.setFont(new Font("Dialog", Font.BOLD, 16));
        image.add(subtitle);

        tfwithdrawalamount = new JTextField();
        tfwithdrawalamount.setBounds(170, 360, 330, 40);
        tfwithdrawalamount.setForeground(Color.BLACK);
        tfwithdrawalamount.setFont(new Font("Dialog", Font.BOLD, 16));
        image.add(tfwithdrawalamount);

        btwithdrawal = new JButton("WITHDRAWAL");
        btwithdrawal.setBounds(350, 490, 170, 40);
        btwithdrawal.setForeground(Color.black);
        btwithdrawal.setBackground(Color.LIGHT_GRAY);
        btwithdrawal.setFont(new Font("Dialog", Font.BOLD, 12));
        btwithdrawal.addActionListener(this);
        image.add(btwithdrawal);

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
        String amount = tfwithdrawalamount.getText();
        Date date = new Date();
        if (ae.getSource() == btwithdrawal) {
            if (amount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a amount you want to deposit");
            } else {
                try {
                    Conn c = new Conn();

                    String query = "insert into bank values('"
                            + pinnumber + "','"
                            + date + "','Withdraw','"
                            + amount + "')";
                    
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "WITHDRAWAL SUCCESSFULLY DONE\nRS- " + amount);
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("0000");
    }
}
