package com.solvd.realestate.entity.apt;

public class AptPrefEntity extends AbstractApt{
    private int rooms;


    public AptPrefEntity(String zone, String operation, int rooms) {
        super(zone, operation);
        this.rooms= rooms;
    }

    public AptPrefEntity(){}

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
}
