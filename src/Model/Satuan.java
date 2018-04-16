/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author mediatama
 */
public class Satuan {
    private int kode_satuan;
    private String nama_satuan;
    private String tgl_create;
    private String tgl_update;

    public int getKode_satuan() {
        return kode_satuan;
    }

    public void setKode_satuan(int kode_satuan) {
        this.kode_satuan = kode_satuan;
    }

    public String getNama_satuan() {
        return nama_satuan;
    }

    public void setNama_satuan(String nama_satuan) {
        this.nama_satuan = nama_satuan;
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
