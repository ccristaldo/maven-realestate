package com.solvd.realestate.entity.apt;

public abstract class AbstractApt {

    private String zone;
    private String operation;
    private String address;

    public AbstractApt(String zone, String operation, String address) {
        this.zone = zone;
        this.operation = operation;
        this.address = address;
    }

    public AbstractApt(String zone, String operation) {
        this.zone = zone;
        this.operation = operation;
    }

    public AbstractApt(String address){
        this.address=address;
    }

    public AbstractApt() {}

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
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
