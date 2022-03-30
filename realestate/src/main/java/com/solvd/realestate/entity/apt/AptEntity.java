package com.solvd.realestate.entity.apt;

public class AptEntity extends AbstractApt{

    private double cost;
    private int dimension;
    private int rooms;
    private int aptId;
    private boolean active = true;

    public AptEntity() {}

    public AptEntity(double cost, int dimension, int rooms, boolean active) {
        super();
        this.cost = cost;
        this.dimension = dimension;
        this.rooms = rooms;
        this.active = active;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getAptId() {
        return aptId;
    }

    public void setAptId(int aptId) {
        this.aptId = aptId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Apartment: { " +
                " address= " + getAddress() +
                " operation= " + getOperation() +
                " zone= " + getZone() +
                " cost= " + cost +
                ", dimension= " + dimension +
                ", rooms= " + rooms +
                '}';
    }
}
