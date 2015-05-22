package ua.george_nika.view.swingimpl;

import ua.george_nika.model.entity.LanguageEntity;
import ua.george_nika.view.factory.ViewAirportsFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class LanguageEditWindow extends JFrame {

    private static LanguageEditWindow instance = new LanguageEditWindow();
    private static Boolean isInitialized=false;

    private LanguageEntity language;

    private JButton buttonOkAction=new JButton("OK");
    private JButton buttonCancelAction=new JButton("Cancel");
    private JLabel labelId = new JLabel("Id");
    private JLabel labelName = new JLabel("Name");
    private JTextField textFieldId = new JTextField(5);
    private JTextField textFieldName = new JTextField(30);
    private WindowActions action ;


    private LanguageEditWindow() {
    }

    public  static LanguageEditWindow getInstance(){
        if (instance==null){
            instance = new LanguageEditWindow();
        }
        return instance;
    }

    public void showAddWindow(){
        this.language = new LanguageEntity();
        action = WindowActions.ADD;
        buttonOkAction.setText(action.name());
        showLanguageEditWindow();
    }


    public void showEditWindow(LanguageEntity language){
        this.language = language;
        action = WindowActions.EDIT;
        buttonOkAction.setText(action.name());
        showLanguageEditWindow();
    }

    public void showDeleteWindow(LanguageEntity language){
        this.language = language;
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
        setTitle("Language Action");
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
                updateLanguage();
                switch (action) {
                    case ADD :
                        ViewAirportsFactory.getModel().addLanguage(language);
                        closeWindow();
                        break;
                    case EDIT:
                        ViewAirportsFactory.getModel().updateLanguage(language);
                        closeWindow();
                        break;
                    case DELETE :
                        ViewAirportsFactory.getModel().deleteLanguage(language);
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
        textFieldId.setText(String.valueOf(language.getLanguageId()));
        textFieldName.setText(language.getName());
        if (action==WindowActions.DELETE) {
            textFieldName.setEditable(false);
        } else {
            textFieldName.setEditable(true);
        }
    }

    private void updateLanguage(){
        language.setName(textFieldName.getText());
    }

    private void closeWindow(){
        setVisible(false);
        LanguageListWindow.getInstance().showLanguageListWindow();
    }
}
