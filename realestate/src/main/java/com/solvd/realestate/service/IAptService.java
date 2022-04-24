package com.solvd.realestate.service;

import com.solvd.realestate.exception.BadAddressException;

import java.sql.SQLException;

public interface IAptService {

    void createApt() throws BadAddressException;
    void readApt();
    void updateApt(int id);
    void deleteApt(int id);
    void filterAptById(int id);
    void readFromDB() throws SQLException;
}
