package ua.george_nika.model.entity;

import java.io.Serializable;

public class NamesCompositePrimaryKey implements Serializable {

    private Long airport;
    private Long language;

    public Long getAirport() {
        return airport;
    }

    public void setAirport(Long airport) {
        this.airport = airport;
    }

    public Long getLanguage() {
        return language;
    }

    public void setLanguage(Long language) {
        this.language = language;
    }
}


