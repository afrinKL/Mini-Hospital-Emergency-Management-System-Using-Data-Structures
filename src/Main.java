import java.util.Scanner;

public class Main {
    static PatientBST records = new PatientBST();
    static EmergencyQueue waitingLine = new EmergencyQueue();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n** Mini Hospital Emergency Management System **");
            System.out.println("1. Patient Records");
            System.out.println("2. Emergency Queue");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            int pick = scan.nextInt();
            scan.nextLine();

            if (pick == 1) {
                patientMenu();
            } else if (pick == 2) {
                queueMenu();
            } else if (pick == 3) {
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
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All Patients (In order)");
            System.out.println("5. Back to Main Menu");
            System.out.print("Your choice: ");
            int pick = scan.nextInt();
            scan.nextLine();

            if (pick == 1) {
                addPatient();
            } else if (pick == 2) {
                findPatient();
            } else if (pick == 3) {
                deletePatient();
            } else if (pick == 4) {
                records.printInOrder();
            } else if (pick == 5) {
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

    static void findPatient() {
        System.out.print("Enter Patient ID to search: ");
        int pID = scan.nextInt();
        scan.nextLine();

        Patient found = records.lookFor(pID);
        if (found != null) {
            System.out.println("Patient found:");
            found.showInfo();
        } else {
            System.out.println("Patient not found.");
        }
    }

    static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int pID = scan.nextInt();
        scan.nextLine();

        Patient found = records.lookFor(pID);
        if (found != null) {
            records.removeP(pID);
            System.out.println("Patient deleted successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    static void queueMenu() {
        boolean stay = true;
        while (stay) {
            System.out.println("\n--- Emergency Queue ---");
            System.out.println("1. Add Patient to Queue");
            System.out.println("2. Serve Next Patient");
            System.out.println("3. Show Waiting Patients");
            System.out.println("4. Back to Main Menu");
            System.out.print("Your choice: ");
            int pick = scan.nextInt();
            scan.nextLine();

            if (pick == 1) {
                addToQueue();
            } else if (pick == 2) {
                Patient served = waitingLine.serveNext();
                if (served != null) {
                    System.out.println("Patient " + served.pName + " removed for treatment.");
                }
            } else if (pick == 3) {
                waitingLine.showQueue();
            } else if (pick == 4) {
                stay = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void addToQueue() {
        System.out.print("Enter Patient ID: ");
        int pID = scan.nextInt();
        scan.nextLine();

        Patient one = records.lookFor(pID);
        if (one == null) {
            System.out.println("Patient not found. Please register the patient first.");
            return;
        }

        waitingLine.joinLine(one);
        System.out.println("Patient " + one.pName + " added to emergency queue.");
    }
}