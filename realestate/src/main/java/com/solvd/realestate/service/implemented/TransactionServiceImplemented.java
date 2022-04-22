package com.solvd.realestate.service.implemented;

import com.solvd.realestate.entity.apt.AptEntity;
import com.solvd.realestate.entity.transaction.Transaction;
import com.solvd.realestate.entity.transaction.rent.RentEntity;
import com.solvd.realestate.entity.transaction.sell.SellEntity;
import com.solvd.realestate.exception.CustomerNullExcepcion;
import com.solvd.realestate.exception.EmployeeNullException;
import com.solvd.realestate.service.ITransactionService;
import com.solvd.realestate.utils.Customers;
import com.solvd.realestate.utils.Employees;
import com.solvd.realestate.utils.Stock;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TransactionServiceImplemented implements ITransactionService {

    public static final Logger LOGGER = LogManager.getLogger(CustomerNullExcepcion.class);

    Transaction<RentEntity> rentTransaction = new Transaction<>();
    Transaction<SellEntity> sellTransaction = new Transaction<>();
    RentEntity rent;
    SellEntity sell;

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

            try {
                rentTransaction.add(createRentTransaction());
            }catch(CustomerNullExcepcion e){
                LOGGER.info("No such costumer id");
            }catch(EmployeeNullException e){
                LOGGER.info("No such employee id");
            }catch(IndexOutOfBoundsException e){
                LOGGER.info("No such Id");
            }
     }else{
            try{
                sellTransaction.add(createSellTransaction());
            }catch(CustomerNullExcepcion e){
                LOGGER.info("No such costumer id");
            }catch(EmployeeNullException e){
                LOGGER.info("No such employee id");
            }catch(IndexOutOfBoundsException e){
                LOGGER.info("No such Id");
            }
        }

    }


    @Override
    public void readRentTransactions() {
        rentTransaction.forEach(System.out::println);

    }

    @Override
    public void findAptByAmount() {

        double amount;
        ArrayList<AptEntity> suitableApt = new ArrayList<>(Stock.apartments.values());

        System.out.println("Enter available amount: ");
        amount = sc.nextDouble();

        suitableApt.stream().filter(e-> e.getCost() <= amount).forEach(System.out::println);

    }

    public RentEntity createRentTransaction() throws CustomerNullExcepcion, EmployeeNullException {
       // RentEntity rent = new RentEntity();
        System.out.println("Enter extension of the contract in months: ");
        contractExtension = sc.nextInt();

        System.out.println("Enter customer (id): ");
        customerId = sc.nextInt();

        System.out.println("Enter employee (id) : ");
        employeeId = sc.nextInt();

        System.out.println("Enter apartment (id) : ");
        aptId = sc.nextInt();

        rent = new RentEntity();

        rent.setContractRentExtension(contractExtension);
        rent.setContractRentDate(LocalDateTime.now());

        if (Employees.employees.get(employeeId) != null)
            rent.setContractRentEmployee(Employees.employees.get(employeeId));
        else throw new EmployeeNullException("No such employee id");

        if (Customers.customers.get(customerId) != null)
            rent.setContractRentCustomer(Customers.customers.get(customerId));
        else throw new CustomerNullExcepcion("No such customer id");
        rent.setContractRentApt(Stock.apartments.get(aptId));

        return rent;
    }

    private SellEntity createSellTransaction() throws CustomerNullExcepcion, EmployeeNullException{

        double amount;

        System.out.println("Enter customer (id): ");
        customerId = sc.nextInt();

        System.out.println("Enter employee (id) : ");
        employeeId = sc.nextInt();

        System.out.println("Enter apartment (id) : ");
        aptId = sc.nextInt();

        System.out.println("Enter amount in the contract:  : ");
        amount = sc.nextDouble();

        sell.setContractSellEmployee(Employees.employees.get(employeeId));
        sell.setContractSellCustomer(Customers.customers.get(customerId));
        sell.setContractSellDate(LocalDateTime.now());
        sell.setContractAmount(amount);

        return sell;
    }
}
