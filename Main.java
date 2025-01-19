import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {

        Scanner sc =new Scanner(System.in);
        Manager mng = new Manager();
        Flights flights = new Flights();

        boolean flight_booking_token = true;//true for testing
        while(true)
        {
            switch(mng.startScreen())
            {
                //질문
                case 1: // Under case 1 , it has two sub options
                    System.out.println("SUB OPTIONS");
                    System.out.println("--------------");
                    System.out.println("1. PRINT FLIGHT OPTIONS");
                    System.out.println("2. SEARCH OPTIONS");
                    switch(mng.choiceOptions())
                    {
                        case 1:
                            flights.showList();
                            break;
                        case 2:
                            String search_token = sc.nextLine();
                            flights.search(search_token);
                            break;
                    }

                    break;
                case 2: // MAKE RESERVATION

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
