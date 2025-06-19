package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1, b2;

    Withdrawl(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460, 180, 400, 35);
        l3.add(label1);

        textField = new TextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460, 230, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(textField);

        b1 = new JButton("WITHDRAW");
        b1.setBounds(700, 362, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700, 406, 150, 35);
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textField.getText();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = sdf.format(date);

            if (e.getSource() == b1) {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                } else {
                    Connn c = new Connn();

                    // Calculate current balance
                    int balance = 0;
                    ResultSet rs = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
                    while (rs.next()) {
                        String type = rs.getString("type");
                        int amt = Integer.parseInt(rs.getString("amount"));
                        if (type.equals("Deposit")) {
                            balance += amt;
                        } else if (type.equals("Withdraw")) {
                            balance -= amt;
                        }
                    }

                    int withdrawAmount = Integer.parseInt(amount);
                    if (withdrawAmount > balance || balance == 0) {
                        JOptionPane.showMessageDialog(null, "Your account balance is not enough");
                    } else {
                        String query = "INSERT INTO bank VALUES('" + pin + "', '" + formattedDate + "', 'Withdraw', '" + amount + "')";
                        c.statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Rs. " + amount + " withdrawn successfully");
                        setVisible(false);
                        new main_Class(pin);
                    }
                }
            } else if (e.getSource() == b2) {
                setVisible(false);
                new main_Class(pin);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    public static void main(String[] args) {
        new Withdrawl("");
    }
}
