/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Customer;
import java.util.List;

/**
 *
 * @author usaid
 */
public interface IntCustomer {
    public void insert(Customer cust);
    public void update(Customer cust);
    public void delete(String keyWord);
    public List<Customer> get_all();
    public List<Customer> get_by_keyword(String keyWord);
}
