package com.solvd.realestate.entity.person;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Iterator;

public class PersonGenerics<T> implements Iterable {

    HashSet<T> persons = new HashSet<>();

    public void add(T ob){
        persons.add(ob);
    }


    @NotNull
    @Override
    public Iterator iterator() {
        return persons.iterator();
    }

    public boolean isEmpty() {
        return persons.isEmpty();
    }
}
