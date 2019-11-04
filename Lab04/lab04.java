import java.util.Random;

public class lab04 {
    private static int[][] generateRandom(int sizeX, int sizeY, Random randomGenerator) {
        int[][] game = new int[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                game[i][j] = randomGenerator.nextInt(2);
            }
        }

        return game;
    }

    private static int[][] generateLod(int sizeX, int sizeY) {
        int[][] game = new int[sizeX][sizeY];

        int midX = (sizeX) / 2;
        int midY = (sizeY) / 2;

        game[midX - 1][midY - 1] = 1;
        game[midX][midY - 1] = 1;
        game[midX - 1][midY] = 1;
        game[midX + 1][midY] = 1;
        game[midX][midY + 1] = 1;

        return game;
    }

    private static int[][] generateBlinker(int sizeX, int sizeY) {
        int[][] game = new int[sizeX][sizeY];

        int midX = (sizeX) / 2;
        int midY = (sizeY) / 2;

        game[midX][midY - 1] = 1;
        game[midX][midY] = 1;
        game[midX][midY + 1] = 1;

        return game;
    }

    private static int[][] generateSpaceship(int sizeX, int sizeY) {
        int[][] game = new int[sizeX][sizeY];

        int midX = (sizeX) / 2;
        int midY = (sizeY) / 2;

        game[midX - 1][midY - 1] = 1;
        game[midX][midY - 1] = 1;
        game[midX + 1][midY - 1] = 1;
        game[midX - 1][midY] = 1;
        game[midX][midY + 1] = 1;

        return game;
    }

    private static void print(int sizeX, int sizeY, int[][] game, int iteration) {
        System.out.println("--------- " + iteration + " --------");
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                char c = (game[i][j] == 1) ? 'X' : '.';
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static int [][] nextGeneration(int sizeX, int sizeY, int[][] game) {
        int[][] nextGenerationArray = new int[sizeX][sizeY];

        for (int l = 1; l < sizeX - 1; l++) {
            for (int m = 1; m < sizeY - 1; m++) {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        aliveNeighbours += game[l + i][m + j];
                    }
                }

                aliveNeighbours -= game[l][m];

                if ((game[l][m] == 1) && (aliveNeighbours < 2)) {
                    nextGenerationArray[l][m] = 0;
                } else if ((game[l][m] == 1) && (aliveNeighbours > 3)) {
                    nextGenerationArray[l][m] = 0;
                } else if ((game[l][m] == 0) && (aliveNeighbours == 3)) {
                    nextGenerationArray[l][m] = 1;
                } else {
                    nextGenerationArray[l][m] = game[l][m];
                }
            }
        }

        return nextGenerationArray;
    }

    public static void main(String[] args) {
        int sizeX = Integer.parseInt(args[0]);
        int sizeY = Integer.parseInt(args[1]);
        int steps = Integer.parseInt(args[2]);
        int preset = Integer.parseInt(args[3]);

        Random randomGenerator = new Random();

        int[][] game;

        switch (preset) {
            case 0:
                game = generateRandom(sizeX, sizeY, randomGenerator);
                break;
            case 1:
                game = generateLod(sizeX, sizeY);
                break;
            case 2:
                game = generateBlinker(sizeX, sizeY);
                break;
            case 3:
                game = generateSpaceship(sizeX, sizeY);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + preset);
        }

        for (int i = 1; i <= steps; i++) {
            print(sizeX, sizeY, game, i);
            game = nextGeneration(sizeX, sizeY, game);
        }
    }
}
