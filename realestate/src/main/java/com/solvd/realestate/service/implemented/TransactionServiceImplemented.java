package com.solvd.realestate.service.implemented;

import com.solvd.realestate.entity.transaction.Transaction;
import com.solvd.realestate.entity.transaction.rent.RentEntity;
import com.solvd.realestate.entity.transaction.sell.SellEntity;
import com.solvd.realestate.service.ITransactionService;
import com.solvd.realestate.utils.Customers;
import com.solvd.realestate.utils.Employees;
import com.solvd.realestate.utils.Stock;

import java.time.LocalDateTime;
import java.util.Scanner;

public class TransactionServiceImplemented implements ITransactionService {

    Transaction<RentEntity> rentTransaction = new Transaction<>();
    Transaction<SellEntity> sellTransaction = new Transaction<>();
    RentEntity rent;

    Scanner sc = new Scanner(System.in);
    int option, contractExtension, customerId, employeeId, aptId;

    @Override
    public void createTransaction() {

        System.out.println("Enter type of Transaction: \n 1 - Rent \n 2 - Sell");
        option = sc.nextInt();
        while (option < 1 || option > 2){
            System.out.println("Invalid option. Try again.");
            option = sc.nextInt();
        }

        if (option == 1){


            RentEntity rent = new RentEntity();
            System.out.println("Enter extension of the contract in months: ");
            contractExtension = sc.nextInt();

            //TODO: insert custom exception here for empty customers list
            System.out.println("Enter customer (id): ");
            customerId = sc.nextInt();

            System.out.println("Enter employee (id) : ");
            employeeId = sc.nextInt();

            System.out.println("Enter apartment (id) : ");
            aptId = sc.nextInt();

            rent = new RentEntity();

            rent.setContractRentExtension(contractExtension);
            rent.setContractRentDate(LocalDateTime.now());
            rent.setContractRentEmployee(Employees.personnel.get(employeeId));
            rent.setContractRentCustomer(Customers.customers.get(customerId));
            rent.setContractRentApt(Stock.apartments.get(aptId));

            rentTransaction.add(rent);




        }

    }

    @Override
    public void readRentTransactions() {
        rentTransaction.forEach(System.out::println);
        /*
        if (!apartments.isEmpty()) {
            Iterator<Entry<Integer, AptEntity>> it = apartments.entrySet().iterator();
            Entry<Integer, AptEntity> a;
            while (it.hasNext()) {
                a =  it.next();
                System.out.println(a.getKey() + " -> " + a.getValue());
            }
        }else{
            System.out.println("There's no apartments yet");
        }
         */

    }
}
