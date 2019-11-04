import java.lang.*;

public class lab3string {
    public static int dlugosc(String a) {
        return a.length();
    }

    public static int ile_razy_literka_wystepuje(String a, char b) {
        int ilosc = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b) {
                ilosc++;
            }
        }

        return ilosc;
    }

    public static Boolean czy_takie_same(String a, String b) {
        return a.equals(b);
    }

    public static String wspak(String a) {
        return new StringBuilder(a).reverse().toString();
    }

    public static Boolean czy_plaindrom(String a) {
        return a.equals(wspak(a));
    }

    public static Boolean czy_abecadlowe(String a) {
        char codeBefore = a.charAt(0);

        for (int i = 1; i < a.length(); i++) {
            if (codeBefore > a.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static String rot13(String a) {
        String result = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) >= 'a' && a.charAt(i) <= 'z') {
                int c = ((a.charAt(i) + 13) % 'z');
                if (c < 'a') {
                    c += 'a' - 1;
                }
                result += (char)(c);
            } else if (a.charAt(i) >= 'A' && a.charAt(i) <= 'Z') {
                int c = ((a.charAt(i) + 13) % 'Z');
                if (c < 'A') {
                    c += 'A' - 1;
                }
                result += (char)(c);
            } else {
                result += a.charAt(i);
            }
        }
        return result;
    }
}