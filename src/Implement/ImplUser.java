/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Database.ConnectDB;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usaid
 */
public class ImplUser implements Interface.IntUser{
    Connection connection;
    final String query_insert = "INSERT INTO tb_user (kode_user, username, password,"
            + " kode_pegawai, kode_group) VALUES (?, ?, MD5(?), ?, ?);";
    final String update = "UPDATE tb_user " +
        "SET username = ?, " +
        "  password = ?, " +
        "  status = ?, " +
        "  kode_pegawai = ?, " +
        "  kode_group = ? " +
        "WHERE kode_user = ?;";
    final String delete = "DELETE FROM tb_user where kode_user = ? ;";
    final String select = "SELECT * FROM tb_user " +
        "inner join tb_group on tb_group.kode_group = tb_user.kode_group " +
        "inner join tb_pegawai on tb_pegawai.kode_pegawai = tb_user.kode_pegawai";
    final String carinama = "SELECT * FROM tb_user where username like ?";
    
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    List<User> mlist;
    
    public ImplUser() {
        connection = ConnectDB.connection();
    }
    
    
    @Override
    public void insert(User obj) {
        ps = null;
        try {
            ps = connection.prepareStatement(query_insert);
            ps.setString(1, obj.getKode_user());
            ps.setString(2, obj.getUsername().toLowerCase());
            ps.setString(3, obj.getPassword());
            ps.setString(4, obj.getKode_pegawai());
            ps.setInt(5, obj.getKode_group());
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
    public void update(User obj) {
        ps = null;
        try {
            ps = connection.prepareStatement(update);
            ps.setString(1, obj.getUsername().toLowerCase());
            ps.setString(2, obj.getPassword());
            ps.setInt(3, obj.getStatus());
            ps.setString(4, obj.getKode_pegawai());
            ps.setInt(5, obj.getKode_group());
            ps.setString(6, obj.getKode_user());
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
    public List<User> get_all() {
        mlist = null;
        try {
            mlist = new ArrayList<User>();
            st = connection.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                User obj = new User();
                obj.setKode_user(rs.getString("kode_user"));
                obj.setUsername(rs.getString("username"));
                obj.setStatus(rs.getInt("status"));
                obj.setKode_pegawai(rs.getString("kode_pegawai"));
                obj.setNama_group(rs.getString("tb_group.nama_group"));
                obj.setTgl_create(rs.getString("tgl_create"));
                obj.setTgl_update(rs.getString("tgl_update"));
                mlist.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mlist;
    }

    @Override
    public List<User> get_by_keyword(String keyWord) {
        mlist = null;
        try {
            mlist = new ArrayList<>();
            ps = connection.prepareStatement(carinama);
            ps.setString(1, "%" + keyWord + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                User obj = new User();
                obj.setKode_user(rs.getString("kode_user"));
                obj.setUsername(rs.getString("username"));
                obj.setStatus(rs.getInt("status"));
                obj.setKode_pegawai(rs.getString("kode_pegawai"));
                obj.setKode_group(rs.getInt("kode_group"));
                obj.setTgl_create(rs.getString("tgl_create"));
                obj.setTgl_update(rs.getString("tgl_update"));
                mlist.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mlist;
    }

    @Override
    public void aktif(int keyWord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String get_kode_user() {
        String kode_otomatis = "";
        // USR-042018-0001
        Date tglSekarang = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMyyyy");
        String stgl = sdf.format(tglSekarang);
        String skode = "USR-"+stgl+"-";
        
        String no = "";
        String nol = "";
        final String query = "SELECT kode_user "
                + "FROM tb_user WHERE "
                + "DATE(MID(kode_user,5,2)) = MONTH(CURDATE()) "
                + "AND DATE(MID(kode_user,7,4)) = YEAR(CURDATE()) "
                + "ORDER BY kode_user DESC LIMIT 0,1";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            if (rs.next()){
                no = rs.getString("kode_user").substring(11);
                String an = "" + (Integer.parseInt(no) + 1);
                switch (an.length()) {
                    case 1:
                        nol = "000";
                        break;
                    case 2:
                        nol = "00";
                        break;
                    case 3:
                        no = "0";
                        break;
                    case 4:
                        no = "";
                        break;
                    default:
                        break;
                }
                no = skode+nol+an;
            } else
            {
                no = skode+nol+"0001";    
            }
            st.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        kode_otomatis = no;
        return kode_otomatis;
    }
}
