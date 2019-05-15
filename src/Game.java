import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Game {

    public void startGame(String requiredText) {
        String requiredTextCopy = requiredText;

        String strToGuess = createStringToGuess(requiredTextCopy.length());
        Set<String> setForEnteredValues = new HashSet<String>();
        Scanner scanner = new Scanner(System.in);

        while (strToGuess.contains("*")) {
            String userInput = scanner.nextLine().toLowerCase();

            if (!isAlpha(userInput)) {
                System.out.println("Please enter the correct symbol(s), only letters can be used in name and whitespace");
            }
            if (setForEnteredValues.contains(userInput)) {
                System.out.println("You already entered this string, let's use another one");
            } else {
                setForEnteredValues.add(userInput);
                if (!requiredTextCopy.contains(userInput)) {
                    System.out.println("Ooops but you didn't guess :(, let's try another one. You can do it!");
                } else {
                    while (requiredTextCopy.contains(userInput)) {
                        int indexOfFinding = requiredTextCopy.indexOf(userInput);
                        strToGuess = modifyStringToGuess(strToGuess, indexOfFinding, userInput);
                        requiredTextCopy = modifyRequiredTextString(requiredTextCopy, indexOfFinding, userInput.length());
                    }
                    if (strToGuess.contains("*")) {
                        System.out.println("Great job! You guessed right! :)");
                        System.out.println("Now try to guess where * shown, your result for now is " + strToGuess);
                    }
                }
            }
        }
        System.out.println("Congrats! You guessed the word(s).");
    }

    private boolean isAlpha(String userInputString) {
        return userInputString.matches("[a-zA-Z\\s]+");
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

