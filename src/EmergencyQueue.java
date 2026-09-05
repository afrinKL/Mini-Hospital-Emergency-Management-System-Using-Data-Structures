public class EmergencyQueue {
    QueueNode top;
    QueueNode bottom;

    public EmergencyQueue() {
        top = null;
        bottom = null;
    }

    public void joinLine(Patient one) {
        QueueNode added = new QueueNode(one);
        if (top == null) {
            top = added;
            bottom = added;
        } else {
            bottom.next = added;
            bottom = added;
        }
    }

    public Patient serveNext() {
        if (top == null) {
            System.out.println("Emergency queue is empty.");
            return null;
        }
        Patient serve = top.info;
        top = top.next;
        if (top == null) {
            bottom = null;
        }
        return serve;
    }

    public void showQueue() {
        if (top == null) {
            System.out.println("Emergency queue is empty.");
            return;
        }
        System.out.println("=== Waiting Patients ===");
        QueueNode go = top;
        int place = 1;
        while (go != null) {
            System.out.println("Position " + place + ":");
            go.info.showInfo();
            System.out.println("------------------------");
            go = go.next;
            place++;
        }
    }

    public boolean hasWaiting() {
        return top != null;
    }
}