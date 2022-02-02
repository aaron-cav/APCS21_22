import java.util.*;
import java.io.*;

/**
 * SubWordFinder is a class wich will take a word from the dictionary and tell the user if it is a word in the dictoinary and if so
 * it will tell the user if it has any subwords in side of it.
 *
 * @author Aaron Caveney
 * @version 2/02/2022
 */
public class SubWordFinder implements WordFinder {
    private ArrayList<ArrayList<String>> dictionary;  // jagged list
    String alpha = "abcdefghijklmnopqrstuvwxyz";

    /**
     *
     */
    public SubWordFinder()  {
        dictionary = new ArrayList<>();
        // 26 buckets
        for(int i = 0; i < alpha.length(); i++) {
            dictionary.add(new ArrayList<String>());
        }
        populateDictionary();
    }

    /**
     * populate dictionary takes the dictionary file and fill its contents into the ArrayList Dictionary
     */
    public void populateDictionary()    {
        try {
            Scanner in = new Scanner(new File("words_all_os.txt"));
            while(in.hasNext()) {
                String word = in.nextLine();
                dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
            }
            in.close();
        }
        catch(Exception e)    {
            e.printStackTrace();
        }
    }
    private int indexOf(ArrayList<String> bucket, String word)   {
        int low = 0, high = bucket.size()-1, mid;
        while(low <= high)   {
            mid = (low + high) /2;
            if(bucket.get(mid).compareTo(word)==0) {
                return mid;
            }
                else if (bucket.get(mid).compareTo(word)<0){
                    low = mid +1;
                }
                else
                    high = mid -1;
            }
        return -1;
        }


    /**
     *
     * @param word The item to be searched for in dictionary
     * @return returns the
     */
        public boolean inDictionary(String word)    {
        int index = alpha.indexOf(word.charAt(0));
        ArrayList<String> bucket = dictionary.get(index);
        return indexOf(bucket, word) >= 0;

    }

    /**
     *a constroctur for the method getSubWords wich finds and collects the sub words.
     * @return returns subword and prints out the original word and sub1 + sub2
     */
    public ArrayList<SubWord> getSubWords() {
        ArrayList<SubWord> subWords = new ArrayList<>();
        for (ArrayList<String> bucket : dictionary) {
            for (String word : bucket) {
                for (int i = 3; i < word.length() - 2; i++) {
                    String sub1 = word.substring(0, i);
                    String sub2 = word.substring(i);
                    //if(indexOf(word.substring(0, i)) != -1 && indexOf(word.substring(i, word.length())) != -1) {
                    if(inDictionary(sub1) && inDictionary(sub2)) {
                        subWords.add(new SubWord(word, sub1, sub2));
                        System.out.println( word + " = " + sub1  + " + " + sub2);
                    }
                    }
                }
            }
        return subWords;
        }

    /*public void printDictionary()   {
        //for(ArrayList<String> bucket : dictionary)
            //System.out.println(bucket);
        int MAXLEN = dictionary.get(0).size();
        int MAXINDEX = 0;
        for(int i = 1; i < dictionary.size(); i++)  {
            if(dictionary.get(i).size() > MAXLEN) {
                MAXLEN = dictionary.get(i).size();
                MAXINDEX = i;
                }


        System.out.println("the longest sublist is at index " + MAXINDEX + " starting with the letter " + alpha.charAt(MAXINDEX));
    }
*/

    /**
     * Main entry point for the class SubWordFinder
     * @param args
     */
    public static void main(String[] args) {
        SubWordFinder app = new SubWordFinder();
        app.getSubWords();
        //app.printDictionary();
    }
}
