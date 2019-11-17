//Tego pliku nie można zmieniać!!!!!!
//Proszę zaimplementować klasy:
//Shape, Point, Squere, Cube tak aby program poniżej działał prawidłowo. Wyjście z programu podane jest na końcu pliku. 
// ^ ta kolejność wyżej jest też kolejnością dziedziczenia. WAŻNE jest aby jak najbardziej korzystać z metod klas po 
// których się dziedziczy. Np. Skoro klasa Point "umie" już wypisać [22.0, 8.0] to po co to implementować po raz kolejny???
// To samo dotyczy objętości i pól powierzchni. 
// Jeśli ktoś to będzie za każdym razem implementował to niestety pojadę po punktacji (można stracić w ten sposób aż 3 punkty!!!)
//
// Miłej zabawy :-)

public class lab5 
{
 public static void main( String args[] )
  {
   Point point = new Point( 7, 11 );          
   Square square = new Square( 3.5, 22, 8 );  
   Cube cube = new Cube( 3.3, 10, 10 ); 

   Shape[] arrayOfShapes = new Shape[ 3 ];
   String result = "";

   arrayOfShapes[ 0 ] = point;
   arrayOfShapes[ 1 ] = square;
   arrayOfShapes[ 2 ] = cube;  
   
   result += point.getName() + ": " + point.toString();
   result += "\n" + square.getName() + ": " + square.toString();
   result += "\n" + cube.getName() + ": " + cube.toString();
     
   for ( int i = 0; i < 3; i++ )
    {
     result += "\n" + arrayOfShapes[ i ].getName() + ": " + arrayOfShapes[ i ].toString();
     result += "\n" + "Area = " + arrayOfShapes[ i ].area();
     result += "\n" + "Volume = " + arrayOfShapes[ i ].volume();
    }
   System.out.println(result+"\n");
   
   double pkt = 0.0;
   String[] toStr_test = { "[7.0, 11.0]","Corner = [22.0, 8.0]; side = 3.5","Corner = [10.0, 10.0]; side = 3.3; depth = 3.3" } ;
   
   for ( int i = 0; i < 3; i++ )
    {
     System.out.print("Checking "+ arrayOfShapes[ i ].getName() + ".toString() ...");
     if (arrayOfShapes[ i ].toString().equals(toStr_test[i])) { System.out.println("OK"); pkt = pkt + 0.5; }
                                          else { System.out.println("ERROR!"); }
    }

   double[] area = {0.0,12.25,65.33999999999999};
   System.out.println(" ");
   for ( int i = 0; i < 3; i++ )
    {
     System.out.print("Checking "+ arrayOfShapes[ i ].getName() + ".area() ...");
     if (arrayOfShapes[ i ].area()==area[i]) { System.out.println("OK"); pkt = pkt + 0.5; }
                                          else { System.out.println("ERROR!"); }
    }

   double[] volume = {0.0,0.0,35.937};
   System.out.println(" ");
   for ( int i = 0; i < 3; i++ )
    {
     System.out.print("Checking "+ arrayOfShapes[ i ].getName() + ".volume() ...");
     if (arrayOfShapes[ i ].volume()==volume[i]) { System.out.println("OK"); pkt = pkt + 1.0; }
                                          else { System.out.println("ERROR!"); }
    }
	
   System.out.println("\n Punkty: " + pkt + " (reszta za dziedziczenie...)");
	
  }
}
/*
Point: [7.0, 11.0]
Square: Corner = [22.0, 8.0]; side = 3.5
Cube: Corner = [10.0, 10.0]; side = 3.3; depth = 3.3
Point: [7.0, 11.0]
Area = 0.0
Volume = 0.0
Square: Corner = [22.0, 8.0]; side = 3.5
Area = 12.25
Volume = 0.0
Cube: Corner = [10.0, 10.0]; side = 3.3; depth = 3.3
Area = 65.33999999999999
Volume = 35.937

Checking Point.toString() ...OK
Checking Square.toString() ...OK
Checking Cube.toString() ...OK

Checking Point.area() ...OK
Checking Square.area() ...OK
Checking Cube.area() ...OK

Checking Point.volume() ...OK
Checking Square.volume() ...OK
Checking Cube.volume() ...OK

 Punkty: 6.0 (reszta za dokumentacje i dziedziczenie...)
*/
