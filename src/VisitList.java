public class VisitList {
    VisitNode first;

    public VisitList() {
        first = null;
    }

    public void addVisit(Visit newVisit) {
        VisitNode added = new VisitNode(newVisit);
        if (first == null) {
            first = added;
        } else {
            VisitNode go = first;
            while (go.next != null) {
                go = go.next;
            }
            go.next = added;
        }
        System.out.println("Visit " + newVisit.visitNo + " added to history.");
    }

    public void removeVisit(int visitNo) {
        if (first == null) {
            System.out.println("Visit history is empty.");
            return;
        }
        if (first.info.visitNo == visitNo) {
            first = first.next;
            System.out.println("Visit " + visitNo + " removed from history.");
            return;
        }
        VisitNode go = first;
        while (go.next != null) {
            if (go.next.info.visitNo == visitNo) {
                go.next = go.next.next;
                System.out.println("Visit " + visitNo + " removed from history.");
                return;
            }
            go = go.next;
        }
        System.out.println("Visit " + visitNo + " not found.");
    }

    public Visit findVisit(int visitNo) {
        VisitNode go = first;
        while (go != null) {
            if (go.info.visitNo == visitNo) {
                return go.info;
            }
            go = go.next;
        }
        return null;
    }

    public void showVisits() {
        if (first == null) {
            System.out.println("  No visit history.");
            return;
        }
        VisitNode go = first;
        while (go != null) {
            go.info.showVisit();
            System.out.println("------------------------");
            go = go.next;
        }
    }
}