package com.solvd.realestate.model;


import com.solvd.realestate.service.implemented.BranchServiceImplemented;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuBranchView {

    public void branchMenu(){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int option, id;

        BranchServiceImplemented branchServiceImplemented = new BranchServiceImplemented();

        while (!salir) {

            System.out.println("1. Create Branch");
            System.out.println("2. Read Branch by Id");
            System.out.println("3. Read all Branches");
            System.out.println("4. Delete Apartment by Id");
            System.out.println("5. Back to Main Menu");

            try {

                System.out.println("Select Option: \n");
                option = sn.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Create Branch: \n");
                        branchServiceImplemented.createBranch();
                        break;
                    case 2:
                        System.out.println("Read Branch by Id: \n");
                        System.out.println("Enter Id: ");
                        id = sn.nextInt();
                        branchServiceImplemented.readBranch(id);
                        break;
                    case 3:
                        System.out.println("Read All Branches: \n");
                       // System.out.println("Enter Id: ");
                        //id = sn.nextInt();
                        //aptServiceImplemented.updateApt(id);
                        branchServiceImplemented.readAllBranch();
                        break;
                    case 4:
                        System.out.println("Delete Apartment by Id: \n");
                        System.out.println("Enter Id: ");
                        id = sn.nextInt();
                        //aptServiceImplemented.deleteApt(id);
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
