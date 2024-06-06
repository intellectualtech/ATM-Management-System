/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


    class Withdrawl extends JFrame implements ActionListener {

    String pin;
    double amount;
    TextField textField;

    JButton b1, b2;
    Withdrawl(String pin){
        this.pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconn/atm2.png"));
        java.awt.Image i2 = i1.getImage().getScaledInstance(1550,830,java.awt.Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS N$ 10,000");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460,180,700,35);
        l3.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(460,220,400,35);
        l3.add(label2);


        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460,260,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(textField);

        b1 = new JButton("WITHDRAW");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }
   

    @Override
     public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            try {
                String amount1 = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
                } else {
                    connn c = new connn();
                    java.sql.ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");
                    double balance = amount;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposite")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount1)) {
                        javax.swing.JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }

                    c.statement.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount1 + "' )");
                    javax.swing.JOptionPane.showMessageDialog(null, "N$ " + amount1 + " Debited Successfully");
                    setVisible(false);
                    new main_Class(pin);
                   

                }
            } catch (Exception E) {

            }
        } else if (e.getSource()==b2) {
            setVisible(false);
            new main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}


