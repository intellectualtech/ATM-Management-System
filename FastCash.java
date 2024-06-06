/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cotad
 */

  

class FastCash extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    FastCash(String pin){
        this.pin =pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconn/atm2.png"));
        java.awt.Image i2 = i1.getImage().getScaledInstance(1550,830,java.awt.Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label = new JLabel("SELECT WITHDRAWL AMOUNT");
        label.setBounds(445,180,700,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,23));
        l3.add(label);

        b1 = new JButton("N$ 100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(410,274,150,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("N$ 500");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(700,274,150,35);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("N$ 1000");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(410,318,150,35);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("N$ 2000");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(700,318,150,35);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("N$ 5000");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(410,362,150,35);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("N$ 10000");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(700,362,150,35);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("BACK");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65,125,128));
        b7.setBounds(700,406,150,35);
        b7.addActionListener(this);
        l3.add(b7);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b7) {
            setVisible(false);
            new main_Class(pin);
        }else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            connn c = new connn();
            Date date = new Date();
            try{
                java.sql.ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance =0;
                while (resultSet.next()){
                    if (resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                if (e.getSource() != b7 && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }

                c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"', 'withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
            }catch (Exception E){
                E.printStackTrace();
            }
            setVisible(false);
           main_Class rd= new main_Class(pin);
        }


    }

    public static void main(String[] args) {
        new FastCash("");
    }
}