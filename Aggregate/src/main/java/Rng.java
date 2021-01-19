import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Rng {
    static Random rng = new Random();

    public static int getComputerChoice(int incMin, int incMax){

        int rand = incMin + rng.nextInt((incMax - incMin)+1);
        return rand;
    }

    public static int getUserChoice(){
        Scanner scn = new scanner(System.in);
        System.out.println("Pick a number from from 1 to 3");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scisssor");
        String userIn = scn.nextLine();
        int user = Integer.parseInt(userIn);
        int computerChoice = getComputerChoice(1,3);
        if(user == computerChoice){
            System.out.println("Its a Draw!");
        }
        else if(user == 1 && computerChoice == 2){
            System.out.println("Paper beats rock!");
            System.out.println("Computer Wins!");
        }
        else if(user == 1 && computerChoice == 3){
            System.out.println("Rock beats Scissor");
            System.out.println("Player Wins!");
        }
        else if(user == 2 && computerChoice == 1){
            System.out.println("Paper bears rock!");
            System.out.println("Player Wins!");
        }
        else if(user == 2 && computerChoice == 3){
            System.out.println("Scissors beat paper!");
            System.out.println("Computer Wins");
        }
        else if(user == 3 && computerChoice == 1){
            System.out.println("Rock beats Scissor");
            System.out.println("Computer Wins");
        }
        else if(user == 3 && computerChoice == 2){
            System.out.println("Scissors beat paper!");
            System.out.println("Player Wins!");
        }
    }
}
