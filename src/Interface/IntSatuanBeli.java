/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.SatuanBeli;
import java.util.List;

/**
 *
 * @author mediatama
 */
public interface IntSatuanBeli {
    public void insert(SatuanBeli satuan);
    public void update(SatuanBeli satuan);
    public void delete(int keyWord);
    public List<SatuanBeli> get_all();
    public List<SatuanBeli> get_by_keyword(String keyWord);
    public boolean cek_nama_satuan(String keyWord);
}
