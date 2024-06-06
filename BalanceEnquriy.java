/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquriy extends JFrame implements ActionListener {

    JTable table;
    String pin;
    Choice choiceEMP;
    JButton searchbtn, print, update, back;
    BalanceEnquriy(String pin1){

        getContentPane().setBackground(new Color(255,131,122));
        JLabel search = new JLabel("Search by form number");
        search.setBounds(20,20,150,20);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(180,20,150,20);
        add(choiceEMP);

        try{
            connn c = new connn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank" );
            while (resultSet.next()){
                choiceEMP.add(resultSet.getString("pin"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{
            connn c= new connn();
            ResultSet resultSet = c.statement.executeQuery("select from bank  where pin = '" + pin1 +" " );
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(20,70,80,20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);


                 setSize(900,700);
                 setLayout(null);
                 setLocation(300,100);
                 setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn){
            String query = "select date,type,amount from bank where pin = '"+choiceEMP.getSelectedItem()+"'";
            try {
                connn c = new connn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == update){
            setVisible(false);
            javax.swing.JOptionPane.showMessageDialog(null,"You are unable to update this data");
            new main_Class(pin);
        }else {
            setVisible(false);
            new main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquriy("");
    }
}
