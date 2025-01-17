import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {

        Manager mng = new Manager();
        Flights flights = new Flights();

        boolean flight_booking_token = true;//true for testing
        while(true)
        {
            switch(mng.startScreen())
            {
                //질문
                case 1: // BOOK FLIGHTS
                        flights.showList();
                    break;
                case 2: // BOOK SEATS
                    if(flight_booking_token)
                    {
                        mng.seats.startScreen("CHOOSE YOUR SEATS");
                    }
                    else
                    {
                        System.out.println("PLEASE CHOOSE A FLIGHT FIRST");
                    }
                    break;
                case 3: // CHECK RESERVATION
                    break;
                case 4:// DELETE RESERVATION
                    break;
                case 5://EXIT
                    mng.exit();
                    break;

            }
        }

    }

}
