public class lab12 {
    public static void main(String[] args) {
        Student testowy_student = new Student();

        testowy_student.setImie("Jan");
        testowy_student.setNazwisko("Nowak");
        testowy_student.setWiek(22);

        System.out.println("Testowy student: " + testowy_student.getImie() + " "
                + testowy_student.getNazwisko() + " "
                + testowy_student.getWiek());
        System.out.println("-------------------------------");

        //UWAGA! Kolekcja wewnštrz klasy "Lista_Studentow" musi przechowywać obiekty klasy "Student"
        Lista_Studentow lista_studentow = new Lista_Studentow();

        lista_studentow.add(testowy_student);
        lista_studentow.add("Kamil", "Kloch", 23);
        lista_studentow.add("Alicja", "Akacja", 18);

        lista_studentow.wypisz_wszystkich();
        System.out.println("-------------------------------");

        //UWAGA! Do sortowania MUSI być wykorzystane Collections.sort(.....)
        lista_studentow.sort_imie_rosnaca();
        lista_studentow.wypisz_wszystkich();
        System.out.println("-------------------------------");

        lista_studentow.sort_imie_malejaca();
        lista_studentow.wypisz_wszystkich();
        System.out.println("-------------------------------");

        lista_studentow.sort_nazwisko_rosnaca();
        lista_studentow.wypisz_wszystkich();
        System.out.println("-------------------------------");

        lista_studentow.sort_nazwisko_malejaca();
        lista_studentow.wypisz_wszystkich();
        System.out.println("-------------------------------");

        lista_studentow.sort_wiek_rosnaca();
        lista_studentow.wypisz_wszystkich();
        System.out.println("-------------------------------");

        lista_studentow.sort_wiek_malejaca();
        lista_studentow.wypisz_wszystkich();
        System.out.println("-------------------------------");

    }
}

 /* Output:

Testowy student: Jan Nowak 22
-------------------------------
Jan Nowak 22
Kamil Kloch 23
Alicja Akacja 18
-------------------------------
Alicja Akacja 18
Jan Nowak 22
Kamil Kloch 23
-------------------------------
Kamil Kloch 23
Jan Nowak 22
Alicja Akacja 18
-------------------------------
Alicja Akacja 18
Kamil Kloch 23
Jan Nowak 22
-------------------------------
Jan Nowak 22
Kamil Kloch 23
Alicja Akacja 18
-------------------------------
Kamil Kloch 23
Jan Nowak 22
Alicja Akacja 18
-------------------------------
Alicja Akacja 18
Jan Nowak 22
Kamil Kloch 23
-------------------------------
 */
