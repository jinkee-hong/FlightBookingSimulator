import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Seats implements Airport{

    /** initialized by true value */
    public boolean[][] avail_seats = new boolean[PLANE_ROW][PLANE_COL];
    public int numberOfSeats = PLANE_ROW * PLANE_COL;
    public int numberOfEconomy = PLANE_ROW   / 2;
    public int numberOfBusiness = PLANE_COL   / 2;

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

        public String getDesignated_number(int designated_number) {
            if(designated_number == 1 )
            {
                return ECONOMY.getStr();
            }
            else if(designated_number == 2)
            {
                return BUSINESS.getStr();
            }
            else
            {
                return "WRONG INPUT";
            }
        }
    }




    /** constructor : initialize boolean 2d arr*/
    Seats()
    {
        for (int i = 0; i < PLANE_ROW; i++) {
            for (int j = 0; j < PLANE_COL; j++) {
                avail_seats[i][j] = true;
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
            if( i == 0 )
            {
                System.out.println("   BUSINESS AREA \n");
            }
            else if(i == PLANE_ROW / 2)
            {
                System.out.println("    ECONOMY AREA \n");
            }
            System.out.print((i+1)+ "\t");
            for (int j = 0; j < PLANE_COL; j++) {
                System.out.print(avail_seats[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public boolean checkSeatAvailability(int row, int col)
    {
        return avail_seats[row][col];
    }

    @Override
    public LinkedList<?> deleteUserInfo()
    {



        return null;
    }

    @Override
    public void search(String str)
    {
        int cnt = 0 ;
        for (int i = 0; i < avail_seats.length; i++) {
            for (int j = 0; j < avail_seats[i].length; j++) {
                if(avail_seats[i][j])
                {
                    cnt++;
                }
            }
        }

        if(cnt == PLANE_ROW * PLANE_COL)
        {
            System.out.println("NO MORE SEATS TO BOOK!");
            System.out.println("REQUIRE TO NEW FLIGHTS AND SEATS!");
        }
    }

}
