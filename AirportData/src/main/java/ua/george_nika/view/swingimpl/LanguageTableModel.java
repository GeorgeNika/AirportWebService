package ua.george_nika.view.swingimpl;

import ua.george_nika.model.entity.LanguageEntity;
import ua.george_nika.view.factory.ViewAirportsFactory;

import javax.swing.table.AbstractTableModel;
import java.util.List;

class LanguageTableModel extends AbstractTableModel {

    private List<LanguageEntity> listLanguages;

    LanguageTableModel() {
        obtainNewData();
    }

    public void showCorrectData(){
        obtainNewData();
        LanguageListWindow.getInstance().repaint();
    }

    private void obtainNewData(){
        listLanguages = ViewAirportsFactory.getModel().getAllLanguages();
    }



    public int getRowCount() {
        return listLanguages.size();
    }

    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        String result = " " + column;
        if (column==0){
            result = "id";
        }
        if (column==1){
            result = "language";
        }
        return result;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Object result = null;
        if (columnIndex==0){
            result = listLanguages.get(rowIndex).getLanguageId();
        }
        if (columnIndex==1){
            result = listLanguages.get(rowIndex).getName();
        }

        return result;
    }
}