package com.solvd.realestate.service.implemented;


import com.solvd.realestate.entity.person.PersonGenerics;
import com.solvd.realestate.entity.person.employee.EmployeeEnt;
import com.solvd.realestate.exception.NameNullException;
import com.solvd.realestate.service.IEmployeeService;
import com.solvd.realestate.utils.Branches;
import com.solvd.realestate.utils.Employees;

import java.util.Scanner;



public class EmployeeServiceImplemented implements IEmployeeService {

    //Transaction<RentEntity> rentTransaction = new Transaction<>();
    PersonGenerics<EmployeeEnt> employees = new PersonGenerics<>();

    Scanner sn = new Scanner(System.in);
    String firstName, lastName;
    int idBranch ;

    EmployeeEnt employee;

    @Override
    public void createEmployee() {

        String finish;
        boolean exit = false;

        while (!exit) {

            try{
                employees.add(loadEmployee());
                //Employees.employees.add(loadEmployee());
            }catch (NameNullException e){
                System.out.println("Name must not be empty");
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
    public void readEmployees() {
        //TODO: CONTINUE FROM HERE!

        System.out.println(employees.isEmpty());
        employees.forEach(System.out::println);
        /*
        if (!employees.isEmpty()) {

            for (EmployeeEnt employee : Employees.employees){
                if (employee.isActive()){
                    System.out.println(employee);
                }
            }
        }else{
            System.out.println("There's no employees yet");
        }

         */
    }

    @Override
    public void updateEmployeeById(int id) {
        try{
            Employees.employees.set(id, loadEmployee());
        }catch (NameNullException e){
            e.printStackTrace();
        }

        System.out.println("Employee Updated");

    }

    @Override
    public void deleteEmployeeById(int id) {
        //Soft Delete
        Employees.employees.get(id).setActive(false);
        System.out.println("Employee removed \n");
    }

    @Override
    public void filterEmployeeByBranch(int id) {
        try {
            System.out.println(Branches.branches.get(id).getEmployees());
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Branch does not exists");
        }
    }

    public EmployeeEnt loadEmployee() throws NameNullException {

        System.out.println("Enter employee's first name:");
        firstName = sn.nextLine();
        if (firstName.isEmpty()){
            throw new NameNullException("Name must not be empty");
        }

        System.out.println("Enter employee's last name:");
        lastName = sn.nextLine();

        System.out.println("Select Branch:");
        Branches.branches.forEach(branchEntity -> System.out.println(branchEntity.getId() + " -> " + branchEntity.getDescription()));
        idBranch = sn.nextInt();

        employee = new EmployeeEnt();

        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmployeeId(Employees.employees.size());
        employee.setBranch(Branches.branches.get(idBranch).getDescription());

        //Branches.branches.get(idBranch).getEmployees().add(employee);

        return employee;
    }
}
