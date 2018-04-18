/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.SatuanJual;
import java.util.List;

/**
 *
 * @author mediatama
 */
public interface IntSatuanJual {
    public void insert(SatuanJual satuan);
    public void update(SatuanJual satuan);
    public void delete(int keyWord);
    public List<SatuanJual> get_all();
    public List<SatuanJual> get_by_keyword(String keyWord);
    public boolean cek_nama_satuan(String keyWord);
}
