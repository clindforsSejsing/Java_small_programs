
import java.util.Date;
import java.util.Scanner;

public class Uppgift6 {

   public static Scanner scanner = new Scanner(System.in);


   /* * Kassasystem. Flödesschema. Användaren väljer i menyn vad programmet ska göra.
   Är valet att lägga in artiklar, ska det finnas plats för 10, fram till användaren matat in 5, då ska utrymmet utökas till
   det dubbla. val 2 ta bort artiklar. val 3 visa valda artiklar. val 4 sälja artiklar. val 5 visa historik. När användaren
   gör val 6, vilket avsluta programmet.
    * @author Carola Töyrä, cartoy-7
    */


   public static void main(String[] args) {

      int[][] articles = new int[10][3]; //deklarerar och ger matrisen sin initiala storlek.
      int[][] sales = new int[10][3];//deklarerar matris som handhar försäljningen.
      Date[] salesDate = new Date[10]; //deklarerar array för datum och klockslag.

      int chosenNumber = menu();//anropar menymetod.

      int articleNumber = 999; //värdet satt till 999 då vi börja artikelnummer från 1000.

      while (chosenNumber != 6) {
         if (chosenNumber == 1) { //om användaren väljer val 1-5 och så länge det inte är val 6.

            System.out.printf("%s", "Hur många artiklar ska läggas till?");
            int numbersOfArticles = input();

            while (articleNumber < 1) { //felkontroll så inmatning inte kan vara noll.
               System.out.printf("%s", "Var god ange nytt val.");
               numbersOfArticles = input();
            }

            for ( int i = 0; i < numbersOfArticles; i++ ) { //inmatade artikelnumret med utskift.
               articles = checkFull(articles);
               articleNumber = insertArticle(articles, articleNumber);

            }

            System.out.print("Senaste inskrivna artikelnummer: " + articleNumber + "\n");

         } else if (chosenNumber == 2) { //användaren väljer val 2. Ta bort artiklar.
            removeArticle(articles);
         } else if (chosenNumber == 3) {//användaren väljer val 3. visa artiklar.

            printArticles(articles);

         } else if (chosenNumber == 4) { //användaren väljer val 4. Försäljning.
            sales = checkFull(sales);
            salesDate = checkFull(salesDate);
            sellArticle(sales, salesDate, articles);

         } else if (chosenNumber == 5) { //användaren väljer val 5. Orderhistorik.
            printSales(sales, salesDate);
         }
         chosenNumber = menu(); //loopar menyn så att den börjar om.
      }

   }

   public static int menu() {


      System.out.print("" +
              "1. Lägg in artiklar " + "\n" +
              "2. Ta bort artikel " + "\n" +
              "3. Visa artiklar " + "\n" +
              "4. Försäljning " + "\n" +
              "5. Orderhistorik " + "\n" +
              "6. Avsluta " + "\n");
      System.out.printf("%s%n", "Ditt val: ");

      int input = input();
      return input;
   }


   public static int input() { //inmatning av användaren. Kontroll att det är heltal.
      while (!scanner.hasNextInt()) {
         scanner.next();

      }
      return scanner.nextInt();
   }


   public static int[][] checkFull(int[][] articles) { //kontroll att matris har plats, annars utökas till det dubbla när hälften är fylld.
      int howBigIsMatrix = articles.length;

      int numberOfRowsWithValues = 0;
      for ( int i = 0; i < howBigIsMatrix; i++ ) {
         if (articles[i][0] != 0) {
            numberOfRowsWithValues++;
         }
      }

      if (numberOfRowsWithValues <= (howBigIsMatrix / 2)) {//om matrisen INTE är fylld till mer än hälften, returneras matrisen som den är.
         return articles;
      } else {
         int[][] biggerArticles = new int[howBigIsMatrix * 2][3]; //initierar ny matris, som returneras om orginalmatris är
         for ( int i = 0; i < howBigIsMatrix; i++ ) {// fylld till över hälften.

            biggerArticles[i][0] = articles[i][0];
            biggerArticles[i][1] = articles[i][1];
            biggerArticles[i][2] = articles[i][2];
         }
         articles = biggerArticles;
         return articles;
      }
   }

