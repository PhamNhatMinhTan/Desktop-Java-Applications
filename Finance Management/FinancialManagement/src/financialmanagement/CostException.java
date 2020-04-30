/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financialmanagement;

/**
 *
 * @author Minh Tân
 */
public class CostException extends Exception{
    /**
     * Create new cost exception
     * @param message 
     */
    public CostException(String message) {
        super("Exception: " + message);
    }
}
