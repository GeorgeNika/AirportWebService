package ua.george_nika.view.swingimpl;

import ua.george_nika.model.entity.LanguageEntity;
import ua.george_nika.view.factory.ViewAirportsFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class LanguageListWindow extends JFrame{

    private static LanguageListWindow instance = new LanguageListWindow();
    private static Boolean isInitialized = false;

    private JPanel panelTitle = new JPanel();
    private JPanel panelDataBase = new JPanel();
    private JPanel panelButtons = new JPanel();
    private JLabel labelTitle = new JLabel("Languages List");
    private JButton buttonAdd = new JButton("Add");
    private JButton buttonEdit = new JButton("Edit");
    private JButton buttonDelete = new JButton("Delete");

    private LanguageTableModel tableModelLanguage = new LanguageTableModel();
    private JTable tableLanguage = new JTable(tableModelLanguage);
    private JScrollPane scrollPaneLanguage = new JScrollPane(tableLanguage);


    private LanguageListWindow(){
    }

    public static LanguageListWindow getInstance(){

        if (instance==null){
            instance = new LanguageListWindow();
        }
        return instance;
    }


    public void showLanguageListWindow(){

        if (! isInitialized) {
            initializeGlobalWindowProperties();
            initializeComponents();
            initializeListeners();
        }
        tableModelLanguage.showCorrectData();
        setVisible(true);
    }


    private void initializeGlobalWindowProperties() {

        int wx = 400;
        int hy = 250;
        setTitle("Languages List");
        setSize(wx, hy);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        isInitialized = true;
    }

    private void initializeComponents() {

        setLayout(new BorderLayout());

        panelTitle.add(labelTitle);

        tableLanguage.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollPaneLanguage.setPreferredSize(new Dimension(300, 130));
        panelDataBase.add(scrollPaneLanguage);

        panelButtons.add(buttonAdd);
        panelButtons.add(buttonEdit);
        panelButtons.add(buttonDelete);

        add(panelTitle,BorderLayout.PAGE_START);
        add(panelDataBase,BorderLayout.CENTER);
        add(panelButtons,BorderLayout.PAGE_END);
    }

    private void initializeListeners() {

        buttonAdd.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                LanguageEditWindow.getInstance().showAddWindow();
            }
        });
        buttonEdit.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                try {
                    LanguageEditWindow.getInstance().showEditWindow(getLanguageFromTable());
                } catch (Exception except) {
                    JOptionPane.showMessageDialog(LanguageListWindow.this, "No selected row in language table","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonDelete.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                try{
                    LanguageEditWindow.getInstance().showDeleteWindow(getLanguageFromTable());
                } catch (Exception except){
                    JOptionPane.showMessageDialog(LanguageListWindow.this, "No selected row in language table","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    private LanguageEntity getLanguageFromTable() throws Exception {
        int n = tableLanguage.getSelectedRow();
        Long id = (Long) tableModelLanguage.getValueAt(n,0);
        if (id>=0) {
            LanguageEntity resultLanguage = ViewAirportsFactory.getModel().getLanguage(id);
            return resultLanguage;
        } else {
            throw new Exception("No selected row in language table");
        }
    }
}

