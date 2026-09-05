public class StackNode {
    TreatmentRecord info;
    StackNode next;

    public StackNode(TreatmentRecord info) {
        this.info = info;
        this.next = null;
    }
}