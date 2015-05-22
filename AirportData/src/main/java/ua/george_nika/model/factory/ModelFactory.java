package ua.george_nika.model.factory;

import ua.george_nika.model.firstimpl.ModelDataBaseImpl;

public class ModelFactory {

    private static ModelInterface instance;

    private ModelFactory(){
    }

    public static ModelInterface getInstance(){
        if (instance==null) {
            instance = new ModelDataBaseImpl();
        }
        return instance;
    }
}
