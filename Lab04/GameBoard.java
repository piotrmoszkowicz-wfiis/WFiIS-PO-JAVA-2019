import java.util.Random;

public class GameBoard {

    private int[][] game;
    private int sizeX;
    private int sizeY;
    private Random randomGenerator;

    GameBoard(int sizeX, int sizeY) {
        this.game = new int[sizeX][sizeY];
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.randomGenerator = new Random();;
    }

    public void generateRandom() {
        for (int i = 0; i < this.sizeX; i++) {
            for (int j = 0; j < this.sizeY; j++) {
                this.game[i][j] = randomGenerator.nextInt(2);
            }
        }
    }

    public void generateLod() {
        int midX = (this.sizeX) / 2;
        int midY = (this.sizeY) / 2;

        this.game[midX - 1][midY - 1] = 1;
        this.game[midX][midY - 1] = 1;
        this.game[midX - 1][midY] = 1;
        this.game[midX + 1][midY] = 1;
        this.game[midX][midY + 1] = 1;
    }

    public void generateBlinker() {
        int midX = (sizeX) / 2;
        int midY = (sizeY) / 2;

        this.game[midX][midY - 1] = 1;
        this.game[midX][midY] = 1;
        this.game[midX][midY + 1] = 1;
    }

    public void generateSpaceship() {
        int midX = (sizeX) / 2;
        int midY = (sizeY) / 2;

        this.game[midX - 1][midY - 1] = 1;
        this.game[midX][midY - 1] = 1;
        this.game[midX + 1][midY - 1] = 1;
        this.game[midX - 1][midY] = 1;
        this.game[midX][midY + 1] = 1;
    }

    public void print(int iteration) {
        System.out.println("--------- " + iteration + " --------");
        for (int i = 0; i < this.sizeX; i++) {
            for (int j = 0; j < this.sizeY; j++) {
                char c = (this.game[i][j] == 1) ? 'X' : '.';
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void nextGeneration() {
        int[][] nextGenerationArray = new int[sizeX][sizeY];

        for (int l = 1; l < this.sizeX - 1; l++) {
            for (int m = 1; m < this.sizeY - 1; m++) {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        aliveNeighbours += this.game[l + i][m + j];
                    }
                }

                aliveNeighbours -= this.game[l][m];

                if ((this.game[l][m] == 1) && (aliveNeighbours < 2)) {
                    nextGenerationArray[l][m] = 0;
                } else if ((this.game[l][m] == 1) && (aliveNeighbours > 3)) {
                    nextGenerationArray[l][m] = 0;
                } else if ((this.game[l][m] == 0) && (aliveNeighbours == 3)) {
                    nextGenerationArray[l][m] = 1;
                } else {
                    nextGenerationArray[l][m] = this.game[l][m];
                }
            }
        }

        this.game = nextGenerationArray;
    }
}