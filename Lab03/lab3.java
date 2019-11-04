//Proszę zaimplementować klasę lab3string
//UWAGA! Rozwiązanie w stylu:
//String wspak(String a)
// {
//  return "kapsw eizdeb ot";
// }
// oznacza automatycznie 0 (ZERO) punktów (choćby dotyczyło TYLKO JEDNEJ metody).

public class lab3
{
 public static void main(String[] args)
 {
  double punkty = 0.0;
  
  String s1 = "banan";
  String s2 = "truskawka";
  
  // 1 punkt
  int dlugosc = lab3string.dlugosc(s1);
  if (dlugosc == 5) punkty = punkty + 0.5;
  System.out.println("Slowo '" + s1 + "' ma " + dlugosc + " liter. (5)");
  
  dlugosc = lab3string.dlugosc(s2);
  if (dlugosc == 9) punkty = punkty + 0.5;
  System.out.println("Slowo '" + s2 + "' ma " + dlugosc + " liter. (9)");
  
  // 1 punkt
  
  int ile_razy = lab3string.ile_razy_literka_wystepuje(s1,'a');
  if (ile_razy == 2) punkty = punkty + 0.5;
  System.out.println("W slowie '" + s1 + "' literka 'a' pojawia sie " + ile_razy + " razy. (2)");
  
  ile_razy = lab3string.ile_razy_literka_wystepuje(s2,'u');
  if (ile_razy == 1) punkty = punkty + 0.5;
  System.out.println("W slowie '" + s2 + "' literka 'u' pojawia sie " + ile_razy + " raz. (1)");
  
    
  // 1 punkt
  
  boolean takie_same = lab3string.czy_takie_same("test1","test1");
  if (takie_same == true) punkty = punkty + 0.5;
  System.out.println("czy_takie_same(\"test1\",\"test1\") = " + takie_same);

  takie_same = lab3string.czy_takie_same("blabla","test1");
  if (takie_same == false) punkty = punkty + 0.5;
  System.out.println("czy_takie_same(\"blabla\",\"test1\") = " + takie_same);

  // 1 punkt
  
  String t1 = lab3string.wspak("to bedzie wspak");
  if (t1.equals("kapsw eizdeb ot") == true) punkty = punkty + 1.0;
  System.out.println("wspak(\"to bedzie wspak\") = \"" + t1 + "\" (\"kapsw eizdeb ot\")");
  
  // 1 punkt
  
  //palindrom to słowo które czytane wspak jest takie samo
  boolean palindrom = lab3string.czy_plaindrom("otto");
  if (palindrom == true) punkty = punkty + 0.5;
  System.out.println("czy_plaindrom(\"otto\") = " + palindrom);  
  
  palindrom = lab3string.czy_plaindrom("kot");
  if (palindrom == false) punkty = punkty + 0.5;
  System.out.println("czy_plaindrom(\"kot\") = " + palindrom); 

  // 1 punkt
  
  //słowo - nazwijmy je "abecadłowe" to takie w którym litery występują w kolejności alfabetycznej
  //np "abc" czy "aceh" to słowa abecadłowe a "zda" już takim słowem nie jest
  boolean abecadlowe = lab3string.czy_abecadlowe("abcdef");
  if (abecadlowe == true) punkty = punkty + 0.5;
  System.out.println("czy_abecadlowe(\"abcdef\") = " + abecadlowe);  
  
  abecadlowe = lab3string.czy_abecadlowe("zebra");
  if (abecadlowe == false) punkty = punkty + 0.5;
  System.out.println("czy_abecadlowe(\"zebra\") = " + abecadlowe);   

  //2 punkty
  // ROT13 to metoda kodowania polegająca na tym, ze przesuwamy litery o 13 do przodu w alfabecie czyli:
  // A staje się N, B przechodzi w O, i tak dalej aż do M, które przechodzi w Z, potem się to "zawija" czyli: 
  // N przechodzi w A, O przechodzi w B, i tak dalej aż do Z, które przechodzi w M.
  // ponieważ w alfabecie jest 26 (bez polskich znaków!) liter to:
  // ROT13(ROT13(x)) = x
  // znaki specjalne nie zostają zmieniane
  System.out.println(lab3string.rot13("Why did the chicken cross the road?"));
  System.out.println(lab3string.rot13("Gb trg gb gur bgure fvqr!"));
  
  
  System.out.println("\nPunkty: " + punkty + " (max 6, potem dodam 2 pkt za rot13, reszta za komentarze w javadoc).");  
 }
}
