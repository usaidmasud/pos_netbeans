/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author usaid
 */
public class Barang {
    private String kode_barang;
    private String nama_barang;
    private int kode_kategori;
    private int kode_satuan;
    private int harga_beli;
    private int harga_jual;
    private int stok_minimal;
    private int tgl_beli;
    private String tgl_create;
    private String tgl_update;
    private String hpp;

    
    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public int getKode_kategori() {
        return kode_kategori;
    }

    public void setKode_kategori(int kode_kategori) {
        this.kode_kategori = kode_kategori;
    }

    public int getKode_satuan() {
        return kode_satuan;
    }

    public void setKode_satuan(int kode_satuan) {
        this.kode_satuan = kode_satuan;
    }

    public int getStok_minimal() {
        return stok_minimal;
    }

    public void setStok_minimal(int stok_minimal) {
        this.stok_minimal = stok_minimal;
    }

    public int getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(int harga_beli) {
        this.harga_beli = harga_beli;
    }

    public String getTgl_create() {
        return tgl_create;
    }

    public void setTgl_create(String tgl_create) {
        this.tgl_create = tgl_create;
    }

    public String getTgl_update() {
        return tgl_update;
    }

    public void setTgl_update(String tgl_update) {
        this.tgl_update = tgl_update;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public int getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(int harga_jual) {
        this.harga_jual = harga_jual;
    }

    public int getTgl_beli() {
        return tgl_beli;
    }

    public void setTgl_beli(int tgl_beli) {
        this.tgl_beli = tgl_beli;
    }

    public String getHpp() {
        return hpp;
    }

    public void setHpp(String hpp) {
        this.hpp = hpp;
    }
}
