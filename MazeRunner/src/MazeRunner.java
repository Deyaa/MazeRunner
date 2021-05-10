import java.util.Arrays;
import java.util.Scanner;

public class MazeRunner {
    public static Maze myMap = new Maze();
    public static int userSteps = 0;
    public static void main(String[] args) {

        intro();

        do {
            String inputUser = userMove();
            if(canUserMove(inputUser)){
                makeMove(inputUser);
            } else {
                System.out.println("Sorry, you’ve hit a wall.");
            }

            myMap.printMap();

            navigatePit(inputUser);

        } while (!myMap.didIWin());

        if (myMap.didIWin()) {
            System.out.println("Congratulations, you made it out alive!");
            System.out.println("and you did it in " + MazeRunner.userSteps + " moves");
        }
    }

    public static void intro(){
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();
    }

    public static String userMove(){

        System.out.println("Where would you like to move? (R, L, U, D)");
        Scanner s= new Scanner(System.in);
        String inputUser = null;
        do{
            inputUser = s.next();
            System.out.println("Please choose only one of the options (R, L, U, D)");
        } while(!validateInput(inputUser));
        //System.out.println("The user choose: " + inputUser);
        return inputUser;
    }

    public static boolean validateInput(String inputUser){
        if(inputUser.equals("R") || inputUser.equals("L") || inputUser.equals("U") || inputUser.equals("D")){
            return true;
        } else{
            return false;
        }
    }

    public static void makeMove(String inputUser){
        movesMessage(++MazeRunner.userSteps);
        switch (inputUser){
            case "R":
                myMap.moveRight();
                break;
            case "L":
                myMap.moveRight();
                break;
            case "U":
                myMap.moveRight();
                break;
            case "D":
                myMap.moveRight();
                break;
        }
    }

    public static void movesMessage(int moves){

        switch (moves){
            case 50:
                System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
                break;
            case 75:
                System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
                break;
            case 90:
                System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
                break;
            case 100:
                System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
                break;
            case 101:
                System.out.println("Sorry, but you didn't escape in time- you lose!");
                System.exit(0);
                break;
        }
    }

    public static boolean canUserMove(String inputUser){
        boolean isCanMove = false;
        switch (inputUser){
            case "R":
                isCanMove = myMap.canIMoveRight();
                break;
            case "L":
                isCanMove = myMap.canIMoveLeft();
                break;
            case "U":
                isCanMove = myMap.canIMoveUp();
                break;
            case "D":
                isCanMove = myMap.canIMoveDown();
                break;
        }
        return isCanMove;
    }

    public static void navigatePit(String inputUser) {
        Scanner input = new Scanner(System.in);
        if(myMap.isThereAPit(inputUser))
        {
            System.out.print("Watch out! There's a pit ahead, jump it?  ");
            String jump = input.next();
            if(jump.equalsIgnoreCase("yes") || jump.equalsIgnoreCase("y"))
                myMap.jumpOverPit(inputUser);
            else
            {
                System.out.println("Sorry, but you didn't jump- you lose!");
                System.exit(0);
            }
        }
        else {
            System.out.println("Sorry, you've hit a wall.");
        }
    }

}
