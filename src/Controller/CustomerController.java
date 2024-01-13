package Controller;

import Model.ModelCustomer;
import View.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerController {
    private Statement St;
    private Connection Con;
    private ResultSet Rs;
    private String sql="";
    private String username, password;
    private int idAdmin;
    public ArrayList CustomerController() {
        ArrayList<ModelCustomer> x = new ArrayList();
        x = getCustomerData();
        return x;
//        for(ModelAdmin ML:x){
//            if (usr.equals(ML.getUsername())&& pwd.equals(ML.getPassword())){
//                return true;
//            }
//        };
        
    }
    public ArrayList<ModelCustomer> getCustomerData(){
        ArrayList listCustomer = new ArrayList();
        String sql = "Select c.idCustomer, p.nama, p.alamat, p.noTelp, c.idAdmin from customer as c JOIN person as p on c.idPerson = p.idPerson";
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Rs = Ps.executeQuery();
            while (Rs.next()){
                int idCustomer =  Rs.getInt("idCustomer");
                String nama = Rs.getString("nama");
                String alamat = Rs.getString("alamat");
                String noTelp = Rs.getString("noTelp");
                int idAdmin = Rs.getInt("idAdmin");
                listCustomer.add(new ModelCustomer(idCustomer,nama,alamat,noTelp,idAdmin));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCustomer;
    }
    public int countOfAdminCustomer(int idAdmin){
        String sql = "SELECT COUNT(*) AS numberOfPeople FROM person WHERE idAdmin = ?";
        int jumCustomer=0;
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Ps.setInt(1, idAdmin);
            Rs = Ps.executeQuery();
            if (Rs.next()){
                jumCustomer = Rs.getInt("numberOfPeople");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jumCustomer;
    }
    public ArrayList<ModelCustomer> getCustomerDataSesuaiAdmin(ArrayList<ModelCustomer> listCustomer, int idAdmin){
        ArrayList listCustomerSesuaiAdmin = new ArrayList();
        for (ModelCustomer x: listCustomer){
            if(x.getIdAdmin() == idAdmin){
                listCustomerSesuaiAdmin.add(x);
            } 
        }
        return listCustomerSesuaiAdmin;
    }
    public void insertPerson(String nama, String alamat, String noTelp, String jenisKelamin){
        String sql1 = "INSERT INTO person (idPerson, nama,alamat,noTelp,jenisKelamin) values (?,?,?,?,?)";
        RegisterController RC = new RegisterController();
        int idPerson = RC.getNextIdPerson();
        int idCustomer = getNextIdCustomer();
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql1);
            Ps.setInt(1,idPerson);
            Ps.setString(2, nama);
            Ps.setString(3, alamat);
            Ps.setString(4, noTelp);
            Ps.setString(5, jenisKelamin);
            Ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql2 = "INSERT INTO customer (idCustomer,idPerson,idAdmin) values (?,?,?)";
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql2);
            Ps.setInt(1, idCustomer);
            Ps.setInt(2, idPerson);
            Ps.setInt(3, Login.adminId);
            Ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getNextIdCustomer(){
        String sql = "Select customer.idCustomer from customer";
        int idCustomer= 0;
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Rs = Ps.executeQuery();
            while (Rs.next()){
                idCustomer++;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idCustomer+1;
    }
}
