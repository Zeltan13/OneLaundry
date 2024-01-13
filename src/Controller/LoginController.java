package Controller;

import Model.ModelAdmin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginController {
    private Statement St;
    private Connection Con;
    private ResultSet Rs;
    private String sql="";
    private String username, password;
    private int idAdmin;
    public boolean LoginController(String usr, String pwd) {
        ArrayList<ModelAdmin> x = new ArrayList();
        x = getLoginData();
        
        for(ModelAdmin ML:x){
            if (usr.equals(ML.getUsername())&& pwd.equals(ML.getPassword())){
                return true;
            }
        };
        return false;
    }
    public ArrayList<ModelAdmin> getLoginData(){
        ArrayList listAdmin = new ArrayList();
        String sql = "Select admin.idAdmin, admin.username, admin.password from admin";
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Rs = Ps.executeQuery();
            while (Rs.next()){
                int idAdmin =  Rs.getInt("idAdmin");
                String username = Rs.getString("username");
                String password = Rs.getString("password");
                listAdmin.add(new ModelAdmin(idAdmin,username,password));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAdmin;
    }
}
