/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Kategori;
import java.util.List;

/**
 *
 * @author usaid
 */
public interface IntKategori {
    public void insert(Kategori obj);
    public void update(Kategori obj);
    public void delete(int keyWord);
    public List<Kategori> get_all();
    public List<Kategori> get_by_keyword(String keyWord);
    public boolean cek_nama_kategori(String keyWord);
}
