import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class lab8 {
    static void printCleanException(String exceptionString) {
        switch(exceptionString) {
            case "java.nio.file.NoSuchFileException":
                System.out.println("Nie ma takiego pliku");
                break;
            default:
                System.out.println("Inny błąd..:");
                break;
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Niepoprawna ilość argumentów. Program potrzebuje nazwy pliku wejściowego oraz nazwy pliku wyjściowego.");
            System.exit(0);
        }

        String fileInputName = args[0];
        String fileOutputName = args[1];

        double sum = 0;
        int i = 0;

        Charset charset = StandardCharsets.US_ASCII;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileInputName), charset)) {
            String number = null;
            while ((number = reader.readLine()) != null) {
                sum += Double.parseDouble(number);
                i++;
            }
        } catch (IOException x) {
            System.out.println(x.getClass().getCanonicalName());
            System.out.println("Wystąpił problem w trakcie otwierania pliku.");
            printCleanException(x.getClass().getCanonicalName());
            x.printStackTrace();
            System.exit(0);
        } catch (NumberFormatException x) {
            System.out.println("Natrafiono na złą wartość w pliku - nie jest to liczba");
            x.printStackTrace();
            System.exit(0);
        }

        if (i == 0) {
            System.out.println("Plik wejściowy nie zawiera liczb. Należy go wypełnić.");
            System.exit(0);
        }

        double result = sum / i;

        String resultString = String.valueOf(result);

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileOutputName), charset)) {
            writer.write(resultString, 0, resultString.length());
        } catch (IOException x) {
            System.out.println("Wystąpił problem w trakcie zapisu do pliku.");
            printCleanException(x.getClass().getCanonicalName());
            x.printStackTrace();
            System.exit(0);
        }
    }
}
