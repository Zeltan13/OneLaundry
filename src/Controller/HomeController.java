/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;

/**
 *
 * @author DHAFINDRA
 */
public class HomeController {
    private static final String DB_URL = "jdbc:mysql://localhost:3307/onelaundry";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    
    public void updateUsernameLabel(JLabel label,int adminID){
        try{
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            
            String query = "SELECT name FROM person WHERE idadmin = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            pstmt.setInt(1, adminID);
            
            if(rs.next()){
                label.setText(rs.getString("name"));
            }
            
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
