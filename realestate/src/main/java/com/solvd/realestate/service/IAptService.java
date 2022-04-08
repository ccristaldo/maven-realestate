package com.solvd.realestate.service;

import com.solvd.realestate.exception.BadAddressException;

public interface IAptService {

    void createApt() throws BadAddressException;
    void readApt();
    void updateApt(int id);
    void deleteApt(int id);
    void filterAptById(int id);
}
