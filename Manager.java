import java.io.IOException;
import java.util.Scanner;

public class Manager {

    public Seats seats = new Seats();



    public enum Options
    {
        BOOK_FLIGHTS("Book a flight"),
        BOOK_SEATS("Book seats"),
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
        System.out.println("\t\t\t\t" + "FLIGHT SIMULATOR");
        System.out.println("**********************************");

        return printOptions();
    }



    public int printOptions()
    {
        int cnt = 1 ;

        for(Options i : Options.values())
        {
            System.out.println(cnt +". " + i.str);
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

    // TODO : add user purchased history
    public void exit()
    {
        System.out.println("CLOSE THE PROGRAM");
    }

}
