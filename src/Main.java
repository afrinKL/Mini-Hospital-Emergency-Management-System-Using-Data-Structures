import java.util.Scanner;

public class Main {
    static PatientBST records = new PatientBST();
    static EmergencyQueue waitingLine = new EmergencyQueue();
    static TreatmentStack history = new TreatmentStack();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n** Mini Hospital Emergency Management System **");
            System.out.println("1. Patient Records");
            System.out.println("2. Emergency Queue");
            System.out.println("3. Treatment History");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int pick = scan.nextInt();
            scan.nextLine();

            if (pick == 1) {
                patientMenu();
            } else if (pick == 2) {
                queueMenu();
            } else if (pick == 3) {
                treatmentMenu();
            } else if (pick == 4) {
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
            System.out.println("\n--- Patient Records ---");
            System.out.println("1. Insert New Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All Patients (In order)");
            System.out.println("5. Add Visit to Patient");
            System.out.println("6. Remove Visit from Patient");
            System.out.println("7. Find a Visit");
            System.out.println("8. Show Patient Visit History");
            System.out.println("9. Back to Main Menu");
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
                addVisit();
            } else if (pick == 6) {
                removeVisit();
            } else if (pick == 7) {
                findVisit();
            } else if (pick == 8) {
                showVisitHistory();
            } else if (pick == 9) {
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

    static void addVisit() {
        System.out.print("Enter Patient ID: ");
        int pID = scan.nextInt();
        scan.nextLine();

        Patient one = records.lookFor(pID);
        if (one == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit No: ");
        int visitNo = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter Visit Date (DD/MM/YYYY): ");
        String visitDay = scan.nextLine();
        System.out.print("Enter Doctor Name: ");
        String docName = scan.nextLine();
        System.out.print("Enter Diagnosis: ");
        String finding = scan.nextLine();
        System.out.print("Enter Treatment: ");
        String care = scan.nextLine();

        Visit newVisit = new Visit(visitNo, visitDay, docName, finding, care);
        one.visits.addVisit(newVisit);
    }

    static void removeVisit() {
        System.out.print("Enter Patient ID: ");
        int pID = scan.nextInt();
        scan.nextLine();

        Patient one = records.lookFor(pID);
        if (one == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit No to remove: ");
        int visitNo = scan.nextInt();
        scan.nextLine();

        one.visits.removeVisit(visitNo);
    }

    static void findVisit() {
        System.out.print("Enter Patient ID: ");
        int pID = scan.nextInt();
        scan.nextLine();

        Patient one = records.lookFor(pID);
        if (one == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit No to find: ");
        int visitNo = scan.nextInt();
        scan.nextLine();

        Visit got = one.visits.findVisit(visitNo);
        if (got != null) {
            System.out.println("Visit found:");
            got.showVisit();
        } else {
            System.out.println("Visit not found.");
        }
    }

    static void showVisitHistory() {
        System.out.print("Enter Patient ID: ");
        int pID = scan.nextInt();
        scan.nextLine();

        Patient one = records.lookFor(pID);
        if (one == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("Visit history for " + one.pName + ":");
        one.visits.showVisits();
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

    static void treatmentMenu() {
        boolean stay = true;
        while (stay) {
            System.out.println("\n--- Treatment History ---");
            System.out.println("1. Complete a Treatment");
            System.out.println("2. Remove Latest Treatment");
            System.out.println("3. Show Treatment History");
            System.out.println("4. Back to Main Menu");
            System.out.print("Your choice: ");
            int pick = scan.nextInt();
            scan.nextLine();

            if (pick == 1) {
                completeTreatment();
            } else if (pick == 2) {
                history.takeFromTop();
            } else if (pick == 3) {
                history.showStack();
            } else if (pick == 4) {
                stay = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void completeTreatment() {
        System.out.print("Enter Patient ID: ");
        int pID = scan.nextInt();
        scan.nextLine();

        Patient one = records.lookFor(pID);
        if (one == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Treatment Details: ");
        String detail = scan.nextLine();
        System.out.print("Enter Date (DD/MM/YYYY): ");
        String when = scan.nextLine();

        TreatmentRecord record = new TreatmentRecord(pID, one.pName, detail, when);
        history.placeOnTop(record);
    }
}