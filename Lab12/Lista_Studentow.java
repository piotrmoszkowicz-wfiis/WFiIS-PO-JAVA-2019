import java.util.ArrayList;
import java.util.Comparator;

public class Lista_Studentow {
    ArrayList<Student> lista_studentow;

    Lista_Studentow() {
        lista_studentow = new ArrayList<>();
    }

    public void add(Student student) {
        lista_studentow.add(student);
    }

    public void add(String imie, String nazwisko, int wiek) {
        Student student = new Student(imie, nazwisko, wiek);
        this.add(student);
    }

    public void wypisz_wszystkich() {
        lista_studentow.forEach(System.out::println);
    }

    public void sort_imie_rosnaca() {
        lista_studentow.sort(Comparator.comparing(Student::getImie));
    }

    public void sort_imie_malejaca() {
        lista_studentow.sort(Comparator.comparing(Student::getImie).reversed());
    }

    public void sort_nazwisko_rosnaca() {
        lista_studentow.sort(Comparator.comparing(Student::getNazwisko));
    }

    public void sort_nazwisko_malejaca() {
        lista_studentow.sort(Comparator.comparing(Student::getNazwisko).reversed());
    }

    public void sort_wiek_rosnaca() {
        lista_studentow.sort(Comparator.comparing(Student::getWiek));
    }

    public void sort_wiek_malejaca() {
        lista_studentow.sort(Comparator.comparing(Student::getWiek).reversed());
    }
}
