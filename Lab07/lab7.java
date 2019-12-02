import java.util.Arrays;
import java.util.Scanner;

public class lab7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numOfNumbers = input.nextInt();
        int numOfTests = input.nextInt();

        int[][] tab = new int[numOfNumbers][numOfNumbers];

        for (int i = 0; i < numOfNumbers; i++) {
            for (int j = 0; j < numOfNumbers; j++) {
                tab[i][j] = (i == j) ? 1 : 0;
            }
        }

        for (int test = 0; test < numOfTests; test++) {
            int[] testScenario = new int[numOfNumbers];

            for (int i = 0; i < numOfNumbers; i++) {
                testScenario[i] = input.nextInt();
            }

            for (int i = 0; i < numOfNumbers / 2; i++) {
                for (int j = numOfNumbers / 2; j < numOfNumbers; j++) {
                    tab[testScenario[i] - 1][testScenario[j] - 1] = 1;
                    tab[testScenario[j] - 1][testScenario[i] - 1] = 1;
                }
            }
        }

        boolean result = ((numOfNumbers * numOfNumbers) == Arrays.stream(tab)
                .flatMapToInt(Arrays::stream)
                .sum());

        if (result) {
            System.out.println("TAK");
        } else {
            System.out.println("NIE");
        }

    }
}
