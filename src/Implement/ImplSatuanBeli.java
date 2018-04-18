/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Database.ConnectDB;
import Entity.SatuanBeli;
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
public class ImplSatuanBeli implements Interface.IntSatuanBeli{
    
    Connection connection;
    final String insert = "INSERT INTO tb_satuan_beli (nama_satuan_beli) VALUES (?);";
    final String update = "UPDATE tb_satuan_beli set nama_satuan_beli = ? where kode_satuan_beli = ? ;";
    final String delete = "DELETE FROM tb_satuan_beli where kode_satuan_beli = ? ;";
    final String select = "SELECT * FROM tb_satuan_beli;";
    final String carinama = "SELECT * FROM tb_satuan_beli where nama_satuan_beli like ?";
    
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    List<SatuanBeli> mlist;
    
    public ImplSatuanBeli() {
        connection = ConnectDB.connection();
    }
    
    
    @Override
    public void insert(SatuanBeli satuan) {
        ps = null;
        try {
            ps = connection.prepareStatement(insert);
            ps.setString(1, satuan.getNama_satuan_beli().toUpperCase());
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
    public void update(SatuanBeli satuan) {
        ps = null;
        try {
            ps = connection.prepareStatement(update);
            ps.setString(1, satuan.getNama_satuan_beli().toUpperCase());
            ps.setInt(2, satuan.getKode_satuan_beli());
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
    public List<SatuanBeli> get_all() {
        mlist = null;
        try {
            mlist = new ArrayList<SatuanBeli>();
            st = connection.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                SatuanBeli obj = new SatuanBeli();
                obj.setKode_satuan_beli(rs.getInt("kode_satuan_beli"));
                obj.setNama_satuan_beli(rs.getString("nama_satuan_beli"));
                obj.setTgl_create(rs.getString("tgl_create"));
                obj.setTgl_update(rs.getString("tgl_update"));
                mlist.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplSatuanBeli.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mlist;
    }

    @Override
    public List<SatuanBeli> get_by_keyword(String keyWord) {
        mlist = null;
        try {
            mlist = new ArrayList<SatuanBeli>();
            ps = connection.prepareStatement(carinama);
            ps.setString(1, "%" + keyWord + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SatuanBeli obj = new SatuanBeli();
                obj.setKode_satuan_beli(rs.getInt("kode_satuan_beli"));
                obj.setNama_satuan_beli(rs.getString("nama_satuan_beli"));
                obj.setTgl_create(rs.getString("tgl_create"));
                obj.setTgl_update(rs.getString("tgl_update"));
                mlist.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplSatuanBeli.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mlist;
    }

    @Override
    public boolean cek_nama_satuan(String keyWord) {
        boolean cek = false;
        try {
            mlist = new ArrayList<SatuanBeli>();
            ps = connection.prepareStatement(carinama);
            ps.setString(1, keyWord);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cek = true;
            } else cek = false;
        } catch (SQLException ex) {
            Logger.getLogger(ImplSatuanBeli.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cek;
    }    
    
}
