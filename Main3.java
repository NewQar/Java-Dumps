 import java.util.Scanner;
class Student {
    
        private String stuName;
        private long stuID;
        private String stuPro;
        private String stuGroup;
        private float CGPA;
        private int part;
        private int nums;
        
//setters
        public void setstuName(String newstuName) {
            stuName = newstuName;
        }
        public void setstuID(long newstuID) {
            stuID = newstuID;
        }
        public void setstuPro(String newstuPro) {
            stuPro = newstuPro;
        }
        public void setstuGroup(String newstuGroup) {
            stuGroup = newstuGroup;
        }
        public void setCGPA(float newCGPA) {
            CGPA = newCGPA;
        }
        public void setpart(int newpart,int count) {
            part = newpart;
            nums = count;
        }
//getters
        public String getName() {
            return stuName;
        }
        public long getID() {
            return stuID;
        }
        public String getPro() {
            return stuPro;
        }
        public String getGro() {
            return stuGroup;
        }
        public float getCGPA() {
            return CGPA;
        }
        public long getpart() {
            return part;
        }
            
        void printStudent(){
                System.out.println("Name: "+stuName+"\nID: "+stuID+"\tProgram: "+stuPro);
                System.out.println("Group: "+stuGroup+"\tCGPA: "+CGPA+"\tPart: "+part+"\n");
                if(nums==5)
                    System.out.println("Total students: "+nums);
                }
        void find(String nam){
                if(nam.equals(stuName)){
                    System.out.println("Name: "+stuName+"\nID: "+stuID+"\tProgram: "+stuPro);
                    System.out.println("Group: "+stuGroup+"\tCGPA: "+CGPA+"\tPart: "+part+"\n");
                }    

        }
}
public class Main3 {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        int num=1,yes=0,x=1,choice=0,c=1;
        
        Student stu1 = new Student();
        stu1.setstuName("Aiman");
        stu1.setstuID(01);
        stu1.setstuPro("Computer science");
        stu1.setstuGroup("3A");
        stu1.setCGPA((float) 4.0);
        stu1.setpart(3, c);
        
    //student 2
        c++;
        Student stu2 = new Student();
        stu2.setstuName("Adam");
        stu2.setstuID(02);
        stu2.setstuPro("Computer science");
        stu2.setstuGroup("3A");
        stu2.setCGPA((float) 3.9);
        stu2.setpart(3, c);
        
    //student 3
        c++;
        Student stu3 = new Student();
        stu3.setstuName("Muaz");
        stu3.setstuID(03);
        stu3.setstuPro("Computer science");
        stu3.setstuGroup("3A");
        stu3.setCGPA((float) 3.8);
        stu3.setpart(3, c);
        
    //student 4
        c++;
        Student stu4 = new Student();
        stu4.setstuName("Mikail");
        stu4.setstuID(04);
        stu4.setstuPro("Computer science");
        stu4.setstuGroup("3B");
        stu4.setCGPA((float) 3.4);
        stu4.setpart(3, c);
        
    //student 5
        c++;
        Student stu5 = new Student();
        stu5.setstuName("Sarah");
        stu5.setstuID(01);
        stu5.setstuPro("Computer science");
        stu5.setstuGroup("3B");
        stu5.setCGPA((float) 3.3);
        stu5.setpart(3, c);
        
        while(yes==0){
            if(choice==0){
                System.out.println("Menu:\n1) Print All Student Information\n2) Find Specific Student");
                System.out.println("3) CGPA 3.5>\n4) Exit");
                choice= s.nextInt();}
            if(choice==1){
                stu1.printStudent();
                stu2.printStudent();
                stu3.printStudent();
                stu4.printStudent();
                stu5.printStudent();
                choice=0;
            }
                if(choice==2){
                String xname="Ada ah";
                    while(!xname.equals("0")){
                    System.out.println("Please enter student name(Type 0 to stop)");
                    xname= s.nextLine();
                    stu1.find(xname);
                    stu2.find(xname);
                    stu3.find(xname);
                    stu4.find(xname);
                    stu5.find(xname);
                }
                choice=0;
            }
                if(choice==3){
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
            if(choice==4){
                yes=1;
            }

        
        
    }

    }
}
