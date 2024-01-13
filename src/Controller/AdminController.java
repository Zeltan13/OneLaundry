package Controller;

import java.util.ArrayList;
import Model.ModelAdmin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;

public class AdminController {
    private Statement St;
    private Connection Con;
    private ResultSet Rs;
    private String sql="";

    public void updateUsernameLabel(JLabel label,int adminID){
        String sql = "SELECT nama FROM person WHERE idadmin = ?";
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Ps.setInt(1, adminID);
            Rs = Ps.executeQuery();
            
            while(Rs.next()){
                label.setText(Rs.getString("nama"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public int getAdminId(String username, String password){
        int idAdmin = -1;
        String sql = "SELECT idAdmin FROM admin WHERE username = ? AND password = ?";
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Ps.setString(1, username);
            Ps.setString(2, password);
            Rs = Ps.executeQuery();
            while(Rs.next()){
                idAdmin =  Rs.getInt("idAdmin");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idAdmin;
    }
    
    
    
}
