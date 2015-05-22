package ua.george_nika.model.entity;


import javax.persistence.*;

@Entity
@IdClass(NamesCompositePrimaryKey.class)
@Table(name = "names")
@NamedQuery(name = "names.getAll", query = "SELECT names FROM NamesEntity names")
public class NamesEntity {


    private AirportEntity airport;
    private LanguageEntity language;

    private String airportName;
    private String cityName;
    private String countryName;

    public NamesEntity() {
    }

    @ManyToOne
    @Id
    @JoinColumn(name = "airport_id")
    public AirportEntity getAirport() {
        return airport;
    }

    public void setAirport(AirportEntity airport) {
        this.airport = airport;
    }

    @ManyToOne
    @Id
    @JoinColumn(name = "language_id")
    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
