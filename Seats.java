import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Seats implements Airport{

    /** initialized by False value */
    private boolean[][] avail_seats = new boolean[PLANE_ROW][PLANE_COL];

    /** constructor : initialize boolean 2d arr*/
    Seats()
    {
        for (int i = 0; i < PLANE_ROW; i++) {
            for (int j = 0; j < PLANE_COL; j++) {
                avail_seats[i][j] = false;
            }
        }
    }

    @Override
    public void startScreen(String theme)
    {
        System.out.println("**********************************");
        System.out.println("\t\t" + theme);
        System.out.println("**********************************");
    }

    @Override
    public void showList()
    {
        System.out.println("\t\t\t\t\t" + "SEATS" +'\t');

        for (int i = 0; i < PLANE_COL; i++) {
            System.out.print("---------");
        }

        System.out.println();

        System.out.print('\t');


        for (int i = 0; i < PLANE_COL ; i++) {
            System.out.print( "  " + (i + 1) + "\t\t");
        }

        System.out.println();

        for (int i = 0; i < PLANE_ROW; i++) {
            System.out.print((i+1)+ "\t");
            for (int j = 0; j < PLANE_COL; j++) {
                System.out.print(avail_seats[i][j] + "\t");
            }
            System.out.println();
        }
    }
    @Override
    public LinkedList<?> deleteUserInfo()
    {



        return null;
    }

    @Override
    public HashMap<Integer,String> search()
    {
        Scanner sc = new Scanner(System.in);
        Class<?> cls = Flights.class;
        HashMap<Integer,String> h_result = new HashMap<Integer,String>();

        try {
            Constructor<?> constructor = cls.getDeclaredConstructor();
            String keyword = sc.next();
            Flights flights_seats = (Flights) constructor.newInstance();
            int idx = 0;
            while(flights_seats.airport_name != null)
            {
                if(keyword.equals(flights_seats.airport_name.get(idx)))
                {
                    System.out.println("FOUND THE AIRPORT!");
                     h_result.put(idx,flights_seats.airport_name.get(idx));
                     return h_result;
                }
            }

            System.out.println("NO SUCH RESULT FOUNDED");

        }
        catch(InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            System.err.println("Failed to Create Instance");
        }



        // in case search fails
        return null;
    }

}
