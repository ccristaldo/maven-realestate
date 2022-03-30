package com.solvd.realestate.service.implemented;


import com.solvd.realestate.entity.customer.CustomerEntity;
import com.solvd.realestate.service.ICustomerService;
import com.solvd.realestate.utils.Customers;

import java.util.Scanner;

public class CustomerServiceImplemented implements ICustomerService {

    //from bussiness perspective, there's no reason to delete customers

    Scanner sn = new Scanner(System.in);
    String firstName, lastName;
    Long tel;
    Double avalaibleAmount;

    CustomerEntity customer;

    @Override
    public void createCustomer() {
        String finish;
        boolean exit = false;

        while (!exit) {

            Customers.customers.add(loadCustomer());

            // clear buffer
            sn.nextLine();

            System.out.println("Finish? (y/n)");
            finish = sn.nextLine().toLowerCase();
            if (finish.equals("y"))
                exit = true;

        }

    }

    @Override
    public void readCustomer() {
        if (!Customers.customers.isEmpty()){
            Customers.customers.forEach(System.out::println);
        }
    }

    @Override
    public void updateCustomer(int id) {

        Customers.customers.set(id, loadCustomer());
        System.out.println("Customer Updated");

    }

    public CustomerEntity loadCustomer(){

        System.out.println("Enter customer's first name:");
        firstName = sn.nextLine();

        System.out.println("Enter customer's last name:");
        lastName = sn.nextLine();

        System.out.println("Enter customer's avalaible amount:");
        avalaibleAmount = sn.nextDouble();

        System.out.println("Enter customer's telephone:");
        tel = sn.nextLong();

        customer = new CustomerEntity();

        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAvalaibleAmount(avalaibleAmount);
        customer.setTel(String.valueOf(tel));
        customer.setId(Customers.customers.size());

        return customer;
    }

}
