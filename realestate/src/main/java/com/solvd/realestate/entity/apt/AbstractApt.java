package com.solvd.realestate.entity.apt;

import com.solvd.realestate.enums.Zones;

public abstract class AbstractApt {

    private Zones zone;
    private String operation;
    private String address;

    public AbstractApt(Zones zone, String operation, String address) {
        this.zone = zone;
        this.operation = operation;
        this.address = address;
    }

    public AbstractApt(Zones zone, String operation) {
        this.zone = zone;
        this.operation = operation;
    }

    public AbstractApt(String address){
        this.address=address;
    }

    public AbstractApt() {}

    public Zones getZone() {
        return zone;
    }

    public void setZone(Zones zone) {
        this.zone = zone;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
