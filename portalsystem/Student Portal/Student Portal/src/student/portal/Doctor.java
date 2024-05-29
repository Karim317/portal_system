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
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Doctor  extends Person  implements User {
    //private String id;
    private List<Lecture> lectures;
    private List<String> grades;

    public Doctor(String id) {
        super(id);
        this.lectures = new ArrayList<>();
        this.grades = new ArrayList<>();
    }
    @Override
    public String getId() {
        return super.ID;
    }

    @Override
    public void displayOptions() {
        System.out.println("1. Add Lecture");
        System.out.println("2. Delete Lecture");
        System.out.println("3. Add Grades");
    }

    @Override
    public void handleOption(int option) {
        switch (option) {
            case 1:
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the lecture name to add:");
                String lectureName = scanner.nextLine();
                System.out.println("Enter the subject name:");
                String subjectName = scanner.nextLine();
                System.out.println("Enter the file path:");
                String filePath = scanner.nextLine();
                addLecture(lectureName, subjectName, filePath);
                break;
            case 2:
                Scanner scannerr=new Scanner(System.in);
                System.out.println("Enter the lecture name to delete:");
                String lectureNameToDelete = scannerr.nextLine();
                System.out.println("Enter the subject name:");
                String subjectNameToDelete = scannerr.nextLine();
                deleteLecture(lectureNameToDelete, subjectNameToDelete);
                break;  
            case 3:
                Scanner scannerrr=new Scanner(System.in);
                System.out.println("Enter the student ID:");
                String studentId = scannerrr.nextLine();
                System.out.println("Enter the subject name:");
                String subjectNameForGrade = scannerrr.nextLine();
                System.out.println("Enter the grade:");
                String grade = scannerrr.nextLine();
                addGrade(studentId, subjectNameForGrade, grade);
                break;
                default:
                System.out.println("Invalid option!");
        }
    }

    private void addLecture(String lectureName, String subjectName, String filePath) {
        Lecture lecture = new Lecture(lectureName, subjectName, filePath);
        lectures.add(lecture);
        System.out.println("Lecture added: " + lecture);
    }

   
     private void deleteLecture(String lectureName, String subjectName) {
        Lecture lectureToRemove = null;
        for (Lecture lecture : lectures) {
            if (lecture.lectureName.equals(lectureName) && lecture.subjectName.equals(subjectName)) {
                lectureToRemove = lecture;
                break;
            }
        }
        if (lectureToRemove != null) {
            lectures.remove(lectureToRemove);
            System.out.println("Lecture deleted: " + lectureToRemove);
        } else {
            System.out.println("Lecture not found: " + lectureName + " (" + subjectName + ")");
        }
    }

    private void addGrade(String studentId, String subjectName, String grade) {
        File inputFile = new File("students.txt");
        File tempFile = new File("students_temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String currentLine;
            boolean found = false;

            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",", -1);
                if (parts[0].trim().equals(studentId) && parts[1].trim().equals(subjectName)) {
                    found = true;
                    parts[2] = grade; // Update the grade for the subject
                    writer.write(String.join(",", parts));
                    writer.newLine();
                } else {
                    writer.write(currentLine);
                    writer.newLine();
                }
            }

            if (!found) {
                System.out.println("Student ID or subject not found: " + studentId + ", " + subjectName);
            }

        } catch (IOException e) {
            System.out.println("Error processing file.");
            e.printStackTrace();
        }

        // Replace the original file with the updated file
        if (!inputFile.delete()) {
            System.out.println("Could not delete original file");
        } else if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename temp file");
        }
    }
    public static Doctor fromString(String line) {
        String[] parts = line.split(",");
        return new Doctor(parts[0]);
    }

    @Override
    public String toString() {
        return super.ID;
    }
}


