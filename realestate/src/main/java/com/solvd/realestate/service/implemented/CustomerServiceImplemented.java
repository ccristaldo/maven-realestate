package com.solvd.realestate.service.implemented;


import com.solvd.realestate.entity.customer.CustomerEntity;
import com.solvd.realestate.exception.NameNullException;
import com.solvd.realestate.service.ICustomerService;
import com.solvd.realestate.utils.Customers;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.naming.Name;
import java.util.Scanner;

public class CustomerServiceImplemented implements ICustomerService {

    //from bussiness perspective, there's no reason to delete customers

    public static final Logger LOGGER = LogManager.getLogger(NameNullException.class);

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

            try {
                Customers.customers.add(loadCustomer());
            }catch(NameNullException e){
                LOGGER.info("Name must not be empty");
            }
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
        try {
            Customers.customers.set(id, loadCustomer());
        }catch(NameNullException e){
            e.printStackTrace();
        }
        System.out.println("Customer Updated");

    }

    public CustomerEntity loadCustomer() throws NameNullException{


        System.out.println("Enter customer's first name:");
        firstName = sn.nextLine();

        if (firstName.isEmpty()) throw new NameNullException();

        System.out.println("Enter customer's last name:");
        lastName = sn.nextLine();

        if (lastName.isEmpty()) throw new NameNullException();

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
