import java.util.*;

public class Seats implements Airport{

    /** initialized by False value */
    boolean[][] avail_seats = new boolean[PLANE_ROW][PLANE_COL];

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
    public HashMap<Integer,Integer> search()
    {

        // in case search fails
        return null;
    }



}
