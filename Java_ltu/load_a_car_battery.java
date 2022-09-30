/**
 * En tabell som beskriver hur länge det tar att ladda ett bilbatteri på 35,8 kWh beroende på om man använder 230V eller
 * 400V samt 10- ,16- eller 32 A.
 * Flödesschema;
 * 1. Önskar veta laddtiden på bilbatteriet med 230V samt 400V.
 * 2. Räkna ut laddeffekt för 230V och 400V.
 * 3. Laddtiden är lagringseffekten/ laddeffekt.
 * 4. Presentera resultatet i en översiktlig tabell med de
 * olika värderna, laddeffekt och laddtiden i h. Skriv ut.
 * @author Carola Töyrä, cartoy-7*/

public class Uppgift1
{

   //En float variabel för lagringseffekten på batteriet, i enheten V.
   final static float BATTERI = 35800f;

   public static void main(String[] args)
   {
      //Gör variabler av värderna vi ska använda.

      int volt1 = 230;
      int volt2 = 400;

      int ampere10 = 10;
      int ampere16 = 16;
      int ampere32 = 32;


      // skriva ut dem i en tabell samt göra metod för uträkningarna av laddeffekt och laddtid.

      System.out.print("Batteri 35.8 (kWh)\n\n");

      System.out.print("Ström(A)\t\tSpänning(V)\t\tLaddeffekt(kW)\t\tLaddningstid(h)\n");

      System.out.print("===================================================================\n");

      System.out.print(ampere10 + "\t\t\t\t" + volt1 + "\t\t\t\t" + load230V(ampere10, volt1) + "\t\t\t\t\t" + loadTime230(ampere10, volt1) + "\n");

      System.out.print(ampere16 + "\t\t\t\t" + volt1 + "\t\t\t\t" + load230V(ampere16, volt1) + "\t\t\t\t" + loadTime230(ampere16, volt1) + "\n");

      System.out.print(ampere10 + "\t\t\t\t" + volt2 + "\t\t\t\t" + load400V(ampere10, volt2) + "\t\t\t\t" + loadTime400V(ampere10, volt2) + "\n");

      System.out.print(ampere16 + "\t\t\t\t" + volt2 + "\t\t\t\t" + load400V(ampere16, volt2) + "\t\t\t\t" + loadTime400V(ampere16, volt2) + "\n");

      System.out.print(ampere32 + "\t\t\t\t" + volt2 + "\t\t\t\t" + load400V(ampere32, volt2) + "\t\t\t\t" + loadTime400V(ampere32, volt2) + "\n");


   }

   /*Metod för att beräkna laddeffekten för 230V med given ström.
   Multiplicerar med 100, delar med 100 (ändrar typ) och efter det avrundning med metod Math.round för att få resultat
   med 2 decimaler . */

   static float load230V(int strom, int spanning)
   {
      float load230V = Math.round(strom * spanning) / (float) 1000 * (100 / (float) 100);
      return load230V;
   }


   /*Metod för att beräkna laddeffekten för 400V med given ström. Multiplicerar
    med 100 och delar med 100 (ändrar typ). Efter det avrundning med metod Math.round för att få resultat med
    2 decimaler.*/

   static float load400V(int strom, int spanning)
   {
      double load4V = (strom * spanning) * Math.sqrt(3);

      float load400V = Math.round(load4V / (float) 1000f * (float) 100f) / (float) 100f;

      return load400V;

   }


   /*Metod för att beräkna laddtid för 230V.
   Multiplicerar med 100 och delar med 100 (ändrar typ) och efter det avrundning med metod Math.round för att
   få resultat med 2 decimaler. */

   static float loadTime230
           (int strom, int spanning)
   {
      float loadTime230V = Math.round((BATTERI / (strom * spanning)) * 100) / (float) 100;

      return loadTime230V;

   }


   /*Metod för att beräkna laddtid för 400V. Multiplicerar med 100, delar med 100 (ändrar typ)
   och efter det avrundning med metod Math.round för att få resultat med 2 decimaler.*/

   static float loadTime400V(int strom, int spanning)
   {
      float loadTime400V = Math.round(BATTERI / (strom * spanning * Math.sqrt(3)) * 100) / (float) 100;

      return loadTime400V;

   }

}




