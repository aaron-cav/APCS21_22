import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class ScrabbleScorer {
    private ArrayList<String> dictionary;
    private int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    private String alpha;

    /**
     * constructor for class ScrabbleScorer.
     * Initializes dictionary and builds alpha string
     * Calls buildDictionary to important words
     */
    public ScrabbleScorer() {
        dictionary = new ArrayList<>();
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        buildDictionary();
    }

    /**
     *Constructor for the class ScrabbleScorer
     * builds and fills in the dictonary
     * sorts the dictonary
     */
    public void buildDictionary()   {
        try {
            Scanner in = new Scanner(new File("datafiles/SCRABBLE_WORDS (1).txt"));
            while(in.hasNext())
                dictionary.add(in.nextLine().strip());
            in.close();
            Collections.sort(dictionary);
        }
        catch(Exception e)  {
            e.printStackTrace();
        }
        // use try/cath
        //use a Scanner
        // read data file
        // when file is read into dictionary, close stream
        // call Collections.sort(dictionary);

    }

    /**
     *returns weather the word os valid or not.
     * @param word
     * @return returns if the word the user inputs is valid or not
     */
    public boolean isValidWord(String word){
        return Collections.binarySearch(dictionary, word) >= 0;

    }

    /**
     * caculates the value of the word and return the value.
     * @param word
     * @return
     */
    public int getWordScore(String word)    {
        int sum = 0;
        for(int i = word.length()-1; i>= 0; i--) {
            sum += points[alpha.indexOf(word.charAt(i))];





        }
        // pare word one letter at a time -- for loop"" charAt or substring
        //find the index of each letter
        //add the corresponding point/score value from points to a sum value
        return sum; //
    }

    public static void main(String[] args) {
        ScrabbleScorer app = new ScrabbleScorer();
        System.out.println("* Welcome to the Scrabble Word Scorer app *");
        String userWord;
        Scanner userIn = new Scanner(System.in);
        try {
            while(true) {
                System.out.print("enter a word to score or 0 to quit: ");
                userWord = userIn.nextLine();
                if(userWord.equals("0")) {
                    System.out.println("Exiting the program thanks for playing");
                    break;
                }
                else {
                    // do the program
                    // is the word in the dictonary
                    if(app.isValidWord(userWord.toUpperCase()))   {
                        System.out.println(userWord + " = " + app.getWordScore(userWord.toUpperCase()));// PRINT OUT POINT VALUE HERE
                    }
                    else {
                        System.out.println(userWord + " is not valid word in the dictionary");
                    }
                }
            }
        }
        catch(Exception e)  {
            e.printStackTrace();
        }
    }
}