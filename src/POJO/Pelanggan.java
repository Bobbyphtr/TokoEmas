/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author ysuta
 */
public class Pelanggan {
    private int id;
    private String nama;
    private String email;
    private String alamat;
    private String no_telp;
    private boolean status_loyal;
    private int bonus;
    private String deskripsi_bonus;

    public Pelanggan(int id, String nama, String email, String alamat, String no_telp, boolean status_loyal, int bonus, String deskripsi_bonus) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.alamat = alamat;
        this.no_telp = no_telp;
        this.status_loyal = status_loyal;
        this.bonus = bonus;
        this.deskripsi_bonus = deskripsi_bonus;
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

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public boolean isStatus_loyal() {
        return status_loyal;
    }

    public void setStatus_loyal(boolean status_loyal) {
        this.status_loyal = status_loyal;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getDeskripsi_bonus() {
        return deskripsi_bonus;
    }

    public void setDeskripsi_bonus(String deskripsi_bonus) {
        this.deskripsi_bonus = deskripsi_bonus;
    }
    
    
}
