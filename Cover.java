/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagement;

import javax.swing.*;
import java.awt.*;

public class Cover extends JFrame implements Runnable {
    
    Thread t;
    Cover() {
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconn/cover.jpg"));
        java.awt.Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        t = new Thread(this);
        t.start();
        
        setVisible(true);
        
        int x = 1;
        for (int i = 2; i <= 600; i+=4, x+=1) {
            setLocation(600 - ((i + x)/2), 350 - (i/2));
            setSize(i + 3*x, i + x/2);
            
            try {
                Thread.sleep(10);
            } catch (Exception e) {}
        }        
    }
    
    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);
            
            // Next Frame
            new Cover2();
        } catch (Exception e) {
            
        }
    }
    
    public static void main(String[] args) {
        new Cover();
    }
}
