package POJO;

import java.sql.Date;

/**
 *
 * @author Xenon
 */
public class Produk {
    private int id, idKategori, idSupplier, karat, hargaBeli;
    private String nama, deskripsi, status, tipeBarang;
    private double berat;
    private Date tanggalBeli;

    public Produk(int id, int idKategori, int idSupplier, int karat, int hargaBeli, String nama, String deskripsi, String status, String tipeBarang, double berat, Date tanggalBeli) {
        this.id = id;
        this.idKategori = idKategori;
        this.idSupplier = idSupplier;
        this.karat = karat;
        this.hargaBeli = hargaBeli;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.status = status;
        this.tipeBarang = tipeBarang;
        this.berat = berat;
        this.tanggalBeli = tanggalBeli;
    }

    public Produk(){
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(int idKategori) {
        this.idKategori = idKategori;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public int getKarat() {
        return karat;
    }

    public void setKarat(int karat) {
        this.karat = karat;
    }

    public int getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(int hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipeBarang() {
        return tipeBarang;
    }

    public void setTipeBarang(String tipeBarang) {
        this.tipeBarang = tipeBarang;
    }

    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public Date getTanggalBeli() {
        return tanggalBeli;
    }

    public void setTanggalBeli(Date tanggalBeli) {
        this.tanggalBeli = tanggalBeli;
    }
    
    
}
