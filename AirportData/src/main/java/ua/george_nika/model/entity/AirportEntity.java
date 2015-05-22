package ua.george_nika.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airports")
@NamedQuery(name = "airports.getAll", query = "SELECT a FROM AirportEntity a")
public class AirportEntity {

    @Id
    @Column(name = "airport_id")
    @GeneratedValue (strategy=GenerationType.AUTO, generator = "airport")
    private Long AirportId;

    @OneToMany(mappedBy = "airport")
    private List<NamesEntity> airportNames;
    private String countryIsoCode;
    private Double timeGmtOffset;
    private String iataCode;
    private String icaoCode;
    private Double latitude;
    private Double longitude;
    private String website;


    public Long getAirportId() {
        return AirportId;
    }

    public void setAirportId(Long airportId) {
        this.AirportId = airportId;
    }

    public List<NamesEntity> getAirportNames() {
        return airportNames;
    }

    public void setAirportNames(List<NamesEntity> airportNames) {
        this.airportNames = airportNames;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public Double getTimeGmtOffset() {
        return timeGmtOffset;
    }

    public void setTimeGmtOffset(Double timeGmtOffset) {
        this.timeGmtOffset = timeGmtOffset;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
