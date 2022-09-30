import java.util.Scanner;

public class Uppgift2
{
   /**
    * @author Carola Töyrä, cartoy-7.
    * Ett program som kan räkna ut hur mycket pengar man tjänar på att sälja el från solpaneler beroende
    * på hur mycket solen skiner under juni-juli.
    * Flödesschema; 1. Tjäna pengar på solsken. 2. Storleken på ytan av alla solpaneler (ett fast värde). 3. datum
    * och tid som solen är uppe (matas in). 4. Beräkning som presenterar resultat av antal soltimmar, produktion av
    * genererad ström samt vad förtjänsten blir i kr med 2 decimaler (utskrift).
    */


   public static void main(String[] args)
   {


      //Mata in datum enter.
      //Delimiter (tecknen "-" eller "whitespace") för att avsluta inmatningen.
      Scanner userInput = new Scanner(System.in);
      userInput.useDelimiter("-|\\s+");

      int dayOfToday;
      int thisMonth;

      System.out.print("Skriv in dagens datum [mm-dd]>");
      thisMonth = userInput.nextInt();
      dayOfToday = userInput.nextInt();
      System.out.print("Dagens datum är:" + thisMonth + "-" + dayOfToday + "\n\n");

      //if-sats för att begränsa månad till juni juli samt 1-31 datum.
      if (thisMonth < 6 || thisMonth > 7)
      {
         System.out.printf("Felaktigt värde månad. Månad måste vara 6 eller 7.");
      } else if (dayOfToday > 31)
      {
         System.out.printf("Felaktigt värde. Dag måste vara mellan 1-31.");
      } else
      {


      /*mata in klockslag när sol går upp och ned hh:mm. Delimiter (tecknen ":" eller "whitespace") för att avsluta
      inmatningen.*/
         userInput.useDelimiter(":|\\s+");

         //Variabler inför beräkning av soltimmar. Timmar samt minuter. Värden matas in för solupp- och nedgång.
         //skrivs ut. hour och min = soluppgång. hour2 och min2 =solnedgång. 
         int hour;
         int min;
         int hour2;
         int min2;

         System.out.printf("Klockslag för soluppgång [hh:mm]" + "\n\n");
         hour = userInput.nextInt();
         min = userInput.nextInt();

         System.out.printf("hour: " + hour + " min :" + min + "\n\n");

         System.out.printf("Klockslag för solnedgång [hh:mm]" + "\n\n");
         hour2 = userInput.nextInt();
         min2 = userInput.nextInt();
         System.out.printf("hour: " + hour2 + " min :" + min2 + "\n\n");

         //if-sats för att begränsa så värde för soluppgång inte är större än solnedgång. Felmeddelande isf. 
         if (hour > hour2)
         {
            System.out.printf("Felaktigt värde. Kontrollera att soluppgång är mindre än solnedgång" + "\n\n");
         } else if (hour == hour2 && min > min2)
         {
            System.out.printf("Felaktigt värde. Kontrollera uppgifterna." + "\n\n");
         } else
         {
            System.out.print("==============================================\n\n");


            //slå ihop antal soltimmar och skriv ut:

            float sunHours2 = ((hour2 * 60) + min2);
            float sunHours = ((hour * 60) + min);
            float sunHours3 = (float) ((double) (sunHours2 - sunHours) / 60);
            System.out.printf("Soltimmar:" + sunHours3 + "\n\n");


            //Solpaneler. 26 st a´1.7*1 m.
            float sunPanels = (float) (26 * (1.7 * 1)); //44.199999999999996 m2


            //Formel för att beräkna solstrålning en dag= 166 Wh/m2/timme. 
            // Solens verkningsgrad är 20 % av solinstrålningen.

            float sunRadiation;
            sunRadiation = (float) (0.166 * sunPanels * (sunHours3));
            float sunEfficiancy = (float) 0.20;

            //Uträkning av produktion (kWh)= solinstrålning (Wh/m2/timme)* soltimmar* storlek (m2)* verkningsgrad
            float elProduction = (float) (sunRadiation * sunEfficiancy);

            //Elpris; 0,9 kr /kWh
            float elPrice = (float) (elProduction * 0.9);

            //utskrift produktion.
            System.out.printf("produktion (kWh): " + Math.round(elProduction * 100f) / (float) 100f + "\n\n");

            //utskrift försäljning.
            System.out.printf("Förtjänst av försäljning (kr): " + Math.round(elPrice * 100f) / (float) 100f + "\n\n");
         }
      }


   }
}
