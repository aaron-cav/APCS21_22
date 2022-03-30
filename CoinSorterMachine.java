import java.io.File;
import java.text.DecimalFormat;
import java.util.*;

public class CoinSorterMachine {
    String file = "datafiles/";
    ArrayList<Coins> coins = new ArrayList<Coins>();
    ArrayList<Integer> error = new ArrayList<Integer>();
    int pennyCount = 0;
    int nickelCount = 0;
    int dimeCount = 0;
    int quarterCount = 0;
    int halfCount = 0;
    int dollarCount = 0;
    //String end = "TOTAL DEPOSIT: ";

    //ArrayList<Double> totalValue = new ArrayList<Double>();
    //private ArrayList<Coins> coins;
    // initializes coins ArrayList
    public CoinSorterMachine()  {
        ArrayList<Coins> coins = new ArrayList<Coins>();
    }
    // use one or two Scanner objects, prompting user for the appropriate file
    // name and importing the data from filename – MUST handle diabolic values!
    public void depositCoins()  {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name of the data file for coin deposit: ");
        file += in.nextLine();
        System.out.println("Depositing coins...");
        //System.out.println(file);
        try {
            Scanner done = new Scanner(new File(file));
            while(done.hasNext())   {
                int temp = done.nextInt();
                if( temp == 1)
                    coins.add(new Penny());
                else if( temp == 5)
                    coins.add(new Nickel());
                else if( temp == 10)
                    coins.add(new Dime());
                else if( temp == 25)
                    coins.add(new Quarter());
                else if( temp == 50)
                    coins.add(new HalfDollar());
                else if( temp == 100)
                    coins.add(new Dollar());
                else
                    System.out.println("Coin value " + temp +" not recognized");;
            }
            done.close();
            //System.out.println(coins);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Prints deposit summary using a DecimalFormat object (see output section)
    public void printDepositSummary() {
        DecimalFormat df = new DecimalFormat("$0.00");
        for (Coins value : coins) {
            if (value.getName().equals("Penny")) {
                pennyCount  = pennyCount+ 1;
            }
            else if (value.getName().equals("Nickel")) {
                nickelCount  = nickelCount+ 1;
            }
            else if (value.getName().equals("Dime")) {
                dimeCount  = dimeCount+ 1;
            }
            else if (value.getName().equals("Quarter")) {
                quarterCount  = quarterCount+ 1;
            }
            else if (value.getName().equals("HalfDollar")) {
                halfCount  = halfCount+ 1;
            }
            else if (value.getName().equals("Dollar")) {
                dollarCount  = dollarCount+ 1;
            }
        }
        //System.out.println(String.format("%.2f", pennyCount));
        //error.replaceAll(",", " ")
        //System.out.println("Depositing coins...");
        //System.out.println("Coin value " + error +" not recognized");
        System.out.println("Summary of deposit:");
        System.out.println("\t"+pennyCount + " pennies "+ (df.format(pennyCount*0.010)));
        System.out.println("\t"+nickelCount+ " nickels "+ (df.format(nickelCount*0.050)));
        System.out.println("\t"+dimeCount+ " dimes "+ (df.format(dimeCount*0.10)));
        System.out.println("\t"+quarterCount+ " quarters "+ (df.format(quarterCount*0.25)));
        System.out.println("\t"+halfCount+ " half dollars "+ (df.format(halfCount*0.50)));
        System.out.println("\t"+dollarCount+ " dollars "+ (df.format(dollarCount*1)));
        getTotalValue();
    }
    // return the total value of all Coin objects stored in coins as a double
    public double getTotalValue() {
        double finalAmount = ((pennyCount * 1) + (nickelCount * 5) + (dimeCount * 10)+(quarterCount * 25)+(halfCount * 50)+(dollarCount * 100))/100.0;
        System.out.println("TOTAL DEPOSIT: $"+finalAmount);
        return finalAmount;
    }
    // main method for the class should use these exact three lines of code
    public static void main(String[] args){
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
}

