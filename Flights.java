import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Flights implements Airport{

    // create 3 vars to store from text file
    private LinkedList<String> airport_name;
    private LinkedList<String> location;
    private LinkedList<Integer> airport_code;

    FileReader fileReader;
    private enum BasicInfo
    {
        FROM("FROM"),
        TO("TO"),
        FLIGHT_DATE("Flight Date");
        private String str = null;
        BasicInfo(String str)
        {
            this.str= str;
        }
    }
    Flights() throws FileNotFoundException,IOException {
        fileReader = new FileReader("C:\\Users\\simpl\\FlightBookingSimulator\\airports.txt");
        showList();
    }

    @Override
    public void startScreen(String theme) {
        System.out.println("**********************************");
        System.out.println("\t\t\t\t" + theme);
        System.out.println("**********************************");


    }

    @Override
    public void showList() throws IOException {
        int ch;
        int round = 1;
        String str = null;
        while((ch = fileReader.read()) != -1)
        {
            if(ch != ';')
            {
                System.out.print((char)ch);
                str +=  (char)ch;
            }
            else
            {
                round %=4 ;
                if(round == 1) // airport name
                {
                    airport_name.add(str); // TODO : FIX ERROR NULLPOINTER EXCEPTION
                }
                else if( round == 2) // location
                {
                    location.add(str);
                }
                else if(round == 0) // airport code
                {
                    assert str != null;
                    airport_code.add(Integer.parseInt(str));
                }
                str = null; // reinitialize str variable
                round++;
            }

        }
    }

    @Override
    public LinkedList<?> deleteUserInfo() {
        return null;
    }

    @Override
    public HashMap<?, ?> search() {
        return null;
    }


}
