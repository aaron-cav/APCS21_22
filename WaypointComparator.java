import java.util.Comparator;

/**
 * this is the main class that is a sub class of Comparator
 * @version 0/05/2022
 * @author 23caveneya
 */
public class WaypointComparator implements Comparator<Waypoint> {
    private int catagory;
    private boolean asc;

    /**
     * this sets the catagry and asc to the paramaters
     * @param c
     * @param a
     */
    public WaypointComparator(int c, boolean a)  {
        catagory = c;
        asc = a;
    }

    public WaypointComparator(int c)    {
        catagory = c;
        asc = true;
    }

    public WaypointComparator()    {
        catagory = 4;
        asc = true;

    }

    /**
     * this method is what compars the input data to the parameters of the constructure
     * @param one
     * @param two
     * @return asc
     */
    public int compare(Waypoint one, Waypoint two) {
            int diff = 0;
            if(catagory ==1)
                diff =  one.getType().compareTo(two.getType());
            else if(catagory ==2)
                diff =  one.getName().compareTo(two.getName());
            else if(catagory ==3)
                diff =  one.getState().compareTo(two.getState());
            else if(catagory ==4) {
                Double d1 = two.getToSpringer();
                Double d2 = two.getToSpringer();
                diff = d1.compareTo(d2);
            }
            else if(catagory ==5) {
                Double d1 = two.getToKatahdin();
                Double d2 = two.getToKatahdin();
                diff = d1.compareTo(d2);
            }
            else if(catagory ==6)
                diff =  one.getElevation() - (two.getElevation());
            return (asc) ? diff : -diff;

    }
}
