package ua.george_nika.view.swingimpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


class MainWindow extends JFrame{

    private JPanel panelAirportsBase = new JPanel();
    private JPanel panelSearchNearest  = new JPanel();
    private JPanel panelSearchFlights = new JPanel();
    private JPanel panelProperties  = new JPanel();

    private JButton buttonAirportsBase= new JButton ("Airport database");
    private JButton buttonSearchNearest = new JButton ("Search nearest");
    private JButton buttonSearchFlights= new JButton ("Search flights");
    private JButton buttonProperties  = new JButton ("Properties");

    //private static JTextField t1 = new JTextField(10);

    //private static JLabel l1 = new JLabel("ip - address");

    public void ShowMainWindow() {

        initializeGlobalWindowProperties();
        initializeComponents();
        initializeListeners();

        setVisible(true);
    }

    private void initializeGlobalWindowProperties(){

        int wx = 600;
        int hy = 400;
        setTitle("Airports");
        setSize(wx, hy);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initializeComponents(){
        setLayout(new FlowLayout());

        panelAirportsBase.add(buttonAirportsBase);
        panelSearchNearest.add(buttonSearchNearest);
        panelSearchFlights.add(buttonSearchFlights);
        panelProperties.add(buttonProperties);

        add(panelAirportsBase);
        add(panelSearchNearest);
        add(panelSearchFlights);
        add(panelProperties);
    }

    private void initializeListeners(){


        buttonAirportsBase.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                AirportListWindow.getInstance().showAirportListWindow();
                //TODO
            }
        });
        buttonSearchNearest.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
        buttonSearchFlights.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
        buttonProperties.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                //TODO
                LanguageListWindow.getInstance().showLanguageListWindow();
            }
        });

    }



}
