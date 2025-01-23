import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.*;

public class Customer{

    //String == name(or it could be divisor) Integer  == seat level
    private HashMap<String,Integer> seatRelation = new HashMap<>(); //included for expandable structure
    private HashMap<String,HashMap<Integer,Integer>> seatPlace = new HashMap<>(); // store where to sit according to their name(or status)
    private String flight_number;
    //is it better off managing as string or int?
    private int numOfAdults;
    private int numOfKids;
    private String code;
    private int total_price;

    // 0 - flight number
    // 3 - seat options
    // 1 - Number of adults
    // 2 - Number of kids
    Customer(Vector<String> customer_info,HashMap<String,Integer> seatRelation,HashMap<String,HashMap<Integer,Integer>>seatPlace, String code, int total_price ) {
        this.flight_number = customer_info.get(0);
        this.numOfAdults = Integer.parseInt(customer_info.get(1));
        this.numOfKids = Integer.parseInt(customer_info.get(2));
        this.seatRelation = seatRelation;
        this.seatPlace = seatPlace;
        this.code = code;
        this.total_price = total_price;
    }

    public String getCode() {
        return code;
    }
}
