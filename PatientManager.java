import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PatientManager {
    public static void main(String[] args) {
        start();
    }

    private static Scanner scan = new Scanner(System.in);
    private static PriorityQueue<Patient> waitingList = new PriorityQueue<Patient>(new pcomparator());

    public static void start() {
        System.out.println("--------------------------");
        System.out.println(" (1) New Patient.");
        System.out.println(" (2) Next Patient.");
        System.out.println(" (3) waiting list.");
        System.out.println(" (4) Exit.");
        System.out.println("---------------------------");
        System.out.print("* Choose an item from the menu: ");
        String choice = scan.nextLine();

        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")) {
            System.out.println(" (X) Wrong choice.");
            System.out.print("* Choose an item from the menu: ");
            choice = scan.nextLine();
        }

        while (!choice.equals("4")) {
            if (choice.equals("1")) {
                addPatient();
            } else if (choice.equals("2")) {
                nextPatient();
            } else {
                displayWaitingList();
            }
            System.out.print("* Choose an item from the menu: ");
            choice = scan.nextLine();
            while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")) {
                System.out.println(" (X) Wrong choice.");
                System.out.print("* Choose an item from the menu: ");
                choice = scan.nextLine();
            }
        }

        System.out.println("Program terminated. Good bye!!");
    }

    public static void addPatient() {
        System.out.print(" Enter patient's name: ");
        String name = scan.nextLine();
        System.out.print(" Enter emerg [1 (low) to 5 (life-and-death)]: ");
        String emerg = scan.nextLine();
        while (!emerg.equals("1") && !emerg.equals("2") && !emerg.equals("3") && !emerg.equals("4")&& !emerg.equals("5")) {
            System.out.print("     (X) Wrong choice. Try again: ");
            emerg = scan.nextLine();
        }
        Patient p = new Patient(0, name, Integer.parseInt(emerg));
        waitingList.add(p);
        System.out.println(" Patient is added in the waiting list.");
    }

    public static void displayWaitingList() {
        if (waitingList.size() == 0) {
            System.out.println(" No patients in the list.");
        } else {
            System.out.println(" Waiting list includes: ");
            Iterator<Patient> itr = waitingList.iterator();
            while (itr.hasNext())
                System.out.println("     - " + itr.next());
        }
    }

    public static void nextPatient() {
        if (waitingList.size() == 0) {
            System.out.println(" No more patients.");
        } else {
            for (int i = 0; i < waitingList.size(); i++) {
                System.out.println(" - " + waitingList.poll() + " is treated.");
            }
        }
    }

}
