/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financialmanagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Minh Tân
 */
public class Controller {

    //declare variables
    private CostModel cm;
    private ArrayList<Cost> list = new ArrayList<Cost>();

    /**
     * Init class Controller
     */
    public Controller() {
        this.cm = new CostModel();
    }

    /**
     * get data from list add to table model
     *
     * @param c_date
     * @param model
     * @throws SQLException
     */
    public void getAllFinance(Date c_date, DefaultTableModel model) throws SQLException {
        list = cm.Select(c_date);
        removeAllRow(model);
        Object addCol[] = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            addCol[0] = i + 1;
            addCol[1] = list.get(i).getC_value();
            addCol[2] = list.get(i).getC_description();
            model.addRow(addCol);
        }
    }

    /**
     * update date
     *
     * @param id
     * @param description
     * @param value
     * @param date
     */
    public void UpdateData(long id, String description, int value, Date date) {
        cm.Update(id, value, description, date);
    }

    /**
     * delete data
     *
     * @param id
     * @throws SQLException
     */
    public void DeleteData(long id) throws SQLException {
        cm.Delete(id);
    }

    /**
     * show in/out come and total money
     *
     * @param c_date
     * @param lblShowIncome
     * @param lblShowOutcome
     * @param lblShowMoney
     */
    public void showInOutcome(Date c_date, JLabel lblShowIncome,
            JLabel lblShowOutcome, JLabel lblShowMoney) {
        lblShowIncome.setText(" " + cm.TotalIncome(c_date));
        lblShowOutcome.setText(" " + cm.TotalOutcome(c_date));
        lblShowMoney.setText(" " + cm.TotalMoney(c_date));
    }

    /**
     * Delete all rows in table
     *
     * @param table
     */
    public void removeAllRow(DefaultTableModel table) {
        int i = 0;
        //remove all row in table
        while (i < table.getRowCount()) {
            table.removeRow(i);
        }
    }

    /**
     * get list
     *
     * @return
     */
    public ArrayList<Cost> getList() {
        return list;
    }
}
