public class SchoolTeacher extends Teacher {
    private String grade;

    public SchoolTeacher(String name, String icNo, int YOS, String grade) {
        super(name, icNo, YOS);
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public double calculateSalary() {
        switch (grade) {
            case "DG41":
                return 1900.00;
            case "DG44":
                return 3300.00;
            case "DG48":
                return 4900.00;
            case "DG52":
                return 5500.00;
            default:
                return 0.00;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Grade: " + grade;
    }
}
