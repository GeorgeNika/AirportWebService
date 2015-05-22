package ua.george_nika.database.factory;

import ua.george_nika.database.jpaimpl.DataBaseAirportJpaImplementation;

public class DataBaseAirportFactory {

    private static DataBaseAirportInterface instance;

    private DataBaseAirportFactory(){
    }

    public static DataBaseAirportInterface getInstance(){
        if (instance == null){
            //instance = new DataBaseAirportJdbcImplementation();
            instance = new DataBaseAirportJpaImplementation();
        }
        return  instance;
    }


}
