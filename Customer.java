import java.io.FileNotFoundException;
import java.io.IOException;

public class Customer{

    private String from_airport_num = "";

    private String to_airport_num = "";

    private String bounded_date = "";

    private int[][] seatNumber = new int[1][2];

    Customer(String from_airport_num,String to_airport_num,String bounded_date) {
        this.from_airport_num = from_airport_num;
        this.to_airport_num = to_airport_num;
        this.bounded_date = bounded_date;
    }
}
