package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    
    String pinnumber;
    JButton deposit, cashwithdrawal, fastcash, ministatement, pinchange, balanceenquiry, exit;
    public Transactions(String pinnumber) {
        
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/icons/atm.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel title = new JLabel("Please Select Your Transaction");
        title.setBounds(210, 250, 700, 35);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Dialog", Font.BOLD, 16));
        image.add(title);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(140, 400, 170, 40);
        deposit.setForeground(Color.black);
        deposit.setBackground(Color.LIGHT_GRAY);
        deposit.setFont(new Font("Dialog", Font.BOLD, 12));
        deposit.addActionListener(this);
        image.add(deposit);

        cashwithdrawal = new JButton("CASH WITHDRAWAL");
        cashwithdrawal.setBounds(350, 400, 170, 40);
        cashwithdrawal.setForeground(Color.black);
        cashwithdrawal.setBackground(Color.LIGHT_GRAY);
        cashwithdrawal.setFont(new Font("Dialog", Font.BOLD, 12));
        cashwithdrawal.addActionListener(this);
        image.add(cashwithdrawal);

        fastcash = new JButton("FAST CASH");
        fastcash.setBounds(140, 445, 170, 40);
        fastcash.setForeground(Color.black);
        fastcash.setBackground(Color.LIGHT_GRAY);
        fastcash.setFont(new Font("Dialog", Font.BOLD, 12));
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("MINI STATEMENT");
        ministatement.setBounds(350, 445, 170, 40);
        ministatement.setForeground(Color.black);
        ministatement.setBackground(Color.LIGHT_GRAY);
        ministatement.setFont(new Font("Dialog", Font.BOLD, 12));
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("PIN CHANGE");
        pinchange.setBounds(140, 490, 170, 40);
        pinchange.setForeground(Color.black);
        pinchange.setBackground(Color.LIGHT_GRAY);
        pinchange.setFont(new Font("Dialog", Font.BOLD, 12));
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("BALANCE ENQUIRY");
        balanceenquiry.setBounds(350, 490, 170, 40);
        balanceenquiry.setForeground(Color.black);
        balanceenquiry.setBackground(Color.LIGHT_GRAY);
        balanceenquiry.setFont(new Font("Dialog", Font.BOLD, 12));
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("EXIT");
        exit.setBounds(350, 535, 170, 40);
        exit.setForeground(Color.black);
        exit.setBackground(Color.LIGHT_GRAY);
        exit.setFont(new Font("Dialog", Font.BOLD, 12));
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource() == cashwithdrawal){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        } else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if(ae.getSource() == ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        } else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if(ae.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else {
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        new Transactions("0000");
    }
}
