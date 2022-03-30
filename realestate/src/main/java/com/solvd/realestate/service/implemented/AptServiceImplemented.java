package com.solvd.realestate.service.implemented;

import com.solvd.realestate.entity.apt.AptEntity;
import com.solvd.realestate.exception.BadAddressException;
import com.solvd.realestate.service.IAptService;
import com.solvd.realestate.utils.Operation;
import com.solvd.realestate.utils.Zones;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

import static com.solvd.realestate.utils.Stock.apartments;

public class AptServiceImplemented implements IAptService {

    AptEntity apt;
    
    Scanner sn = new Scanner(System.in);
    String address, zone, operation;
    int idZone, idOperation, dimension, rooms;
    double cost;

    @Override
    public void createApt() {

        String finish;
        boolean exit = false;

        while (!exit) {

            try{
                apartments.put(apartments.size(), loadApt());
            }catch(BadAddressException e){
                System.out.println("Address must have number. Try Again.");
            }


            //Stock.stock.add(loadApt());

            // clear buffer
            sn.nextLine();

            System.out.println("Finish? (y/n)");
            finish = sn.nextLine().toLowerCase();
            if (finish.equals("y"))
                exit = true;
        }
    }

    @Override
    public void readApt() {

        if (!apartments.isEmpty()) {
            Iterator<Entry<Integer, AptEntity>> it = apartments.entrySet().iterator();
            Entry<Integer, AptEntity> a;
            while (it.hasNext()) {
                a =  it.next();
                if (a.getValue().isActive()){
                    System.out.println(a.getKey() + " -> " + a.getValue());
                }
            }
        }else{
            System.out.println("There's no apartments yet");
        }
    }

    @Override
    public void updateApt(int id) {
        if (apartments.containsKey(id)){
            try{
                apartments.put(id, loadApt());
            }catch(BadAddressException e){
                System.out.println("Address must have number");
            }

            System.out.println("Apartment Updated \n");
        }else{
            System.out.println("Item does not exists");
        }

    }

    @Override
    public void deleteApt(int id) {
        //soft delete
        if (apartments.containsKey(id)){
            apartments.get(id).setActive(false);
            System.out.println("Apartment Deleted \n");
        }else{
            System.out.println("Item does not exists");
        }
    }

    @Override
    public void filterAptById(int id) {
        if (apartments.get(id) == null){
            System.out.println("There's no apartment with that id");
        }else{
            System.out.println(apartments.get(id));
        }

    }

    public AptEntity loadApt() throws BadAddressException {


        System.out.println("Enter Apartment's address:");
        address = sn.nextLine();

        if (!verifyAddress(address)){
            throw new BadAddressException("Address must have number.");
        }




        System.out.println("Select Apartment's zone: \n" +
                " 1 - Center \n 2 - Downtown \n 3 - Uptown \n" +
                " 4 - East Side \n 5 - West Side \n 6 - North Side \n 7 - South Side");
        idZone = sn.nextInt();
        while (idZone < 1 || idZone > 7){
            System.out.println("Only numbers. 1-7");
            System.out.println("Select Apartment's zone: \n" +
                    " 1 - Center \n 2 - Downtown \n 3 - Uptown \n" +
                    " 4 - East Side \n 5 - West Side \n 6 - North Side \n 7 - South Side");
            idZone = sn.nextInt();
        }

        switch (idZone){
            case 1 :
                zone = Zones.CENTER;
                break;
            case 2:
                zone = Zones.DOWNTOWN;
                break;
            case 3:
                zone = Zones.UPTOWN;
                break;
            case 4:
                zone = Zones.EASTSIDE;
                break;
            case 5:
                zone = Zones.WESTSIDE;
                break;
            case 6:
                zone = Zones.NORTHSIDE;
                break;
            case 7:
                zone = Zones.SOUTHSIDE;
                break;
            default:
                System.out.println("Only numbers. 1-7");
        }

        System.out.println("Select operation avalaible: \n" +
                " 1 - To Sell \n 2 - To Rent \n");
        idOperation = sn.nextInt();
        while (idOperation < 1 || idOperation > 2){
            System.out.println("Select operation avalaible: \n" +
                    " 1 - To Sell \n 2 - To Rent \n");
            idOperation = sn.nextInt();
            }

        switch (idOperation){
            case 1:
                operation = Operation.SELL;
                break;
            case 2:
                operation=Operation.RENT;
                break;
            default:
                System.out.println("Only numbers. 1-2");
        }

        System.out.println("Enter Apartment's cost:");
        cost = sn.nextDouble();

        System.out.println("Enter Apartment's dimension (square meters):");
        dimension = sn.nextInt();

        System.out.println("How many rooms does the Apartment have?:");
        rooms = sn.nextInt();

        apt = new AptEntity();

        apt.setAddress(address);
        apt.setZone(zone);
        apt.setOperation(operation);
        apt.setCost(cost);
        apt.setDimension(dimension);
        apt.setRooms(rooms);

        //TODO: set apt id with using hashmap
        //apt.setAptId(Stock.stock.size());

        return apt;
    }

    public boolean verifyAddress(String address){
        //TODO: verify address contains letters and numbers
        System.out.println(apartments.size());
        System.out.println(address);
        System.out.println(address.matches("[A-Za-z]\\w+\\s[0-99999]\\d+"));
        //return address.matches(address.matches("[A-Za-z]\\w+\\s[0-99999]\\d+"));
        return true;


    }
}
