package com.bugtracker;

import com.bugtracker.model.*;
import com.bugtracker.service.BugService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BugService service = new BugService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== BUG TRACKING SYSTEM ===");
            System.out.println("1. Report a Bug");
            System.out.println("2. View All Bugs");
            System.out.println("3. Update Bug Status");
            System.out.println("4. Assign Bug");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

                case 1: {
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Description: ");
                    String desc = scanner.nextLine();

                    // Assign new bug to userId=1, status=OPEN, priority=MEDIUM
                    service.createBug(title, desc, Priority.Medium, Status.Open, 1);
                    break;
                }

                case 2:
                    service.displayAllBugs();
                    break;

                case 3: {
                    System.out.print("Bug ID: ");
                    int bugId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Choose status: 1.Open 2.In_Progress 3.Resolved 4.Closed");
                    int statusChoice = scanner.nextInt();
                    scanner.nextLine();

                    Status newStatus;
                    switch (statusChoice) {
                        case 1 -> newStatus = Status.Open;
                        case 2 -> newStatus = Status.In_Progress;
                        case 3 -> newStatus = Status.Resolved;
                        case 4 -> newStatus = Status.Closed;
                        default -> {
                            System.out.println("Invalid status, defaulting to OPEN");
                            newStatus = Status.Open;
                        }
                    }

                    service.updateStatus(bugId, newStatus);
                    break;
                }

                case 4: {
                    System.out.print("Bug ID: ");
                    int bugId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Developer ID to assign: ");
                    int devId = scanner.nextInt();
                    scanner.nextLine();

                    service.assignBug(bugId, devId);
                    break;
                }

                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}

