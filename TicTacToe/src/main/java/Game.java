import java.util.Random;
import java.util.Scanner;

public class Game {


    //handles scores
    //how many games are played
    public static void Game(){
        Scanner scan = new Scanner(System.in);
        int numWins = 0;
        int numLoss = 0;
        int numTie = 0;
        int temp;
        int numGames =1;
        boolean valid = false;
        while(!valid) {
            try {
                System.out.println("How many Games of Tic Tac Toe would you like to play?");
                numGames = Integer.parseInt(scan.nextLine());
                valid = true;
            }
            catch (NumberFormatException ex) {
            }
        }

        System.out.println("How to Play: You must type in the number of the space of your choice.");
        for(int i = 0; i < numGames; i++){
            temp = gameLogic();
            if(temp == 2) numLoss++;                         //Player lost
            else if(temp == 3) numWins++;                    //Player wins
            else if(temp == 4) numTie++;                     //game is Tied
            displayScore(numWins, numLoss, numTie);
        }
    }


    //Display scoreboard
    public static void displayScore(int win, int loss, int tie){
        System.out.println("Wins: " + win + " | " + "Loss: " + loss + " | " + "Tie: " + tie);
    }


    //handles user input and the order in which the game runs
    public static int gameLogic(){
        int[][] board = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        DisplayBoard(board);
        boolean done = false;
        int check = 1;
        int looped = 0;
        while(!done) {
            board = playerInput(board); //gets user input makes sure its valid and updates the board
            check = check(board);
            if(check == 1) {
                board = computerChoice(board);  //gets a random valid number and updates the board
            }
            DisplayBoard(board);    //displays the board
            check = check(board);
            if(check != 1) done = true;
            looped++;
            if(looped == 4 && check == 1){
                check = 4;
                done = true;
            }
        }
        return check;
    }

    //check all possible cases for win
    public static int check(int[][] board){
        int check = 1;
        if(board[0][0] == 10 && board[0][1]== 10 && board[0][2]==10) check = 3;     //top row
        else if(board[0][0] == 0 && board[0][1]== 0 && board[0][2]==0) check = 2;   //top row

        else if(board[0][0] == 10 && board[1][0]== 10 && board[2][0]==10) check = 3; //left column
        else if(board[0][0] == 0 && board[1][0]== 0 && board[2][0]==0) check = 2; //left column

        else if(board[0][2] == 10 && board[1][2]== 10 && board[2][2]==10) check = 3; //right column
        else if(board[0][2] == 0 && board[1][2]== 0 && board[2][2]==0) check = 2; //right column

        else if(board[2][0] == 10 && board[2][1]== 10 && board[2][2]==10) check = 3; //Bottom row
        else if(board[2][0] == 0 && board[2][1]== 0 && board[2][2]==0) check = 2; //Bottom row

        else if(board[1][0] == 10 && board[1][1]== 10 && board[1][2]==10) check = 3; //Middle row
        else if(board[1][0] == 0 && board[1][1]== 0 && board[1][2]==0) check = 2; //Middle row

        else if(board[0][1] == 10 && board[1][1]== 10 && board[2][1]==10) check = 3; //Middle column
        else if(board[0][1] == 0 && board[1][1]== 0 && board[2][1]==0) check = 2; //Middle column

        else if(board[0][0] == 10 && board[1][1]== 10 && board[2][2]==10) check = 3; //left to bottom right diagonal
        else if(board[0][0] == 0 && board[1][1]== 0 && board[2][2]==0) check = 2; //left to bottom right diagonal

        else if(board[0][2] == 10 && board[1][1]== 10 && board[2][0]==10) check = 3; //right to left diagonal
        else if(board[0][2] == 0 && board[1][1]== 0 && board[2][0]==0) check = 2; //right to left diagonal
        return check;
    }

    //updates board, by who and where
    //does not verify
    public static int[][] updateBoard(int[][] board, String who, int placement){
        placement--;
        int row = placement / 3;
        int col = placement % 3;
        if(who.equals("player")) {
            board[row][col] = 10;
        }
        else if(who.equals("computer")){
            board[row][col] = 0;
        }
        return board;
    }


    //gets valid user input and checks input
    public static int[][] playerInput(int[][] board){
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        int row = Integer.MAX_VALUE;
        int col = Integer.MAX_VALUE;
        int user = 0;
        while(!isValid) {
            System.out.println("Your Turn");
            try {
                user = Integer.parseInt(scan.nextLine()); //ask player to type in their choice

                row = (user - 1) / 3;
                col = (user - 1) % 3;
                if (user < 10 && user > 0) {
                    if (board[row][col] != 10 && board[row][col] != 0) {
                        isValid = true;
                    }
                }
            } catch (NumberFormatException ex) {

            }
        }
        board = updateBoard(board, "player", user);
        return board;
    }

    //displays board
    public static void DisplayBoard(int[][] board){
        String temp = " ";
        for(int row = 0; row < board.length; row++){

            for(int col = 0; col < board[row].length; col++){   //traverses through the columns
                if(board[row][col] != 10 && board[row][col] != 0){
                    temp = String.valueOf(board[row][col]);
                }
                else if(board[row][col] == 10){
                    temp = "X";
                }
                else if (board[row][col] == 0){
                    temp = "O";
                }
                if(col == 1 || col == 2) System.out.print("|"); //places vertical lines in between the spaces
                System.out.print(" " + temp + " "); //prints out the String and additional spaces
            }

            System.out.println(); // starts a new line for the in between space for rows

            if(row != board.length -1){                         //displays the dashed lines and vertical lines in between columns
                for(int i = 0; i < (6+board[row].length); i++){
                    if(i==3 || i==6){
                        System.out.print("|");
                    }
                    System.out.print("-");
                }
            }

            System.out.println(); // new line ready for the next row
        }
    }


    public static int[][] computerChoice(int[][] board){ //generates random number and only returns a valid choice
        Random rand = new Random();                       //updates the board
        boolean valid = false;
        int row;
        int col;
        int ChosenOne = 1;
        while(!valid){
            ChosenOne = rand.nextInt(8) + 1;
            row = ChosenOne / 3;
            col = ChosenOne % 3;
            if(board[row][col] != 0 && board[row][col] != 10){
                valid = true;
            }
        }
        ChosenOne++;
        board =updateBoard(board, "computer", ChosenOne);
    return board;
    }

}
