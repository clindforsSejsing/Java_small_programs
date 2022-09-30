import java.util.Scanner;

public class uppgift5 {
   public static Scanner scanner = new Scanner(System.in);


   /* * Area och volym. Flödesschema. 1.Användaren matar in värden och  Värderna fylls på; först med
   radie och sedan höjd. 2. uträkningar sker först när användaren trycker enter, vilka skrivs ut (om det inte är "q"
   i såfall går programmet vidare till uträkning av bråkdelar). 3. "q" anropas, programmet går vidare till bråkdelar.
   4. Täljare och nämnare matas in (så till vida att det inte är "q"). 5. Värdena beräknas och förkortas.
   6. Skrivs ut. 7. Program pågår tills användaren matar in "q".
     */


   public static void main(String[] args) {


      System.out.print("---------------------------------------------------------------------------------------------"
              + "\n\n");
      System.out.print(" # Test av area och volymmetoderna" + "\n\n");


      System.out.print("---------------------------------------------------------------------------------------------"
              + "\n\n");
      System.out.print(">");


      //variabler för höjd och radie.
      int height = 0;
      int radius = 0;

      //inmatning från användaren. Så länge det finns en int att skriva ut, körs programmet.
      // om q = loop bryts och fortsätter vidare i programmet.

      areaAndVolym:
      while (scanner.hasNextInt() || !scanner.next().equals("q")) {
         while (!scanner.hasNextInt()) {
            if (scanner.next().equals("q")) {
               break areaAndVolym;
            }
         }

         radius = Math.abs(scanner.nextInt());
         System.out.print("r = " + radius);

         while (!scanner.hasNextInt()) {
            if (scanner.next().equals("q")) {
               break areaAndVolym;
            }
         }

         height = Math.abs(scanner.nextInt());
         System.out.print(" h = " + height + "\n");

         //påkallar metoder ,som gör uträkningarna, vilka är deklarerade längre ned i programmet.
         System.out.printf("Basytans area: %.2f \n", area(radius));
         //System.out.print("Basytans area: " + ((int)(12.5767767 * 100))/(float)100 + "\n");
         System.out.printf("Mantelytans area: %.2f \n", area(radius, height));
         System.out.printf("Volym: %.2f \n", volume(radius, height));

      }


      System.out.print("------------------------------------------------------------------------------------------" +
              "\n\n");
      System.out.print("# Test av bråktalsmetoderna" + "\n\n");
      System.out.print("------------------------------------------------------------------------------------------" +
              "\n\n");
      System.out.print(">");

      //så länge det finns en integer att läsa in från inmatning och inmatning inte är q,
      // eller om det är slut på inmatning av integers och q matas in, avslutas loopen. Programmet avslutas.
      fractions:
      while (scanner.hasNextInt() || !scanner.next().equals("q")) {
         while (!scanner.hasNextInt()) {
            if (scanner.next().equals("q")) {
               break fractions;
            }
         }
         //deklarerar variabler för täljare, nämnare samt array.
         int nominator;
         int denominator;
         int[] numbers = new int[3];


         nominator = scanner.nextInt();
         System.out.print(nominator + "/");


         while (!scanner.hasNextInt()) {
            if (scanner.next().equals("q")) {
               break fractions;
            }
         }

         denominator = scanner.nextInt();
         System.out.print(denominator + " = ");


         if (denominator != 0) {
            numbers[0] = nominator / denominator; //ger arrayens första nummer ett värde.
            int restOfNumber = (nominator % denominator); //räknar ut resten efter delning (modulus);

            int numberDownSized = sgd(restOfNumber, denominator);//räknar ut minsta gemensamma nämnare.

            numbers[1] = restOfNumber / numberDownSized;
            numbers[2] = denominator / numberDownSized;
         } else {
            numbers = null;
         }

         //utskrift. Se metod nedan.
         printFraction(numbers);

      }
   }

   //metod för utskrift av arrayen.
   private static void printFraction(int[] parts) {
      if (parts == null) {
         System.out.print("Error" + "\n\n");
      } else if (parts[0] == 0) {
         System.out.print(parts[1] + "/" + parts[2] + "\n\n");
      } else if (parts[1] == 0) {
         System.out.print(parts[0] + "\n\n");
      } else if (parts[2] == 0) {
         System.out.print("0" + "\n\n");
      } else {
         System.out.print(parts[0] + " " + parts[1] + "/" + parts[2] + "\n\n");
      }
   }

   //metod för att beräkna basytans area.
   public static float area(int radius) {

      return (float) (Math.PI * Math.pow(radius, 2));
   }

   //metod för att beräkna mantelytans area.
   public static float area(int radius, int height) {

      return (float) (Math.PI * radius * phytagoras(radius, height));

   }

   //metod för att beräkna hypotenusan med phytagoras sats.
   public static float phytagoras(int sideA, int sideB) {

      return (float) Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
   }

   //metod för att beräkna konens volym.
   public static float volume(int radius, int height) {
      return (float) ((Math.PI * Math.pow(radius, 2) * height) / 3);

   }

   //metod för att räkna fram minsta delbara tal.
   public static int sgd(int a, int b) {

      if (a < b) {
         int temp = a;
         a = b;
         b = temp;
      }

      while (b != 0) {
         int c = a % b;
         a = b;
         b = c;

      }
      return a;
   }

}





