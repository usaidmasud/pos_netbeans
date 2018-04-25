/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Database.ConnectDB;
import Entity.Jabatan;
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
public class ImplJabatan implements Interface.IntJabatan{
    Connection connection;
    final String insert = "INSERT INTO tb_jabatan (nama_jabatan) VALUES (?);";
    final String update = "UPDATE tb_jabatan set nama_jabatan = ? where kode_jabatan = ? ;";
    final String delete = "DELETE FROM tb_jabatan where kode_jabatan = ? ;";
    final String select = "SELECT * FROM tb_jabatan;";
    final String carinama = "SELECT * FROM tb_jabatan where nama_jabatan like ?";
    
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    List<Jabatan> mlist;
    
    public ImplJabatan() {
        connection = ConnectDB.connection();
    }
    
    
    @Override
    public void insert(Jabatan satuan) {
        ps = null;
        try {
            ps = connection.prepareStatement(insert);
            ps.setString(1, satuan.getNama_jabatan().toUpperCase());
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
    public void update(Jabatan satuan) {
        ps = null;
        try {
            ps = connection.prepareStatement(update);
            ps.setString(1, satuan.getNama_jabatan().toUpperCase());
            ps.setInt(2, satuan.getKode_jabatan());
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
    public List<Jabatan> get_all() {
        mlist = null;
        try {
            mlist = new ArrayList<Jabatan>();
            st = connection.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                Jabatan obj = new Jabatan();
                obj.setKode_jabatan(rs.getInt("kode_jabatan"));
                obj.setNama_jabatan(rs.getString("nama_jabatan"));
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
    public List<Jabatan> get_by_keyword(String keyWord) {
        mlist = null;
        try {
            mlist = new ArrayList<Jabatan>();
            ps = connection.prepareStatement(carinama);
            ps.setString(1, "%" + keyWord + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Jabatan obj = new Jabatan();
                obj.setKode_jabatan(rs.getInt("kode_jabatan"));
                obj.setNama_jabatan(rs.getString("nama_jabatan"));
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
    public boolean cek_nama_jabatan(String keyWord) {
        boolean cek = false;
        try {
            mlist = new ArrayList<Jabatan>();
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
