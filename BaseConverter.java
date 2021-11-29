import java.util.Scanner;
import java.io.*;

/**
 * BaseConverter opens a data file, reads, converts numbers, prints
 * @version Thursdat 11/18/2021
 * @author Aaron Caveney
 */
public class BaseConverter {
    // Constructor for class.
    public BaseConverter()  {
    }

    // Convert a String num in fromBase to base-10 int.
    public int strToInt(String num, String fromBase)    {
        int base = Integer.parseInt(fromBase);
        String alpha = "0123456789ABCDEF";
        int sum = 0, exp = 0;
        for(int i = num.length()-1; i>= 0; i--)  {
            sum += alpha.indexOf(""+num.charAt(i)) *Math.pow(base, exp);
            exp++;
        }
        return sum;
    }
    // Convert a base-10 int to a String number of base toBase.
    public String intToStr(int num, int toBase) {
        String aplha = "0123456789ABCDEF";
        String toNum = "";

        while(num > 0) {
            int i = num % toBase;
            toNum = aplha.charAt(i) + toNum;
            num = num / toBase;
        }
        if (toNum.equals (""))  {
            return "0";
        }
        else {
            return toNum;
            }
        }

    /**
     * Opens the file stream, inputs data one line at a time, converts,
     * prints the results to the console window and writes data to the output string
     */
    public void inputConvertPrintWrite()    {
        Scanner sc = null ;
        PrintWriter pw = null;
        try {
            sc = new Scanner(new File("datafiles/values30.dat"));
            pw = new PrintWriter(new File("datafiles/converted.dat"));
            while(sc.hasNext()) {
                String[] line = sc.nextLine().split("\t");
                // String [] line = {"24A4B56", "13", "6"};
                int fromBase = Integer.parseInt(line[1]);
                int toBase = Integer.parseInt(line[2]);
                if(fromBase < 2 || fromBase > 16) {
                    System.out.println("invalid input base " + fromBase);
                }
                else if(toBase < 2 || toBase > 16)
                    System.out.println("invalid output base " + toBase);
                else {
                    System.out.println(line[0] + " base " + fromBase + " = " + intToStr(strToInt(line[0], line[1]),toBase) + " base " + toBase);
                    pw.println(line[0] + "\t" + fromBase + "\t" + intToStr(strToInt(line[0], line[1]),toBase) + "\t" + toBase);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if(sc != null)
            sc.close();
        if(pw != null)
            pw.close();
    }

    /**
     * Main method for class BaseConverter
     * @param args comman line arguments, if needed
     */
    // Main method for class BaseConverter. Yours should look just like this!
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();
        //System.out.println(app.strToInt("21221201", "3"));
        //System.out.println(app.intToStr(5789324, 16));
    }
}