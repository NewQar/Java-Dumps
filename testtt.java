
import java.util.Scanner;
public class testtt
{
    public static void main (String args[]){
        Scanner console=new Scanner(System.in);
	//ni untuk scanner utk masukkan input. Tanpa ni, takleh masuk input
	//console = nama panggilan untuk input. Sebelum input, letak nama panggilan scanner

        double radius, height;

        Cylinder volume = new Cylinder();
 //Cylinder = nama class, volume= nama panggilan dalam main

        System.out.println("Enter radius and height for cylinder: ");
        radius = console.nextDouble();
        height = console.nextDouble();
        volume.setvolume(radius, height);
        double vol = volume.calvolume();
        volume.printVolume(vol);
    }
}

//buat class baru untuk buat calculasi so dalam main tak kelam kabut
class Cylinder{
    public double r;
    private double h;
    private double volu;
	//ni untuk listkan nama variable untuk calculasi kot

    public int setvolume(double ra, double he){
        r = ra;
        h = he;
        //”ra” dan “he” tu saje letak nama variable gitu
        return 0;
    }

    public double calvolume(){
        return volu= 2 * 3.142 * r * h;
	//tak tahu formula betul ke tak
    }

    public void printVolume(double last){
       System.out.println("The Volume is: "+last); 
    }
	//public void sebab nak keluarkan output strings.
}
