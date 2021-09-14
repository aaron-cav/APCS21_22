import java.util.Scanner;

public class HolyGrail {
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
        System.out.print("Your name is:" + name +"\n Your quest is:" + quest +"\n Your favorite color is: " + color);
    }
}
