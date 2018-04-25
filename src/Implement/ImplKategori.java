/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Database.ConnectDB;
import Entity.Kategori;
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
public class ImplKategori implements Interface.IntKategori{
    
    Connection connection;
    final String insert = "INSERT INTO tb_kategori (nama_kategori) VALUES (?);";
    final String update = "UPDATE tb_kategori set nama_kategori = ? where kode_kategori = ? ;";
    final String delete = "DELETE FROM tb_kategori where kode_kategori = ? ;";
    final String select = "SELECT * FROM tb_kategori;";
    final String carinama = "SELECT * FROM tb_kategori where nama_kategori like ?";
    
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    List<Kategori> mlist;
    
    public ImplKategori() {
        connection = ConnectDB.connection();
    }
    
    
    @Override
    public void insert(Kategori satuan) {
        ps = null;
        try {
            ps = connection.prepareStatement(insert);
            ps.setString(1, satuan.getNama_kategori().toUpperCase());
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
    public void update(Kategori satuan) {
        ps = null;
        try {
            ps = connection.prepareStatement(update);
            ps.setString(1, satuan.getNama_kategori().toUpperCase());
            ps.setInt(2, satuan.getKode_kategori());
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
    public List<Kategori> get_all() {
        mlist = null;
        try {
            mlist = new ArrayList<Kategori>();
            st = connection.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                Kategori obj = new Kategori();
                obj.setKode_kategori(rs.getInt("kode_kategori"));
                obj.setNama_kategori(rs.getString("nama_kategori"));
                obj.setTgl_create(rs.getString("tgl_create"));
                obj.setTgl_update(rs.getString("tgl_update"));
                mlist.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplKategori.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mlist;
    }

    @Override
    public List<Kategori> get_by_keyword(String keyWord) {
        mlist = null;
        try {
            mlist = new ArrayList<Kategori>();
            ps = connection.prepareStatement(carinama);
            ps.setString(1, "%" + keyWord + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Kategori obj = new Kategori();
                obj.setKode_kategori(rs.getInt("kode_kategori"));
                obj.setNama_kategori(rs.getString("nama_kategori"));
                obj.setTgl_create(rs.getString("tgl_create"));
                obj.setTgl_update(rs.getString("tgl_update"));
                mlist.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplKategori.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mlist;
    }

    @Override
    public boolean cek_nama_kategori(String keyWord) {
        boolean cek = false;
        try {
            mlist = new ArrayList<Kategori>();
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
