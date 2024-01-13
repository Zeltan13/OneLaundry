package Model;

public class ModelItem  {
    private int idItem;
    private String item;
    private int hargaPerKg;
    public ModelItem(int idItem,String item, int hargaPerKg){
        setIdItem(idItem);
        setItem(item);
        setHargaPerKg(hargaPerKg);
    }
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getHargaPerKg() {
        return hargaPerKg;
    }

    public void setHargaPerKg(int hargaPerKg) {
        this.hargaPerKg = hargaPerKg;
    }

    
    
}
