
/**
 * Write a description of class Lab3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Lab3
{
    public static void main (String args[]){
        Scanner console=new Scanner(System.in);
        // volume of cylinder = 2 * pie * radius * height
        double radius, height;
        Cylinder volume = new Cylinder(); // default constructor
        System.out.println("Enter radius and height for cylinder: ");
        radius = console.nextDouble();
        height = console.nextDouble();
        volume.setvolume(radius, height);
        double vol = volume.calvolume();
        volume.printVolume(vol);
    }
}
class Cylinder{
    private double r;
    private double h;
    private double volu;
    public int setvolume(double ra, double he){
        r = ra;
        h = he;
        //ra dan he tu saje letak nama variable gitu
        return 0;
    }
    public double calvolume(){
        return volu= 2 * 3.142 * r * h;
    }
    public void printVolume(double last){
       System.out.println("The Volume is: "+last); 
    }
}
