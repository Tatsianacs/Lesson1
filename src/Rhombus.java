public class Rhombus {

    public void printRhombus(int number) {
        for (int i = 0; i < number; i ++){
            for (int j = 0; j < number; j++) {
                if (j == ((number/2) - i) || j == ((number/ 2) + i) || j == (-number/2 + i) || j == ((3 * number/2) - i - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
