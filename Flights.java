import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Flights implements Airport {

    // create 3 vars to store from text file
    public LinkedList<String> airport_name;
    protected LinkedList<String> location;
    protected LinkedList<Integer> airport_code;

    FileReader fileReader;

    private enum BasicInfo {
        FROM("FROM"),
        TO("TO"),
        FLIGHT_DATE("Flight Date");
        private String str = null;

        BasicInfo(String str) {
            this.str = str;
        }
    }

    Flights() throws FileNotFoundException, IOException {
        fileReader = new FileReader("airports.txt");
        airport_name = new LinkedList<String>();
        location = new LinkedList<String>();
        airport_code = new LinkedList<Integer>();
    }

    @Override
    public void startScreen(String theme) {
        System.out.println("**********************************");
        System.out.println("\t\t\t\t" + theme);
        System.out.println("**********************************");


    }

    public void parseList() throws IOException {
        int ch;
        int round = 1;
        String str = "";
        while ((ch = fileReader.read()) != -1) {
            if (ch != ';' && ch != '\n') {
                str += (char) ch;
            } else {
                round %= 4;

                if (round == 1) // airport name
                {
                    airport_name.add(str);
                } else if (round == 2) // location
                {
                    location.add(str);
                } else if (round == 0) // airport code
                {
                    try {
                        airport_code.add(Integer.parseInt(str));
                    } catch (NumberFormatException e) {
                        airport_code.add(-1);
                    }

                }
                str = ""; // reinitialize str variable
                round++;
            }

        }
    }

    @Override
    public void showList() throws IOException {
        parseList(); // parse text into LinkedList to show them
        for (int j = 0; j < airport_name.size(); j++) {
            System.out.println((j + 1) + ". " + airport_name.get(j));
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

    /** return customer type Objects */
    public Customer selectOptions(Manager mng) {

        Scanner sc = new Scanner(System.in);
        int[] temp = new int[2];
        int count = 0;
        String temp_str = "";
        for (BasicInfo i : BasicInfo.values())
        {
            System.out.println("\t"+i.str);
            System.out.println("----------------");
            if(!i.str.equals("Flight Date")) {
                temp[count] = sc.nextInt();
                count++;
            }
            else
            {
                temp_str = sc.next();
            }
        }

        return checkValidity(temp[0],temp[1],temp_str);
    }

    public Customer checkValidity(int from, int to , String date)
    {
        Scanner sc = new Scanner(System.in);
        String temp = "";
        int curr_year = Calendar.getInstance().get(Calendar.YEAR);
        try{
           String air_from =  airport_name.get(from);
           String air_to = airport_name.get(to);


            for (int i = 0; i < date.length(); i++) {
                temp += date.charAt(i);
                if(i % 4 == 0 && i != 0)
                {
                    if(Integer.parseInt(temp) != curr_year)
                    {
                        System.out.println("ONLY ALLOWED TO BOOK A FLIGHTS IN CURRENT YEAR");
                        System.out.println("YOU CAN INSERT THE DATE AGAIN");
                        date = sc.next();
                        i = -1;
                    }
                    else
                    {
                        break;
                    }
                }
            }

            return new Customer(air_from,air_to,date);
        }
        catch(IndexOutOfBoundsException e)
        {
            System.err.println("NO SUCH ELEMENTS IS IN LIST");
        }

        return null;
    }

}
