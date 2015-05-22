package ua.george_nika.database.factory;

import ua.george_nika.model.entity.AirportEntity;
import ua.george_nika.model.entity.LanguageEntity;
import ua.george_nika.model.entity.NamesCompositePrimaryKey;
import ua.george_nika.model.entity.NamesEntity;

import java.util.List;


public interface DataBaseAirportInterface {

    void addAirport(AirportEntity airport);
    void updateAirport(AirportEntity airport);
    void deleteAirport(AirportEntity airport);
    AirportEntity getAirport(Long id);
    List<AirportEntity> getAllAirports();

    void addLanguage(LanguageEntity language);
    void updateLanguage(LanguageEntity language);
    void deleteLanguage(LanguageEntity language);
    LanguageEntity getLanguage(Long id);
    List<LanguageEntity> getAllLanguages();

    void addNames(NamesEntity names);
    void updateNames(NamesEntity names);
    void deleteNames(NamesEntity names);
    NamesEntity getNames(NamesCompositePrimaryKey key);
    List<NamesEntity> getAllNames();

}
