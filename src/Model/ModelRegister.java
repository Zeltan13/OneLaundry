package Model;

public class ModelRegister {
    private String nama, alamat, username, password, jenisKelamin;

    public ModelRegister(String nama, String alamat, String username, String password, String jenisKelamin) {
        this.nama = nama;
        this.alamat = alamat;
        this.username = username;
        this.password = password;
        this.jenisKelamin = jenisKelamin;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
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

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    
}
