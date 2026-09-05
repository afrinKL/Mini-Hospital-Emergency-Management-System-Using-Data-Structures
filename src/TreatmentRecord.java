public class TreatmentRecord {
    int pID;
    String pName;
    String detail;
    String when;

    public TreatmentRecord(int pID, String pName, String detail, String when) {
        this.pID = pID;
        this.pName = pName;
        this.detail = detail;
        this.when = when;
    }

    public void showRecord() {
        System.out.println("Patient ID     : " + pID);
        System.out.println("Patient Name   : " + pName);
        System.out.println("Treatment      : " + detail);
        System.out.println("Date           : " + when);
    }
}