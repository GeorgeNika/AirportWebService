package ua.george_nika.database.jpaimpl;

import ua.george_nika.model.entity.AirportEntity;
import ua.george_nika.model.entity.LanguageEntity;
import ua.george_nika.database.factory.DataBaseAirportAbstractImplementation;
import ua.george_nika.model.entity.NamesCompositePrimaryKey;
import ua.george_nika.model.entity.NamesEntity;

import java.util.List;


public class DataBaseAirportJpaImplementation extends DataBaseAirportAbstractImplementation {

    public void addAirport(AirportEntity airport) {
        DataBaseObject dataBaseObject = new DataBaseObject();
        dataBaseObject.addObject(airport);
        dataBaseObject.close();
    }

    public void updateAirport(AirportEntity airport) {
        DataBaseObject dataBaseObject = new DataBaseObject();
        dataBaseObject.updateObject(airport);
        dataBaseObject.close();
    }

    public void deleteAirport(AirportEntity airport) {
        DataBaseObject dataBaseObject = new DataBaseObject();
        dataBaseObject.deleteObject(airport);
        dataBaseObject.close();
    }

    public AirportEntity getAirport(Long id) {
        DataBaseObject dataBaseObject = new DataBaseObject();
        AirportEntity resultAirport = dataBaseObject.getAirport(id);
        dataBaseObject.close();
        return resultAirport;
    }

    public List<AirportEntity> getAllAirports() {
        DataBaseObject dataBaseObject = new DataBaseObject();
        List<AirportEntity> resultAirports = dataBaseObject.getAllAirports();
        dataBaseObject.close();
        return resultAirports;
    }


    public void addLanguage(LanguageEntity language) {
        DataBaseObject dataBaseObject = new DataBaseObject();
        dataBaseObject.addObject(language);
        dataBaseObject.close();
    }

    public void updateLanguage(LanguageEntity language) {
        DataBaseObject dataBaseObject = new DataBaseObject();
        dataBaseObject.updateObject(language);
        dataBaseObject.close();
    }

    public void deleteLanguage(LanguageEntity language) {
        DataBaseObject dataBaseObject = new DataBaseObject();
        dataBaseObject.deleteObject(language);
        dataBaseObject.close();
    }

    public LanguageEntity getLanguage(Long id) {
        DataBaseObject dataBaseObject = new DataBaseObject();
        LanguageEntity resultLanguage = dataBaseObject.getLanguage(id);
        dataBaseObject.close();
        return resultLanguage;
    }

    public List<LanguageEntity> getAllLanguages() {
        DataBaseObject dataBaseObject = new DataBaseObject();
        List<LanguageEntity> resultLanguages = dataBaseObject.getAllLanguages();
        dataBaseObject.close();
        return resultLanguages;
    }

    public void addNames(NamesEntity names) {
        DataBaseObject dataBaseObject = new DataBaseObject();
        dataBaseObject.addObject(names);
        dataBaseObject.close();
    }

    public void updateNames(NamesEntity names) {
        DataBaseObject dataBaseObject = new DataBaseObject();
        dataBaseObject.updateObject(names);
        dataBaseObject.close();
    }

    public void deleteNames(NamesEntity names) {
        DataBaseObject dataBaseObject = new DataBaseObject();
        dataBaseObject.deleteObject(names);
        dataBaseObject.close();
    }

    public NamesEntity getNames(NamesCompositePrimaryKey key) {
        DataBaseObject dataBaseObject = new DataBaseObject();
        NamesEntity resultNames = dataBaseObject.getNames(key);
        dataBaseObject.close();
        return resultNames;
    }

    public List<NamesEntity> getAllNames() {
        DataBaseObject dataBaseObject = new DataBaseObject();
        List<NamesEntity> resultNames = dataBaseObject.getAllNames();
        dataBaseObject.close();
        return resultNames;
    }
}