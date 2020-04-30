/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financialmanagement;

import DBLib.ConnectionLib;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Minh Tân
 */
public class CostModel {

    private Connection con;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private ArrayList<Cost> list;

    public CostModel() {
        try {
            con = ConnectionLib.getConnection();
            pst = null;
            st = null;
            list = new ArrayList<>();
        } catch (SQLException ex) {
            Logger.getLogger(CostModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*
    public void insert(String des, int val, String date) throws SQLException{
        String sqlStr = "INSERT INTO `cost`(`c_description`, `c_value`, `c_date`) VALUES (?,?,?)";
        pst = con.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
        
        pst.setString(1, des);
        pst.setInt(2, val);
        pst.setString(3, date);
        
        pst.executeUpdate();
        
    }
     */

    public long insert(String des, int val, String date) throws SQLException {
        long c_id;
        String sqlStr = "INSERT INTO `cost`(`c_description`, `c_value`, `c_date`) VALUES (?,?,?)";
        pst = con.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, des);
        pst.setInt(2, val);
        pst.setString(3, date);
        
        //insert new in/outcome to mysql
        pst.executeUpdate();
        //get c_id auto increment id after insert new data
        rs = pst.getGeneratedKeys();
        rs.next();
        c_id = rs.getInt(1);
        return c_id;
    }
    
    /**
     * Update data in database
     *
     * @param c_id
     * @param c_value
     * @param c_description
     * @param c_date
     */
    public void Update(long c_id, int c_value, String c_description, Date c_date) {
        try {
            String Date = dateToString(c_date);
            String sqlStr = "UPDATE `cost` SET `c_description`= ?,`c_value`= ?,`c_date`= ? WHERE c_id = ?";
            pst = con.prepareStatement(sqlStr);
            pst.setString(1, c_description);
            pst.setInt(2, c_value);
            pst.setString(3, Date);
            pst.setLong(4, c_id);
            //update data to mysql
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    /**
     * Delete data in database
     *
     * @param c_id
     */
    public void Delete(long c_id) throws SQLException {
        String sqlStr = "DELETE FROM `cost` WHERE c_id = ?";
        pst = con.prepareStatement(sqlStr);
        pst.setLong(1, c_id);
        
        //delete data to mysql
        pst.executeUpdate();
    }

    /**
     * Select date >>> get data from database and add to list
     *
     * @param c_date
     * @return
     * @throws SQLException
     */
    public ArrayList<Cost> Select(Date c_date) throws SQLException {
        Connection con = ConnectionLib.getConnection();
        st = con.createStatement();
        String sqlStr = "SELECT * FROM `cost`";
        ResultSet rs = st.executeQuery(sqlStr);
        list = new ArrayList<>();

        //check out which date is date user choose and add into list
        while (rs.next()) {
            //format date to string
            String date = dateToString(c_date);
            //check date user choose on calendar with date in database
            if (rs.getDate("c_date").toString().equals(date)) {
                list.add(new Cost(rs.getLong("c_id"), rs.getString("c_description"),
                        rs.getInt("c_value"), rs.getDate("c_date")));
            }
        }
        //return list
        return list;
    }

    /**
     * Method format Date to String
     *
     * @param c_date
     * @return
     */
    public static String dateToString(Date c_date) {
        //format date to string
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(c_date);
//        String Date = new SimpleDateFormat("yyyy/MM/dd").format(date);
        //return date after format
        return date;
    }

    /**
     * get total income of that day
     *
     * @param c_date
     * @return
     */
    public long TotalIncome(Date c_date) {
        int totalIncome = 0;
        for (int i = 0; i < list.size(); i++) {
            Cost c = this.list.get(i);
            //if value greater than 0 then add to totalIncome
            if (c.getC_value() > 0) {
                totalIncome += c.getC_value();
            }
        }
        //return total value
        return totalIncome;
    }

    /**
     * get total outcome of that day
     *
     * @param c_date
     * @return
     */
    public long TotalOutcome(Date c_date) {
        int totalOutcome = 0;
        for (int i = 0; i < list.size(); i++) {
            Cost c = this.list.get(i);
            //if value less than 0 then add to totalOutcome
            if (c.getC_value() < 0) {
                totalOutcome += c.getC_value();
            }
        }
        //return total value
        return totalOutcome;
    }

    /**
     * get total money by totalIncome - totalOutcome
     */
    public long TotalMoney(Date c_date) {
        return TotalIncome(c_date) + TotalOutcome(c_date);
    }
    
    /**
     * return ID on data by row index in table
     * @param tableRow
     * @return 
     */
    public long getIdFromTable(int tableRow) {
        long c_id;
        for (int i = 0; i < list.size(); i++) {
            Cost c = list.get(i);
            //if row index = index in list
            if (tableRow == i) {
                //return c_id on database
                c_id = c.getC_id();
                return c_id;
            }
        }
        return -1;
    }
    
    /**
     * return value on database by row index in table
     * @param tableRow
     * @return 
     */
    public long getValueFromTable(int tableRow) {
        long c_value;
        for (int i = 0; i < list.size(); i++) {
            Cost c = list.get(i);
            //if row index = index in list
            if (tableRow == i) {
                //return c_value on database
                c_value = c.getC_value();
                return c_value;
            }
        }
        return -1;
    }
    
    /**
     * get ArrayList
     *
     * @return
     */
    public ArrayList<Cost> getList() {
        return list;
    }

}
