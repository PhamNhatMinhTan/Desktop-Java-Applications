/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financialmanagement;

import java.sql.SQLException;
import java.time.DateTimeException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Minh Tân
 */
public class CheckValidate {

    //declare variable
    private CostModel cm = new CostModel();

    /**
     * Init class check validate
     */
    public CheckValidate() {
        this.cm = cm;
    }

    /**
     * check money when users Insert data into database
     *
     * @param c_date
     * @param value
     * @return
     * @throws SQLException
     */
    public boolean checkMoneyInsert(Date c_date, long value) throws SQLException {
        cm.Select(c_date);
        //get (value users inputed) + (total money in a day)
        long money = value + cm.TotalMoney(c_date);
        //if money remaining less than 0 then return false
        if (money < 0) {
            return false;
        }
        return true;
    }

    /**
     * check money when users Update data into database
     *
     * @param c_date
     * @param currentValue
     * @param updateValue
     * @return
     * @throws SQLException
     */
    public boolean checkMoneyUpdate(Date c_date, long currentValue, long updateValue) throws SQLException {
        cm.Select(c_date);
        long money;
        //get (totalMoney in a day) - (value in table) + (value in textField users inputed)
        money = cm.TotalMoney(c_date) - currentValue + updateValue;
        //if money remaining less than 0 then return false
        if (money < 0) {
            return false;
        }
        return true;
    }

    /**
     * Check users choose future day or not
     *
     * @param date
     * @return
     */
    public boolean checkdate(Date date) {
        //get current day
        java.util.Date dateNow = new java.util.Date();
        System.out.println(date);
        //check if date users choose greater than current date then return false
        if (date.compareTo(dateNow) > 0) {
            return false;
        }
        //return true
        return true;
    }
}
