# Mini Hospital Emergency Management System Using Data Structures

A simple Java console application that manages patients in a mini hospital using core data structures.

## Features

- **Patient Records** - a Binary Search Tree (BST) to add, search, delete, and display patients sorted by ID
- **Patient Visit History** - a Linked List that stores each patient's visits
- **Emergency Queue** - a Queue that processes patients by the order they arrive
- **Treatment History** - a Stack that records past treatments (last one on top)

## Data Structures Used

| Data Structure | Purpose |
| -------------- | ------- |
| Binary Search Tree (BST) | Store and sort patient records |
| Linked List | Keep visit history for each patient |
| Queue | Manage the emergency waiting line (First In, First Out) |
| Stack | Track treatment history (Last In, First Out) |

## How to Run

Make sure you have **Java installed**. Then run:

```bash
javac *.java
java Main
```

Or, if you are in the `src` folder:

```bash
cd src
javac *.java
java Main
```

## How to Use

1. Choose **Patient Records** to add or search patients.
2. Choose **Emergency Queue** to add patients to the waiting line and serve them in order.
3. Choose **Treatment History** to view past treatments.
4. Choose **Exit** to close the program.

## Project Structure

```
src/
  Main.java           - menu and program flow
  Patient.java        - patient details
  PatientNode.java    - a single node in the BST
  PatientBST.java     - BST implementation
  Visit.java          - a single visit record
  VisitNode.java      - a node in the visit linked list
  VisitList.java      - linked list implementation
  QueueNode.java      - a node in the queue
  EmergencyQueue.java - queue implementation
  StackNode.java      - a node in the stack
  TreatmentRecord.java- treatment info
  TreatmentStack.java - stack implementation
```

## Built With

- Java
- Core Data Structures (BST, Linked List, Queue, Stack)