import java.util.*;

public interface Airport {

    /** PLANE SEATS SIZE */
    int PLANE_ROW = 10;
    int PLANE_COL = 5;



    /**show what's inside of the list
     * ex. ROW, COL of seats*/
    void showList();

    /** delete user info*/
    LinkedList<?> deleteUserInfo();

    /** search */
    HashMap<?,?>  search();



}
