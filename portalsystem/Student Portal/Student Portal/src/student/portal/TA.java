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
public class TA implements User {
    private String id;

    public TA(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void displayOptions() {
        System.out.println("1. Assist Students");
    }

    @Override
    public void handleOption(int option) {
        if (option == 1) {
            assistStudents();
        } else {
            System.out.println("Invalid option!");
        }
    }

    private void assistStudents() {
        System.out.println("Assisting students...");
    }

    public static TA fromString(String line) {
        String[] parts = line.split(",");
        return new TA(parts[0]);
    }

    @Override
    public String toString() {
        return id;
    }
    
}
