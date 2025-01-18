import java.io.*;
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
    public void startScreen(String theme) throws IOException {
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
    public void showList() throws IOException{
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
    public void search(String str) {

        for (int i = 0; i < airport_name.size(); i++) {
            if(str.equals(airport_name.get(i)))
            {
                System.out.println("THERE IS " + airport_name.get(i));
            }
        }
        System.out.println("SEARCH FAILED");
    }



}
