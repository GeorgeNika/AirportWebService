package ua.george_nika.view.swingimpl;


import ua.george_nika.model.entity.AirportEntity;
import ua.george_nika.view.factory.ViewAirportsFactory;

import javax.swing.table.AbstractTableModel;
import java.util.List;

class AirportTableModel extends AbstractTableModel {

    private List<AirportEntity> listAirports;

    AirportTableModel() {
        obtainNewData();
    }

    public void showCorrectData(){
        obtainNewData();
        AirportListWindow.getInstance().repaint();
    }

    private void obtainNewData(){
        listAirports = ViewAirportsFactory.getModel().getAllAirports();
    }
    public int getRowCount() {
        return listAirports.size();
    }

    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        String result = " " + column;
        if (column==0){
            result = "id";
        }
        if (column==1){
            result = "country Iso Code";
        }
        if (column==2){
            result = "Time GMT offset";
        }
        if (column==3){
            result = "iata code";
        }
        if (column==4){
            result = "icao code";
        }
        if (column==5){
            result = "latitude";
        }
        if (column==6){
            result = "longitude";
        }
        if (column==7){
            result = "website";
        }
        return result;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Object result = null;
        if (columnIndex==0){
            result = listAirports.get(rowIndex).getAirportId();
        }
        if (columnIndex==1){
            result = listAirports.get(rowIndex).getCountryIsoCode();
        }
        if (columnIndex==1){
            result = listAirports.get(rowIndex).getTimeGmtOffset();
        }
        if (columnIndex==1){
            result = listAirports.get(rowIndex).getIataCode();
        }
        if (columnIndex==1){
            result = listAirports.get(rowIndex).getIcaoCode();
        }
        if (columnIndex==1){
            result = listAirports.get(rowIndex).getLatitude();
        }
        if (columnIndex==1){
            result = listAirports.get(rowIndex).getLongitude();
        }
        if (columnIndex==1){
            result = listAirports.get(rowIndex).getWebsite();
        }

        return result;
    }
}
