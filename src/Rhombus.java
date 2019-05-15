public class Rhombus {

    public void printRhombus(int ribSize) {
        int twoRibSize = ribSize * 2;
        for (int i = 0; i < twoRibSize - 1; i++){
            for (int j = 0; j < twoRibSize - 1; j++) {
                if (j == ((twoRibSize/2) - i - 1)|| j == ((twoRibSize/ 2) + i - 1) || j == (-twoRibSize/2 + i + 1) || j == ((3 * twoRibSize/2) - i - 3)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
