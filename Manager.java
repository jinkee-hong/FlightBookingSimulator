import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Manager {

    public Customer customer = new Customer();
    public LinkedList<Customer> customerLinkedList = new LinkedList<>();

    public enum BasicInfo{
        FLIGHT_NUMBER("Flight Number"),
        SEAT_OPTIONS("Seat options"),
        ADULTS("Number of Adults"),
        KIDS("Number of Kids");
        private String str;

        BasicInfo(String str)
        {
            this.str = str;
        }

    }
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

    public void enterBasicInfo(Seats seats, Flights flights)
    {
        for( BasicInfo i :  BasicInfo.values())
        {
            System.out.println(i.str);
            System.out.println("----------------");
        }


    }

    public String inputString(String msg,Flights flights)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Input "+ msg);
        System.out.println("--------------------");
        String temp = sc.nextLine();
        int i = 0 ;
        while(true)
        {
            while (i < flights.flight_number.size()) {
                if (temp.equals(flights.flight_number.get(i))) {
                    System.out.println(".....INFO FOUNDED");
                }
                i++;
            }

            // TODO : if search can't find the flight number, be able to reenter the input

        }

        return temp;
    }

    // TODO :
    public int inputInteger(String msg,Seats seats)
    {
        return -1;
    }



    // TODO : add user purchased history
    public void exit()
    {
        System.out.println("CLOSE THE PROGRAM");
        System.exit(0);
    }

}
