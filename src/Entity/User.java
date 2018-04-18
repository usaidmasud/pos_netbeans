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
public class User {
    private String kode_user;
    private String username;
    private String password;
    private int kode_pegawai;
    private int kode_group;
    private String tgl_create;
    private String tgl_update;

    public String getKode_user() {
        return kode_user;
    }

    public void setKode_user(String kode_user) {
        this.kode_user = kode_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getKode_pegawai() {
        return kode_pegawai;
    }

    public void setKode_pegawai(int kode_pegawai) {
        this.kode_pegawai = kode_pegawai;
    }

    public int getKode_group() {
        return kode_group;
    }

    public void setKode_group(int kode_group) {
        this.kode_group = kode_group;
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
