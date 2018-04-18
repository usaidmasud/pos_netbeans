/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Database.ConnectDB;
import Entity.SatuanJual;
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
 * @author mediatama
 */
public class ImplSatuanJual implements Interface.IntSatuanJual{
    
    Connection connection;
    final String insert = "INSERT INTO tb_satuan_jual (nama_satuan_jual) VALUES (?);";
    final String update = "UPDATE tb_satuan_jual set nama_satuan_jual = ? where kode_satuan_jual = ? ;";
    final String delete = "DELETE FROM tb_satuan_jual where kode_satuan_jual = ? ;";
    final String select = "SELECT * FROM tb_satuan_jual;";
    final String carinama = "SELECT * FROM tb_satuan_jual where nama_satuan_jual like ?";
    
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    List<SatuanJual> mlist;
    
    public ImplSatuanJual() {
        connection = ConnectDB.connection();
    }
    
    
    @Override
    public void insert(SatuanJual satuan) {
        ps = null;
        try {
            ps = connection.prepareStatement(insert);
            ps.setString(1, satuan.getNama_satuan_jual().toUpperCase());
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
    public void update(SatuanJual satuan) {
        ps = null;
        try {
            ps = connection.prepareStatement(update);
            ps.setString(1, satuan.getNama_satuan_jual().toUpperCase());
            ps.setInt(2, satuan.getKode_satuan_jual());
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
    public List<SatuanJual> get_all() {
        mlist = null;
        try {
            mlist = new ArrayList<SatuanJual>();
            st = connection.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                SatuanJual obj = new SatuanJual();
                obj.setKode_satuan_jual(rs.getInt("kode_satuan_jual"));
                obj.setNama_satuan_jual(rs.getString("nama_satuan_jual"));
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
    public List<SatuanJual> get_by_keyword(String keyWord) {
        mlist = null;
        try {
            mlist = new ArrayList<SatuanJual>();
            ps = connection.prepareStatement(carinama);
            ps.setString(1, "%" + keyWord + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SatuanJual obj = new SatuanJual();
                obj.setKode_satuan_jual(rs.getInt("kode_satuan_jual"));
                obj.setNama_satuan_jual(rs.getString("nama_satuan_jual"));
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
    public boolean cek_nama_satuan(String keyWord) {
        boolean cek = false;
        try {
            mlist = new ArrayList<SatuanJual>();
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
    
}
