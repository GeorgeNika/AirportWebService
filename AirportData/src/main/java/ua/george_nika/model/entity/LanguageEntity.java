package ua.george_nika.model.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "languages")
@NamedQuery(name = "languages.getAll", query = "SELECT lang FROM LanguageEntity lang")
public class LanguageEntity {

    @Id
    @Column(name = "language_id")
    @GeneratedValue (strategy=GenerationType.AUTO, generator = "language")
    private Long languageId;

    private String name;

    @OneToMany(mappedBy = "language")
    private List<NamesEntity> airportNames;


    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NamesEntity> getAirportNames() {
        return airportNames;
    }

    public void setAirportNames(List<NamesEntity> airportNames) {
        this.airportNames = airportNames;
    }
}
