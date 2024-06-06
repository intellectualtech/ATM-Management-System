/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagement;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author cotad
 */
public class connn {

    Connection connection;
    Statement statement;
    Connection conn;

    //connn conn = new connn();

    public connn(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/twoo?zeroDateTimeBehavior=CONVERT_TO_NULL ","root","");
            statement = connection.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
public Connection getConnection() {
        return conn;
    }
}
