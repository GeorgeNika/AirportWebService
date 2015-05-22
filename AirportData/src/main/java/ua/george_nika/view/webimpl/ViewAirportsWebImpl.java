package ua.george_nika.view.webimpl;

import ua.george_nika.view.factory.ViewAirportsAbstractImpl;

import java.io.IOException;

/**
 * Created by George on 15.05.2015.
 */
public class ViewAirportsWebImpl extends ViewAirportsAbstractImpl{
    public void startView() {
        try {
            Process process = Runtime.getRuntime().exec("cmd /c start www.rambler.ru");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
