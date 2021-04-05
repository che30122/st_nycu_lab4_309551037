package lab04;
import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        String []choice=new String[2];
        int result;
        Scanner input=new Scanner(System.in);
        System.out.println("=== Welcome to Rock-Paper-Scissors game ===");
        for(int i=0;i<2;i++) {
            System.out.println("Enter Player 1 choice (rock, paper or scissors):");
            choice[i] = input.next();
            try {
                Game.validate_input(choice[i]);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return;
            }
        }
        result=Game.game(choice[0],choice[1]);
        switch (result){
            case 0:
                System.out.println("Draw!");
                break;
            case 1:
                System.out.println("Player 1 win!");
                break;
            case -1:
                System.out.println("Player 2 win!");
                break;
        }
    }
}