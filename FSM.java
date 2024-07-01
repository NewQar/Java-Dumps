import java.io.*;
import java.util.*;
/*
Strings containing an even number of one
0 1
----------------
A* A B
B B A
----------------
*/
public class FSM{
    final static int STATES=2,INPUTS=2;
    public static void main (String[] args) throws IOException{
        boolean[] accept = new boolean [STATES];
        int[][] fsm = new int[STATES][INPUTS]; // state table
        accept[0]=true;
        accept[1]=false;
        fsm[0][0]=0;
        fsm[0][1]=1;
        fsm[1][0]=1;
        fsm[1][1]=0;
        // State A=0, State B = 1
        int inp = 0; // input symbol (0..INPUTS)
        int state = 0; // starting state;
        try{
            inp = System.in.read() - '0'; // character input,
            // convert to int.
            while (inp>=0 && inp<INPUTS){
                state = fsm[state][inp]; // next state
                inp = System.in.read() - '0'; // get next input
            }
        }
        catch (IOException ioe)
        {
        System.out.println ("IO error " + ioe);
        }
        if (accept[state])
        System.out.println ("Accepted");
        else
        System.out.println ("Rejected");
    }
}