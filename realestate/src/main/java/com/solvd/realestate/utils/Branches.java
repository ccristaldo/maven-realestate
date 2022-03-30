package com.solvd.realestate.utils;

import com.solvd.realestate.entity.branch.BranchEntity;

import java.util.ArrayList;

public class Branches {

    public static ArrayList<BranchEntity> branches = new ArrayList<>();

    BranchEntity central = new BranchEntity("Central Branch", "Evergreen 123", 33, 0);
    BranchEntity uptown = new BranchEntity("Uptown Branch", "Fake St 321", 55, 1);
    BranchEntity downtown = new BranchEntity("Downtown Branch", "5th Av 345", 44, 2);

    public void addBranch(){
        Branches.branches.add(central);
        Branches.branches.add(uptown);
        Branches.branches.add(downtown);
    }

    public void readAllBranch(){
        Branches.branches.forEach(System.out::println);
    }

    public void readBranchById(int id){
        System.out.println(Branches.branches.get(id));
    }


}
