/* Tego pliku nie wolno zmieniać! */public class lab11 {  public static void main(String[] args)   {    Stos<Integer> stos = new Stos<Integer>();    stos.push(10);    stos.push(20);    System.out.println(stos);    stos.push(30);    stos.push(40);    System.out.println(stos);    stos.pop();    stos.pop();    System.out.println(stos);
    Stos<String> stos2 = new Stos<String>();    stos2.push("a");    stos2.push("b");    System.out.println(stos2);    stos2.push("c");    stos2.push("d");    System.out.println(stos2);    stos2.pop();    stos2.pop();    System.out.println(stos2);  }}

/*Wynik:
{20} {10} 
{40} {30} {20} {10} 
{20} {10} 
{b} {a} 
{d} {c} {b} {a} 
{b} {a} 
*/
