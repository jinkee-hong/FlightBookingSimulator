import java.io.IOException;
import java.util.*;

public class Reservation implements Airport {

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
    public void enterBasicInfo(Seats seats, Flights flights)
    {
        for( BasicInfo i :  BasicInfo.values())
        {
            System.out.println("\t"+ i.str);
            System.out.println("----------------");
        }
    }


    public Customer reservation(int[][] seat_info)
    {
        Scanner sc= new Scanner(System.in);
        String temp = sc.nextLine();
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
