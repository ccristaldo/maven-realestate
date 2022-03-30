package com.solvd.realestate.service.implemented;

import com.solvd.realestate.entity.branch.BranchEntity;
import com.solvd.realestate.service.IBranchService;
import com.solvd.realestate.utils.Branches;

import java.util.Scanner;

public class BranchServiceImplemented implements IBranchService {

    Scanner sn = new Scanner(System.in);
    String address, description;
    int tel;
    BranchEntity branch;

    @Override
    public void readBranch(int id) {
        try{
            System.out.println(Branches.branches.get(id));
        }catch (IndexOutOfBoundsException e){
            System.out.format("Branch with id [%d] does not exists\n", id);
        }



    }

    @Override
    public void createBranch() {
        loadBranch();
    }

    @Override
    public void readAllBranch() {
        if (Branches.branches.isEmpty()){
            System.out.println("there is no branches yet");
        }else{
            Branches.branches.forEach(System.out::println);
        }
    }

    public void loadBranch(){

        System.out.println("Enter Branch's address:");
        address = sn.nextLine();

        System.out.println("Enter Branch's description:");
        description = sn.nextLine();

        System.out.println("Enter Branch's phone:");
        tel = sn.nextInt();

        branch = new BranchEntity();

        branch.setAddress(address);
        branch.setDescription(description);
        branch.setTel(tel);
        branch.setId(Branches.branches.size());

        Branches.branches.add(branch);


    }
}
