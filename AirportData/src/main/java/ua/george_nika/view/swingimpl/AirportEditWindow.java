package ua.george_nika.view.swingimpl;

import ua.george_nika.model.entity.AirportEntity;
import ua.george_nika.view.factory.ViewAirportsFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class AirportEditWindow extends JFrame {

    private static AirportEditWindow instance = new AirportEditWindow();
    private static Boolean isInitialized=false;

    private AirportEntity airport;

    private JButton buttonOkAction=new JButton("OK");
    private JButton buttonCancelAction=new JButton("Cancel");
    private JLabel labelId = new JLabel("Id");
    private JLabel labelName = new JLabel("Name");
    private JTextField textFieldId = new JTextField(5);
    private JTextField textFieldName = new JTextField(30);
    private WindowActions action ;


    private AirportEditWindow() {
    }

    public  static AirportEditWindow getInstance(){
        if (instance==null){
            instance = new AirportEditWindow();
        }
        return instance;
    }

    public void showAddWindow(){
        this.airport = new AirportEntity();
        action = WindowActions.ADD;
        buttonOkAction.setText(action.name());
        showLanguageEditWindow();
    }


    public void showEditWindow(AirportEntity airport){
        this.airport = airport;
        action = WindowActions.EDIT;
        buttonOkAction.setText(action.name());
        showLanguageEditWindow();
    }

    public void showDeleteWindow(AirportEntity airport){
        this.airport = airport;
        action = WindowActions.DELETE;
        buttonOkAction.setText(action.name());
        showLanguageEditWindow();
    }

    private void showLanguageEditWindow(){
        if (! isInitialized) {
            initializeGlobalWindowProperties();
            initializeComponents();
            initializeListeners();
        }
        setFieldData();
        setVisible(true);
    }

    private void initializeGlobalWindowProperties(){
        setSize(300, 150);
        setTitle("Airport Action");
        setLocationRelativeTo(this);
        setLayout(new GridBagLayout());
        setResizable(false);
        isInitialized = true;
    }

    private void initializeComponents(){
        add(labelId, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(textFieldId, new GridBagConstraints(1, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        textFieldId.setEditable(false);
        add(labelName, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(textFieldName, new GridBagConstraints(1, 1, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        textFieldName.setEditable(false);

        add(buttonOkAction, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(buttonCancelAction, new GridBagConstraints(2, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
    }

    private void initializeListeners(){

        buttonOkAction.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                updateAirport();
                switch (action) {
                    case ADD :
                        ViewAirportsFactory.getModel().addAirport(airport);
                        closeWindow();
                        break;
                    case EDIT:
                        ViewAirportsFactory.getModel().updateAirport(airport);
                        closeWindow();
                        break;
                    case DELETE :
                        ViewAirportsFactory.getModel().deleteAirport(airport);
                        closeWindow();
                        break;
                }
            }
        });
        buttonCancelAction.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });

    }

    private void setFieldData(){
        textFieldId.setText(String.valueOf(airport.getAirportId()));
        textFieldName.setText(airport.getCountryIsoCode());
        // todo all fields
        if (action==WindowActions.DELETE) {
            textFieldName.setEditable(false);
        } else {
            textFieldName.setEditable(true);
        }
    }

    private void updateAirport(){
        airport.setCountryIsoCode(textFieldName.getText());
        //todo all fields
    }

    private void closeWindow(){
        setVisible(false);
        AirportListWindow.getInstance().showAirportListWindow();
    }
}