package com.solvd.realestate.model;

import com.solvd.realestate.service.implemented.CustomerServiceImplemented;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCustomerView {

     public void costumerMenu() {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int option, id;

        CustomerServiceImplemented customerServiceImplemented = new CustomerServiceImplemented();

        while (!salir) {

            System.out.println("1. Create Customer");
            System.out.println("2. Read Customers");
            System.out.println("3. Update Employee by Id");
            System.out.println("4. Delete Employee by Id");
            System.out.println("5. Back to Main Menu");

            try {

                System.out.println("Select Option: \n");
                option = sn.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Create Customer: \n");
                        customerServiceImplemented.createCustomer();
                        break;
                    case 2:
                        System.out.println("Read Employees: \n");
                        customerServiceImplemented.readCustomer();
                        break;
                    case 3:
                        System.out.println("Update Employee by Id: \n");
                        System.out.println("Enter Id: ");
                        id = sn.nextInt();
                        customerServiceImplemented.updateCustomer(id);
                        break;
                    case 4:
                        System.out.println("Delete Employee by Id: \n");
                        System.out.println("Enter Id: ");
                        id = sn.nextInt();

                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

}
