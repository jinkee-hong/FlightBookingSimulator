import java.io.IOException;
import java.util.*;

public class Reservation implements Airport {
    public final int MISS_COUNT = 2;
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
        HashMap<String,Integer[][]> seatPlace = new HashMap<>();
        for( BasicInfo i :  BasicInfo.values())
        {
            System.out.println("> ENTER THE "+ i.str);
            System.out.println("---------------------------");

             if(i.str.equals(BasicInfo.FLIGHT_NUMBER.str)) {
                 System.out.println("** THE INPUT HAS TO BE 8 CHARACTERS **");
                 System.out.println();
                 temp.add(reservation(i.str, flights));
             }
            else if(i.str.equals(BasicInfo.SEAT_OPTIONS.str)) {
                 selectSeatType(seatRelation, Integer.parseInt(temp.get(1).trim()), Integer.parseInt(temp.get(2).trim()));
                 selectSeatNumber(seatRelation,seatPlace,seats);
             }
            else// Num of adults , Num of kids
                 temp.add(reservation(i.str, seats));

        }
        return new Customer(temp,seatRelation,seatPlace);
    }

    // 1 == BUSINESS 2 == ECONOMY
    public void selectSeatType(HashMap<String,Integer> seatRelation, int adults, int kids)
    {
        Scanner sc= new Scanner(System.in);
        int counter = 0,limit = -1 ;

        System.out.println("\t\t\t\t\t\t\t\tNOTICE");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\t\t[* ROW 0 TO ROW "+ PLANE_ROW * PLANE_COL / 2+" IS BUSINESS SEATS AREA *]");
        System.out.println("\t\t[* THE REST OF SEATS IS ECONOMY SEATS *]");
        System.out.println("-----------------------------------------------------------------\n\n");

            // Show how much class they got for seats
            for(Seats.SeatOptions i : Seats.SeatOptions.values())
            {
                System.out.println((counter+1) + ". " + i.getStr());
                counter++;
            }
        System.out.println();
            // adults seat type
        for(int i = 0 ; i < adults ; i++) {
            do {
                System.out.println(" PLEASE SELECT SEAT TYPE FOR " + Guest.ADULTS.getStr()+" "+ (i+1) );
                System.out.println("--------------------------------------------------------------");
                limit = sc.nextInt();
            } while (limit < 0 || limit > Seats.SeatOptions.values().length);
            seatRelation.put(Guest.ADULTS.getStr() + (i+1),limit);
        }

        // kids seats type
        for(int i = 0 ; i < kids ; i++) {
            do {
                System.out.println(" PLEASE SELECT SEAT TYPE FOR " + Guest.KIDS.getStr() + " "+(i+1));
                System.out.println("--------------------------------------------------------------");
                limit = sc.nextInt();
            } while (limit < 0 || limit > Seats.SeatOptions.values().length);
            seatRelation.put(Guest.KIDS.getStr()+(i+1),limit);
        }
    }

    // 1 == BUSINESS 2 == ECONOMY
    public HashMap<String,Integer[][]> selectSeatNumber(HashMap<String,Integer> seatLevel,HashMap<String,Integer[][]> seatPlace,Seats seats)
    {
        Scanner sc = new Scanner(System.in);
        int row = -1, col = -1 ;

        // iterate by number of seat options

    }


    public String reservation(String msg,Seats seats )
    {
        Scanner sc = new Scanner(System.in);
        int askedSeat = -1;

        do{
            askedSeat = sc.nextInt();
            if(askedSeat < 0 || askedSeat > seats.numberOfSeats)
            {
                System.out.println("[ ** Please Check Your Input For "+ msg +" **]\n");
                System.out.println("[ ** You May Input " + msg + " Again Please ** ]");
            }
        }while(askedSeat< 0 || askedSeat > seats.numberOfSeats);


        return Integer.toString(askedSeat);
    }


    public String reservation(String msg,Flights flights)
    {
        Scanner sc= new Scanner(System.in);
        String num = "";
        int idx = 0,round = 0,missCnt = 0;
        do
        {
            if(idx == 0)
            {
                if(round >= 1)
                {
                    System.out.println("PLEASE MAKE A CORRECT INPUT FOR " + msg);
                    System.out.println("-------------------------------------");
                    missCnt++;
                    if(missCnt > MISS_COUNT )
                    {
                        System.out.println("\n ** NEED A HELP TO INSERT RIGHT " + msg +" ?");
                        System.out.println("Insert : HELP to see all the information available");
                        missCnt = 0 ; // reinitialize
                    }
                }
                num = sc.next();
            }

            if(num.equals("HELP"))
            {
                flights.showList();
                num = "0"; // reinitialize num variable
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
