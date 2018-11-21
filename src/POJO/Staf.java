package POJO;

/**
 *
 * @author Xenon
 */
public class Staf {
    private int id, gaji, reward;
    private String nama, email, alamat, noTelp, posisi, dekripsiReward;

    public Staf(int id, int gaji, int reward, String nama, String email, String alamat, String noTelp, String posisi, String dekripsiReward) {
        this.id = id;
        this.gaji = gaji;
        this.reward = reward;
        this.nama = nama;
        this.email = email;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.posisi = posisi;
        this.dekripsiReward = dekripsiReward;
    }

    public Staf(int gaji, int reward, String nama, String email, String alamat, String noTelp, String posisi, String dekripsiReward) {
        this.gaji = gaji;
        this.reward = reward;
        this.nama = nama;
        this.email = email;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.posisi = posisi;
        this.dekripsiReward = dekripsiReward;
    }
    
    public Staf(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getDekripsiReward() {
        return dekripsiReward;
    }

    public void setDekripsiReward(String dekripsiReward) {
        this.dekripsiReward = dekripsiReward;
    }
    
    
}
