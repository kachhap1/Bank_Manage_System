package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AccountDetails extends JFrame implements ActionListener {

    String formno;
    JRadioButton rbsaving, rbfixeddeposit, rbcurrent, rbrecurring;
    JCheckBox checkboxfinal, cbatmcard, cbinternetbanking, cbmobilebanking, cbemailalerts, cbchequebook, cbestatement;
    JButton submit, cancel;
    JLabel lbcardnumber, lbpin;

    public AccountDetails(String formno) {
        this.formno = formno;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lbformno = new JLabel("Form No: 6211");
        lbformno.setBounds(570, 10, 100, 30);
        lbformno.setFont(new Font("Dialog", Font.BOLD, 12));
        lbformno.setForeground(Color.BLACK);
        add(lbformno);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(70, 20, 90, 90);
        add(image);

        JLabel subheading = new JLabel("Page 3: Account Details");
        subheading.setBounds(180, 50, 300, 40);
        subheading.setFont(new Font("Dialog", Font.BOLD, 24));
        add(subheading);

        JLabel accttype = new JLabel("Account Type:");
        accttype.setBounds(50, 120, 200, 40);
        accttype.setFont(new Font("Dialog", Font.BOLD, 16));
        add(accttype);

        ButtonGroup accttypegroup = new ButtonGroup();
        rbsaving = new JRadioButton("Saving Account");
        rbsaving.setBounds(60, 160, 200, 30);
        rbsaving.setBackground(Color.WHITE);
        rbsaving.setFont(new Font("Dialog", Font.BOLD, 16));
        add(rbsaving);
        rbfixeddeposit = new JRadioButton("Fixed Deposit Acoount");
        rbfixeddeposit.setBounds(260, 160, 200, 30);
        rbfixeddeposit.setBackground(Color.WHITE);
        rbfixeddeposit.setFont(new Font("Dialog", Font.BOLD, 16));
        add(rbfixeddeposit);
        rbcurrent = new JRadioButton("Fixed Deposit Acoount");
        rbcurrent.setBounds(60, 200, 200, 30);
        rbcurrent.setBackground(Color.WHITE);
        rbcurrent.setFont(new Font("Dialog", Font.BOLD, 16));
        add(rbcurrent);
        rbrecurring = new JRadioButton("Recurring Deposit Acoount");
        rbrecurring.setBounds(260, 200, 200, 30);
        rbrecurring.setBackground(Color.WHITE);
        rbrecurring.setFont(new Font("Dialog", Font.BOLD, 16));
        add(rbrecurring);
        accttypegroup.add(rbsaving);
        accttypegroup.add(rbfixeddeposit);
        accttypegroup.add(rbcurrent);
        accttypegroup.add(rbrecurring);

        JLabel cardnumber = new JLabel("Card Number:");
        cardnumber.setBounds(50, 260, 200, 40);
        cardnumber.setFont(new Font("Dialog", Font.BOLD, 16));
        add(cardnumber);

        lbcardnumber = new JLabel("XXXX-XXX-XXXX-5030");
        lbcardnumber.setBounds(250, 260, 200, 40);
        lbcardnumber.setFont(new Font("Dialog", Font.BOLD, 20));
        add(lbcardnumber);

        JLabel cardSpec = new JLabel("(Your 16-digit Card number)");
        cardSpec.setBounds(50, 300, 200, 20);
        cardSpec.setFont(new Font("Dialog", Font.BOLD, 12));
        add(cardSpec);

        JLabel cardspec2 = new JLabel("(It would appear on ATM/Check Book and statement)");
        cardspec2.setBounds(250, 300, 200, 20);
        cardspec2.setFont(new Font("Dialog", Font.BOLD, 12));
        add(cardspec2);

        JLabel pin = new JLabel("PIN:");
        pin.setBounds(50, 340, 200, 40);
        pin.setFont(new Font("Dialog", Font.BOLD, 16));
        add(pin);

        JLabel pinspec = new JLabel("(4-digit password)");
        pinspec.setBounds(50, 380, 200, 20);
        pinspec.setFont(new Font("Dialog", Font.BOLD, 12));
        add(pinspec);

        lbpin = new JLabel("XXXX");
        lbpin.setBounds(250, 340, 200, 40);
        lbpin.setFont(new Font("Dialog", Font.BOLD, 16));
        add(lbpin);

        JLabel sevicered = new JLabel("Service Required:");
        sevicered.setBounds(50, 420, 200, 40);
        sevicered.setFont(new Font("Dialog", Font.BOLD, 16));
        add(sevicered);

        cbatmcard = new JCheckBox("ATM CARD");
        cbatmcard.setBounds(60, 480, 200, 30);
        cbatmcard.setBackground(Color.WHITE);
        cbatmcard.setFont(new Font("Dialog", Font.BOLD, 16));
        add(cbatmcard);
        cbinternetbanking = new JCheckBox("Internet Banking");
        cbinternetbanking.setBounds(260, 480, 200, 30);
        cbinternetbanking.setBackground(Color.WHITE);
        cbinternetbanking.setFont(new Font("Dialog", Font.BOLD, 16));
        add(cbinternetbanking);
        cbmobilebanking = new JCheckBox("Mobile Banking");
        cbmobilebanking.setBounds(60, 530, 200, 30);
        cbmobilebanking.setBackground(Color.WHITE);
        cbmobilebanking.setFont(new Font("Dialog", Font.BOLD, 16));
        add(cbmobilebanking);
        cbemailalerts = new JCheckBox("Email Alerts");
        cbemailalerts.setBounds(260, 530, 200, 30);
        cbemailalerts.setBackground(Color.WHITE);
        cbemailalerts.setFont(new Font("Dialog", Font.BOLD, 16));
        add(cbemailalerts);
        cbchequebook = new JCheckBox("Cheque Book");
        cbchequebook.setBounds(60, 570, 200, 30);
        cbchequebook.setBackground(Color.WHITE);
        cbchequebook.setFont(new Font("Dialog", Font.BOLD, 16));
        add(cbchequebook);
        cbestatement = new JCheckBox("E-Statement");
        cbestatement.setBounds(260, 570, 200, 30);
        cbestatement.setBackground(Color.WHITE);
        cbestatement.setFont(new Font("Dialog", Font.BOLD, 16));
        add(cbestatement);

        checkboxfinal = new JCheckBox("I hereby declares that the above enerted details corret to the best of my knowledge");
        checkboxfinal.setBounds(50, 620, 400, 20);
        checkboxfinal.setFont(new Font("Dialog", Font.BOLD, 12));
        add(checkboxfinal);

        submit = new JButton("Next");
        submit.setBounds(200, 650, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(400, 650, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(700, 750);
        setLocation(300, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){
            String accounttype = null;
            if(rbsaving.isSelected()){
                accounttype = "Saving Account";
            } else if(rbfixeddeposit.isSelected()){
                accounttype = "Fixed Deposit Account";
            } else if(rbcurrent.isSelected()){
                accounttype = "Current Account";
            } else {
                accounttype = "Recurring Deposit Account";
            }
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
          
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if(cbatmcard.isSelected()){
                facility = facility + " ATM CARD";
            } else if(cbinternetbanking.isSelected()){
                facility = facility + " Internet Banking";
            } else if(cbmobilebanking.isSelected()){
                facility = facility + " Mobile Banking";
            } else if(cbemailalerts.isSelected()){
                facility = facility + " Email & SMS Alerts";
            } else if(cbchequebook.isSelected()){
                facility = facility + " Cheque Book";
            } else {
                facility = facility + " E-Statement";
            }
            
            try{
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    Conn c = new Conn();
                    String query = "insert into accountdetails values('"
                            + formno + "','"
                            + accounttype + "','"
                            + cardnumber + "','"
                            + pinnumber + "','"
                            + facility + "')";
                    String query2 = "insert into login values('"
                            + formno + "','"
                            +cardnumber + "','"
                            +pinnumber + "')";
                    
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card no.:" + cardnumber + "\nPIN: " + pinnumber);
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
                
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AccountDetails("6473");
    }
}
