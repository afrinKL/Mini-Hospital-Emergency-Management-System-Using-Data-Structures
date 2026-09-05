public class Visit {
    int visitNo;
    String visitDay;
    String docName;
    String finding;
    String care;

    public Visit(int visitNo, String visitDay, String docName, String finding, String care) {
        this.visitNo = visitNo;
        this.visitDay = visitDay;
        this.docName = docName;
        this.finding = finding;
        this.care = care;
    }

    public void showVisit() {
        System.out.println("Visit No    : " + visitNo);
        System.out.println("Visit Date  : " + visitDay);
        System.out.println("Doctor      : " + docName);
        System.out.println("Diagnosis   : " + finding);
        System.out.println("Treatment   : " + care);
    }
}