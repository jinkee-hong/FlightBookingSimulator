import java.io.FileNotFoundException;
import java.io.IOException;

public class Customer{

    private int from_airport_num = -1;

    private int to_airport_num = -1;

    private String bounded_date = "";

    Customer(int from_airport_num,int to_airport_num,String bounded_date) {
        this.from_airport_num = from_airport_num;
        this.to_airport_num = to_airport_num;
        this.bounded_date = bounded_date;
    }
}
