package com.solvd.realestate.utils;

import com.solvd.realestate.entity.transaction.rent.RentEntity;
import com.solvd.realestate.entity.transaction.sell.SellEntity;

import java.util.HashSet;

public class Transactions {

    public static HashSet<SellEntity> sells = new HashSet<>();
    public static HashSet<RentEntity> rents = new HashSet<>();
}
