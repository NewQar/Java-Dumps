public class KindergartenTeacher extends Teacher {
    private int OTHours;

    public KindergartenTeacher(String name, String icNo, int YOS, int OTHours) {
        super(name, icNo, YOS);
        this.OTHours = OTHours;
    }

    public int getOT() {
        return OTHours;
    }

    public void setOT(int OTHours) {
        this.OTHours = OTHours;
    }

    @Override
    public double calculateSalary() {
        double basicSalary;
        if (getYOS() <= 2) {
            basicSalary = 1200.00;
        } else if (getYOS() <= 5) {
            basicSalary = 1800.00;
        } else {
            basicSalary = 2000.00;
        }
        return basicSalary + (OTHours * 10);
    }

    @Override
    public String toString() {
        return super.toString() + ", Overtime Hours: " + OTHours;
    }
}
