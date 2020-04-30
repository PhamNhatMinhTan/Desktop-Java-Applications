/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financialmanagement;

import java.sql.Date;

/**
 *
 * @author Minh Tân
 */
public class Cost {
    //declare variables
    private long c_id;
    private int c_value;
    private String c_description;
    private Date c_date;

    /**
     * Unit class Cost
     * @param c_id
     * @param c_value
     * @param c_description
     * @param c_date 
     */
    public Cost(long c_id, String c_description, int c_value, Date c_date) {
        this.c_id = c_id;
        this.c_value = c_value;
        this.c_description = c_description;
        this.c_date = c_date;
    }

    /**
     * get c_date
     * @return 
     */
    public Date getC_date() {
        return c_date;
    }

    /**
     * set c_date
     * @param c_date 
     */
    public void setC_date(Date c_date) {
        this.c_date = c_date;
    }

    /**
     * get c_id
     * @return 
     */
    public long getC_id() {
        return c_id;
    }

    /**
     * set c_id
     * @param c_id 
     */
    public void setC_id(long c_id) {
        this.c_id = c_id;
    }

    /**
     * get c_value
     * @return 
     */
    public int getC_value() {
        return c_value;
    }

    /**
     * set c_value
     * @param c_value 
     */
    public void setC_value(int c_value) {
        this.c_value = c_value;
    }

    /**
     * get c_description
     * @return 
     */
    public String getC_description() {
        return c_description;
    }

    /**
     * set c_description
     * @param c_description 
     */
    public void setC_description(String c_description) {
        this.c_description = c_description;
    }
}
