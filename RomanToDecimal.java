/**
 * @author Aaron Caveney
 * @version 09/30/2021
 * 
 */


/**
 * no parameters, this stores the code used for the whole project
 */
public class RomanToDecimal {
    /**
     * this does the conversion
     * @param roman
     * @return
     */
    public static int romanToDecimal(String roman)  {
        int decimal = 0;
        for(int i = 0; i < roman.length(); i++) {
            //System.out.print("DEBUG " + roman.substring(i, i+1).toUpperCase());
            if(roman.substring(i, i+1).toUpperCase().equals("I")){
                decimal += 1;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("V")) {
                decimal += 5;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("X")) {
                decimal += 10;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("L")) {
                decimal += 50;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("C")) {
                decimal += 100;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("D")) {
                decimal += 500;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("M")) {
                decimal += 1000;
            }
            else    {
                return -1;
            }
        }
        if(roman.toUpperCase().indexOf("IV") != -1)
            decimal -=2;
        if (roman.toUpperCase().indexOf("IX") != -1)
            decimal -=2;
        if(roman.toUpperCase().indexOf("XL") != -1)
            decimal -=20;
        if (roman.toUpperCase().indexOf("XC") != -1)
            decimal -=20;
        if(roman.toUpperCase().indexOf("CD") != -1)
            decimal -=200;
        if (roman.toUpperCase().indexOf("CM") != -1)
            decimal -=200;
        return decimal;
    }

    /**
     * this runs the program
     * @param args
     */
    public static void main(String[] args) {
        for(String temp : args) {
            int val = romanToDecimal(temp);
            if(val == -1)
                System.out.println("Input: " + temp + " => output: invalid");
            else
                System.out.println("Input: " + temp + " => output: " + val);
        }
    }
}
