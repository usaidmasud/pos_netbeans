/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Database.ConnectDB;
import Entity.Pegawai;
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
public class ImplPegawai implements Interface.IntPegawai{
    
    Connection connection;
    final String insert = "INSERT INTO rc_pos.tb_pegawai (kode_pegawai, nama_pegawai, "
            + "gender, alamat, no_telpon, email, avatar, kode_jabatan) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    final String update = "UPDATE tb_pegawai " +
            "SET kode_pegawai = ?, " +
            "  nama_pegawai = ?, " +
            "  gender = ?, " +
            "  alamat = ?, " +
            "  no_telpon = ?, " +
            "  email = ?, " +
            "  avatar = ?, " +
            "  kode_jabatan = ? " +
            "WHERE kode_pegawai = kode_pegawai;";
    final String delete = "DELETE FROM tb_pegawai where kode_pegawai = ? ;";
    final String select = "SELECT * FROM tb_pegawai;";
    final String carinama = "SELECT * FROM tb_pegawai where nama_pegawai like ?";
    final String query_get_kode = "SELECT kode_pegawai FROM tb_pegawai where nama_pegawai = ?";
    final String query_get_nama = "SELECT nama_pegawai FROM tb_pegawai where kode_pegawai = ?";
    
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    List<Pegawai> mlist;
    
    public ImplPegawai() {
        connection = ConnectDB.connection();
    }
    
    
    @Override
    public void insert(Pegawai obj) {
        ps = null;
        try {
            ps = connection.prepareStatement(insert);
            ps.setString(1, obj.getKode_pegawai());
            ps.setString(2, obj.getNama_pegawai().toUpperCase());
            ps.setString(3, obj.getGender());
            ps.setString(4, obj.getAlamat());
            ps.setString(5, obj.getNo_telpon());
            ps.setString(6, obj.getEmail());
            ps.setString(7, obj.getAvatar());
            ps.setInt(8, obj.getKode_jabatan());
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
    public void update(Pegawai obj) {
        ps = null;
        try {
            ps = connection.prepareStatement(update);
            ps.setString(1, obj.getNama_pegawai().toUpperCase());
            ps.setString(2, obj.getGender());
            ps.setString(3, obj.getAlamat());
            ps.setString(4, obj.getNo_telpon());
            ps.setString(5, obj.getEmail());
            ps.setString(6, obj.getAvatar());
            ps.setInt(7, obj.getKode_jabatan());
            ps.setString(8, obj.getKode_pegawai());
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
    public void delete(String keyWord) {
        ps = null;
        try {
            ps = connection.prepareStatement(delete);
            ps.setString(1, keyWord);
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
    public List<Pegawai> get_all() {
        mlist = null;
        try {
            mlist = new ArrayList<Pegawai>();
            st = connection.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                Pegawai obj = new Pegawai();
                obj.setKode_pegawai(rs.getString("kode_pegawai"));
                obj.setNama_pegawai(rs.getString("nama_pegawai"));
                obj.setGender(rs.getString("gender"));
                obj.setAlamat(rs.getString("alamat"));
                obj.setNo_telpon(rs.getString("no_telpon"));
                obj.setEmail(rs.getString("email"));
                obj.setAvatar(rs.getString("avatar"));
                obj.setKode_jabatan(rs.getInt("kode_jabatan"));
                obj.setTgl_create(rs.getString("tgl_create"));
                obj.setTgl_update(rs.getString("tgl_update"));
                mlist.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplPegawai.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mlist;
    }

    @Override
    public List<Pegawai> get_by_keyword(String keyWord) {
        mlist = null;
        try {
            mlist = new ArrayList<>();
            ps = connection.prepareStatement(carinama);
            ps.setString(1, "%" + keyWord + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Pegawai obj = new Pegawai();
                obj.setKode_pegawai(rs.getString("kode_pegawai"));
                obj.setNama_pegawai(rs.getString("nama_pegawai"));
                obj.setGender(rs.getString("gender"));
                obj.setAlamat(rs.getString("alamat"));
                obj.setNo_telpon(rs.getString("no_telpon"));
                obj.setEmail(rs.getString("email"));
                obj.setAvatar(rs.getString("avatar"));
                obj.setKode_jabatan(rs.getInt("kode_jabatan"));
                obj.setTgl_create(rs.getString("tgl_create"));
                obj.setTgl_update(rs.getString("tgl_update"));
                mlist.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplPegawai.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mlist;
    }

    @Override
    public String get_kode(String keyWord) {
        String kode = "";
        try {
            ps = connection.prepareStatement(query_get_kode);
            ps.setString(1, keyWord);
            rs = ps.executeQuery();
            if (rs.next()) {
                kode = rs.getString("kode_pegawai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplPegawai.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kode;
    }

    @Override
    public String get_nama(String keyWord) {
        String kode = "";
        try {
            ps = connection.prepareStatement(query_get_nama);
            ps.setString(1, keyWord);
            rs = ps.executeQuery();
            if (rs.next()) {
                kode = rs.getString("nama_pegawai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplPegawai.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kode;
    }
}
