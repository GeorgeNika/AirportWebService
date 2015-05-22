package ua.george_nika.view.bridge;

import ua.george_nika.model.entity.AirportEntity;
import ua.george_nika.model.entity.LanguageEntity;
import ua.george_nika.model.factory.ModelFactory;

import java.util.List;

public class BridgeFromViewToModelImpl implements BridgeFromViewToModel{
    public void addAirport(AirportEntity airport) {
        ModelFactory.getInstance().addAirport(airport);
    }

    public void updateAirport(AirportEntity airport) {
        ModelFactory.getInstance().updateAirport(airport);
    }

    public void deleteAirport(AirportEntity airport) {
        ModelFactory.getInstance().deleteAirport(airport);
    }

    public AirportEntity getAirport(Long id) {
        return ModelFactory.getInstance().getAirport(id);
    }

    public List<AirportEntity> getAllAirports() {
        return ModelFactory.getInstance().getAllAirports();
    }

    public void addLanguage(LanguageEntity language) {
        ModelFactory.getInstance().addLanguage(language);
    }

    public void updateLanguage(LanguageEntity language) {
        ModelFactory.getInstance().updateLanguage(language);
    }

    public void deleteLanguage(LanguageEntity language) {
        ModelFactory.getInstance().deleteLanguage(language);
    }

    public LanguageEntity getLanguage(Long id) {
        return ModelFactory.getInstance().getLanguage(id);
    }

    public List<LanguageEntity> getAllLanguages() {
        return ModelFactory.getInstance().getAllLanguages();
    }
}
