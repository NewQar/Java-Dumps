import java.util.Scanner;
 // Soalan a:
class StudentVehicle {
    private String stickerNumber;
    private String studentNumber;
    private String studentProgram;
    private String plateNumber;
    private String vehicleType;
    

    public void setstickerNumber(String a) {
        if(a.equals(""))
            a=null;
        else
        this.stickerNumber = a;
    }
        public void setstudentNumber(String newstudentNumber) {
        this.studentNumber = newstudentNumber;
    }
        public void setstudentProgram(String newstudentProgram) {
        this.studentProgram = newstudentProgram;
    }
        public void setplateNumber(String newplateNumber) {
        this.plateNumber = newplateNumber;
    }
        public void setvehicleType(String newvehicleType) {
        this.vehicleType = newvehicleType;
    }
    // Soalan b:
    public String getstickerNumber() {
            return stickerNumber;
        }
    public String getstudentNumber() {
            return studentNumber;
        }
    public String getstudentProgram() {
            return studentProgram;
        }
    public String getplateNumber() {
            return plateNumber;
        }
    public String getvehicleType() {
            return vehicleType;
        }
        
    // Soalan c :
    public float CalcStickerCharge(){
        if(this.getvehicleType().equals("motorcycle")){
            return 2.00f;
        }
        else if(this.getvehicleType().equals("car")){
            return 4.00f;
        }
        else
            return 0.00f;
    }
}
public class Test1
{
    public static void main(String[] args) {
        Scanner awi= new Scanner(System.in);

        //Soalan d i)
        StudentVehicle studVeh[]=new StudentVehicle[100];
        String temp;
        for(int i=0;i<100;i++){
            System.out.println("Sticker Number: ");
            temp = awi.nextLine();
            studVeh[i].setstickerNumber(temp);
            System.out.println("Student Number: ");
            temp = awi.nextLine();
            studVeh[i].setstudentNumber(temp);
            System.out.println("StudentProgram: ");
            temp = awi.nextLine();
            studVeh[i].setstudentProgram(temp);
            System.out.println("Plate Number: ");
            temp = awi.nextLine();
            studVeh[i].setplateNumber(temp);
            System.out.println("Vehicle Type: ");
            temp = awi.nextLine();
            studVeh[i].setvehicleType(temp);
        }
        
        //Soalan d ii)
        int motor=0;
        for(int i=0;i<100;i++){
            if(studVeh[i].getvehicleType().equals("motorcycle")){
            motor++;
            }
        }
        System.out.println("Total Motorcycles: "+motor);
        
        // Soalan d iii)
        float total=0.00f, price=0.00f;
        for(int i=0;i<100;i++){
            price=studVeh[i].CalcStickerCharge();
            total=total+price;
        }
        System.out.println("Total Price: "+total);
    }
}
