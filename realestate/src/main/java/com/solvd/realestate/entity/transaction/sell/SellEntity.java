package com.solvd.realestate.entity.transaction.sell;

import com.solvd.realestate.entity.apt.AptEntity;
import com.solvd.realestate.entity.customer.CustomerEntity;
import com.solvd.realestate.entity.employee.EmployeeEntity;

import java.time.LocalDateTime;

public class SellEntity {
    private LocalDateTime contractSellDate;
    private CustomerEntity contractSellCustomer;
    private EmployeeEntity contractSellEmployee;
    private AptEntity contractSellApt;
    private double contractAmount;

    public SellEntity() {
    }

    public SellEntity(LocalDateTime contractSellDate, CustomerEntity contractSellCustomer, EmployeeEntity contractSellEmployee, AptEntity contractSellApt, double contractAmount) {
        this.contractSellDate = contractSellDate;
        this.contractSellCustomer = contractSellCustomer;
        this.contractSellEmployee = contractSellEmployee;
        this.contractSellApt = contractSellApt;
        this.contractAmount = contractAmount;
    }

    public LocalDateTime getContractSellDate() {
        return contractSellDate;
    }

    public void setContractSellDate(LocalDateTime contractSellDate) {
        this.contractSellDate = contractSellDate;
    }

    public CustomerEntity getContractSellCustomer() {
        return contractSellCustomer;
    }

    public void setContractSellCustomer(CustomerEntity contractSellCustomer) {
        this.contractSellCustomer = contractSellCustomer;
    }

    public EmployeeEntity getContractSellEmployee() {
        return contractSellEmployee;
    }

    public void setContractSellEmployee(EmployeeEntity contractSellEmployee) {
        this.contractSellEmployee = contractSellEmployee;
    }

    public AptEntity getContractSellApt() {
        return contractSellApt;
    }

    public void setContractSellApt(AptEntity contractSellApt) {
        this.contractSellApt = contractSellApt;
    }

    public double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(double contractAmount) {
        this.contractAmount = contractAmount;
    }

    @Override
    public String toString() {
        return "SellEntity{" +
                "contractSellDate=" + contractSellDate +
                ", contractSellCustomer=" + contractSellCustomer +
                ", contractSellEmployee=" + contractSellEmployee +
                ", contractSellApt=" + contractSellApt +
                ", contractAmount=" + contractAmount +
                '}';
    }
}
