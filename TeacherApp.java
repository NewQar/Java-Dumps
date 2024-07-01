public class TeacherApp {
    public static void main(String[] args) {
        final int N = 5;
        Teacher tList[] = new Teacher[N];

        tList[0] = new SchoolTeacher("Nur Ain", "910521102560", 3, "DG48");
        tList[1] = new KindergartenTeacher("Nur Aiman", "910118015871", 5, 15);
        tList[2] = new SchoolTeacher("Zakiah", "830120144540", 7, "DG41");
        tList[3] = new KindergartenTeacher("Mohd Ashraf", "851003013453", 15, 10);
        tList[4] = new SchoolTeacher("Ramlan", "930701106673", 7, "DG48");

        // Display the list of name and salary of teachers with grade DG48
        System.out.println("Teachers with Grade DG48:");
        for (Teacher teacher : tList) {
            if (teacher instanceof SchoolTeacher) {
                SchoolTeacher schoolTeacher = (SchoolTeacher) teacher;
                if (schoolTeacher.getGrade().equals("DG48")) {
                    System.out.println(teacher);
                }
            }
        }

        // Calculate and display the total overtime hours done by kindergarten teachers
        int totalOTHours = 0;
        for (Teacher teacher : tList) {
            if (teacher instanceof KindergartenTeacher) {
                KindergartenTeacher kindergartenTeacher = (KindergartenTeacher) teacher;
                totalOTHours += kindergartenTeacher.getOT();
            }
        }
        System.out.println("Total Overtime Hours for Kindergarten Teachers: " + totalOTHours);

        // Display the information of kindergarten teacher who got the highest salary
        double maxSalary = 0.0;
        KindergartenTeacher maxSalaryKindergartenTeacher = null;
        for (Teacher teacher : tList) {
            if (teacher instanceof KindergartenTeacher) {
                KindergartenTeacher kindergartenTeacher = (KindergartenTeacher) teacher;
                if (kindergartenTeacher.calculateSalary() > maxSalary) {
                    maxSalary = kindergartenTeacher.calculateSalary();
                    maxSalaryKindergartenTeacher = kindergartenTeacher;
                }
            }
        }
        System.out.println("Kindergarten Teacher with the Highest Salary: " + maxSalaryKindergartenTeacher);
    }
}
