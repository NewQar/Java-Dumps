public class Student {
    private String studentName;
    private String studentID;
    private String program;
    private double test;
    private double assignment;
    private double finalMarks;

    // Default constructor
    public Student() {
        studentName = "";
        studentID = "";
        program = "";
        test = 0.0;
        assignment = 0.0;
        finalMarks = 0.0;
    }

    // Mutator methods
    public void setStudentName(String name) {
        studentName = name;
    }

    public void setStudentID(String id) {
        studentID = id;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setTest(double test) {
        this.test = test;
    }

    public void setAssignment(double assignment) {
        this.assignment = assignment;
    }

    public void setFinalMarks(double finalMarks) {
        this.finalMarks = finalMarks;
    }

    // Accessor methods
    public String getStudentName() {
        return studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getProgram() {
        return program;
    }

    public double getTest() {
        return test;
    }

    public double getAssignment() {
        return assignment;
    }

    public double getFinalMarks() {
        return finalMarks;
    }

    // toString method
    public String toString() {
        return "Student Name: " + studentName + "\n"
                + "Student ID: " + studentID + "\n"
                + "Program: " + program + "\n"
                + "Test: " + test + "\n"
                + "Assignment: " + assignment + "\n"
                + "Final Marks: " + finalMarks;
    }

    // Processor method
    public double calculateFinalMarks() {
        finalMarks = test * 0.3 + assignment * 0.2 + finalMarks * 0.5;
        return finalMarks;
    }

    // Main method
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setStudentName("John Smith");
        s1.setStudentID("12345");
        s1.setProgram("CS233");
        s1.setTest(80.0);
        s1.setAssignment(90.0);
        s1.calculateFinalMarks();

        Student s2 = new Student();
        s2.setStudentName("Jane Doe");
        s2.setStudentID("67890");
        s2.setProgram("CS233");
        s2.setTest(70.0);
        s2.setAssignment(85.0);
        s2.calculateFinalMarks();

        Student s3 = new Student();
        s3.setStudentName("Bob Johnson");
        s3.setStudentID("54321");
        s3.setProgram("CS233");
        s3.setTest(90.0);
        s3.setAssignment(80.0);
        s3.calculateFinalMarks();

        Student s4 = new Student();
        s4.setStudentName("Mary Lee");
        s4.setStudentID("09876");
        s4.setProgram("CS233");
        s4.setTest(85.0);
        s4.setAssignment(95.0);
        s4.calculateFinalMarks();

        System.out.println(s1.toString());
        System.out.println();
        System.out.println(s2.toString());
        System.out.println();
        System.out.println(s3.toString());
        System.out.println();
        System.out.println(s4.toString());
    }
}
