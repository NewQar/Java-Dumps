import java.util.Scanner;
class Student
{
   private String stuName;     //stores student's name
   private long stuID;         //stores student's unique ID
   private String stuProgram;  //program enrolled
   private String stuGroup;    //group registered
   private float CGPA;         //stores student's CGPA
   private int part;           //no of semester
   
   private static int count;   // for (d) method printStudent() to calculate and returns the total number of students
   
   
   //(a) default constructor that will intialize all data
   //(b) normal constructor that will initialize all data according to the data pass through the parameter
   Student(String stuName, long stuID, String stuProgram, String stuGroup, float CGPA, int part)
   {
       this.stuName = stuName;
       this.stuID = stuID;
       this.stuProgram = stuProgram;
       this.stuGroup = stuGroup;
       this.CGPA = CGPA;
       this.part = part;
       
       count++;
   }
   
    
   //(c) mutator and accessor methods for all data member
   
   //mutator method
   void setStudent (String stuName, int stuID, String stuProgram, String stuGroup, float CGPA, int part)
   {
       this.stuName = stuName;
       this.stuID = stuID;
       this.stuProgram = stuProgram;
       this.stuGroup = stuGroup;
       this.CGPA = CGPA;
       this.part = part;
   }
   
   
   //accessor method
   void getStudent()
   {
       System.out.println ("NAME : " + this.stuName);
       System.out.println ("ID : " + this.stuID);
       System.out.println ("PROGRAM : " + this.stuProgram);
       System.out.println ("GROUP : " + this.stuGroup);
       System.out.println ("CGPA : " + this.CGPA);
       System.out.println ("NO OF SEMESTER (PART) : " + this.part);
   }
   
   
   //(d) method printStudent to calculate and returns the total number of students
   public static int printStudent ()
   {
       return count;
   }
   
   
   //(e) method find (String xname) that find student information based on their name
   void find (String name)
   {
if(name.equals(stuName)){
       System.out.println ("NAME : " + this.stuName);
       System.out.println ("ID : " + this.stuID);
       System.out.println ("PROGRAM : " + this.stuProgram);
       System.out.println ("GROUP : " + this.stuGroup);
       System.out.println ("CGPA : " + this.CGPA);
       System.out.println ("NO OF SEMESTER (PART) : " + this.part);
   }
}
   
   void findCGPA (float CGPA)
   {
       if (CGPA > 3.5)
       {
           System.out.println ("NAME : " + this.stuName);
           System.out.println ("ID : " + this.stuID);
           System.out.println ("PROGRAM : " + this.stuProgram);
           System.out.println ("GROUP : " + this.stuGroup);
           System.out.println ("CGPA : " + this.CGPA);
           System.out.println ("NO OF SEMESTER (PART) : " + this.part);
       }
   }
}      
   
   

//(f) application class which contain main method
public class StudentsInfo {
    public static void main (String [] args)
    {
        Scanner awi= new Scanner(System.in);
        //(i) 5 objects of student
        //(ii) set name, ID, program name, group, CGPA and part
        Student s1 = new Student ("Haikal", 2022826302, "IT", "C", 3.21f, 2);
        Student s2 = new Student ("Nadia", 2019026462, "Business", "B", 3.58f, 4);
        Student s3 = new Student ("Emy", 2021494366, "Computer Science", "A", 4.00f, 3);
        Student s4 = new Student ("Amira", 2021049361, "Electrical", "F", 3.77f, 3);
        Student s5 = new Student ("Uwais", 2018846389, "Food Tech", "E", 3.21f, 6);
        
        //(iii) print all students’ information using method in (d).
        s1.getStudent();
        s2.getStudent();
        s3.getStudent();
        s4.getStudent();
        s5.getStudent();
        
        int total = Student.printStudent();
        System.out.println("\nTotal Student : " + total);
        
        //(iv) print particular student information by calling method in (e)
        System.out.print("Student Name: ");
        String xname = awi.nextLine();
s1.find(xname);
s2.find(xname);
s3.find(xname);
s4.find(xname);
s5.find(xname);
        
        //(v) print all students’ information who has CGPA > 3.5
        System.out.println("\nStudents with CGPA > 3.5\n");
        s1.findCGPA(3.21f);
        s2.findCGPA(3.58f);
        s3.findCGPA(4.00f);
        s4.findCGPA(3.77f);
        s5.findCGPA(3.21f);
    }
}