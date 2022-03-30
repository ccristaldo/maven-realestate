package com.solvd.realestate.entity.employee;

import com.solvd.realestate.entity.Person;

public class EmployeeEntity extends Person {

    private int employeeId;
    private String branch;
    private boolean active = true;

    public EmployeeEntity(int employeeId, String branch, boolean active) {
        super();
        this.employeeId = employeeId;
        this.branch = branch;
        this.active = active;
    }

    public EmployeeEntity() {}

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", employeeId=" + employeeId +
                ", branch='" + branch + '\'' +
                '}';
    }
}
