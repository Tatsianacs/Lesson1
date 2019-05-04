import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex","Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
    static Integer[] times  = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};

    public static void main(String[] args)  {

        // String Basics
        System.out.println("String basics task. Please enter the string below".toUpperCase());
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        StringBasics stringToCheck = new StringBasics();
        System.out.println("Reversed string is " + stringToCheck.reverseString(userInput));
        System.out.println("Splitted string:");
        stringToCheck.splitString(userInput);
        System.out.println("Replaced with asterisk is " + userInput.replace(" ", "*"));
        System.out.println("String in Upper case is " + userInput.toUpperCase());
        if (userInput.length() > 10) {
            System.out.println("Substring is " + userInput.substring(5,11));
        }

        // Print day of Week
        System.out.println("Print day of week task. Please enter week day number below".toUpperCase());
        WeekDays guessDay = new WeekDays();
        try {
            int enteredNumber = scanner.nextInt();
            System.out.println("Required day is " + guessDay.getDayName(enteredNumber));
        } catch (InputMismatchException e) {
            System.out.println("Invalid value");
        }

        // Print Rhombus
        System.out.println("Print rhombus task. Please enter size of side of rhombus below".toUpperCase());
        Rhombus rhombus = new Rhombus();
        try {
            int enteredNumber = scanner.nextInt();
            rhombus.printRhombus(enteredNumber);
        } catch (InputMismatchException e) {
            System.out.println("Invalid value");
        }

        // Marathon
        Marathon marathon = new Marathon();
        Map<String, Integer> marathonMap = marathon.createHashMap(names, times);
        System.out.println(marathonMap);
        System.out.println("Please enter below the place of the person to show info:");
        try {
            int enteredPlace = scanner.nextInt();
            System.out.println("The person place and time: " + marathon.getParticipantInfo(enteredPlace, marathonMap));
        } catch (InputMismatchException e) {
            System.out.println("Invalid value");
        }
        System.out.println("Second place: " + marathon.getParticipantInfo(2, marathonMap));
        System.out.println("Winner: " + marathon.getParticipantInfo(1, marathonMap));


        // Game
        System.out.println("Let's play the game, try to guess the word(s)".toUpperCase());
        Game game = new Game();
        game.startGame("tatsiana masiukevich");
    }

}
