import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Manager {

    public Seats seats = new Seats();
    public LinkedList<Customer> customerLinkedList = new LinkedList<>();

    public enum ToolMenu{

        SEARCH("Search"),
        INSERT("Insert Data");
        private String str;

        ToolMenu(String str)
        {
            this.str = str;
        }
    }


    public enum Orders{
        ENTER_FROM("Departure"),
        ENTER_TO("Destination"),
        ENTER_DATE("Date");

        private String str;

        Orders(String str)
        {
            this.str = str;
        }

    }


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

    public Customer enterBasicInfo(Seats seats, Flights flights)
    {
        for(Orders i : Orders.values())
        {
            System.out.println(i.str);
            System.out.println("----------------");
            while(true) {
                toolMenus(flights);
            }
        }

        // TODO : return Customer Class
        return new Customer()
    }

    public String[] toolMenus( Flights flights)
    {
        Scanner sc =new Scanner(System.in);
        int choice = 0,cnt =1;
        String airport = "";

            for(ToolMenu i : ToolMenu.values())
            {
                System.out.println(cnt + ". " +i.str);
                cnt++;
            }
            choice = sc.nextInt();
            switch(choice)
            {
                case 1: // Search
                    System.out.println("INPUT SEARCH KEYWORD");
                    System.out.println("---------------------");
                    String keyword = sc.next();
                    flights.search(keyword);
                    break;
                case 2: // Input data
                    // TODO : Add input data method in Flights class
                    break;
            }
    }



    // TODO : add user purchased history
    public void exit()
    {
        System.out.println("CLOSE THE PROGRAM");
        System.exit(0);
    }

}
