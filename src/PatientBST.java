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

    public Patient lookFor(int wantedID) {
        return searchNode(rootNode, wantedID);
    }

    private Patient searchNode(PatientNode current, int wantedID) {
        if (current == null) {
            return null;
        }
        if (current.info.pID == wantedID) {
            return current.info;
        }
        if (wantedID < current.info.pID) {
            return searchNode(current.l, wantedID);
        }
        return searchNode(current.r, wantedID);
    }

    public void removeP(int goneID) {
        rootNode = removeNode(rootNode, goneID);
    }

    private PatientNode removeNode(PatientNode current, int goneID) {
        if (current == null) {
            return null;
        }
        if (goneID < current.info.pID) {
            current.l = removeNode(current.l, goneID);
        } else if (goneID > current.info.pID) {
            current.r = removeNode(current.r, goneID);
        } else {
            if (current.l == null) {
                return current.r;
            } else if (current.r == null) {
                return current.l;
            }
            current.info = findSmallest(current.r);
            current.r = removeNode(current.r, current.info.pID);
        }
        return current;
    }

    private Patient findSmallest(PatientNode current) {
        while (current.l != null) {
            current = current.l;
        }
        return current.info;
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