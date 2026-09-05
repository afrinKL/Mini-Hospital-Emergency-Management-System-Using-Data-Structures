public class PatientBST {
    PatientNode rootNode;

    public PatientBST() {
        rootNode = null;
    }

    public void add(Patient newPatient) {
        rootNode = addNode(rootNode, newPatient);
    }

    private PatientNode addNode(PatientNode current, Patient newPatient) {
        if (current == null) {
            return new PatientNode(newPatient);
        }
        if (newPatient.pID < current.info.pID) {
            current.l = addNode(current.l, newPatient);
        } else if (newPatient.pID > current.info.pID) {
            current.r = addNode(current.r, newPatient);
        }
        return current;
    }

    public void printInOrder() {
        if (rootNode == null) {
            System.out.println("No patients in the system.");
            return;
        }
        printTree(rootNode);
    }

    private void printTree(PatientNode current) {
        if (current != null) {
            printTree(current.l);
            current.info.showInfo();
            System.out.println("--------------------------------");
            printTree(current.r);
        }
    }
}
