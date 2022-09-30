import java.util.Scanner;

public class Omtentamen_HT20_cartoy7 {
   public static Scanner scanner = new Scanner(System.in);

   /* * LTU Hockey games. Meny 1 med följande val; Registrera lag, upp till 4 st. 2. utskrift med tilldelat nummer.
    Startar turnering. Avsluta.  Meny 2 med val; skriva ut spelschema, regsitrera matchresultat,
    skriva ut resultattabell, avsluta programmet.
   * @author Carola Töyrä, cartoy-7
   */
   public static void main(String[] args) {

      String[][] teamsNumber = new String[4][4]; //deklarerar och ger matrisen sin storlek.
      int[][] matchresult = new int[6][6]; //deklarerar en till matris, för att hålla reda på matcherna.

      System.out.print("Välkommen till Ltu Hockey games!");
      String menu1Choice = menu1();//anropar menymetod 1.

      while (!menu1Choice.equals("4")) { //avslutar programmet om menyval är 4. Annars fortsätter loopen(Menyn).

         if (menu1Choice.equals("1")) { //val 1 = registrera
            numberOneChoice(teamsNumber);
         }


         if (menu1Choice.equals("2")) { //val 2 = skriva ut lista med anmälda lag.
            numberTwoChoice(teamsNumber);

         }


         if (menu1Choice.equals("3")) { //Val 3 = starta turnering. Andra menyn anropas.

            String menuChoice2 = menu2();//anropar menymetod 2.

            while (!menuChoice2.equals("4")) { //avslutar programmet om menyval är 4. Annars loopar.

               if (menuChoice2.equals("1")) { //val 1 = skriva ut spelschema.
                  teamSchedule(teamsNumber, matchresult);
               }
               if (menuChoice2.equals("2")) { //val 2 = registrera matchresultat.
                  registerResult(matchresult);
               }
               if (menuChoice2.equals("3")) { // val 3 = Skriva ut resultattabell.
                  resultTable(teamsNumber, matchresult);
               }
               menuChoice2 = menu2();
            }
            break;
         }

         menu1Choice = menu1();
      }
   }

   public static String menu1() { //metod för meny1.

      System.out.printf("%s", " Var god gör ett val. " + "\n");


      System.out.print("" +
              "1. Registrera lag, max 4 st.  " + "\n" +
              "2. Anmälda lag" + "\n" +
              "3. Starta turnering " + "\n" +
              "4. Avsluta " + "\n");
      System.out.printf("%s%n", "Ditt val: ");

      String input = input();
      return input;
   }

   public static String input() { // metod för inmatning av användaren.
      while (!scanner.hasNextLine()) {
         scanner.nextLine();

      }
      return scanner.nextLine();
   }

   public static void numberOneChoice(String[][] teamsNumber) { //metod för att skriva in lag plus tilldelas nr.

      System.out.printf("%s", "Var god mata in namn på max 4 lag som ska delta. " + "\n" +
              "Om färre lag än 4 registreras, var god ange k efter inmatning är klar." + "\n");

      String team;
      int numberOfTeams = 0;

      while (numberOfTeams < 4) {
         team = scanner.nextLine();
         if (team.equals("k")) { //om k skrivs in avbryts inmatningen.
            break;
         }

         for ( int l = 0; l < teamsNumber.length; l++ ) {
            if (teamsNumber[l][0] == null) //om sloten är tom, skriv in värde som användaren matar in.
            {

               teamsNumber[l][0] = String.valueOf(l + 1); //+1 för att inte lag 1 ska få lag 0.
               teamsNumber[l][1] = team;
               numberOfTeams++;
               break;

            }

         }
      }
   }

   public static void numberTwoChoice(String[][] teamsNumber) { //metod för utskrift lagen.
      for ( int l = 0; l < teamsNumber.length; l++ ) {
         System.out.print(teamsNumber[l][0] + " " + teamsNumber[l][1] + "\n");
      }

   }


   public static String menu2() { //menyval 2.

      System.out.printf("%s", " Var god gör ett val. " + "\n");


      System.out.print("" +
              "1. Skriv ut spelschema" + "\n" +
              "2. Regsistrera matchresultat" + "\n" +
              "3. Resultattabell" + "\n" +
              "4. Avsluta " + "\n");
      System.out.printf("%s%n", "Ditt val: ");

      String input = input();
      return input;
   }

   public static void teamSchedule(String[][] teamsNumber, int[][] matchresult) { //metod för matchresultat.
      printGame(teamsNumber, matchresult, 1, 2);
      printGame(teamsNumber, matchresult, 3, 4);

      printGame(teamsNumber, matchresult, 4, 2);
      printGame(teamsNumber, matchresult, 1, 3);

      printGame(teamsNumber, matchresult, 4, 1);
      printGame(teamsNumber, matchresult, 2, 3);
   }

