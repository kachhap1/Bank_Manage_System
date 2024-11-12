package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    String pinnumber;
    JButton rs100, rs500, rs1000, rs2000, rs5000, rs10000, back;
    String amount;
    public FastCash(String pinnumber) {
        
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/icons/atm.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel title = new JLabel("SELECT WITHDRAWAL AMOUNT");
        title.setBounds(210, 250, 700, 35);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Dialog", Font.BOLD, 16));
        image.add(title);

        rs100 = new JButton("RS 100");
        rs100.setBounds(140, 400, 170, 40);
        rs100.setForeground(Color.black);
        rs100.setBackground(Color.LIGHT_GRAY);
        rs100.setFont(new Font("Dialog", Font.BOLD, 12));
        rs100.addActionListener(this);
        image.add(rs100);

        rs500 = new JButton("RS 500 ");
        rs500.setBounds(350, 400, 170, 40);
        rs500.setForeground(Color.black);
        rs500.setBackground(Color.LIGHT_GRAY);
        rs500.setFont(new Font("Dialog", Font.BOLD, 12));
        rs500.addActionListener(this);
        image.add(rs500);

        rs1000 = new JButton("RS 1000");
        rs1000.setBounds(140, 445, 170, 40);
        rs1000.setForeground(Color.black);
        rs1000.setBackground(Color.LIGHT_GRAY);
        rs1000.setFont(new Font("Dialog", Font.BOLD, 12));
        rs1000.addActionListener(this);
        image.add(rs1000);

        rs2000 = new JButton("RS 2000");
        rs2000.setBounds(350, 445, 170, 40);
        rs2000.setForeground(Color.black);
        rs2000.setBackground(Color.LIGHT_GRAY);
        rs2000.setFont(new Font("Dialog", Font.BOLD, 12));
        rs2000.addActionListener(this);
        image.add(rs2000);
        
        rs5000 = new JButton("RS 5000");
        rs5000.setBounds(140, 490, 170, 40);
        rs5000.setForeground(Color.black);
        rs5000.setBackground(Color.LIGHT_GRAY);
        rs5000.setFont(new Font("Dialog", Font.BOLD, 12));
        rs5000.addActionListener(this);
        image.add(rs5000);

        rs10000 = new JButton("RS 10,000");
        rs10000.setBounds(350, 490, 170, 40);
        rs10000.setForeground(Color.black);
        rs10000.setBackground(Color.LIGHT_GRAY);
        rs10000.setFont(new Font("Dialog", Font.BOLD, 12));
        rs10000.addActionListener(this);
        image.add(rs10000);
        
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
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            
            try {
                Conn c = new Conn();
                
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"
                        + pinnumber + "','"
                        + date + "','Withdraw','"
                        + amount + "')";
                
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs-" + amount + " Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("0000");
    }
}
