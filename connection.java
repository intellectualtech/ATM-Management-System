/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagement;

import java.beans.Statement;
import java.sql.Connection;

/**
 *
 * @author cotad
 */
class connection {
    //Connection connection;
    java.sql.Statement statement;

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/twoo?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
    
}
