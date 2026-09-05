public class TreatmentStack {
    StackNode peak;

    public TreatmentStack() {
        peak = null;
    }

    public void placeOnTop(TreatmentRecord record) {
        StackNode added = new StackNode(record);
        added.next = peak;
        peak = added;
        System.out.println("Treatment record saved for patient " + record.pName + ".");
    }

    public TreatmentRecord takeFromTop() {
        if (peak == null) {
            System.out.println("Treatment history is empty.");
            return null;
        }
        TreatmentRecord record = peak.info;
        peak = peak.next;
        System.out.println("Latest treatment record removed for patient " + record.pName + ".");
        return record;
    }

    public void showStack() {
        if (peak == null) {
            System.out.println("Treatment history is empty.");
            return;
        }
        System.out.println("=== Treatment History ===");
        StackNode go = peak;
        int place = 1;
        while (go != null) {
            System.out.println("Record " + place + ":");
            go.info.showRecord();
            System.out.println("------------------------");
            go = go.next;
            place++;
        }
    }

    public boolean hasRecords() {
        return peak != null;
    }
}