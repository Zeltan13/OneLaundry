package Controller;

import Model.ModelTransaksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class TransactionController {
    private Statement St;
    private Connection Con;
    private ResultSet Rs;
    private String sql="";

    
    public ArrayList<ModelTransaksi> getTransactionData(){
        ArrayList listTransaksi = new ArrayList();
        String sql = "Select t.idTransaksi, t.idCustomer, t.layanan, t.status, t.tgl, i.item, t.total, t.idAdmin, i.hargaPerKg, t.berat from transaksi as t JOIN item as i on t.idItem = i.idItem";
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Rs = Ps.executeQuery();
            while (Rs.next()){
                int idTransaksi =  Rs.getInt("idTransaksi");
                int idCustomer = Rs.getInt("idCustomer");
                String layanan = Rs.getString("layanan");
                String status = Rs.getString("status");
                String tgl = Rs.getString("tgl");
                String item = Rs.getString("item");
                int total = Rs.getInt("total");
                int idAdmin = Rs.getInt("idAdmin");
                String hargaPerKg = Rs.getString("hargaPerKg");
                String berat = Rs.getString("berat");
                listTransaksi.add(new ModelTransaksi(idTransaksi,idCustomer,layanan,status,tgl,item,total,idAdmin, hargaPerKg, berat));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTransaksi;
    }
    public int countOfAdminTransaction(int idAdmin){
        String sql = "SELECT COUNT(*) AS numberOfPeople FROM transaksi WHERE idAdmin = ?";
        int jumTransaksi=0;
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Ps.setInt(1, idAdmin);
            Rs = Ps.executeQuery();
            if (Rs.next()){
                jumTransaksi = Rs.getInt("numberOfPeople");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jumTransaksi;
    }
    public ArrayList<ModelTransaksi> getTransactionDataSesuaiAdmin(ArrayList<ModelTransaksi> listTransaksi, int idAdmin){
        ArrayList listTransaksiSesuaiAdmin = new ArrayList();
        for (ModelTransaksi x: listTransaksi){
            if(x.getIdAdmin() == idAdmin){
                listTransaksiSesuaiAdmin.add(x);
            } 
        }
        return listTransaksiSesuaiAdmin;
    }
    public void insertTransaksi(int idTransaksi,String noTransaksi, String layanan,String status, float total,int idCustomer, int idItem,int idAdmin, String berat, String tgl){
        String sql = "INSERT INTO transaksi (idTransaksi,noTransaksi,layanan,status,total,idCustomer,idItem,idAdmin,berat,tgl) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Ps.setInt(1, idTransaksi);
            Ps.setString(2, noTransaksi);
            Ps.setString(3, layanan);
            Ps.setString(4, status);
            Ps.setFloat(5, total);
            Ps.setInt(6, idCustomer);
            Ps.setInt(7, idItem);
            Ps.setInt(8, idAdmin);
            Ps.setString(9, berat);
            Ps.setString(10, tgl);
            Ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean adaTransaksi(int idTransaksi) {
        String sql = "SELECT COUNT(*) AS numberOfTransaction FROM transaksi WHERE idTransaksi = ?";
        boolean ada = false;
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql); 
            Ps.setInt(1, idTransaksi);
            Rs = Ps.executeQuery();
            if (Rs.next()){
                int jum = Rs.getInt("numberOfTransaction");
                ada = (jum>0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ada;
    }
    public int getNextIdTransaksi(){
        String sql = "Select MAX(idTransaksi) as MaxID from transaksi";
        int idTransaksi = 0;
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Rs = Ps.executeQuery();
            if (Rs.next()){
                idTransaksi = Rs.getInt("MaxID");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idTransaksi+1;
    }
    public void deleteTransaksi(int idTransaksi){
        String sql = "Delete From transaksi where transaksi.idTransaksi = ?";
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Ps.setInt(1, idTransaksi);
            Ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateTransaksi(int idTransaksi, String noTransaksi, String layanan,String status, float total,int idCustomer, int idItem,int idAdmin, String berat, String tgl){
        String sql = "UPDATE transaksi SET noTransaksi = ?, layanan = ?, status = ?, total = ?, idCustomer = ?, idItem = ?, idAdmin = ?, berat = ?, tgl = ? WHERE idTransaksi = ?";
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            
            Ps.setString(1, noTransaksi);
            Ps.setString(2, layanan);
            Ps.setString(3, status);
            Ps.setFloat(4, total);
            Ps.setInt(5, idCustomer);
            Ps.setInt(6, idItem);
            Ps.setInt(7, idAdmin);
            Ps.setString(8, berat);
            Ps.setString(9, tgl);
            Ps.setInt(10, idTransaksi);
            Ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateRowNumbers(DefaultTableModel tableModel) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.setValueAt(i+1, i, 0);
        }
    }
    public int getIdTransaksi(){
        String sql = "Select transaksi.idTransaksi from transaksi";
        int idTransaksi = 0;
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Rs = Ps.executeQuery();
            while (Rs.next()){
                idTransaksi++;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idTransaksi;
    }
}
