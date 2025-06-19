package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    Signup3(String formno) {

        this.formno = formno;

        setTitle("Signup - Page 3");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(150, 5, 100, 100);
        add(image);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel l3 = new JLabel("Account Type:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 140, 200, 30);
        add(l3);

        r1 = new JRadioButton("Saving Account");
        r2 = new JRadioButton("Fixed Deposit Account");
        r3 = new JRadioButton("Current Account");
        r4 = new JRadioButton("Recurring Deposit Account");

        JRadioButton[] radioButtons = {r1, r2, r3, r4};
        int[] yPositions = {180, 180, 220, 220};
        int[] xPositions = {100, 350, 100, 350};
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i].setFont(new Font("Raleway", Font.BOLD, 16));
            radioButtons[i].setBackground(new Color(215, 252, 252));
            radioButtons[i].setBounds(xPositions[i], yPositions[i], 250, 30);
            add(radioButtons[i]);
        }

        ButtonGroup accountGroup = new ButtonGroup();
        for (JRadioButton rb : radioButtons) {
            accountGroup.add(rb);
        }

        JLabel l4 = new JLabel("Card Number:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(100, 300, 200, 30);
        add(l4);

        JLabel l5 = new JLabel("(Your 16-digit Card Number)");
        l5.setFont(new Font("Raleway", Font.PLAIN, 12));
        l5.setBounds(100, 330, 200, 20);
        add(l5);

        JLabel l6 = new JLabel("XXXX-XXXX-XXXX-4841");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(330, 300, 250, 30);
        add(l6);

        JLabel l7 = new JLabel("(It would appear on ATM card, cheque book, and statements)");
        l7.setFont(new Font("Raleway", Font.PLAIN, 12));
        l7.setBounds(330, 330, 400, 20);
        add(l7);

        JLabel l8 = new JLabel("PIN:");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(100, 370, 200, 30);
        add(l8);

        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(330, 370, 200, 30);
        add(l9);

        JLabel l10 = new JLabel("(4-digit Password)");
        l10.setFont(new Font("Raleway", Font.PLAIN, 12));
        l10.setBounds(100, 400, 200, 20);
        add(l10);

        JLabel l11 = new JLabel("Services Required:");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        l11.setBounds(100, 450, 200, 30);
        add(l11);

        c1 = new JCheckBox("ATM CARD");
        c2 = new JCheckBox("Internet Banking");
        c3 = new JCheckBox("Mobile Banking");
        c4 = new JCheckBox("EMAIL Alerts");
        c5 = new JCheckBox("Cheque Book");
        c6 = new JCheckBox("E-Statement");

        JCheckBox[] services = {c1, c2, c3, c4, c5, c6};
        int[] yCords = {500, 500, 550, 550, 600, 600};
        int[] xCords = {100, 350, 100, 350, 100, 350};

        for (int i = 0; i < services.length; i++) {
            services[i].setBackground(new Color(215, 252, 252));
            services[i].setFont(new Font("Raleway", Font.BOLD, 16));
            services[i].setBounds(xCords[i], yCords[i], 200, 30);
            add(services[i]);
        }

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.", true);
        c7.setFont(new Font("Raleway", Font.PLAIN, 12));
        c7.setBackground(new Color(215, 252, 252));
        c7.setBounds(100, 680, 600, 20);
        add(c7);

        JLabel l12 = new JLabel("Form No:");
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(700, 10, 100, 30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 14));
        l13.setBounds(760, 10, 60, 30);
        add(l13);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(new Color(215, 252, 252));
        setLayout(null);
        setSize(850, 800);
        setLocation(400, 20);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String atype = null;

        if (r1.isSelected()) atype = "Saving Account";
        else if (r2.isSelected()) atype = "Fixed Deposit Account";
        else if (r3.isSelected()) atype = "Current Account";
        else if (r4.isSelected()) atype = "Recurring Deposit Account";

        // Safely handle null account type
        if (atype == null) {
            JOptionPane.showMessageDialog(null, "Please select an Account Type");
            return;
        }

        // Generate card number and PIN
        Random ran = new Random();
        String cardno = "" + (Math.abs(ran.nextLong()) % 90000l + 100000L);
        String pin = "" + (Math.abs(ran.nextInt()) % 9000 + 1000);

        // Collect selected services
        StringBuilder fac = new StringBuilder();
        if (c1.isSelected()) fac.append("ATM CARD ");
        if (c2.isSelected()) fac.append("Internet Banking ");
        if (c3.isSelected()) fac.append("Mobile Banking ");
        if (c4.isSelected()) fac.append("EMAIL Alerts ");
        if (c5.isSelected()) fac.append("Cheque Book ");
        if (c6.isSelected()) fac.append("E-Statement ");

        try {
            if (e.getSource() == submit) {
                if (!c7.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please confirm declaration.");
                    return;
                }

                Connn c1 = new Connn();
                String q1 = "insert into signupthree values('" + formno + "', '" + atype + "','" + cardno + "','" + pin + "','" + fac + "')";
                String q2 = "insert into login values('" + formno + "','" + cardno + "','" + pin + "')";
                c1.statement.executeUpdate(q1);
                c1.statement.executeUpdate(q2);

                JOptionPane.showMessageDialog(null, "Card Number : " + cardno + "\nPIN : " + pin);
                new Deposit(pin);
                setVisible(false);

            } else if (e.getSource() == cancel) {
                System.exit(0);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
}
