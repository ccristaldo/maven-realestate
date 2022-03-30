package com.solvd.realestate.model;

import com.solvd.realestate.service.implemented.EmployeeServiceImplemented;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuEmployeeView {
    public void employeeMenu() {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int option, id, branch;

        EmployeeServiceImplemented employeeServiceImplemented = new EmployeeServiceImplemented();

        while (!salir) {

            System.out.println("1. Create Employee");
            System.out.println("2. Read Employees");
            System.out.println("3. Update Employee by Id");
            System.out.println("4. Delete Employee by Id");
            System.out.println("5. Filter Employee by Branch");
            System.out.println("6. Back to Main Menu");

            try {

                System.out.println("Select Option: \n");
                option = sn.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Create Employee: \n");
                        employeeServiceImplemented.createEmployee();
                        break;
                    case 2:
                        System.out.println("Read Employees: \n");
                        employeeServiceImplemented.readEmployees();
                        break;
                    case 3:
                        System.out.println("Update Employee by Id: \n");
                        System.out.println("Enter Id: ");
                        id = sn.nextInt();
                        employeeServiceImplemented.updateEmployeeById(id);
                        break;
                    case 4:
                        System.out.println("Delete Employee by Id: \n");
                        System.out.println("Enter Id: ");
                        id = sn.nextInt();
                        employeeServiceImplemented.deleteEmployeeById(id);
                        break;
                    case 5:
                        System.out.println("Filter Employee by Branch: \n");
                        System.out.println("Enter Branch: ");
                        branch = sn.nextInt();
                        employeeServiceImplemented.filterEmployeeByBranch(branch);
                        break;
                    case 6:
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
