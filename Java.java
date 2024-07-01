
/**
 * Write a description of class Java here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Java
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int code=5;
        String resitype="o";
        while(code>4){
            System.out.println("Enter code (1/2/3/4): ");
            code=sc.nextInt();
            if(code>4){
            System.out.println("Wrong entry! Please enter again");
            }
        }
        if(code == 1){
        resitype = "house";
        }
        else if (code == 2){
        resitype = "office";
        }
        else if (code == 3){
            resitype = "factory";
        }
        else if (code == 4){
            resitype = "mosque and religious and charity welfare";
        }
        System.out.println(resitype);
    }
}


