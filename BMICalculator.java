import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * BMI calculator computes body weight and height and uses those to caculate your BMI
 * @version 11/8/2021
 * @Auther Aaron Caveney
 */
public class BMICalculator {
    /**
     * This method is doing the formula to BMI
     * @param inches
     * @param pounds
     * @return
     */
    public static double computeBMI(int inches, int pounds) {
        if(inches <= 0 || pounds < 0)
            return 0;
        return pounds*.454 / Math.pow(inches*0.0254, 2);
    }

    /**
     * This method is finding the how tall the user is in inches
     * @param heightIN
     * @return
     */
    public static int extractInches(String heightIN) {
        int qtPos = heightIN.indexOf("'");
        int dblQtPos = heightIN.indexOf("\"");
        if (qtPos == -1 || dblQtPos == -1) {
            return -1;
        }
        int feet = Integer.parseInt(heightIN.substring(0, qtPos));
        int inches = Integer.parseInt(heightIN.substring(qtPos + 1, dblQtPos));
        if (inches < 0 || inches > 11 || feet < 0)
            return -1;

        return (feet * 12 + inches == 0) ? -1 : feet * 12 + inches;
    }

    /**
     * this is the main for the program. this method is initalizing and running the program
     * @param args
     */
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        while(true) {
            try {
                System.out.print("Enter your height in feet and inches (Ex 6'1\"): ");
                String height = in.nextLine();
                //int inches = extractInches(height);
                System.out.print("Enter your weight in pounds: ");
                Integer weight = in.nextInt();
                in.nextLine();
                //System.out.println("your BMI is: "+ df.format(computeBMI(height, weight)));
                //System.out.println(computeBMI(extractInches(height), weight));
                System.out.println("Your BMI, Expresed as weight(kg)/height(m)^2: " + df.format(computeBMI(extractInches(height), weight)));
                System.out.print("Continue (Y/N): ");
                String cont = in.nextLine();
                if (!cont.toLowerCase().equals("y"))
                    break;
            }
            catch(Exception e)  {
                System.out.println("Invalid data entered, please try again.");
                in.nextLine();
            }
        }
        System.out.println("end of program");
    }
}


