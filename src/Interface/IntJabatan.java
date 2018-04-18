/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Jabatan;
import java.util.List;

/**
 *
 * @author usaid
 */
public interface IntJabatan {
    public void insert(Jabatan obj);
    public void update(Jabatan obj);
    public void delete(int keyWord);
    public List<Jabatan> get_all();
    public List<Jabatan> get_by_keyword(String keyWord);
}
