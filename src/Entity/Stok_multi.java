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
public class Stok_multi extends Barang{
    private String kode_stok;
    private String kode_barang;
    private int stok;
    private String stok_terbilang;
    private String tgl_create;
    private String tgl_update;

    public String getKode_stok() {
        return kode_stok;
    }

    public void setKode_stok(String kode_stok) {
        this.kode_stok = kode_stok;
    }

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getStok_terbilang() {
        return stok_terbilang;
    }

    public void setStok_terbilang(String stok_terbilang) {
        this.stok_terbilang = stok_terbilang;
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
