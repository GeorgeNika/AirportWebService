package ua.george_nika.mainconsole;


        import ua.george_nika.model.entity.AirportEntity;
        import ua.george_nika.model.entity.NamesEntity;
        import ua.george_nika.model.entity.LanguageEntity;
        import ua.george_nika.database.factory.DataBaseAirportFactory;
        import ua.george_nika.model.factory.ModelFactory;
        import ua.george_nika.view.factory.ViewAirportsFactory;

        import java.util.List;

public class MainRandomJSP {

    public static void main (String[] args){

 //       workWithDB();
        workWithView();
    }

    private static void workWithDB(){
        LanguageEntity firstLanguage = new LanguageEntity();
        firstLanguage.setName("English");
        LanguageEntity secondLanguage = new LanguageEntity();
        secondLanguage.setName("Русский");

        ModelFactory.getInstance().addLanguage(firstLanguage);
        ModelFactory.getInstance().addLanguage(secondLanguage);



        AirportEntity firstAirport = new AirportEntity();
        firstAirport.setLatitude(50.3);
        firstAirport.setLongitude(-43.6);

        AirportEntity secondAirport = new AirportEntity();
        secondAirport.setLatitude(-51.3);
        secondAirport.setLongitude(34.6);

        ModelFactory.getInstance().addAirport(firstAirport);
        ModelFactory.getInstance().addAirport(secondAirport);



        NamesEntity firstNames = new NamesEntity();
        firstNames.setAirport(firstAirport);
        firstNames.setLanguage(firstLanguage);
        firstNames.setAirportName("Kharkov");
        firstNames.setCityName("Kharkov");
        firstNames.setCountryName("Ukraine");

        NamesEntity secondNames = new NamesEntity();
        secondNames.setAirport(secondAirport);
        secondNames.setLanguage(secondLanguage);
        secondNames.setAirportName("Киев");
        secondNames.setCityName("Киев");
        secondNames.setCountryName("Украина");

        ModelFactory.getInstance().addNames(firstNames);
        ModelFactory.getInstance().addNames(secondNames);



//
//        List<AirportEntity> allAirports = DataBaseAirportFactory.getInstance().getAllAirports();
//        for (AirportEntity tempAirport : allAirports){
//            System.out.println(tempAirport.toString());
//        }
//
//        List<LanguageEntity> allLanguages = DataBaseAirportFactory.getInstance().getAllLanguages();
//        for (LanguageEntity tempLanguage : allLanguages){
//            System.out.println(tempLanguage.toString());
//        }
    }

    private static void workWithView (){
        ViewAirportsFactory.getInstance().startView();
    }

}