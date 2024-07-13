
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SignupOne extends JFrame {

    public SignupOne(){//constructor
        setLayout(null);
        Random rnd = new Random();
        long random =Math.abs(rnd.nextLong()%9000L)+1000L;
        
        JLabel formno = new JLabel("APPLICATION FORM NO."+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,150,30);
        add(fname);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,190,150,30);
        add(dob);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
        
    }
    public static void main(String[] args) {
        new SignupOne();
    }
    
}
