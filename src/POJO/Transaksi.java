/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.sql.Date;

/**
 *
 * @author ysuta
 */
public class Transaksi {
    int idBarang;
    int idCustomer;
    int idPekerja;
    String metodePembayaran;
    int hargaJual;
    Date tanggalJual;

    public Transaksi(int idBarang, int idCustomer, int idPekerja, String metodePembayaran, int hargaJual, Date tanggalJual) {
        this.idBarang = idBarang;
        this.idCustomer = idCustomer;
        this.idPekerja = idPekerja;
        this.metodePembayaran = metodePembayaran;
        this.hargaJual = hargaJual;
        this.tanggalJual = tanggalJual;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdPekerja() {
        return idPekerja;
    }

    public void setIdPekerja(int idPekerja) {
        this.idPekerja = idPekerja;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public int getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(int hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Date getTanggalJual() {
        return tanggalJual;
    }

    public void setTanggalJual(Date tanggalJual) {
        this.tanggalJual = tanggalJual;
    }
    
}
