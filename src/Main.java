import java.util.Scanner;

public class Main {
    static PatientBST records = new PatientBST();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n** Mini Hospital Emergency Management System **");
            System.out.println("1. Patient Records");
            System.out.println("2. Exit");
            System.out.print("Your choice: ");
            int pick = scan.nextInt();
            scan.nextLine();

            if (pick == 1) {
                patientMenu();
            } else if (pick == 2) {
                System.out.println("Thank you for using the system.");
                running = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scan.close();
    }

    static void patientMenu() {
        boolean stay = true;
        while (stay) {
            System.out.println("\n--- Patient Records (BST) ---");
            System.out.println("1. Insert New Patient");
            System.out.println("2. Display All Patients (In order)");
            System.out.println("3. Back to Main Menu");
            System.out.print("Your choice: ");
            int pick = scan.nextInt();
            scan.nextLine();

            if (pick == 1) {
                addPatient();
            } else if (pick == 2) {
                records.printInOrder();
            } else if (pick == 3) {
                stay = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int pID = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter Patient Name: ");
        String pName = scan.nextLine();
        System.out.print("Enter Age: ");
        int pAge = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter Phone Number: ");
        String pPhone = scan.nextLine();
        System.out.print("Enter Sickness: ");
        String pSickness = scan.nextLine();

        Patient one = new Patient(pID, pName, pAge, pPhone, pSickness);
        records.add(one);
        System.out.println("Patient added successfully.");
    }
}
