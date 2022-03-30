package com.solvd.realestate.model;


import com.solvd.realestate.service.implemented.AptServiceImplemented;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAptView {
    public void aptMenu(){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int option, id;

        AptServiceImplemented aptServiceImplemented = new AptServiceImplemented();

        while (!salir) {

            System.out.println("1. Create Apartment");
            System.out.println("2. Read Apartment");
            System.out.println("3. Filter Apartment by Id");
            System.out.println("4. Update Apartment by Id");
            System.out.println("5. Delete Apartment by Id");
            System.out.println("6. Back to Main Menu");

            try {

                System.out.println("Select Option: \n");
                option = sn.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Create Apartment: \n");
                        aptServiceImplemented.createApt();
                        break;
                    case 2:
                        System.out.println("Read Apartments: \n");
                        aptServiceImplemented.readApt();
                        break;
                    case 3:
                        System.out.println("Filter Apartment by Id: \n");
                        System.out.println("Enter Id: ");
                        id = sn.nextInt();
                        aptServiceImplemented.filterAptById(id);
                        break;
                    case 4:
                        System.out.println("Update Apartment by Id: \n");
                        System.out.println("Enter Id: ");
                        id = sn.nextInt();
                        aptServiceImplemented.updateApt(id);
                        break;
                    case 5:
                        System.out.println("Delete Apartment by Id: \n");
                        System.out.println("Enter Id: ");
                        id = sn.nextInt();
                        aptServiceImplemented.deleteApt(id);
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
