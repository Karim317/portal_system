/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.portal;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Temp
 */
public class Portal {
     private Map<String, User> users;
    private static final String STUDENTS_FILE = "students.txt";

    private static final String DOCTORS_FILE = "doctors.txt";
    private static final String GRADUATES_FILE = "graduates.txt";

    public Portal() {
        users = new HashMap<>();
        initializeData();
    }
     public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }


    private void initializeData() {
        // Read data from files
        readUsersFromFile(STUDENTS_FILE, "Student");
       
        readUsersFromFile(DOCTORS_FILE, "Doctor");
        readUsersFromFile(GRADUATES_FILE, "Graduate");
    }

   private void readUsersFromFile(String fileName, String userType) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
            User user = null;
            switch (userType) {
                case "Student":
                    user = Student.fromString(line);
                    break;
                
                case "Doctor":
                    user = Doctor.fromString(line);
                    break;
                case "Graduate":
                    user = Graduate.fromString(line);
                    break;
            }
            if (user != null) {
                users.put(user.getId(), user);
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + fileName);
        // You can choose to log the exception or handle it as needed
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Portal");

        boolean continuePortal = true;
        System.out.println("Enter your ID:");
        String userId = scanner.nextLine();
        while (continuePortal) {
             User user = getUser(userId);
            if (user != null) {
                user.displayOptions();

                System.out.println("Enter your choice:");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                user.handleOption(option);

                System.out.println("Do you want to do anything else? (yes/no)");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("yes")) {
                    continuePortal = false;
                    System.out.println("Thank you for using the Portal!");
                }
            } else {
                System.out.println("User not found. Please try again.");
                break;
            }
        }
        scanner.close();
    }
}
