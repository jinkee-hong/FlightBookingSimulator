import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.*;

public class Customer{

    //String == name(or it could be divisor) Integer  == seat level
    private HashMap<String,Integer> seatRelation = new HashMap<>(); //included for expandable structure
    private String flight_number;
    //is it better off managing as string or int?
    private int seat_option;
    private int numOfAdults;
    private int numOfKids;

    // 0 - flight number
    // 3 - seat options
    // 1 - Number of adults
    // 2 - Number of kids
    Customer(Vector<String> customer_info,HashMap<String,Integer> seatRelation ) {
        this.flight_number = customer_info.get(0);
        this.numOfAdults = Integer.parseInt(customer_info.get(1));
        this.numOfKids = Integer.parseInt(customer_info.get(2));
        this.seat_option = Integer.parseInt(customer_info.get(3));
        this.seatRelation = seatRelation;
    }


}
