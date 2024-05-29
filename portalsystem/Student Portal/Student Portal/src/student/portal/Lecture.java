/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.portal;

/**
 *
 * @author Jomana
 */
public class Lecture {
    String lectureName;
    String subjectName;
    String filePath;

   public Lecture(String lectureName, String subjectName, String filePath) {
        this.lectureName = lectureName;
        this.subjectName = subjectName;
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return lectureName + " (" + subjectName + ") - " + filePath;
    }
}
