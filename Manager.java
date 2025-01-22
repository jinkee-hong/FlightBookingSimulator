import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class Manager {
    public Reservation reservation = new Reservation();
    public Flights flights = new Flights();
    public Seats seats =  new Seats();


    public enum Options
    {
        FLIGHT_LIST("see the flight list"),
        RESERVATION("Make a Reservation"),
        CHECK_RESERVATION("Check the Reservation"),
        DELETE_RESERVATION("Delete the Reservation"),
        EXIT("Close the program");
        private String str = null;

        Options(String str)
        {
            this.str = str;
        }

    }

    Manager() throws IOException {}


    public int startScreen()
    {
        System.out.println("**********************************");
        System.out.println("\t\t" + "FLIGHT SIMULATOR");
        System.out.println("**********************************");

        return printOptions();
    }

    public int printOptions()
    {
        int cnt = 1 ;

        for(Options i : Options.values())
        {
            System.out.println(cnt +". " + i.str);
            cnt++;
        }

        return choiceOptions();
    }

    public int choiceOptions()
    {
        Scanner sc = new Scanner(System.in);
        int sel = -1;

        do {
            sel = sc.nextInt();
            if(sel < 1 && sel > Options.values().length-1)
            {
                System.out.println("WRONG ACCESS");
            }
        }while(sel < 1 && sel > Options.values().length-1);

        return sel;
    }

    public boolean isInteger(String sample)
    {
        for (int i = 0; i < sample.length(); i++) {
            if(48 <= sample.charAt(i)&&sample.charAt(i)<= 57)
            {
                return true;
            }
        }
        return false;
    }


    // TODO : add user purchased history
    public void exit()
    {
        System.out.println("CLOSE THE PROGRAM");
        System.exit(0);
    }

}
