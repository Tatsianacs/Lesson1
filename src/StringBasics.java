public class StringBasics {

    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public void splitString(String s) {
        String[] arrayOfWords = s.split(" ");
        for(String word: arrayOfWords) {
            System.out.println(word);
        }
    }
}
