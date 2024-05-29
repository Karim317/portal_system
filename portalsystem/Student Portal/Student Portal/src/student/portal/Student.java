/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.portal;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Desktop;
import java.util.Scanner;

/**
 *
 * @author Temp
 */
public class Student extends Person implements User {

    private List<Subject> subjects;
    private List<Grade> grades;

    public Student(String id) {
        super(id);
        this.subjects = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Grade> getGrades() {
        return grades;
    }
      public void addAllSubjects(List<Subject> subjectsToAdd) {
        subjects.addAll(subjectsToAdd);
    }
      public double Gpaa(){
      double totalPoints = 0;
        int totalCreditHours = 0;
        for (Grade grade : grades) {
            System.out.println("enter the grade for this course" + ":");
            Scanner inp =new Scanner(System.in);
            
            double grad= inp.nextDouble();
            
            if(97<=grad&&grad<=100){
totalPoints+=4.0;
System.out.println("the grade is : " + ": " +"A+");
}
else if(93<=grad&&grad<97){
totalPoints+=3.833333333333;
System.out.println("the grade is : " + ": " +"A");
}
else if(89<=grad&&grad<93){
totalPoints+=3.6666666666666;
System.out.println("the grade is : " + ": " +"A-");
}
else if(84<=grad&&grad<89){
totalPoints+=3.3333333333;
System.out.println("the grade is : " + ": " +"B+");
}
else if(80<=grad&&grad<84){
totalPoints+=3.0;
System.out.println("the grade is : " + ": "+"B");
}
else if(76<=grad&&grad<80){
totalPoints+=2.6666666666;
System.out.println("the grade is : " + ": " +"B-");
}
else if(73<=grad&&grad<76){
totalPoints+=2.333333333;
System.out.println("the grade is : " + ": " +"C+");
}
else if(70<=grad&&grad<73){
totalPoints+=2.0;
System.out.println("the grade is : " + ": " +"C");
}
else if(67<=grad&&grad<70){
totalPoints+=1.66666666;
System.out.println("the grade is : " + ": "+"C-");
}
else if(64<=grad&&grad<67){
totalPoints+=1.3333333;
System.out.println("the grade is : " + ": " +"D+");
}
else if(60<=grad&&grad<64){
totalPoints+=1.0;
System.out.println("the grade is : " + ": " +"D");
}
else if(0<=grad&&grad<60){
totalPoints+=0.0;
System.out.println("the grade is : " + ": " +"F");
}
else{
totalPoints+=0.0;
}

        }
        return  totalPoints / 6;
        
          
          
     
      }

    public double calculateGPA() {
        double totalPoints = 0;
        int totalCreditHours = 0;
        for (Grade grade : grades) {
            
            
            if(97<=grade.getGrade()&&grade.getGrade()<=100){
totalPoints+=4.0;
System.out.println(grade.getSubject()+","+grade.getGrade());
}
else if(93<=grade.getGrade()&&grade.getGrade()<97){
totalPoints+=3.833333333333;
System.out.println(grade.getSubject()+","+grade.getGrade());
}
else if(89<=grade.getGrade()&&grade.getGrade()<93){
totalPoints+=3.6666666666666;
System.out.println(grade.getSubject()+","+grade.getGrade());
}
else if(84<=grade.getGrade()&&grade.getGrade()<89){
totalPoints+=3.3333333333;
System.out.println(grade.getSubject()+","+grade.getGrade());
}
else if(80<=grade.getGrade()&&grade.getGrade()<84){
totalPoints+=3.0;
System.out.println(grade.getSubject()+","+grade.getGrade());
}
else if(76<=grade.getGrade()&&grade.getGrade()<80){
totalPoints+=2.6666666666;
System.out.println(grade.getSubject()+ ","+grade.getGrade());
}
else if(73<=grade.getGrade()&&grade.getGrade()<76){
totalPoints+=2.333333333;
System.out.println(grade.getSubject()+","+grade.getGrade());
}
else if(70<=grade.getGrade()&&grade.getGrade()<73){
totalPoints+=2.0;
System.out.println(grade.getSubject()+","+grade.getGrade());
}
else if(67<=grade.getGrade()&&grade.getGrade()<70){
totalPoints+=1.66666666;
System.out.println(grade.getSubject()+","+grade.getGrade());
}
else if(64<=grade.getGrade()&&grade.getGrade()<67){
totalPoints+=1.3333333;
System.out.println(grade.getSubject()+","+grade.getGrade());
}
else if(60<=grade.getGrade()&&grade.getGrade()<64){
totalPoints+=1.0;
System.out.println(grade.getSubject()+","+grade.getGrade());
}
else if(0<=grade.getGrade()&&grade.getGrade()<60){
totalPoints+=0.0;
System.out.println(grade.getSubject()+","+grade.getGrade());
}
else{
totalPoints+=0.0;
}

        }
        return  totalPoints / 6;
    }
    
    @Override
    public String getId() {
        return ID;
    }

    @Override
    public void displayOptions() {
        System.out.println("1. Open Moodle");
        System.out.println("2. View Results");
        System.out.println("3. Calculate GPA");
    }

    @Override
    public void handleOption(int option) {
        switch (option) {
            case 1:
                openMoodle();
                break;
            case 2:
                viewResults();
                break;
            case 3:
                
                displayGPA();
                break;
                default:
                    System.out.println("Invalid option!");
        }
    }
     public void openMoodle() {
     subjects.clear(); // Clear existing subjects to avoid duplicates

        try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            System.out.println("Subjects:");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 3);
                String studentId = parts[0].trim();
                String subjectName = parts[1].trim();

                if (studentId.equals(super.ID)) {
                    subjects.add(new Subject(subjectName, 3)); // Use 5 as default value for credit hours
                }
            }

