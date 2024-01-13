package Model;

public class ModelTransaksi implements HitungHarga {
    private int idTransaksi;
    private int idCustomer;
    private String layanan;
    private String status;
    private String tgl;
    private String item;
    private double total;
    private int idAdmin;
    private String hargaPerKg;
    private String berat;
    
    public ModelTransaksi(){
    }
    public ModelTransaksi(int idTransaksi, int idCustomer, String layanan, String status, String tgl, String item, int total,int idAdmin, String hargaPerKg, String berat) {
        this.idTransaksi = idTransaksi;
        this.idCustomer = idCustomer;
        this.layanan = layanan;
        this.status = status;
        this.tgl = tgl;
        this.item = item;
        this.total = total;
        this.idAdmin = idAdmin;
        this.hargaPerKg = hargaPerKg;
        this.berat = berat;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    public String getHargaPerKg() {
        return hargaPerKg;
    }

    public void setHargaPerKg(String hargaPerKg) {
        this.hargaPerKg = hargaPerKg;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }
//    public void calcTotal() {
//        int sum = 0;
//        for (Item i : this.item) {
//            sum += i.getHarga();
//        }
//        this.total = sum;
//    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getLayanan() {
        return layanan;
    }

    public void setLayanan(String layanan) {
        this.layanan = layanan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    @Override
    public float HitungHarga(int hargaPerKg,float berat){
        float harga;
        harga = hargaPerKg * berat;
        return harga;
    }; 
}
