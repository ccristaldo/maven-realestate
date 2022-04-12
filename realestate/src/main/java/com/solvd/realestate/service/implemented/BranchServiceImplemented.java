package com.solvd.realestate.service.implemented;

import com.solvd.realestate.entity.branch.BranchEntity;
import com.solvd.realestate.exception.BadAddressException;
import com.solvd.realestate.service.IBranchService;
import com.solvd.realestate.utils.Branches;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class BranchServiceImplemented implements IBranchService {

    public static final Logger LOGGER = LogManager.getLogger(BadAddressException.class.getName());

    Scanner sn = new Scanner(System.in);
    String address, description;
    int tel;
    BranchEntity branch;

    @Override
    public void readBranch(int id) {
        try{
            System.out.println(Branches.branches.get(id));
        }catch (IndexOutOfBoundsException e){
            LOGGER.log(Level.WARN, "Branch with id " + id + "does not exists\n");
        }

    }

    @Override
    public void createBranch() {
        loadBranch();
    }

    @Override
    public void readAllBranch() {
        if (Branches.branches.isEmpty()){
            LOGGER.log(Level.WARN, "there is no branches yet");
        }else{
            Branches.branches.forEach(System.out::println);
        }
    }

    public void loadBranch(){

        System.out.println("Enter Branch's address:");
        address = sn.nextLine();

        if (!verifyAddress(address)){
            throw new BadAddressException("Address must have number.");
        }

        System.out.println("Enter Branch's description:");
        description = sn.nextLine();

        System.out.println("Enter Branch's phone:");
        tel = sn.nextInt();

        branch = new BranchEntity();

        branch.setAddress(address);
        branch.setDescription(description);
        branch.setTel(String.valueOf(tel));
        branch.setId(Branches.branches.size());

        Branches.branches.add(branch);


    }

    public boolean verifyAddress(String address){

        return address.matches(".*\\w+.*\\s+\\d+");

    }
}
