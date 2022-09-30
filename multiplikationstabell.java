import java.util.Scanner;
public class multiplikationstabell {

/** 1- 12:ans tabell. Val att välja 1-12. programmet slumpar fram ett tal i den tabellen, inmatning av svar, får besked
 * om det är rätt eller fel. Programmet fortsätter så länge användaren svarat rätt på alla tal 3 ggr. Har ett tal svarats
 * rätt 3 grr ska det ej slumpas fram längre. val 0 = välja ny tabell alt avsluta programmet.
 * @author Carola Töyrä, cartoy-7
 */

Scanner input= new Scanner(System.in);

public static void main(String[] args)
{


   choiceOftabell();

}

public static int choiceOftabell (){
   System.out.print(""+
           "Var god välj en tabell mellan 1-12"+"/n"+
            "1"+"/n"+
            "2"+"/n"+
            "3"+"/n"+
            "4"+"/n"+
            "5"+"/n"+
            "6"+"/n"+
            "7"+"/n"+
            "8"+ "/n"+
            "9"+"/n"+
            "10"+"/n"+
            "11"+"/n"+
            "12"+"/n");

   System.out.printf("%s%n","Ditt val: ");


   
}
}