/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author mediatama
 */
public class SatuanBeli {
    private int kode_satuan_beli;
    private String nama_satuan_beli;
    private String tgl_create;
    private String tgl_update;

    public int getKode_satuan_beli() {
        return kode_satuan_beli;
    }

    public void setKode_satuan_beli(int kode_satuan) {
        this.kode_satuan_beli = kode_satuan;
    }

    public String getNama_satuan_beli() {
        return nama_satuan_beli;
    }

    public void setNama_satuan_beli(String nama_satuan) {
        this.nama_satuan_beli = nama_satuan;
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
