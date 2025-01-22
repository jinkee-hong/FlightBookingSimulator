import java.io.FileNotFoundException;
import java.io.IOException;

public class Customer{
    // TODO : Make methods for reservation

    private String flight_number;
    //is it better off managing as string or int?
    private int seat_option;
    private int numOfAdults;
    private int numOfKids;


    Customer(String flight_number,int seat_option,int numOfAdults,int numOfKids) {
        this.flight_number = flight_number;
        this.numOfAdults = numOfAdults;
        this.numOfKids = numOfKids;
        this.seat_option = seat_option;
    }


}
