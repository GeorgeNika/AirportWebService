package ua.george_nika.model.firstimpl;

import ua.george_nika.model.entity.AirportEntity;
import ua.george_nika.model.entity.LanguageEntity;
import ua.george_nika.database.factory.DataBaseAirportFactory;
import ua.george_nika.model.entity.NamesCompositePrimaryKey;
import ua.george_nika.model.entity.NamesEntity;
import ua.george_nika.model.factory.ModelInterface;

import java.util.List;

public class ModelDataBaseImpl implements ModelInterface {

    public void addAirport(AirportEntity airport) {
        DataBaseAirportFactory.getInstance().addAirport(airport);
    }

    public void updateAirport(AirportEntity airport) {
        DataBaseAirportFactory.getInstance().updateAirport(airport);
    }

    public void deleteAirport(AirportEntity airport) {
        DataBaseAirportFactory.getInstance().deleteAirport(airport);
    }

    public AirportEntity getAirport(Long id) {
        return DataBaseAirportFactory.getInstance().getAirport(id);
    }

    public List<AirportEntity> getAllAirports() {
        return DataBaseAirportFactory.getInstance().getAllAirports();
    }

    public void addLanguage(LanguageEntity language) {
        DataBaseAirportFactory.getInstance().addLanguage(language);
    }

    public void updateLanguage(LanguageEntity language) {
        DataBaseAirportFactory.getInstance().updateLanguage(language);
    }

    public void deleteLanguage(LanguageEntity language) {
        DataBaseAirportFactory.getInstance().deleteLanguage(language);
    }

    public LanguageEntity getLanguage(Long id) {
        return DataBaseAirportFactory.getInstance().getLanguage(id);
    }

    public List<LanguageEntity> getAllLanguages() {
        return DataBaseAirportFactory.getInstance().getAllLanguages();
    }

    public void addNames(NamesEntity names) {
        DataBaseAirportFactory.getInstance().addNames(names);
    }

    public void updateNames(NamesEntity names) {
        DataBaseAirportFactory.getInstance().updateNames(names);
    }

    public void deleteNames(NamesEntity names) {
        DataBaseAirportFactory.getInstance().deleteNames(names);
    }

    public NamesEntity getNames(NamesCompositePrimaryKey key) {
        return DataBaseAirportFactory.getInstance().getNames(key);
    }

    public List<NamesEntity> getAllNames() {
        return DataBaseAirportFactory.getInstance().getAllNames();
    }
}
