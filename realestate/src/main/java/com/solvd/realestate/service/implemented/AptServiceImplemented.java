package com.solvd.realestate.service.implemented;

import com.solvd.realestate.connection.ConnectionPool;
import com.solvd.realestate.entity.apt.AptEntity;
import com.solvd.realestate.enums.Operation;
import com.solvd.realestate.enums.Zones;
import com.solvd.realestate.exception.BadAddressException;
import com.solvd.realestate.service.IAptService;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

import static com.solvd.realestate.utils.Stock.apartments;

public class AptServiceImplemented implements IAptService {

    public static Connection getConnected(){
        Connection conn = null;
        conn = ConnectionPool.getInstance().getConnection();
        //connection successfully
        if (conn != null){
            LOGGER.log(Level.INFO, "Connected to DATABASE");

        }else{
            LOGGER.log(Level.ERROR, "Unable to connect DATABASE");
        }
        return conn;
    }


    public static final Logger LOGGER = LogManager.getLogger(BadAddressException.class.getName());

    AptEntity apt;
    
    Scanner sn = new Scanner(System.in);
    String address;
    Operation operation;
    Zones zone;
    int idZone, idOperation, dimension, rooms;
    double cost;

    @Override
    public void createApt() throws BadAddressException {

        String finish;
        boolean exit = false;

        while (!exit) {

            apartments.put(apartments.size(), loadApt());


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
            LOGGER.log(Level.WARN,"There's no apartments yet");
            //System.out.println("There's no apartments yet");
        }
    }

    @Override
    public void updateApt(int id) {
        if (apartments.containsKey(id)){

            try{
                apartments.put(id, loadApt());
            }catch(BadAddressException e){
                LOGGER.log(Level.WARN, "Address must have number");
            }

            LOGGER.log(Level.INFO,"Apartment Updated \n");
        }else{
            LOGGER.log(Level.WARN,"Item does not exists");
        }

    }

    @Override
    public void deleteApt(int id) {
        //soft delete
        if (apartments.containsKey(id)){
            apartments.get(id).setActive(false);
            LOGGER.log(Level.INFO,"Apartment Deleted \n");
        }else{
            LOGGER.log(Level.WARN,"Item does not exists");
        }
    }

    @Override
    public void filterAptById(int id) {
        if (apartments.get(id) == null){
            LOGGER.log(Level.WARN,"There's no apartment with that id");
        }else{
            System.out.println(apartments.get(id));
        }

    }

    @Override
    public void readFromDB() throws SQLException {
        String addres;
        Connection conn = getConnected();
        if (conn == null){
            LOGGER.log(Level.FATAL, "Connection is null");
        }
        String query = "SELECT * FROM `aptentity`";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("address")+" "+rs.getString("zone"));
        }
        ps.close();
        rs.close();

       /* Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()){
            addres = rs.getString("address");
            System.out.println(addres);
        }

        */

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
                operation = Operation.TO_SELL;
                break;
            case 2:
                operation=Operation.TO_RENT;
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
        apt.setOperation(String.valueOf(operation));
        apt.setCost(cost);
        apt.setDimension(dimension);
        apt.setRooms(rooms);

        return apt;
    }

    public boolean verifyAddress(@NotNull String address){

        return address.matches(".*\\w+.*\\s+\\d+");

    }
}
