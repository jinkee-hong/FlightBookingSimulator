import java.io.IOException;
import java.util.*;

public class Reservation implements Airport {
    private final int SEARCH_HELP_ENGAGED = 5;
    public enum Guest{
        ADULTS("adults"),
        KIDS("Kids"),
        BABY("Babies"); // included just in case.
        private String str;
        Guest(String str)
        {
            this.str =str;
        }
        public String getStr() {
            return str;
        }
    }
    public enum BasicInfo{
        FLIGHT_NUMBER("Flight Number"),
        ADULTS("Number of Adults"),
        KIDS("Number of Kids"),
        SEAT_OPTIONS("Seat options");

        private String str;

        BasicInfo(String str)
        {
            this.str = str;
        }

    }
    public Customer enterBasicInfo(Seats seats, Flights flights)
    {
        Vector<String> temp = new Vector<>();
        HashMap<String,Integer> seatRelation = new HashMap<>();

        for( BasicInfo i :  BasicInfo.values())
        {
            System.out.println("> ENTER THE "+ i.str);
            System.out.println("---------------------------");

             if(i.str.equals(BasicInfo.FLIGHT_NUMBER.str)) {
                 System.out.println("** THE INPUT HAS TO BE 8 CHARACTERS **");
                 System.out.println();
                 temp.add(reservation(i.str, flights));
             }
            else {
                 temp.add(reservation(i.str, seats));
                 selectSeatType(seatRelation,Integer.parseInt(temp.get(1).trim()),Integer.parseInt(temp.get(2).trim()));

             }

        }
        return new Customer(temp,seatRelation);
    }

    public void selectSeatType(HashMap<String,Integer> seatRelation, int adults, int kids)
    {
        Scanner sc= new Scanner(System.in);
        int counter = 0,limit = -1 ;

        System.out.println("\t\t\t\t\tNOTICE");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("[* ROW 0 TO ROW "+ PLANE_ROW * PLANE_COL / 2+"IS BUSINESS SEATS AREA *]");
        System.out.println("\t\t[* THE REST OF SEATS IS ECONOMY SEATS *]");
        System.out.println("-----------------------------------------------------------------");

            // Show how much class they got for seats
            for(Seats.SeatOptions i : Seats.SeatOptions.values())
            {
                System.out.println((counter+1) + ". " + i.getStr());
            }

            // adults seat type
        for(int i = 0 ; i < adults ; i++) {
            do {
                System.out.println( (i+1) + " PLEASE SELECT SEAT TYPE FOR" + Guest.ADULTS.getStr());
                System.out.println("--------------------------------------------------------------");
                limit = sc.nextInt();
            } while (limit > 0 && limit < Seats.SeatOptions.values().length);
            seatRelation.put(Guest.ADULTS.getStr(),limit);
        }

        // kids seats type
        for(int i = 0 ; i < kids ; i++) {
            do {
                System.out.println( (i+1) + " PLEASE SELECT SEAT TYPE FOR" + Guest.KIDS.getStr());
                System.out.println("--------------------------------------------------------------");
                limit = sc.nextInt();
            } while (limit > 0 && limit < Seats.SeatOptions.values().length);
            seatRelation.put(Guest.KIDS.getStr(),limit);
        }
    }

    /**Reservation for seats*/
    public String reservation(String msg,Seats seats )
    {
        //TODO : input row and cols of the seat according to the seat type
        // TODO : It has to be limited by the seat type ( 1, 2)



        // Select Row and col for matching seat type

        return null;
    }


    public String reservation(String msg,Flights flights)
    {
        Scanner sc= new Scanner(System.in);
        String num = "";
        int idx = 0,round = 0;
        do
        {
            if(idx == 0)
            {
                if(round >= 1)
                {
                    System.out.println("PLEASE MAKE A CORRECT INPUT FOR " + msg);
                    System.out.println("-------------------------------------");
                }
                num = sc.next();
            }
            idx++;
            idx %=  flights.flight_number.size() ;
            round++;
        }while(Integer.parseInt(num) != flights.flight_number.get(idx));

        return  num;
    }

    @Override
    public void startScreen(String theme) throws IOException {

    }

    @Override
    public void showList() throws IOException {

    }

    @Override
    public LinkedList<?> deleteUserInfo() {
        return null;
    }

    @Override
    public void search(String str) {

    }
}
