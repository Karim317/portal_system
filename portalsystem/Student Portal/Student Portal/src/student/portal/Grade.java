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
public class Grade {
     private Subject subject;
    private double grade;

    public Grade(Subject subject, double grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public Subject getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return subject.getName() + ": " + grade;
    }

    public static Grade fromString(String line) {
        String[] parts = line.split(",");
        Subject subject = new Subject(parts[0], Integer.parseInt(parts[1]));
        return new Grade(subject, Double.parseDouble(parts[2]));
    }
}
