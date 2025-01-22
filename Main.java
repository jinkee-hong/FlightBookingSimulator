import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {

        Scanner sc =new Scanner(System.in);
        Manager mng = new Manager();

        LinkedList<Customer> customers = new LinkedList<>();
        String search_token = "";
        int int_search_token = -1;

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
                            mng.flights.showList();
                            break;
                        case 2:
                            System.out.println("RECOMMENDED KEYWORDS : DESTINATION / FLIGHTS NUMBER / AIRPORT NAME");
                            search_token = sc.nextLine();
                            if(mng.isInteger(search_token))
                            {
                                int_search_token = Integer.parseInt(search_token);
                                mng.flights.search(int_search_token);
                            }
                            else
                                mng.flights.search(search_token);
                            break;
                    }
                    break;

                case 2: // MAKE RESERVATION, Under case 2 , it has two sub options

                    System.out.println("SUB OPTIONS");
                    System.out.println("--------------");
                    System.out.println("1. MAKE RESERVATION ");
                    System.out.println("2. SEARCH OPTIONS");
                    switch(mng.choiceOptions())
                    {
                        case 1:
                            customers.add(mng.reservation.enterBasicInfo(mng.seats,mng.flights));
                            break;
                        case 2:

                            break;
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
