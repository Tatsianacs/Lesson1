import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Game {

     public void startGame(String requiredText) {
        String strToGuess = createStringToGuess(requiredText.length());
        Set<String> setForEnteredValues = new HashSet<String>();

        while (strToGuess.contains("*")) {
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine().toLowerCase();

            if (!isAlpha(userInput)) {
                System.out.println("Please enter the correct symbol(s), only letters can be used in name");
            }
            if (setForEnteredValues.contains(userInput)) {
                System.out.println("You already entered this string");
            } else {
                setForEnteredValues.add(userInput);
                if (!requiredText.contains(userInput)) {
                    System.out.println("Sorry but you didn't guess");
                } else {
                    while (requiredText.contains(userInput)) {
                        int indexOfFinding = requiredText.indexOf(userInput);
                        strToGuess = modifyStringToGuess(strToGuess, indexOfFinding, userInput);
                        requiredText = modifyRequiredTextString(requiredText, indexOfFinding, userInput.length());
                    }
                    System.out.println("You guessed right!");
                    System.out.println("try to guess now where *, your result is " + strToGuess);
                }
            }
        }
        System.out.println("Congrats! You guessed the word(s).");
    }

    private boolean isAlpha(String userInputString) {
        return userInputString.matches("[a-zA-Z]+");
    }

    private String createAsteriskString(int number) {
        String resultString = "";
        for (int i = 0; i < number; i++) {
            resultString += "*";
        }
        return resultString;
    }

    private String createStringToGuess(int length) {
        char[] charArray = new char[length];
        Arrays.fill(charArray, '*');
        return new String(charArray);
    }

    private String modifyStringToGuess(String str, int index, String inputValue) {
        return str.substring(0, index) + inputValue + str.substring(index + inputValue.length());
    }

    private String modifyRequiredTextString(String str, int index, int inputLength) {
        return str.substring(0, index) + createAsteriskString(inputLength) + str.substring(index + inputLength);
    }

}

