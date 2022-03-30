package com.solvd.realestate.entity.transaction.rent;

import com.solvd.realestate.entity.apt.AptEntity;
import com.solvd.realestate.entity.customer.CustomerEntity;
import com.solvd.realestate.entity.employee.EmployeeEntity;

import java.time.LocalDateTime;

public class RentEntity {

    private int contractRentExtension;
    private LocalDateTime contractRentDate;
    private CustomerEntity contractRentCustomer;
    private EmployeeEntity contractRentEmployee;
    private AptEntity contractRentApt;

    public RentEntity(){}

    public RentEntity(int contractRentExtension, LocalDateTime contractRentDate, CustomerEntity contractRentCustomer, EmployeeEntity contractRentEmployee, AptEntity contractRentApt) {
        this.contractRentExtension = contractRentExtension;
        this.contractRentDate = contractRentDate;
        this.contractRentCustomer = contractRentCustomer;
        this.contractRentEmployee = contractRentEmployee;
        this.contractRentApt = contractRentApt;
    }

    public int getContractRentExtension() {
        return contractRentExtension;
    }

    public void setContractRentExtension(int contractRentExtension) {
        this.contractRentExtension = contractRentExtension;
    }

    public LocalDateTime getContractRentDate() {
        return contractRentDate;
    }

    public void setContractRentDate(LocalDateTime contractRentDate) {
        this.contractRentDate = contractRentDate;
    }

    public CustomerEntity getContractRentCustomer() {
        return contractRentCustomer;
    }

    public void setContractRentCustomer(CustomerEntity contractRentCustomer) {
        this.contractRentCustomer = contractRentCustomer;
    }

    public EmployeeEntity getContractRentEmployee() {
        return contractRentEmployee;
    }

    public void setContractRentEmployee(EmployeeEntity contractRentEmployee) {
        this.contractRentEmployee = contractRentEmployee;
    }

    public AptEntity getContractRentApt() {
        return contractRentApt;
    }

    public void setContractRentApt(AptEntity contractRentApt) {
        this.contractRentApt = contractRentApt;
    }

    @Override
    public String toString() {
        return "RentEntity{" +
                "contractRentExtension=" + contractRentExtension +
                ", contractRentDate=" + contractRentDate +
                ", contractRentCustomer=" + contractRentCustomer.getId() + " Name= " + contractRentCustomer.getLastName() + ", " + contractRentCustomer.getFirstName() + " " +
                ", contractRentEmployee=" + contractRentEmployee.getEmployeeId() + " Name= " + contractRentEmployee.getLastName() + ", " + contractRentEmployee.getFirstName() + " " +
                ", contractRentApt=" + contractRentApt.getAddress() +
                '}';
    }
}
