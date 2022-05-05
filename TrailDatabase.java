import java.util.*;
import java.io.File;
/**
 * This is a java program desgined
 * @author Aaron Caveney
 * @version 05/05/2022
 */


/**
 * the TrailDataBase is a class that imports data and sorts it
 */
public class TrailDatabase {
    private ArrayList<Waypoint> database;
    private int searchTerm;
    private boolean asc;

    public TrailDatabase()  {
        database = new ArrayList<>();
        populatedatabase();
    }


    /**
     * this method is the code for selection sort. th
     */
    private void selectionSort()    {
        WaypointComparator wc = new WaypointComparator(searchTerm, asc)   ;
        Waypoint toSwap;
        int index;
        for(int out = 0; out < database.size(); out++)  {
            index = out;
            toSwap = database.get(out);
            for( int in = out+1; in < database.size(); in++)    {
                Waypoint temp = database.get(in);
                if(wc.compare(temp, toSwap) < 0) {
                    toSwap = new Waypoint(temp);
                    index = in;
                }
            }
            database.set(index, database.get(out));
            database.set(out, toSwap);
        }
    }

    /**
     * this uses the scanner to populate a dictionary from the file
     */
    public void populatedatabase()  {
        try {
            Scanner in = new Scanner(new File("datafiles/apptrailDB.txt"));
            while (in.hasNext())    {
                String[] line = in.nextLine().split("\t");
                database.add(new Waypoint(line[0], line[1], line[2], Double.parseDouble(line[5]), Double.parseDouble(line[6]),Integer.parseInt(line[7])));

            }
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * this contrustor is what promts the user input and then uses the input for its sorting method
     */
    public void getSearchTerm()  {
        System.out.println("+ Menu of search terms to use for sorting waypoints +\n" +
                "\tTY: by type\n" +
                "\tNA: by name\n" +
                "\tST: by State\n" +
                "\tDS: by distance to Springer\n" +
                "\tDK: by distance to Katahdin\n" +
                "\tEL: by elevation\n");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your preferred sort by term or 'Q' to quit: ");
        String term = in.nextLine();
        if(term.equals("TY"))
            searchTerm = 1;
        else if (term.equals("NA"))
            searchTerm = 2;
        else if (term.equals("ST"))
            searchTerm = 3;
        else if (term.equals("DS"))
            searchTerm = 4;
        else if (term.equals("DK"))
            searchTerm = 5;
        else if (term.equals("EL"))
            searchTerm = 6;
        else
            searchTerm = 0;
        if(searchTerm != 0)
            System.out.print("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
            term = in.nextLine();
            asc = (term.toLowerCase().equals('a')) ? true: false;
        //"Enter 'A' to sort in ascending order or 'D' to sort in descending order: D");
    }

    /**
     * this prints the data base
     */
    public void printDB()   {
        for(Waypoint w : database)
            System.out.println(w);
    }

    /**
     * this sorts the databse
     */
    public void sortDB()    {
        //Collections.sort(database, new WaypointComparator(searchTerm, asc));
        selectionSort();
    }

    /**
     * this is the main entry point for the class
     * @param args
     */
    public static void main(String[] args) {
        TrailDatabase db = new TrailDatabase();
        System.out.println("*** Welcome to the Appalachian Trail Database ***");
        while(true) {
            db.getSearchTerm();
            if (db.searchTerm == 0)
                break;
            db.sortDB();
            db.printDB();
        }
        System.out.println("End of program");
    }
}
