import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     STUDENT GRADE TRACKER");
        System.out.println("=================================");

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        while (n <= 0) {
            System.out.print("Please enter a valid number of subjects: ");
            n = sc.nextInt();
        }

        String[] subjects = new String[n];
        int[] marks = new int[n];

        int total = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        String highestSubject = "";
        String lowestSubject = "";

        for (int i = 0; i < n; i++) {

            sc.nextLine();

            System.out.print("Enter subject " + (i + 1) + ": ");
            subjects[i] = sc.nextLine();

            System.out.print("Enter marks in " + subjects[i] + " (0-100): ");
            int mark = sc.nextInt();

            // Marks validation
            while (mark < 0 || mark > 100) {
                System.out.println("Invalid marks! Marks must be between 0 and 100.");
                System.out.print("Enter marks again: ");
                mark = sc.nextInt();
            }

            marks[i] = mark;
            total += marks[i];

            if (marks[i] > highest) {
                highest = marks[i];
                highestSubject = subjects[i];
            }

            if (marks[i] < lowest) {
                lowest = marks[i];
                lowestSubject = subjects[i];
            }
        }

        double average = (double) total / n;

        char grade;

        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else if (average >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        System.out.println("\n=================================");
        System.out.println("       STUDENT GRADE REPORT");
        System.out.println("=================================");

        System.out.println("Student Name: " + name);

        System.out.println("\nSubject\t\tMarks");
        System.out.println("-------------------------");

        for (int i = 0; i < n; i++) {
            System.out.println(subjects[i] + "\t\t" + marks[i]);
        }

        System.out.println("-------------------------");
        System.out.println("Total Marks: " + total);
        System.out.printf("Average Marks: %.2f%n", average);
        System.out.println("Highest Marks: " + highest + " (" + highestSubject + ")");
        System.out.println("Lowest Marks: " + lowest + " (" + lowestSubject + ")");
        System.out.println("Grade: " + grade);

        System.out.println("=================================");

        sc.close();
    }
}