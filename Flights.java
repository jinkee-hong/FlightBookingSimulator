import java.io.*;
import java.util.*;

public class Flights implements Airport {

    public enum Destination{

        US("United State"),
        S_KOREA("South Korea"),
        JAPAN("Japan");

        private String str = "";

        Destination(String str)
        {
            this.str = str;
        }

    }

    // create 3 vars to store from text file
    public LinkedList<String> airport_name;
    protected LinkedList<String> location;
    protected LinkedList<String> destination;
    protected LinkedList<int[]> takeOff_date;
    protected LinkedList<int[]> landing_date;
    protected LinkedList<String> flight_number;
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
        takeOff_date = new LinkedList<int[]>();
        landing_date = new LinkedList<int[]>();
        destination = new LinkedList<String>();
        flight_number = new LinkedList<String>();
        parseList();
    }

    @Override
    public void startScreen(String theme)   {
        System.out.println("**********************************");
        System.out.println("\t\t\t\t" + theme);
        System.out.println("**********************************");
     }

    public void parseList() throws IOException {
        int ch;
        int round = 0,checker=0;


        String str = "";
        while ((ch = fileReader.read()) != -1) {
            if (ch != ';' && ch != '\n')
            {
                str += (char) ch;
            }
            else {
                round %= 4;
                checker %= Destination.values().length;

                if (round == 0 ) // airport name
                {
                    airport_name.add(str);
                }
                else if (round == 1) // location
                {
                    location.add(str);
                }
                else if (round == 2) // create Random Takeoff and Landing date
                {
                    takeOff_date.add(createRandomDate());
                    landing_date.add(createRandomDate());
                      for(Destination i : Destination.values())
                     {
                         switch(checker)
                         {
                             case 0:
                                 destination.add(Destination.US.str);
                                 break;
                             case 1:
                                 destination.add(Destination.S_KOREA.str);
                                 break;
                             case 2:
                                 destination.add(Destination.JAPAN.str);
                                 break;
                         }
                     }

                }
                else if(round == 3)
                {
                    flight_number.add(str);
                }
                str = ""; // reinitialize str variable
                round++;
                checker++;
            }

        }
    }

    @Override
    public void showList() throws IOException{
        parseList(); // parse text into LinkedList to show them
         for (int j = 0; j < airport_name.size(); j++) {
            System.out.println((j + 1) + ". " + airport_name.get(j));
             System.out.println("-----------------------------------");
             System.out.println("Flight Number : " + flight_number.get(j));
             System.out.println("Departure Location : " + location.get(j));
             System.out.println("Departure Date : " + takeOff_date.get(j)[1] +"/" + takeOff_date.get(j)[2] + "/" + takeOff_date.get(j)[0]);
             System.out.println("Arrival Date : " + landing_date.get(j)[1] +"/" + landing_date.get(j)[2] + "/" + landing_date.get(j)[0]);
             System.out.println("Destination : " + destination.get(j));
             System.out.println();
         }

    }

    @Override
    public LinkedList<?> deleteUserInfo() {
        return null;
    }

    @Override
    public void search(String str) {

        int i = 0 ;
        boolean isFound = false;
       while(i < airport_name.size()) {
            if(str.equalsIgnoreCase(airport_name.get(i)))
            {
                System.out.println("THERE IS " + airport_name.get(i));
                System.out.println("-----------------------------------");
                System.out.println("Flight Number : " + flight_number.get(i));
                System.out.println("Departure Location : " + location.get(i));
                System.out.println("Departure Date : " + takeOff_date.get(i)[1] +"/" + takeOff_date.get(i)[2] + "/" + takeOff_date.get(i)[0]);
                System.out.println("Arrival Date : " + landing_date.get(i)[1] +"/" + landing_date.get(i)[2] + "/" + landing_date.get(i)[0]);
                System.out.println("Destination : " + destination.get(i));
                System.out.println();
                isFound = true;
            }
            i++;
        }
       if(!isFound)
            System.out.println("SEARCH FAILED");
    }

    public int[] createRandomDate()
    {
        Scanner sc = new Scanner(System.in);
        String temp = "";
        int curr_year = Calendar.getInstance().get(Calendar.YEAR);
        int year = 0, month = 0, day = 0;
        long seed = System.currentTimeMillis();
        // random for creating random date
        Random rnd = new Random(seed);
        year = Calendar.getInstance().getWeekYear(); // curr year
        month = (rnd.nextInt(12) + 1 );
        if(month == 2)
        {
            day = (rnd.nextInt(28) + 1 );
            System.err.println("NO SUCH ELEMENTS IS IN LIST");
        }
        else
        {
             day =  (rnd.nextInt(31) + 1 ); ;
        }
        return new int[] {year,month,day};
    }

}
