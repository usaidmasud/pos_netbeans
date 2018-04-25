/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.User;
import java.util.List;

/**
 *
 * @author usaid
 */
public interface IntUser {
    public void insert(User obj);
    public void update(User obj);
    public void delete(String keyWord);
    public void aktif(int keyWord);
    public List<User> get_all();
    public List<User> get_by_keyword(String keyWord);
    public String get_kode_user();
}
