import java.util.Scanner;

public class Main
{
   /**
    * Tärningsspel 12. Slumpade tärningskast var summan ska bli 12 för att man ska vinna spelet.
    * 3 kast per omgång.
    * flödesschema;
    * 1. Val att kasta tärning 1, 2, 3 eller avsluta spelet.
    * 2. presentera slumpad siffra mellan 1-6 för slag 1-3.
    * 3. addera siffrorna, avslut (vinst) om det efter 3 kast summan uppnår 12. Annars förlust.
    * Presentera antal vinster och antal förluster.
    * Påbörja spelet igen om inte användaren aktivt väljer att avsluta.
    *
    * @author Carola Töyrä, cartoy-7
    */

   //Presentera konstanter; sidor på tärning + antal poäng för vinst.
   public static final int SIDES_OF_DICE = 6;
   public static final int POINTS_TO_WIN = 12;

   public static void main(String[] args)
   {

      //Presentera variabler.
      int losses = 0;
      int wins = 0;
      int oneDice = 0;
      int twoDice = 0;
      int threeDice = 0;

      //utskrift med uppmaning till användare om val.
      System.out.printf("Kasta tärning [1,2,3] med enter" +
              " Avsluta spelet genom att trycka ned tangenten q");

      //Scanner för inmatning, delimiter whitespace.
      Scanner scanner = new Scanner(System.in);
      scanner.useDelimiter("\\s+");
      String userInput = scanner.next();

      //loop med första krav; inmatning ska ej vara "q" för fortsatt loop.
      while (!userInput.equals("q"))
      {
         //Tärning 1, oslagen då värde är 0. Loop fortsätter. Randomiserad siffra mellan 1-6.
         if (userInput.equals("1"))
         {
            if (oneDice == 0)
            {
               oneDice = (int) (Math.random() * SIDES_OF_DICE) + 1;
            } else //om inmatning ej följer regler; felmeddelande.
            {
               System.out.printf("Du får endast slå varje tärning en gång!%n");
            }
         }//Tärning 2, oslagen då värde är 0. Loop fortsätter. Randomiserad siffra mellan 1-6.
         else if (userInput.equals("2"))
         {
            if (twoDice == 0)
            {
               twoDice = (int) (Math.random() * SIDES_OF_DICE) + 1;
            } else //om inmatning ej följer regler; felmeddelande.
            {
               System.out.printf("Du får endast slå varje tärning en gång!%n");
            }
         }//Tärning 2, oslagen då värde är 0. Loop fortsätter. Randomiserad siffra mellan 1-6.
         else if (userInput.equals("3"))
         {
            if (threeDice == 0)
            {
               threeDice = (int) (Math.random() * SIDES_OF_DICE) + 1;
            } else
            {//om inmatning ej följer regler; felmeddelande.
               System.out.printf("Du får endast slå varje tärning en gång!%n");
            }
         } else //om inget av ovanstående är "rätt", skrivs nedanstående meddelande ut.
         {
            System.out.printf("Felaktig inmatning.%n");
         }
         //summan för slagna tärningar.
         int sum = oneDice + twoDice + threeDice;

         //förklara boolean som falsk.
         boolean endOfTurn = false;

            /*om summan av tärningarna bli 12 körs detta steg. Skriver ut antal vinster och förluster. Booleans
            värde ändras till sann. = tärningarna nollställs. */
         if (sum == POINTS_TO_WIN)
         {
            wins++;
            System.out.printf("Grattis du vann! Antal vinster: %d, antal förluster: %d%n", wins, losses);
            endOfTurn = true;
         }
            /*om summan av tärningarna inte blir 12, men tärning 1-3 ej längre är 0 = de måste ha slagits,
             körs detta steg. Skriver ut antal vinster och förluster. Booleans
            värde ändras till sann. = tärningarna nollställs. */
         else if (oneDice > 0 && twoDice > 0 && threeDice > 0)
         {
            losses++;
            System.out.printf("Oj du förlorade! Antal vinster: %d, antal förluster: %d%n", wins, losses);
            endOfTurn = true;
         }

         System.out.printf("%d %d %d sum: %d #vinst: %d #förlust: %d%n", oneDice, twoDice, threeDice, sum, wins, losses);

         //boolean nollställer tärningarna.
         if (endOfTurn)
         {
            oneDice = 0;
            twoDice = 0;
            threeDice = 0;
         }

         //Uppmanar till inmatning igen. Antingen påbörja spelet igen eller avsluta med "q".
         System.out.printf("Kasta tärning [1,2,3] med enter" +
                 " Avsluta spelet genom att trycka ned tangenten q");
         userInput = scanner.next();
      }
   }
}