   public static String findResult(int[][] matchresult, int team1home, int team2away) {// metod för att se om resultat finns.
      //returnerar isf det utskriftsvänligt.
      for ( int g = 0; g < matchresult.length; g++ ) {
         if (matchresult[g][0] == team1home) {
            if (matchresult[g][1] == team2away) {
               return "(" + matchresult[g][2] + "-" + +matchresult[g][3] + ")";
            }
         }
      }
      return "";
   }

   public static String getTeamName(String[][] teamsNumber, int number) {//översätter nummer till namn. Returnera error om
      //nummer saknas.
      for ( int t = 0; t < teamsNumber.length; t++ ) {
         if (teamsNumber[t][0] != null && Integer.parseInt(teamsNumber[t][0]) == number) {
            return teamsNumber[t][1];
         }
      }
      return "Error";
   }

   public static void printGame(String[][] teamsNumber, int[][] matchresult, int homeTeam, int awayTeam) { //Skriver ut
      //match med resultat.
      String teamName1 = getTeamName(teamsNumber, homeTeam);
      String teamName2 = getTeamName(teamsNumber, awayTeam);
      if (!teamName1.equals("Error") && !teamName2.equals("Error")) {
         System.out.print(teamName1 + " - " + teamName2 + " " + findResult(matchresult, homeTeam, awayTeam) + "\n");
      }
   }

   public static void registerResult(int[][] matchresult) { //Användaren får registrera in resultat. Lagrar i resultatmatris.
      //sparar även undan poängen för vardera lag för just den matchen.
      System.out.print("Ange resultat på formatet 'lagnr1 lagnr2 x-x'");
      int team1Number = scanner.nextInt();
      int team2Number = scanner.nextInt();
      String result = scanner.next();
      String[] resultArr = result.split("-");
      int team1Score = Integer.parseInt(resultArr[0]);
      int team2Score = Integer.parseInt(resultArr[1]);
      if (!findResult(matchresult, team1Number, team2Number).equals("")) {
         System.out.print("Resultatet för denna match redan angivet!\n");
      } else {
         for ( int r = 0; r < matchresult.length; r++ ) {
            if (matchresult[r][0] == 0) {
               matchresult[r][0] = team1Number;
               matchresult[r][1] = team2Number;
               matchresult[r][2] = team1Score;
               matchresult[r][3] = team2Score;

               //poäng
               if (team1Score == team2Score) {
                  matchresult[r][4] = 1;
                  matchresult[r][5] = 1;
               } else if (team1Score > team2Score) {
                  matchresult[r][4] = 3;
                  matchresult[r][5] = 0;
               } else {
                  matchresult[r][4] = 0;
                  matchresult[r][5] = 3;
               }
               break;
            }
         }
      }
   }

   public static int getPoints(int[][] matchresult, int team) { //Totala poängen för ett lag. Returnerar som en int.
      int totalPoints = 0;
      for ( int r = 0; r < matchresult.length; r++ ) {
         if (matchresult[r][0] == team) {
            totalPoints = totalPoints + matchresult[r][4]; //pos4 är hemmalagetspoäng
         } else if (matchresult[r][1] == team) {
            totalPoints = totalPoints + matchresult[r][5]; //pos5 är bortalagetspoäng
         }
      }
      return totalPoints;
   }

   public static void resultTable(String[][] teamsNumber, int[][] matchresult) { //Utskrift resultat lagnamn och poäng.
      String team1Name = getTeamName(teamsNumber, 1);
      int team1Points;
      String team2Name = getTeamName(teamsNumber, 2);
      int team2Points;
      String team3Name = getTeamName(teamsNumber, 3);
      int team3Points;
      String team4Name = getTeamName(teamsNumber, 4);
      int team4Points;

      if (!team1Name.equals("Error")) {
         team1Points = getPoints(matchresult, 1);
         System.out.print(team1Name + " Poäng: " + team1Points + "\n");
      }

      if (!team2Name.equals("Error")) {
         team2Points = getPoints(matchresult, 2);
         System.out.print(team2Name + " Poäng: " + team2Points + "\n");
      }

      if (!team3Name.equals("Error")) {
         team3Points = getPoints(matchresult, 3);
         System.out.print(team3Name + " Poäng: " + team3Points + "\n");
      }

      if (!team4Name.equals("Error")) {
         team4Points = getPoints(matchresult, 4);
         System.out.print(team4Name + " Poäng: " + team4Points + "\n");
      }
   }
}






