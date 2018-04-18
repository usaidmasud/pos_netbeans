/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.HakAkses;
import java.util.List;

/**
 *
 * @author usaid
 */
public interface IntHakAkses {
    public void insert(HakAkses obj);
    public void update(HakAkses obj);
    public void delete(int keyWord);
    public List<HakAkses> get_all();
    public List<HakAkses> get_by_keyword(String keyWord);
}
