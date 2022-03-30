package com.solvd.realestate.service;

public interface IEmployeeService {

    void createEmployee();
    void readEmployees();
    void updateEmployeeById(int id);
    void deleteEmployeeById(int id);
    void filterEmployeeByBranch(int id);
}
