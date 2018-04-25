/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Database.ConnectDB;
import Entity.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usaid
 */
public class ImplGroup implements Interface.IntGroup{
    Connection connection;
    final String insert = "INSERT INTO tb_group (nama_group) VALUES (?);";
    final String update = "UPDATE tb_group set nama_group = ? where kode_group = ? ;";
    final String delete = "DELETE FROM tb_group where kode_group = ? ;";
    final String select = "SELECT * FROM tb_group;";
    final String carinama = "SELECT * FROM tb_group where nama_group like ?";
    final String query_get_kode = "SELECT kode_group FROM tb_group where nama_group = ?";
    final String query_get_nama = "SELECT nama_group FROM tb_group where kode_group = ?";
    
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    List<Group> mlist;
    
    public ImplGroup() {
        connection = ConnectDB.connection();
    }
    
    
    @Override
    public void insert(Group satuan) {
        ps = null;
        try {
            ps = connection.prepareStatement(insert);
            ps.setString(1, satuan.getNama_group().toUpperCase());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Group satuan) {
        ps = null;
        try {
            ps = connection.prepareStatement(update);
            ps.setString(1, satuan.getNama_group().toUpperCase());
            ps.setInt(2, satuan.getKode_group());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int keyWord) {
        ps = null;
        try {
            ps = connection.prepareStatement(delete);
            ps.setInt(1, keyWord);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Group> get_all() {
        mlist = null;
        try {
            mlist = new ArrayList<Group>();
            st = connection.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                Group obj = new Group();
                obj.setKode_group(rs.getInt("kode_group"));
                obj.setNama_group(rs.getString("nama_group"));
                obj.setTgl_create(rs.getString("tgl_create"));
                obj.setTgl_update(rs.getString("tgl_update"));
                mlist.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplSatuanJual.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mlist;
    }

    @Override
    public List<Group> get_by_keyword(String keyWord) {
        mlist = null;
        try {
            mlist = new ArrayList<Group>();
            ps = connection.prepareStatement(carinama);
            ps.setString(1, "%" + keyWord + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Group obj = new Group();
                obj.setKode_group(rs.getInt("kode_group"));
                obj.setNama_group(rs.getString("nama_group"));
                obj.setTgl_create(rs.getString("tgl_create"));
                obj.setTgl_update(rs.getString("tgl_update"));
                mlist.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplSatuanJual.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mlist;
    }

    @Override
    public boolean cek_nama_group(String keyWord) {
        boolean cek = false;
        try {
            mlist = new ArrayList<Group>();
            ps = connection.prepareStatement(carinama);
            ps.setString(1, keyWord);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cek = true;
            } else cek = false;
        } catch (SQLException ex) {
            Logger.getLogger(ImplSatuanJual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cek;
    }

    @Override
    public int get_kode(String keyWord) {
        int kode = 0;
        try {
            ps = connection.prepareStatement(query_get_kode);
            ps.setString(1, keyWord);
            rs = ps.executeQuery();
            if (rs.next()) {
                kode = rs.getInt("kode_group");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplPegawai.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kode;
    }

    @Override
    public String get_nama(int keyWord) {
        String kode = "";
        try {
            ps = connection.prepareStatement(query_get_nama);
            ps.setInt(1, keyWord);
            rs = ps.executeQuery();
            if (rs.next()) {
                kode = rs.getString("nama_group");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplPegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kode;
    }
    
    
}
