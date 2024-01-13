package Controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterController {
    private Statement St;
    private Connection Con;
    private ResultSet Rs;
    private String sql="";
    
    public void insertAdmin(int idAdmin, String username, String password){
        String sql = "INSERT INTO admin (idAdmin,username,password) VALUES (?,?,?)";
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Ps.setInt(1, idAdmin);
            Ps.setString(2, username);
            Ps.setString(3, password);
            Ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertPerson(int idPerson, String nama, String alamat,String noTelp, String jenisKelamin,int idAdmin){
        String sql = "INSERT INTO Person (idPerson,nama,alamat,noTelp,jenisKelamin,idAdmin) VALUES (?,?,?,?,?,?)";
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Ps.setInt(1, idPerson);
            Ps.setString(2, nama);
            Ps.setString(3, alamat);
            Ps.setString(4, noTelp);
            Ps.setString(5, jenisKelamin);
            Ps.setInt(6, idAdmin);
            Ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getNextIdAdmin(){
        String sql = "Select MAX(idAdmin) maxID from admin";
        int idAdmin = 0;
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Rs = Ps.executeQuery();
            if (Rs.next()){
                idAdmin = Rs.getInt("maxID");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idAdmin+1;
    }
    public int getNextIdPerson(){
        String sql = "Select person.idPerson from person";
        int idPerson = 0;
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Rs = Ps.executeQuery();
            while (Rs.next()){
                idPerson++;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idPerson+1;
    }
    public boolean usernameTaken(String inputUsername){
        boolean taken = false;
        String sql = "Select admin.username from admin";
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Rs = Ps.executeQuery();
            while (Rs.next()){
                String username = Rs.getString("username");
                if (inputUsername.equals(username)){
                    taken = true;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taken;
    }
    
}
