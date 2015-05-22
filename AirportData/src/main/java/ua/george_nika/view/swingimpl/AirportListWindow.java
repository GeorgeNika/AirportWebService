package ua.george_nika.view.swingimpl;


import ua.george_nika.model.entity.AirportEntity;
import ua.george_nika.view.factory.ViewAirportsFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class AirportListWindow extends JFrame{

    private static AirportListWindow instance = new AirportListWindow();
    private static Boolean isInitialized = false;

    private JPanel panelTitle = new JPanel();
    private JPanel panelDataBase = new JPanel();
    private JPanel panelButtons = new JPanel();
    private JLabel labelTitle = new JLabel("Airports List");
    private JButton buttonAdd = new JButton("Add");
    private JButton buttonEdit = new JButton("Edit");
    private JButton buttonDelete = new JButton("Delete");

    private AirportTableModel tableModelAirport = new AirportTableModel();
    private JTable tableAirport = new JTable(tableModelAirport);
    private JScrollPane scrollPaneLanguage = new JScrollPane(tableAirport);

    private AirportListWindow(){
    }

    public static AirportListWindow getInstance(){

        if (instance==null){
            instance = new AirportListWindow();
        }
        return instance;
    }


    public void showAirportListWindow(){

        if (! isInitialized) {
            initializeGlobalWindowProperties();
            initializeComponents();
            initializeListeners();
        }
        tableModelAirport.showCorrectData();
        setVisible(true);
    }

    private void initializeGlobalWindowProperties() {

        int wx = 500;
        int hy = 400;
        setTitle("Airports List");
        setSize(wx, hy);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        isInitialized = true;
    }

    private void initializeComponents() {

        setLayout(new BorderLayout());

        panelTitle.add(labelTitle);

        tableAirport.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
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
                AirportEditWindow.getInstance().showAddWindow();
            }
        });
        buttonEdit.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                try {
                    AirportEditWindow.getInstance().showEditWindow(getAirportFromTable());
                } catch (Exception except) {
                    JOptionPane.showMessageDialog(AirportListWindow.this, "No selected row in airport table", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonDelete.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                try {
                    AirportEditWindow.getInstance().showDeleteWindow(getAirportFromTable());
                } catch (Exception except) {
                    JOptionPane.showMessageDialog(AirportListWindow.this, "No selected row in airport table", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private AirportEntity getAirportFromTable() throws Exception {
        int n = tableAirport.getSelectedRow();
        Long id = (Long) tableModelAirport.getValueAt(n,0);
        if (id>=0) {
            AirportEntity resultAirport = ViewAirportsFactory.getModel().getAirport(id);
            return resultAirport;
        } else {
            throw new Exception("No selected row in airport table");
        }
    }



}
