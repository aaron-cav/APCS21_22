import java.util.*;
import java.io.*;


/**
 * ScrabbleRackManager shows the user what words are playable with thier given wrack
 * @author Aaron Caveney
 * @version 3/25/22
 */
public class ScrabbleRackManager {
    private ArrayList<ArrayList<String>> dictionary;
    ArrayList<String> tileRack = new ArrayList<>();
    ArrayList<Integer> possibleNumbers = new ArrayList<>();
    private String alpha;
    String[] tiles = {"A","A","A","A","A","A","A","A","A","B","B","C","C","D","D","D","D","E","E","E","E","E","E","E","E","E","E","E","E","F","F","G","G","G","H","H","I","I","I","I","I","I","I","I","I","J","K","L","L","L","L","M","M","N","N","N","N","N","N","O","O","O","O","O","O","O","O","P","P","Q","R","R","R","R","R","S","S","S","S","T","T","T","T","T","T","U","U","U","U","V","V","W","W","X","Y","Y","Z"};
    /** class constructor
     * This looks through the SCRABBLE.txt file and reads all lines.
     * it uses that to populate dictionary
     * @param
     * */
    public ScrabbleRackManager() {
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        dictionary = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < 26; i++) {
            dictionary.add(new ArrayList<String>());
        }
        try {
            Scanner in = new Scanner(new File("datafiles/SCRABBLE.txt"));
            while (in.hasNext()) {
                String temp = in.nextLine();
                dictionary.get(alpha.indexOf(temp.charAt(0))).add(temp);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addTiles()  {
        ArrayList<String> letters = new ArrayList<String>();
        for(String item: tiles)
            letters.add(item);
        Collections.shuffle(letters);
        for(int i = 0; i < 7; i++)  {
            tileRack.add(letters.remove((int)Math.random()*letters.size()));
        }
        System.out.println(tileRack);
    }

    /** displays the contents of the player's tile rack
     * calls this from the add tiles method
     * */
    public void printRack() {
        addTiles();
        }


     /**builds and returns an ArrayList of String objects that are values pulled
     from
     * the dictionary/database based on the available letters in the user's tile
     * rack
      * @return
      * */
    public ArrayList<String> getPlaylist()  {
        ArrayList<String> plays = new ArrayList<>();
        for(ArrayList<String> bucket : dictionary)
            if(tileRack.contains("" + bucket.get(0).charAt(0)))
                for(int i = 0; i < bucket.size(); i++)
                    if(isPlayable(bucket.get(i)))
                        plays.add(bucket.get(i));
            return plays;
    }

    private boolean isPlayable(String word) {
        ArrayList<String> rack2 = new ArrayList<String>(tileRack);
        for(int i = 0; i < word.length(); i++)
            if(!rack2.remove("" + word.charAt(i)))
                return false;
            return true;
    }


    /**
     * print all of the playable words based on the letters in the tile rack
     * */
    public void printMatches()  {
        ArrayList<String> plays = getPlaylist();
        boolean bingo = false;
        System.out.println("You can play the following words from the letters in your rack:");
        if(plays.isEmpty())
            System.out.println("Sorry, NO wordss can be played from those tiles.");
        for(int i = 0; i < plays.size(); i++) {
            String word = plays.get(i);
            if (word.length() == 7) {
                word += "*";
                bingo = true;
            }
            System.out.printf("%-10s", word);
            if ((i + 1) % 10 == 0)
                System.out.println();
        }
        if(bingo)
            System.out.println("\n * Denotes BINGO");
    }
    /**
     *  main method for the class; use only 3 command lines in main
     * @param args command lines arguments if needed
     *  */
    public static void main(String[] args){
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();
    }
}
