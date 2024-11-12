package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdditionalDetails extends JFrame implements ActionListener {

    String formno;
    JTextField tfpannumber, tfadharnumber;
    JRadioButton rbscyes, rbscno, rbexacctyes, rbexacctno;
    JButton next;
    JComboBox cbreligion, cbcategory, cbincome, cbeducation, cboccupation;

    public AdditionalDetails(String formno) {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        this.formno = formno;

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

        JLabel subheading = new JLabel("Page 2: Additonal Details");
        subheading.setBounds(180, 50, 300, 40);
        subheading.setFont(new Font("Dialog", Font.BOLD, 24));
        add(subheading);

        JLabel religion = new JLabel("Religion");
        religion.setBounds(50, 120, 200, 40);
        religion.setFont(new Font("Dialog", Font.BOLD, 16));
        religion.setBackground(Color.WHITE);
        add(religion);

        String valreligion[] = {"Hindu", "Muslim", "Sikh", "Chrisitian", "Other"};
        cbreligion = new JComboBox(valreligion);
        cbreligion.setBounds(260, 120, 300, 40);
        cbreligion.setFont(new Font("Dialog", Font.BOLD, 16));
        cbreligion.setBackground(Color.WHITE);
        add(cbreligion);

        JLabel category = new JLabel("Categoey");
        category.setBounds(50, 170, 200, 40);
        category.setFont(new Font("Dialog", Font.BOLD, 16));
        category.setBackground(Color.WHITE);
        add(category);

        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        cbcategory = new JComboBox(valcategory);
        cbcategory.setBounds(260, 170, 300, 40);
        cbcategory.setFont(new Font("Dialog", Font.BOLD, 16));
        cbcategory.setBackground(Color.WHITE);
        add(cbcategory);

        JLabel income = new JLabel("Income");
        income.setBounds(50, 220, 200, 40);
        income.setFont(new Font("Dialog", Font.BOLD, 16));
        income.setBackground(Color.WHITE);
        add(income);

        String valincome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,00,000"};
        cbincome = new JComboBox(valincome);
        cbincome.setBounds(260, 220, 300, 40);
        cbincome.setFont(new Font("Dialog", Font.BOLD, 16));
        cbincome.setBackground(Color.WHITE);
        add(cbincome);

        JLabel education = new JLabel("Education");
        education.setBounds(50, 270, 200, 40);
        education.setFont(new Font("Dialog", Font.BOLD, 16));
        add(education);
        JLabel qualification = new JLabel("Qualification:");
        qualification.setBounds(50, 300, 200, 40);
        qualification.setFont(new Font("Dialog", Font.BOLD, 16));
        add(qualification);

        String valeducation[] = {"Non-Graduation", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        cbeducation = new JComboBox(valeducation);
        cbeducation.setBounds(260, 280, 300, 40);
        cbeducation.setFont(new Font("Dialog", Font.BOLD, 16));
        cbeducation.setBackground(Color.WHITE);
        add(cbeducation);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setBounds(50, 340, 200, 40);
        occupation.setFont(new Font("Dialog", Font.BOLD, 16));
        add(occupation);

        String valoccupation[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Other"};
        cboccupation = new JComboBox(valoccupation);
        cboccupation.setBounds(260, 340, 300, 40);
        cboccupation.setFont(new Font("Dialog", Font.BOLD, 16));
        cboccupation.setBackground(Color.WHITE);
        add(cboccupation);

        JLabel pannumber = new JLabel("PAN Number:");
        pannumber.setBounds(50, 400, 200, 40);
        pannumber.setFont(new Font("Dialog", Font.BOLD, 16));
        add(pannumber);

        tfpannumber = new JTextField();
        tfpannumber.setBounds(260, 400, 300, 40);
        tfpannumber.setFont(new Font("Dialog", Font.BOLD, 16));
        add(tfpannumber);

        JLabel adharnumber = new JLabel("Adhar Number:");
        adharnumber.setBounds(50, 450, 200, 40);
        adharnumber.setFont(new Font("Dialog", Font.BOLD, 16));
        add(adharnumber);

        tfadharnumber = new JTextField();
        tfadharnumber.setBounds(260, 450, 300, 40);
        tfadharnumber.setFont(new Font("Dialog", Font.BOLD, 16));
        add(tfadharnumber);

        JLabel seniorcitizen = new JLabel("Senior Citizen:");
        seniorcitizen.setBounds(50, 500, 200, 40);
        seniorcitizen.setFont(new Font("Dialog", Font.BOLD, 16));
        add(seniorcitizen);

        ButtonGroup seniorgroup = new ButtonGroup();
        rbscyes = new JRadioButton("YES");
        rbscyes.setBounds(260, 500, 150, 40);
        rbscyes.setBackground(Color.WHITE);
        rbscyes.setFont(new Font("Dialog", Font.BOLD, 16));
        add(rbscyes);
        rbscno = new JRadioButton("NO");
        rbscno.setBounds(410, 500, 150, 40);
        rbscno.setBackground(Color.WHITE);
        rbscno.setFont(new Font("Dialog", Font.BOLD, 16));
        add(rbscno);
        seniorgroup.add(rbscyes);
        seniorgroup.add(rbscno);

        JLabel existingaccount = new JLabel("Exisiting Account:");
        existingaccount.setBounds(50, 550, 200, 40);
        existingaccount.setFont(new Font("Dialog", Font.BOLD, 16));
        add(existingaccount);

        ButtonGroup exacctgroup = new ButtonGroup();
        rbexacctyes = new JRadioButton("YES");
        rbexacctyes.setBounds(260, 550, 150, 40);
        rbexacctyes.setBackground(Color.WHITE);
        rbexacctyes.setFont(new Font("Dialog", Font.BOLD, 16));
        add(rbexacctyes);
        rbexacctno = new JRadioButton("NO");
        rbexacctno.setBounds(410, 550, 150, 40);
        rbexacctno.setBackground(Color.WHITE);
        rbexacctno.setFont(new Font("Dialog", Font.BOLD, 16));
        add(rbexacctno);
        exacctgroup.add(rbexacctyes);
        exacctgroup.add(rbexacctno);

        next = new JButton("Next");
        next.setBounds(450, 600, 100, 40);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setSize(700, 700);
        setLocation(300, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String religion = (String) cbreligion.getSelectedItem();
        String category = (String) cbcategory.getSelectedItem();
        String income = (String) cbincome.getSelectedItem();
        String education = (String) cbeducation.getSelectedItem();
        String occupation = (String) cboccupation.getSelectedItem();
        String pannumber = tfpannumber.getText();
        String adharnumber = tfadharnumber.getText();
        String seniorcitizen = null;
        if (rbscyes.isSelected()) {
            seniorcitizen = "YES";
        } else {
            seniorcitizen = "NO";
        }
        String existingaccount = null;
        if (rbexacctyes.isSelected()) {
            existingaccount = "YES";
        } else {
            existingaccount = "NO";
        }

        if (ae.getSource() == next) {
            if (religion.equals("")) {
               JOptionPane.showMessageDialog(null,"Regligion not Entered");
            } else if (category.equals("")) {
               JOptionPane.showMessageDialog(null,"Category not Entered");
            } else if (income.equals("")) {
               JOptionPane.showMessageDialog(null,"Income not Entered");
            } else if (education.equals("")) {
               JOptionPane.showMessageDialog(null,"Education not Entered");
            } else if (occupation.equals("")) {
               JOptionPane.showMessageDialog(null,"Occupation not Entered");
            } else if (pannumber.equals("")) {
               JOptionPane.showMessageDialog(null,"PAN Number not Entered");
            } else if (adharnumber.equals("")) {
               JOptionPane.showMessageDialog(null,"Adhar Number not Entered");
            } else if (seniorcitizen.equals("")) {
               JOptionPane.showMessageDialog(null,"Senior Citizen not Chossen");
            } else if (existingaccount.equals("")) {
               JOptionPane.showMessageDialog(null,"Existing Account not Chossen");
            } else {
                try {
                    Conn c = new Conn();
                    String query = "insert into addtionaldetails values('"
                            + formno + "','"
                            + religion + "','"
                            + category + "','"
                            + income + "','"
                            + education + "','"
                            + occupation + "','"
                            + pannumber + "','"
                            + adharnumber + "','"
                            + seniorcitizen + "','"
                            + existingaccount + "')";

                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Infomation Added!");
                    new AccountDetails(formno).setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new AdditionalDetails("6343");
    }
}