   public static Date[] checkFull(Date[] salesDate) { //kontroll att arrayen för datum är tilllräckligt stor strlk. Annars förstoras den.

      int howBigIsMatrix = salesDate.length;

      int numberOfRowsWithValues = 0;
      for ( int i = 0; i < howBigIsMatrix; i++ ) {
         if (salesDate[i] != null) {
            numberOfRowsWithValues++;
         }
      }

      if (numberOfRowsWithValues <= (howBigIsMatrix / 2)) {//om arrayen INTE är fylld till mer än hälften, returneras matrisen som den är.
         return salesDate;
      } else {
         Date[] biggerArray = new Date[howBigIsMatrix * 2]; //initierar ny array, som returneras om orginalarray är
         for ( int i = 0; i < howBigIsMatrix; i++ ) {// fylld till över hälften.

            biggerArray[i] = salesDate[i];

         }
         salesDate = biggerArray;
         return salesDate;
      }
   }

   public static int insertArticle(int[][] articles, int articleNumber) {//metod för insättande av artikel. Antal och pris slumpas.

      for ( int i = 0; i < articles.length; i++ ) {
         if (articles[i][0] == 0) {
            articles = checkFull(articles);
            articleNumber = articleNumber + 1;
            articles[i][0] = articleNumber;
            articles[i][1] = (int) (1 + (Math.random() * 10)); //antal.
            articles[i][2] = (int) (100 + (Math.random() * 1000)); //pris.

            break;

         }

      }

      return articleNumber;

   }


   public static void removeArticle(int[][] articles) { //metod för att nollställa vald artikelnummer.
      System.out.printf("%s", "Vilken artikel ska tas bort? ");

      int artcleToremove = input();//inmatning sker av användaren.
      for ( int i = 0; i < articles.length; i++ ) {

         if (articles[i][0] == artcleToremove) {
            articles[i][0] = 0; //artikelnummer
            articles[i][1] = 0; //antal artiklar
            articles[i][2] = 0; //pris

            break;
         }


      }
   }

   public static void printArticles(int[][] articles) { //skriver ut historik sålda artiklar + datum och tid.
      System.out.printf(("%s%s%s%n"), "artikelnummer ", "antal artiklar ", "pris i kronor ");
      for ( int i = 0; i < articles.length; i++ ) {
         if (articles[i][0] != 0) {
            System.out.print(i + " " + articles[i][0] + " " + articles[i][1] + " " + articles[i][2] + "\n");
         }
      }
   }

   public static void sellArticle(int[][] sales, Date[] salesDate, int[][] articles) { //metod för försäljning av vara.
      System.out.printf("%s%n", "ange artikelnummer: ");
      int articleToSell = input();
      System.out.printf("%s%n", "ange antal: ");
      int numberOfArticles = input();

      for ( int i = 0; i < articles.length; i++ ) {

         if (articles[i][0] == articleToSell) {

            if (numberOfArticles > articles[i][1]) { //felhantering. om vara ej finns i önskat antal.
               System.out.printf("%s", "Varan finns tyvärr inte i önskat antal. Var god gör nytt val" + "\n");
               break;
            } else {
               articles[i][1] = articles[i][1] - numberOfArticles;

            }


            for ( int j = 0; j < sales.length; j++ ) {
               if (sales[j][0] == 0) {

                  sales[j][0] = articleToSell;
                  sales[j][1] = numberOfArticles;
                  sales[j][2] = articles[i][2] * numberOfArticles;
                  salesDate[j] = new Date();
                  break;
               }
            }
            break;
         }

      }
   }


   public static void printSales(int[][] sales, Date[] salesDate) { //metod för datum och tid för försäljningen.
      for ( int j = 0; j < sales.length; j++ ) {
         if (sales[j][0] == 0) {
            break;
         } else {
            System.out.print(salesDate[j] + " " + sales[j][0] + " " + sales[j][1] + " " + sales[j][2] + "\n");
         }
      }

   }
}



