public class Patient {
    int pID;
    String pName;
    int pAge;
    String pPhone;
    String pSickness;
    VisitList visits;

    public Patient(int pID, String pName, int pAge, String pPhone, String pSickness) {
        this.pID = pID;
        this.pName = pName;
        this.pAge = pAge;
        this.pPhone = pPhone;
        this.pSickness = pSickness;
        this.visits = new VisitList();
    }

    public void showInfo() {
        System.out.println("Patient ID   : " + pID);
        System.out.println("Patient Name : " + pName);
        System.out.println("Age          : " + pAge);
        System.out.println("Phone        : " + pPhone);
        System.out.println("Sickness     : " + pSickness);
    }
}