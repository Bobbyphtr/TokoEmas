package POJO;

/**
 *
 * @author Xenon
 */
public class SupplierData {
    private int id;
    private String nama, alamat, notelp;
    
    public SupplierData(){
        
    }
    
    public SupplierData(String nama, String alamat, String notelp) {
        this.nama = nama;
        this.alamat = alamat;
        this.notelp = notelp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }
    
    
}
