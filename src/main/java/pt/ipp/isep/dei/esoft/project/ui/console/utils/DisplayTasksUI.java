package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * The DisplayTasksUI class represents a user interface for displaying tasks based on user input criteria.
 */
public class DisplayTasksUI implements Runnable {

    private final String userEmail;

    /**
     * Constructs a new DisplayTasksUI with the given user email.
     *
     * @param userEmail the email of the user accessing the display tasks functionality
     */
    public DisplayTasksUI(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Runs the display tasks user interface.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate startDate;
        LocalDate endDate;
        String status;

        while (true) {
            while (true) {
                try {
                    System.out.print("Enter start date (DD-MM-YYYY): ");
                    String startDateStr = scanner.nextLine();
                    startDate = LocalDate.parse(startDateStr, dateFormatter);
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid date format. Please use DD-MM-YYYY.");
                }
            }

            while (true) {
                try {
                    System.out.print("Enter end date (DD-MM-YYYY): ");
                    String endDateStr = scanner.nextLine();
                    endDate = LocalDate.parse(endDateStr, dateFormatter);
                    if (endDate.isBefore(startDate)) {
                        System.out.println("End date must be the same or after the start date.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid date format. Please use DD-MM-YYYY.");
                }
            }

            System.out.println("Please select a task status:");
            System.out.println("1. Planned");
            System.out.println("2. Postponed");
            System.out.println("3. Canceled");
            System.out.println("4. Done");
            System.out.println("5. All");
            System.out.println("6. Go back");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    status = "Planned";
                    break;
                case 2:
                    status = "Postponed";
                    break;
                case 3:
                    status = "Canceled";
                    break;
                case 4:
                    status = "Done";
                    break;
                case 5:
                    status = "All";
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }
            DisplayTasks(startDate, endDate, status);
        }
    }

    /**
     * Checks if a given date is within a specified date range.
     *
     * @param date      the date to check
     * @param startDate the start date of the range
     * @param endDate   the end date of the range
     * @return true if the date is within the range, false otherwise
     */
    private boolean isWithinDateRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return (date.isEqual(startDate) || date.isAfter(startDate)) &&
                (date.isEqual(endDate) || date.isBefore(endDate));
    }

    /**
     * Displays tasks based on the specified criteria.
     *
     * @param startDate the start date for filtering tasks
     * @param endDate   the end date for filtering tasks
     * @param status    the status for filtering tasks
     */
    private void DisplayTasks(LocalDate startDate, LocalDate endDate, String status) {
        // ...
    }
}
