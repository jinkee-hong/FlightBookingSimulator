import java.io.IOException;
import java.util.*;

/** WEAKNESS
 * 1. poor System Design
 * 2. Didn't think much about optimization and expandability
 * 3. Didn't follow OOP Design that much
 * 4. I have to throw manager class if I want to
 * approach certain class -> this could be really worse if manager class got bigger
 * 5. I didn't separate the responsibility that causes certain method huge responsibility and
 * becomes heavy
 * 6. Declared Variables that will be obsolete in the end */

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
                case 1:
                    mng.printSubOptions("PRINT FLIGHT OPTIONS","SEARCH OPTIONS","GO BACK");
                    switch(mng.choiceOptions())
                    {
                        case 1:
                            mng.flights.showList();
                            break;
                        case 2:
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
                            System.out.println("RESERVATION CODE : " + mng.customers.getLast().getCode());
                            System.out.println("[ ** RESERVATION COMPLETED ! ** ]");
                            break;

                            // search options
                        case 2:
                            search_token = sc.nextLine();
                            mng.reservation.search(search_token);
                            break;

                        case 3:
                            break;
                    }
                    break;
                case 3://EXIT
                    mng.exit();
                    break;

            }
        }

    }

}
