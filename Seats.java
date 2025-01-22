import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Seats implements Airport{

    /** initialized by False value */
    private boolean[][] avail_seats = new boolean[PLANE_ROW][PLANE_COL];
    public int numberOfSeats = PLANE_ROW * PLANE_COL;
    public int numberOfEconomy = PLANE_ROW * PLANE_COL / 2;
    public int numberOfBusiness = PLANE_COL * PLANE_ROW / 2;

    public enum SeatOptions
    {
        ECONOMY("Economy" ,2),
        BUSINESS("Business",1);
        private String str ;
        private int designated_number;
        SeatOptions(String str,int designated_number)
        {
            this.str = str;
            this.designated_number = designated_number;
        }

        public String getStr() {
            return str;
        }

        public int getDesignated_number() {
            return designated_number;
        }
    }




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
        System.out.println("\t\t" + "SEATS" +'\t');

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
    public void search(String str)
    {

    }

}
