/**
 * Created by iyasuwatts on 10/17/17.
 */
import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;

public class Main {

    public static void main(String[] args){
        Scanner userIn = new Scanner(System.in);
        System.out.println("Welcome to my guessing game, how many guesses do you want?:");
        int guesses = userIn.nextInt();
        System.out.println("The guessing starts at 0, what do YOU want the max to be?:");
        int maxNum = userIn.nextInt();
        Random rand = new Random();
        int answer = rand.nextInt(maxNum+1);
        int userGuess = -1;
        int lastGuess;

	    for(int i = 0; i < guesses; i++){
            System.out.println("What do you think the number is?:");
            lastGuess = userGuess;
            userGuess = userIn.nextInt();
            if(userGuess == lastGuess){
                System.out.println("Live a little, try different guesses");
                i--;
                continue;
            }
            if(userGuess == answer){
                System.out.println("CORRECT! You win the game, pat yourself on the back");
                try {
                    Thread.sleep(1000);
                }
                catch(Exception e){
                    System.out.println("it was supposed to wait like 3 seconds");
                }
                System.out.println("No really, pat yourself on the back");
                System.out.println("Number of guesses: " + (i + 1));
                return;
            }
            else if(userGuess > answer){
                System.out.println("No, the number is lower than that");
            }
            else if(userGuess < answer){
                System.out.println("No, the number is higher than that");
            }
        }

        System.out.println("You ran out of guesses, better luck next time! It was:" + answer);

    }
}
