package com.solvd.realestate.entity.transaction;

import java.util.HashSet;
import java.util.Iterator;

public class Transaction <T> implements Iterable{

    HashSet<T> transactions = new HashSet<>();

    public void add(T ob){
        transactions.add(ob);
    }

    @Override
    public Iterator iterator() {
        return transactions.iterator();
    }
}
