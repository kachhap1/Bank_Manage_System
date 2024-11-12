package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JButton btdeposit, back;
    JTextField tfdepositammount;
    String pinnumber;

    public Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/icons/atm.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel title = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        title.setBounds(170, 250, 700, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Dialog", Font.BOLD, 16));
        image.add(title);

        tfdepositammount = new JTextField();
        tfdepositammount.setBounds(170, 310, 310, 40);
        tfdepositammount.setForeground(Color.black);
        tfdepositammount.setBackground(Color.LIGHT_GRAY);
        tfdepositammount.setFont(new Font("Dialog", Font.BOLD, 12));
        tfdepositammount.addActionListener(this);
        image.add(tfdepositammount);

        btdeposit = new JButton("DEPOSIT");
        btdeposit.setBounds(350, 490, 170, 40);
        btdeposit.setForeground(Color.black);
        btdeposit.setBackground(Color.LIGHT_GRAY);
        btdeposit.setFont(new Font("Dialog", Font.BOLD, 12));
        btdeposit.addActionListener(this);
        image.add(btdeposit);

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
        String amount = tfdepositammount.getText();
        Date date = new Date();
        if (ae.getSource() == btdeposit) {
            if (amount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a amount you want to deposit");
            } else {
                try {
                    Conn c = new Conn();

                    String query = "insert into bank values('"
                            + pinnumber + "','"
                            + date + "','Deposit','"
                            + amount + "')";

                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + amount + " Deposited Successfully");
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
        new Deposit("0000");
    }
}
