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
public class Subject {
      private String name;
      private int creditHours;

    public Subject(String name, int creditHours) {
        this.name = name;
        this.creditHours = creditHours;
    }

    public String getName() {
        return name;
    }

    public int getCreditHours() {
        return creditHours;
    }

    @Override
    public String toString() {
        return name + " (" + creditHours + " credit hours)";
    }

    public static Subject fromString(String line) {
        String[] parts = line.split(",");
        return new Subject(parts[0], Integer.parseInt(parts[1]));
    }
}
