package ua.george_nika.view.bridge;

import ua.george_nika.model.entity.AirportEntity;
import ua.george_nika.model.entity.LanguageEntity;

import java.util.List;

/**
 * Created by George on 15.05.2015.
 */
public interface BridgeFromViewToModel {

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

}
