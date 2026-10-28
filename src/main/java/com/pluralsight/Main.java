package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        // Log application launch
        logAction("launch");

        while (true) {
            System.out.print("Enter a search term (X to exit): ");
            String searchTerm = read.nextLine().trim();

            // Exit if the user enters X
            if (searchTerm.equalsIgnoreCase("X")) {
                logAction("exit");
                break;
            }

            // Log the search term
            logAction("search : " + searchTerm);
        }

        read.close();
        System.out.println("Application exited.");
    }

    // Method to log user actions to logs.txt
    // Log user actions using BufferedWriter
    public static void logAction(String action) {
        try {
            FileWriter fileWriter = new FileWriter("logs.txt", true);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");;
            String timestamp = LocalDateTime.now().format(fmt);
            writer.write(timestamp + " " + action);
            writer.newLine();

            writer.close();
            
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }
}