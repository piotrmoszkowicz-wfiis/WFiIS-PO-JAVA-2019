public class lab04 {
    public static void main(String[] args) {
        if (args.length < 4) {
            throw new IllegalStateException("Wrong parameters - use like java lab04 size_x size_y steps preset");
        }
        int sizeX = Integer.parseInt(args[0]);
        int sizeY = Integer.parseInt(args[1]);
        int steps = Integer.parseInt(args[2]);
        int preset = Integer.parseInt(args[3]);

        GameBoard gameBoard = new GameBoard(sizeX, sizeY);

        switch (preset) {
            case 0:
                gameBoard.generateRandom();
                break;
            case 1:
                gameBoard.generateLod();
                break;
            case 2:
                gameBoard.generateBlinker();
                break;
            case 3:
                gameBoard.generateSpaceship();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + preset);
        }

        for (int i = 1; i <= steps; i++) {
            gameBoard.print(i);
            gameBoard.nextGeneration();
        }
    }
}
