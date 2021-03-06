package com.solvd.realestate.model;


import com.solvd.realestate.exception.BadAddressException;
import com.solvd.realestate.service.implemented.AptServiceImplemented;

import java.sql.SQLException;
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
            System.out.println("3. Read Apartment(from DB)");
            System.out.println("4. Filter Apartment by Id");
            System.out.println("5. Update Apartment by Id");
            System.out.println("6. Delete Apartment by Id");
            System.out.println("7. Back to Main Menu");

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
                        System.out.println("Read Apartment(from DB): \n");
                        System.out.println("CONSULT DB HERE");
                        aptServiceImplemented.readFromDB();
                        break;
                    case 4:
                        System.out.println("Filter Apartment by Id: \n");
                        System.out.println("Enter Id: ");
                        id = sn.nextInt();
                        aptServiceImplemented.filterAptById(id);
                        break;

                    case 5:
                        System.out.println("Update Apartment by Id: \n");
                        System.out.println("Enter Id: ");
                        id = sn.nextInt();
                        aptServiceImplemented.updateApt(id);
                        break;
                    case 6:
                        System.out.println("Delete Apartment by Id: \n");
                        System.out.println("Enter Id: ");
                        id = sn.nextInt();
                        aptServiceImplemented.deleteApt(id);
                        break;
                    case 7:
                        salir = true;
                        break;
                    default:
                        System.out.println("Only numbers between 1 and 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Must enter a number");
                sn.next();
            } catch (BadAddressException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
