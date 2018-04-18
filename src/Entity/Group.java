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
public class Group {
    private int kode_group;
    private String nama_group;
    private String tgl_create;
    private String tgl_update;

    public int getKode_group() {
        return kode_group;
    }

    public void setKode_group(int kode_group) {
        this.kode_group = kode_group;
    }

    public String getNama_group() {
        return nama_group;
    }

    public void setNama_group(String nama_group) {
        this.nama_group = nama_group;
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
