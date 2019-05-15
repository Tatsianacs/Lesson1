public class StringBasics {

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void splitStringAndPrint(String s) {
        String[] arrayOfWords = s.split(" ");
        for(String word: arrayOfWords) {
            System.out.println(word);
        }
    }
}
