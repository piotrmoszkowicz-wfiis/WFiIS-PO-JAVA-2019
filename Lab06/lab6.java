import Armia.Czolg;
import Armia.CentrumDowodzenia;
import Armia.Rozkaz;

public class lab6
{
    public static void main(String[] argv)
    {
        //Utworzenie obiektu Czolg
        Czolg tank_1 = new Czolg();

        //Utworzenie obiektu CentrumDowodzenia
        CentrumDowodzenia headquarters = new CentrumDowodzenia();

        //Zarejestrowanie przez CentrumDowodzenia czolgu tank_1
        headquarters.zarejestrujCzolg(tank_1);

        //Zarejestrowanie 3 kolejnych czolgow
        for(int i=0;i<3;i++) headquarters.zarejestrujCzolg(new Czolg());

        //Wyslanie do 3 pierwszych czolgow komunikatu "jechac na polnoc"
        for(int i=1;i<4;i++) headquarters.wydajRozkaz(new String("" + i),new Rozkaz("jechac na polnoc"));

        //Wyslanie do 2 pierwszych czolgow komunikatu "stac!"
        for(int i=1;i<3;i++) headquarters.wydajRozkaz(new String("" + i),new Rozkaz("stac!"));

        //Wyslanie komunikatu do 1 czolgu "ognia!"
        headquarters.wydajRozkaz("1",new Rozkaz("ognia!"));

        //Wyslanie komunikatu do 4 czolgu "doloczyc do reszty"
        headquarters.wydajRozkaz("4",new Rozkaz("doloczyc do reszty"));

        //Wypisanie wszystkich wyslanych rozkazow
        System.out.println(headquarters);

        //Wypisanie ostatniego rozkazu wyslanego do czolgu nr 1
        System.out.println(tank_1.ostatniRozkaz());
    }
}

/*
Do tej pory centrum dowodzenia wyslalo nastepujace rozkazy:
Czolg nr 1 otrzymal rozkazy:
jechac na polnoc
stac!
ognia!

Czolg nr 2 otrzymal rozkazy:
jechac na polnoc
stac!

Czolg nr 3 otrzymal rozkazy:
jechac na polnoc

Czolg nr 4 otrzymal rozkazy:
doloczyc do reszty


Ostatni rozkaz do mnie: ognia!
*/
