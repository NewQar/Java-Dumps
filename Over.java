import java.util.Scanner;
class Student{ // constructor
    private String stuName; // stores student’s name
    private long stuID; // stores student’s unique ID
    private String stuProgram; // program enrolled
    private String stuGroup; // group registered
    private float CGPA; // stores student’s CGPA
    private int part; // no of semester
    private int nums;
    // declaraction of mutator and accessor  
    public String getName() {
        return stuName;}
    public void setName(String name) {
        this.stuName = name;}
    public long getID() {
        return stuID;}
    public void setID(long id) {
        this.stuID = id;}
    public String getPro() {
        return stuProgram;}
    public void setPro(String stuProg) {
        this.stuProgram = stuProg;}
    public String getGro() {
        return stuGroup;}
    public void setGro(String stuGro) {
        this.stuGroup = stuGro;}
    public float getCGPA() {
        return CGPA;}
    public void setCGPA(float CGPA) {
        this.CGPA = CGPA;}
    public int getPart() {
        return part;}
    public void setPart(int sem,int count) {
        this.part = sem;
        this.nums = count;
    }
    void printStudent(){ //method to print student information
        System.out.println("Name: "+stuName+"\nID: "+stuID+"\tProgram: "+stuProgram);
        System.out.println("Group: "+stuGroup+"\tCGPA: "+CGPA+"\tPart: "+part+"\n");
        if(nums==5)
            System.out.println("Total students: "+nums);
        }
    void find(String nam){
        if(nam.equals(stuName)){ //if student name is equals to the input by user
            System.out.println("Name: "+stuName+"\nID: "+stuID+"\tProgram: "+stuProgram);
            System.out.println("Group: "+stuGroup+"\tCGPA: "+CGPA+"\tPart: "+part+"\n");
        }    
    }
}
public class Over{ //default constructor
     public static void main(String[] args){
        Scanner awi= new Scanner(System.in);
        int num=1,yes=0,x=1,choice=0,c=1;
        Student stu1 = new Student();
        Student stu2 = new Student();
        Student stu3 = new Student();
        Student stu4 = new Student();
        Student stu5 = new Student();
        stu1.setName("Yusuf Al-Qardhawi"); // calling mutator methods
        stu1.setID(2021488972);
        stu1.setPro("CS");
        stu1.setGro("3A");
        stu1.setCGPA(3.9f);
        stu1.setPart(1,c);
        c++;
        stu2.setName("Amin");
        stu2.setID(2021111111);
        stu2.setPro("CS");
        stu2.setGro("3B");
        stu2.setCGPA(3.6f);
        stu2.setPart(2,c);
        c++;
        stu3.setName("Bob");
        stu3.setID(2021222222);
        stu3.setPro("CS");
        stu3.setGro("3C");
        stu3.setCGPA(3.2f);
        stu3.setPart(3,c);
        c++;
        stu4.setName("Charlie");
        stu4.setID(2021333333);
        stu4.setPro("CS");
        stu4.setGro("3D");
        stu4.setCGPA(3.1f);
        stu4.setPart(4,c);
        c++;
        stu5.setName("Damia");
        stu5.setID(2021444444);
        stu5.setPro("CS");
        stu5.setGro("3E");
        stu5.setCGPA(4.0f);
        stu5.setPart(5,c);
        while(yes==0){
            if(choice==0){ //main menu interface
                System.out.println("Menu:\n1) Print All Student Information\n2) Find Specific Student");
                System.out.println("3) CGPA 3.5>\n4) Exit");
                choice= awi.nextInt();}
            if(choice==1){ //print all student info
                stu1.printStudent();
                stu2.printStudent();
                stu3.printStudent();
                stu4.printStudent();
                stu5.printStudent();
                choice=0;
            }
                if(choice==2){ //finding specific student
                String xname="Ada ah";
                    while(!xname.equals("0")){
                    System.out.println("Which student would you like to know?(Type 0 to stop)");
                    xname= awi.nextLine();//string input by user
                    stu1.find(xname);
                    stu2.find(xname);
                    stu3.find(xname);
                    stu4.find(xname);
                    stu5.find(xname);
                }
                choice=0;
            }
                if(choice==3){//comparing students cgpa
                System.out.println("\nStudents with over 3.5 CGPA:\n");
                if(stu1.getCGPA()>3.5f)
                stu1.printStudent();
                if(stu2.getCGPA()>3.5f)
                stu2.printStudent();
                if(stu3.getCGPA()>3.5f)
                stu3.printStudent();
                if(stu4.getCGPA()>3.5f)
                stu4.printStudent();
                if(stu5.getCGPA()>3.5f)
                stu5.printStudent();
                choice=0;
            }
            if(choice==4){ //exit program
                yes=1;
            }
        }
    }
}

