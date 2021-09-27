import java.util.Scanner;

/**
 * javadoc this thang
 * @version Monday, September 27, 2021
 * @Author Aaron Caveney
 */
public class SimpleIOMath {
    private String name;
    private int age;
    private int favNumber;
    private int extra;

    /**
     * this takes the user input and finds the smallest prime in it
     * @param num
     * @return
     */
    private int smallestPrime(int num) {
        for(int i = 2; i <= (int)(Math.sqrt(num))+1; i++) {
            if(num % i ==0)
                return i;

        }
        return num;
    }

    /**
     * no paramaters because it takes the user info and stores it.
    */
    public void promptUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Question 1: What is your name?");
        name = input.nextLine();
        System.out.println("Question 2: How old are you?");
        age = input.nextInt();
        System.out.println("Question 3: What is your favorite number?");
        favNumber = input.nextInt();
        extra = (int) Math.sqrt(favNumber);
    }

    /**
     *no paramaters because this just prints the user input in the main hub.
     */
    public void printInfo() {
        Scanner input = new Scanner(System.in);
        System.out.println("I'm gonna teach you how to sing it out\n" +
                "Come on, come on, come on\n" +
                "Let me tell you what it's all about\n" +
                "Reading, writing, arithmetic\n" +
                "Are the branches of the learning tree");
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " +age);
        System.out.println(" At your next birthday, you will turn " + age ++ +".");
        System.out.println("The first prime factor of " + age + " is: " + smallestPrime(age));
        System.out.println("Your favorite number is: " + favNumber);
        System.out.println("Your favorite number squared is: " + favNumber*favNumber);
        /**
         * code that didnt work
        System.out.println("The square root of your age is " + extra );
        if(extra <= 0);
        System.out.println("you faverite number is needs to be greater than 0");*/
    }


    public void getExtra() {
        if(favNumber > 0)
            System.out.println("your favorite number square rooted and rounded to the nearest whole number is " + extra);
        if(favNumber <= 0)
            System.out.println("your favorite number needs to be greater than 0 for the extra");
    }

    /**
     * main entry point for simpleIO math.
     * The center hub for all methods and how i print everything.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("* Sit yourself down, take a seat");
        System.out.println("* All you gotta do is repeat after me *");
        SimpleIOMath obj = new SimpleIOMath();
        obj.promptUser();
        obj.printInfo();
        obj.getExtra();
        System.out.println("* end of program *");
    }
}
