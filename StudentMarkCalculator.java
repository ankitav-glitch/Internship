
import java.util.Scanner;

public class StudentMarkCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        // Input validation for number of subjects
        if (numberOfSubjects <= 0) {
            System.out.println("Number of subjects must be a positive integer.");
            scanner.close();
            return;
        }

        int totalMarksObtained = 0;
        int maximumPossibleMarks = numberOfSubjects * 100; // Each subject is out of 100

        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.printf("Enter marks for Subject %d (out of 100): ", i);
            int marks = scanner.nextInt();

            // Input validation for marks
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Marks must be between 0 and 100. Please re-enter.");
                i--; // Decrement i to re-enter marks for the current subject
                continue;
            }
            totalMarksObtained += marks;
        }

        // Calculate percentage
        double percentage = (double) totalMarksObtained / maximumPossibleMarks * 100;

        System.out.println("\n--- Results ---");
        System.out.println("Total Marks Obtained: " + totalMarksObtained);
        System.out.println("Maximum Possible Marks: " + maximumPossibleMarks);
        System.out.printf("Percentage: %.2f%%\n", percentage);

        scanner.close();
    }
}