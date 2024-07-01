public abstract class Teacher {
    private String name;
    private String icNo;
    private int YOS;

    public Teacher(String name, String icNo, int YOS) {
        this.name = name;
        this.icNo = icNo;
        this.YOS = YOS;
    }

    public String getName() {
        return name;
    }

    public String getIC() {
        return icNo;
    }

    public int getYOS() {
        return YOS;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Name: " + name + ", Salary: " + calculateSalary();
    }
}
