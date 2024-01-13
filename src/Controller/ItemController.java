package Controller;

import Model.ModelItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class ItemController {
    private Statement St;
    private Connection Con;
    private ResultSet Rs;
    private String sql="";
    
    public int getIdItem(String itemName){
        String sql = "SELECT idItem FROM item WHERE item = ?";
        int idItem = 0;
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Ps.setString(1, itemName);
            Rs = Ps.executeQuery();
            if (Rs.next()){
                idItem = Rs.getInt("idItem");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idItem;
    }
    public ArrayList<ModelItem> getItemData(){
        ArrayList listItem = new ArrayList();
        String sql = "Select item.idItem, item.item, item.hargaPerKg from item";
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Rs = Ps.executeQuery();
            while (Rs.next()){
                int idItem =  Rs.getInt("idItem");
                String item = Rs.getString("item");
                int hargaPerKg = Rs.getInt("hargaPerKg");
                listItem.add(new ModelItem(idItem,item,hargaPerKg));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listItem;
    }
    public int getHargaPerKg(String barang){
        int hargaPerKg = 0;
        String sql = "Select hargaPerKg from item where item = ?";
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/onelaundry", "username", "password");
            PreparedStatement Ps = Con.prepareStatement(sql);
            Ps.setString(1,barang);
            Rs = Ps.executeQuery();
            if (Rs.next()){
                hargaPerKg = Rs.getInt("hargaPerKg");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaPerKg;
    }
}
