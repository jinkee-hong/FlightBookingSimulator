import java.io.IOException;
import java.util.*;

public interface Airport {

    /** PLANE SEATS SIZE */
    int PLANE_ROW = 10;
    int PLANE_COL = 5;


    /**Print Basic Screen*/
    void startScreen(String theme) throws IOException;
    /**show what's inside of the list
     * ex. ROW, COL of seats*/
    void showList() throws IOException;

    /** delete user info*/
    LinkedList<?> deleteUserInfo();

    /** search */
    void  search(String str);}