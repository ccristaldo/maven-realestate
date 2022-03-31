package com.solvd.realestate.service;

import com.solvd.realestate.exception.NameNullException;

public interface ICustomerService {

    void createCustomer() throws NameNullException;
    void readCustomer();
    void updateCustomer(int id);
}
