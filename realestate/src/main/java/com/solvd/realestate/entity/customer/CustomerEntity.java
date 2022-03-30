package com.solvd.realestate.entity.customer;


import com.solvd.realestate.entity.Person;

public class CustomerEntity extends Person {

    private double avalaibleAmount;
    private String tel;
    private int id;

    public CustomerEntity(double avalaibleAmount) {
        super();
        this.avalaibleAmount = avalaibleAmount;
    }

    public CustomerEntity() {}

    public double getAvalaibleAmount() {
        return avalaibleAmount;
    }

    public void setAvalaibleAmount(double amount) {
        this.avalaibleAmount = amount;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "First Name = " + getFirstName() +
                ", Last Name = " + getLastName() +
                ", amount= " + avalaibleAmount +
                ", tel='" + tel + '\'' +
                ", id= " + id +
                '}';
    }
}
