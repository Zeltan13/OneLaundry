package Model;

public class ModelAdmin extends ModelPerson{
    private String username;
    private String password;
    private int idAdmin;
    private ModelTransaksi[] transaksi;

    public ModelAdmin(String nama, String alamat, String noTelp, String jenisKelamin, String username, String password, ModelTransaksi[] transaksi) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.jenisKelamin = jenisKelamin;
        this.username = username;
        this.password = password;
        this.transaksi = transaksi;
    }
    public ModelAdmin(int idAdmin, String username, String password){
        this.idAdmin = idAdmin;
        this.username = username;
        this.password = password;
    }
    public String getNama() {
        return nama;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ModelTransaksi[] getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(ModelTransaksi[] transaksi) {
        this.transaksi = transaksi;
    }
}