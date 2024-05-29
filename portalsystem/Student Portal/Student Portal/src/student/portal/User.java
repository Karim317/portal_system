/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.portal;
/**
 *
 * @author Temp
 */
public interface User {
    String getId();
    void displayOptions();
    void handleOption(int option);
}

