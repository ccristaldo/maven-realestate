package com.solvd.realestate;


import com.solvd.realestate.connection.ConnectionPool;
import com.solvd.realestate.exception.BadAddressException;
import com.solvd.realestate.model.*;
import com.solvd.realestate.utils.Branches;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(BadAddressException.class.getName());
/*
    public static Connection getConnected(){
        Connection conn = null;
        try{
            conn = ConnectionPool.getInstance().getConnection();
            //connection successfully
            if (conn != null){
                LOGGER.log(Level.INFO, "Connected to DATABASE");
                ConnectionPool.getInstance().closeConnection(conn);
            }else{
                LOGGER.log(Level.ERROR, "Unable to connect DATABASE");
            }
        }catch (SQLException e){
            LOGGER.log(Level.FATAL, "Unable to execute");
        }
        return conn;
    }
*/
    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        MenuEmployeeView employeeView = new MenuEmployeeView();
        MenuAptView menuAptView = new MenuAptView();
        MenuCustomerView menuCustomerView = new MenuCustomerView();
        MenuBranchView menuBranchView = new MenuBranchView();
        MenuTransactionView menuTransactionView = new MenuTransactionView();

        Branches branches = new Branches();
        branches.addBranch();

        while (!salir) {

            System.out.println("1. Employees");
            System.out.println("2. Apartments");
            System.out.println("3. Customers");
            System.out.println("4. Branches");
            System.out.println("5. Transactions");
            System.out.println("6. Terminate Program");

            try {

                System.out.println("Select: ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Employees Management: ");
                        employeeView.employeeMenu();
                        break;
                    case 2:
                        System.out.println("Apartments Management");
                        menuAptView.aptMenu();
                        break;
                    case 3:
                        System.out.println("Customers Management");
                        menuCustomerView.costumerMenu();
                        break;
                    case 4:
                        System.out.println("Branches Management");
                        menuBranchView.branchMenu();
                        break;
                    case 5:
                        System.out.println("Transactions Management");
                        menuTransactionView.transactionMenu();
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Only numbers between 1 and 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong value. Only numbers.");
                sn.next();
            }
        }

    }
}
