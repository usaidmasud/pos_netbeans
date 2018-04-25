/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Group;
import java.util.List;

/**
 *
 * @author usaid
 */
public interface IntGroup {
    public void insert(Group obj);
    public void update(Group obj);
    public void delete(int keyWord);
    public List<Group> get_all();
    public List<Group> get_by_keyword(String keyWord);
    public boolean cek_nama_group(String keyWord);
    public int get_kode(String keyWord);
    public String get_nama(int keyWord);
}
