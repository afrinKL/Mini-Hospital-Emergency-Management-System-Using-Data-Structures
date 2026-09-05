public class PatientNode {
    Patient info;
    PatientNode l;
    PatientNode r;

    public PatientNode(Patient info) {
        this.info = info;
        this.l = null;
        this.r = null;
    }
}
