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
public class BarangDetail_multi extends Barang{
    private String barcode;
    private String nama_barang;
    private int kode_satuan_jual;
    private int isi;
    private int hpp;
    private String tgl_expired;
    private int harga_toko;
    private int harga_grosir;
    private String tgl_create;
    private String tgl_update;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public int getKode_satuan_jual() {
        return kode_satuan_jual;
    }

    public void setKode_satuan_jual(int kode_satuan_jual) {
        this.kode_satuan_jual = kode_satuan_jual;
    }

    public int getIsi() {
        return isi;
    }

    public void setIsi(int isi) {
        this.isi = isi;
    }

    public int getHpp() {
        return hpp;
    }

    public void setHpp(int hpp) {
        this.hpp = hpp;
    }

    public String getTgl_expired() {
        return tgl_expired;
    }

    public void setTgl_expired(String tgl_expired) {
        this.tgl_expired = tgl_expired;
    }

    public int getHarga_toko() {
        return harga_toko;
    }

    public void setHarga_toko(int harga_toko) {
        this.harga_toko = harga_toko;
    }

    public int getHarga_grosir() {
        return harga_grosir;
    }

    public void setHarga_grosir(int harga_grosir) {
        this.harga_grosir = harga_grosir;
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
    
    
}
