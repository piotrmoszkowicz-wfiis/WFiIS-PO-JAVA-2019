import java.io.*;
import java.util.Arrays;
import java.util.Collections;


public class lab9 {
    public static void main(String[] args) {
        String fileName = args[0];
        String[] firstLine = new String[3];
        int numberOfPoints = 0;
        Points points = new Points();

        try {
            BufferedReader f = new BufferedReader(new FileReader(fileName));
            firstLine = f.readLine().split(" ");
            numberOfPoints = Integer.parseInt(f.readLine());

            for (int i = 0; i < numberOfPoints; i++) {
                String[] lineWithPoint;
                lineWithPoint = f.readLine().split(",");
                int x = Integer.parseInt(lineWithPoint[0]);
                int y = Integer.parseInt(lineWithPoint[1]);

                points.addPoint(new Point(x, y));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        int h = Integer.parseInt(firstLine[0]);
        int w = Integer.parseInt(firstLine[1]);
        String outputName = firstLine[2];


        FileWriter writer = null;
        try {
            writer = new FileWriter(new File(outputName));
            writer.write("P3\n");
            writer.write("#Piotr Moszkowicz\n");
            writer.write(h + " " + w + "\n");
            writer.write("255\n");

            for (int currY = 0; currY < h; currY++) {
                for (int currX = 0; currX < w; currX++) {
                    Double[] distances = new Double[numberOfPoints];

                    Point currentPoint = new Point(currX, currY);

                    for (int i = 0; i < numberOfPoints; i++) {
                        distances[i] = currentPoint.calculateDistanceTo(points.get(i));
                    }

                    Arrays.sort(distances, Collections.reverseOrder());

                    if (Math.abs(distances[0] - distances[1]) < 1.4) {
                        writer.write("0 0 0 ");
                    } else {
                        writer.write("255 255 255 ");
                    }
                }
                writer.write("\n");
            }

        } catch (IOException e) {
            System.out.println("Wystapil blad podczas wpisywania danych do pliku wyjsciowego " + outputName + ".");
        } finally {
            try {
                assert writer != null;
                writer.close();
            } catch (IOException e) {
                System.out.println("Wystapil blad podczas zamykania pliku wyjsciowego " + outputName + ".");
            }
        }
    }
}
