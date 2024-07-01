import java.util.Scanner;

public abstract class ZooTaiping {
    private String visitorName;
    private String icNumber;
    private boolean govServant;
    public ZooTaiping(String name, String ic, boolean govServ) {
        public class TestZoo {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            // Declare an array of objects to store 20 data information
            ZooTaiping[] visitors = new ZooTaiping[20];
            // Get input from user regarding all the information required
            System.out.print("Enter the number of visitors: ");
            int numVisitors = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            for (int i = 0; i < numVisitors; i++) {
                System.out.print("Enter visitor name: ");
                String name = scanner.nextLine();
                System.out.print("Enter IC number: ");
                String icNumber = scanner.nextLine();
                System.out.print("Is visitor a government servant (true/false): ");
                boolean govServant = scanner.nextBoolean();
                System.out.print("Enter visit type (day/night): ");
                String visitType = scanner.next();
                if (visitType.equalsIgnoreCase("day")) {
                    System.out.print("Enter number of children: ");
                    int childrenCount = scanner.nextInt();
                    visitors[i] = new DayVisit(name, icNumber, govServant, childrenCount);
                } else if (visitType.equalsIgnoreCase("night")) {
                    System.out.print("Choose package (A/B/C): ");
                    String packageChoice = scanner.next();
                    boolean packageA = false;
                    boolean packageB = false;
                    boolean packageC = false;
                    if (packageChoice.equalsIgnoreCase("A")) {
                        packageA = true;
                    } else if (packageChoice.equalsIgnoreCase("B")) {
                        packageB = true;
                    } else if (packageChoice.equalsIgnoreCase("C")) {
                        packageC = true;
                    }
                    visitors[i] = new NightVisit(name, icNumber, govServant, packageA, packageB, packageC);
                }
                scanner.nextLine(); // Consume newline character
            }
    
            // Calculate and display the number of visitors for each category and the total income for the Zoo Taiping
            int numDayVisitors = 0;
            int numNightVisitors = 0;
            double totalIncome = 0;
            for (ZooTaiping visitor : visitors) {
                if (visitor == null) {
                    break;
                }
                if (visitor instanceof DayVisit) {
                    numDayVisitors++;
                } else if (visitor instanceof NightVisit) {
                    numNightVisitors++;
                }
                totalIncome += visitor.totalCharges();
            }
            System.out.println("Number of day visitors: " + numDayVisitors);
        }
    }
    public abstract double totalCharges();
    }
}
public class DayVisit extends ZooTaiping {
    private String category;
    private int childrenCount;
    
    public DayVisit(String name, String ic, boolean govServ, String category, int childrenCount) {
        super(name, ic, govServ);
        this.category = category;
        this.childrenCount = childrenCount;
    }
    
    public double totalCharges() {
        double charges = 0;
        // Calculate charges for day visit
        // Charges for adult
        charges += 25.00;
        // Charges for children
        charges += childrenCount * 15.00;
        // Apply discount for government servant
        if (govServant){
            charges *= 0.85;
        }
        return charges;
    }
}

public class NightVisit extends ZooTaiping {
    private boolean packageA; //if the visitor choose package A
    private boolean packageB; //if the visitor choose package B
    private boolean packageC; //if the visitor choose package C
    
    public NightVisit(String name, String ic, boolean govServ, boolean packageA, boolean packageB, boolean packageC) {
        super(name, ic, govServ);
        this.packageA = packageA;
        this.packageB = packageB;
        this.packageC = packageC;
    }
}