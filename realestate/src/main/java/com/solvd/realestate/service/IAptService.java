package com.solvd.realestate.service;

public interface IAptService {

    void createApt();
    void readApt();
    void updateApt(int id);
    void deleteApt(int id);
    void filterAptById(int id);
}
