package com.solvd.realestate.entity.apt;

import com.solvd.realestate.enums.Zones;

public class AptPrefEntity extends AbstractApt{
    private int rooms;


    public AptPrefEntity(Zones zone, String operation, int rooms) {
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
