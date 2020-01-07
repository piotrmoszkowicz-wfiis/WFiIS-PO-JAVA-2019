import java.io.*;

public class lab10 {
    public static void addToFile(String pl, String en) {
        String word = searchForWord(pl);

        if (word != null) {
            System.out.println("Taki wpis już istnieje.");
            return;
        }

        FileWriter writer = null;
        try {
            writer = new FileWriter(new File("slownik.txt"), true);
            writer.write(pl + ":" + en + "\n");
        } catch (IOException e) {
            System.out.println("Wystapil blad podczas wpisywania danych do pliku wyjsciowego.");
        } finally {
            try {
                assert writer != null;
                writer.close();
            } catch (IOException e) {
                System.out.println("Wystapil blad podczas zamykania pliku wyjsciowego.");
            }
        }
    }

    public static String searchForWord(String word) {
        try {
            BufferedReader f = new BufferedReader(new FileReader("slownik.txt"));

            String line;

            while((line = f.readLine()) != null) {
                String[] arr = line.split(":");
                if (arr[0].equals(word)) {
                    return arr[1];
                }
            }

            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void removeFromFile(String word) {
        FileWriter writer = null;
        try {
            File temp = new File("temp.txt");
            BufferedReader f = new BufferedReader(new FileReader("slownik.txt"));
            writer = new FileWriter(temp, true);

            String line;

            while((line = f.readLine()) != null) {
                if(line.contains(word)) {
                    continue;
                }
                writer.write(line + "\n");
            }

            temp.renameTo(new File("slownik.txt"));
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                assert writer != null;
                writer.close();
            } catch (IOException e) {
                System.out.println("Wystapil blad podczas zamykania pliku wyjsciowego.");
            }
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Bledna ilosc argumentow!");
            return;
        }

        File file = new File("slownik.txt");
        try {
            file.createNewFile();
        } catch (Exception e) {
            System.out.println(e);
        }


        String operation = args[0];

        if (operation.equals("add")) {
            if (args.length < 3) {
                System.out.println("Bledna ilosc argumentow!");
                return;
            }
            addToFile(args[1], args[2]);
        } else if (operation.equals("del")) {
            if (args.length < 2) {
                System.out.println("Bledna ilosc argumentow!");
                return;
            }
            removeFromFile(args[1]);
            System.out.println("Usunieto wpis");
        } else {
            String word = searchForWord(operation);
            if (word != null) {
                System.out.println(word);
            } else {
                System.out.println("Brak slowa w slowniku");
            }

        }
    }
}
