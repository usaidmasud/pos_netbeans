/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Pegawai;
import java.util.List;

/**
 *
 * @author usaid
 */
public interface IntPegawai {
    public void insert(Pegawai obj);
    public void update(Pegawai obj);
    public void delete(String keyWord);
    public List<Pegawai> get_all();
    public List<Pegawai> get_by_keyword(String keyWord);
    public String get_kode(String keyWord);
    public String get_nama(String keyWord);
}
