/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author njang
 */
public class Stok {
    private int kode_stok;
    private String kode_barang;
    private int stok;
    private String tgl_create;
    private String tgl_update;

    /**
     * @return the kode_stok
     */
    public int getKode_stok() {
        return kode_stok;
    }

    /**
     * @param kode_stok the kode_stok to set
     */
    public void setKode_stok(int kode_stok) {
        this.kode_stok = kode_stok;
    }

    /**
     * @return the kode_barang
     */
    public String getKode_barang() {
        return kode_barang;
    }

    /**
     * @param kode_barang the kode_barang to set
     */
    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    /**
     * @return the stok
     */
    public int getStok() {
        return stok;
    }

    /**
     * @param stok the stok to set
     */
    public void setStok(int stok) {
        this.stok = stok;
    }

    /**
     * @return the tgl_create
     */
    public String getTgl_create() {
        return tgl_create;
    }

    /**
     * @param tgl_create the tgl_create to set
     */
    public void setTgl_create(String tgl_create) {
        this.tgl_create = tgl_create;
    }

    /**
     * @return the tgl_update
     */
    public String getTgl_update() {
        return tgl_update;
    }

    /**
     * @param tgl_update the tgl_update to set
     */
    public void setTgl_update(String tgl_update) {
        this.tgl_update = tgl_update;
    }
    
    
}
