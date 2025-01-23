import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {

        Scanner sc =new Scanner(System.in);
        Manager mng = new Manager();

         String search_token = "";
        int int_search_token = -1;

        while(true)
        {
            switch(mng.startScreen())
            {
                //질문
                case 1:
                    mng.printSubOptions("PRINT FLIGHT OPTIONS","SEARCH OPTIONS","GO BACK");
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
                        case 3:
                            break;
                    }
                    break;

                case 2: // MAKE RESERVATION, Under case 2 , it has two sub options
                    mng.printSubOptions("MAKE RESERVATION","SEARCH OPTIONS","GO BACK");
                    switch(mng.choiceOptions())
                    {
                        case 1:
                            mng.customers.add(mng.reservation.enterBasicInfo(mng.seats,mng.flights));
                            break;
                        case 2:
                            break;
                        case 3:
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
