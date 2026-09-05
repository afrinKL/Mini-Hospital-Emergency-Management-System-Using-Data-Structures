public class QueueNode {
    Patient info;
    QueueNode next;

    public QueueNode(Patient info) {
        this.info = info;
        this.next = null;
    }
}