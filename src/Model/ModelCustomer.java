package Model;

public class ModelCustomer extends ModelPerson{
    private int idCustomer,idAdmin;
    private String item;

    public ModelCustomer(int idCustomer,String nama, String alamat, String noTelp, String jenisKelamin, String item) {
        this.idCustomer = idCustomer;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.jenisKelamin = jenisKelamin;
        this.item = item;
    }
    public String getNama() {
        return nama;
    }
    
    public ModelCustomer(int idCustomer,String nama, String alamat, String noTelp, String item,int idAdmin) {
        this.idCustomer = idCustomer;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.item = item;
        this.idAdmin = idAdmin;
    }

    public ModelCustomer(int idCustomer,String nama, String alamat, String noTelp,int idAdmin) {
        this.idCustomer = idCustomer;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.item = item;
        this.idAdmin = idAdmin;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
    
    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
}
