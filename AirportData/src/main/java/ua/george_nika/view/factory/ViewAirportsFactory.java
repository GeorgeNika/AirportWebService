package ua.george_nika.view.factory;


import ua.george_nika.view.bridge.BridgeFromViewToModel;
import ua.george_nika.view.bridge.BridgeFromViewToModelImpl;
import ua.george_nika.view.swingimpl.ViewAirportsSwingImpl;

public class ViewAirportsFactory {

    private static ViewAirportsInterface instance;
    private static BridgeFromViewToModel bridgeFromViewToModel;

    private ViewAirportsFactory(){
    }

    public static ViewAirportsInterface getInstance (){
        if (instance==null) {
            instance = new ViewAirportsSwingImpl();
        }
        return instance;
    }

    public static BridgeFromViewToModel getModel(){
        if (bridgeFromViewToModel==null) {
            bridgeFromViewToModel = new BridgeFromViewToModelImpl();
        }
        return bridgeFromViewToModel;
    }
}
