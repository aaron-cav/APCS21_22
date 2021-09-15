/**
 * holy grail is an interactive program that ask the user for input and then returns their answer.
 * @author Aaron Caveney
 * @version 9/15/2021
 */

import java.util.Scanner;
public class HolyGrail{
    /**
     * Main entry point
     * @param args none
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("* A chat with the bridge keeper *");
        System.out.print("\nWho would cross the Bridge of Death must answer me these\n" +
                "questions three, ere the other side he see.");
        System.out.print("\n Question 1: What is your name?");
        String name = input.nextLine();
        System.out.print("Question 2: What is your quest?");
        String quest = input.nextLine();
        System.out.print("Question 3: What is your favorite color?");
        String color = input.nextLine();
        System.out.print("King Arthur says, \"You have to know these things when you're a\n" +
                "king, you know.\"");
        System.out.print("\nYour name is:" + name + "\n Your quest is:" + quest + "\n Your favorite color is: " + color);
    }
}