            for (Subject subject : subjects) {
                System.out.println(subject);
                 }
            openLecture();
        } catch (IOException e) {
            System.out.println("Error reading subjects file.");
        }
     }
        public void displayGPA() {
        double gpaa = Gpaa();
        System.out.println("Your GPA is: " + gpaa);
    }
     public static Student fromString(String line) {
        String[] parts = line.split(",", 2);
        String id = parts[0];
        String[] subjectNames = parts[1].split(",");
        
        Student student = new Student(id);
        for (String subjectName : subjectNames) {
            student.addSubject(new Subject(subjectName.trim(), 0)); // Use 0 as default value for credit hours
        }
        
        return student;
    }
     public static Map<String, Student> fromFile(String fileName) {
        Map<String, Student> studentsMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2); // Split the line into ID and subject name
                String id = parts[0].trim();
                String subjectName = parts[1].trim();

                Student student = studentsMap.getOrDefault(id, new Student(id));
                student.addSubject(new Subject(subjectName, 5)); // Use 5 as default value for credit hours
                studentsMap.put(id, student); // Ensure that the student is added to the map
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentsMap;
    }
    
       public void viewResults() {
        if (!grades.isEmpty()) {
            System.out.println("Results:");
            for (Grade grade : grades) {
                System.out.println(grade.getSubject() + ": " + grade.getGrade());
            }
            return;
        }
        loadResultsFromFile();
        
                
        double gpa = calculateGPA();
        System.out.println("Your GPA is: " + gpa);
       }
    private void loadResultsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String studentId = parts[0].trim();
                if (studentId.equals(super.ID)) {
                    Subject subject = new Subject(parts[1].trim(), 3); // Default credit hours
                    double gradeValue = Double.parseDouble(parts[2].trim());
                    grades.add(new Grade(subject, gradeValue));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading results file.");
        }
    }
      public void openLecture() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the subject name:");
        String subjectName = scanner.nextLine();
        System.out.println("Enter the lecture number:");
        String lectureNumber = scanner.nextLine();

        // Get the desktop directory
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";

        // Find the folder corresponding to the subject name on the desktop
        File subjectFolder = new File(desktopPath, subjectName);
        if (!subjectFolder.exists() || !subjectFolder.isDirectory()) {
            System.out.println("Folder for subject " + subjectName + " not found on the desktop.");
            return;
        }

        // Construct the file path for the lecture PDF
        String filePath = subjectFolder.getAbsolutePath() + File.separator + lectureNumber + ".pdf";
        File file = new File(filePath);

        // Check if the lecture PDF exists and open it if found
        if (file.exists() && file.isFile()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                System.out.println("Error opening PDF file.");
            }
        } else {
            System.out.println("Lecture not found.");
        }
    }
    @Override
    public String toString() {
        return ID;
    }
}