package com.customer.service;

import com.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer saveCustomer(Customer customer);

    Customer getCustomerById(int id);
    Customer updateCustomer(Customer customer);

    void deleteCustomerById(int id);
}
