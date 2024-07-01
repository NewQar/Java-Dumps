import java.io.*;
import java.util.*;
public class manipString{
    char inp;
    public static void main (String[] args) throws IOException{
    InputStreamReader stdin = new InputStreamReader (System.in);
    manipString rdp = new manipString();
    System.out.println("Enter a string:");
    rdp.parse();
    }
    void parse ()
    {
        inp = getinp();
        while (inp != '\n'){
            System.out.print(inp) ;
            inp = getinp();
        }
        System.out.print (inp) ;
    }
    char getinp ()
    {
    try
    {
    return (char)
    System.in.read();
}
    catch (IOException ioe)
    {
    System.out.println ("I0 error " + ioe);
}
    return '#'; // must return a char
}
}