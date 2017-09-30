import java.util.Scanner;
import java.util.Random;
public class BlackJack {
    public static void main(String[] args) {
        Random randGen = new Random();
        Scanner scanner = new Scanner(System.in);

        int userOption = 0;
        int numGames = 1;
        int playerWin = 0;
        int dealerWin = 0;
        int tie = 0;
        int playerCard = randGen.nextInt(13) + 1;
        int playerHand = 0;
        int dealerHand = 0;

        double percent = 0;

        boolean newGame = true;

        while (userOption != 4) {

            if (newGame) {
                System.out.println("\n START GAME #" + numGames);
                if (playerCard > 1 && playerCard < 11) {                       //if the card is not a facecard
                    System.out.println("Your card is a " + playerCard + "!");
                }

                if (playerCard == 1) {
                    System.out.println("Your card is an ACE!");              //Facecard Ace is technically 1
                }

                if (playerCard == 11) {
                    System.out.println("Your card is a JACK!");              //Face card Jack is technically 11
                    playerCard = 10;
                }

                if (playerCard == 12) {
                    System.out.println(" Your card is a QUEEN!");            //Face card Queen is technically 12
                    playerCard = 10;
                }

                if (playerCard == 13) {
                    System.out.println("Your card is a KING!");              //Face card King is technically 13
                    playerCard = 10;
                }

                playerHand = playerCard;
                System.out.print("Your hand is: " + playerHand);
                newGame = false;
            }
                System.out.println("\n 1. Get another card \n 2. Hold hand \n 3. Print game statistics \n 4. Exit");
                System.out.println("Choose an option:");

            try {
                userOption = scanner.nextInt();
                if (userOption < 1 || userOption > 4) {
                    throw new Exception();
                }
            }
            catch (Exception excpt) {
                scanner.nextLine();
                System.out.println("Invalid input! \nPlease enter an integer value between 1 and 4");
            }

            if (userOption == 1) {                                                 //If user chooses 1 on menu
                playerCard = randGen.nextInt(13) + 1;                       //Random number will be between 1-13 inclusive

                if (playerCard > 1 && playerCard < 11 ) {
                    System.out.println("Your card is a " + playerCard + "!");
                }

                if (playerCard == 1) {
                    System.out.println("Your card is an ACE!");
                    playerCard = 1;
                }

                if (playerCard == 11) {
                    System.out.println("Your card is a JACK!");
                    playerCard = 10;
                }

                if (playerCard == 12) {
                    System.out.println(" Your card is a QUEEN!");
                    playerCard = 10;
                }

                if (playerCard == 13) {
                    System.out.println("Your card is a KING!");
                    playerCard = 10;
                }

                playerHand += playerCard;                            //adding the new card to the hand gives gives you new total value of hand
                System.out.println("Your hand is " + playerHand);
                if (playerHand == 21) {
                    System.out.println("BLACKJACK! You win!");
                    playerWin += 1;
                    numGames += 1;
                    newGame = true;
                } else if (playerHand > 21) {
                    System.out.println("You exceeded 21! You lose! :(");
                    dealerWin += 1;
                    numGames += 1;
                    newGame = true;                                   //Either way you win, lose, or tie, you start a new game
                }

            }

            else if (userOption == 2) {                                //If user chooses 2 on menu
                dealerHand = randGen.nextInt(11) + 15;            //Random number will be between 15-26 inclusive

                if (dealerHand == 21) {
                    System.out.println("Dealer wins!");
                    dealerWin += 1;
                    numGames += 1;
                    newGame = true;
                }

                else if (dealerHand > 21) {
                    System.out.println("You win!");
                    playerWin += 1;
                    numGames += 1;
                    newGame = true;
                }

                else if (dealerHand == playerHand) {
                    System.out.println("It's a tie! No one wins!");
                    tie += 1;
                    numGames += 1;
                    newGame = true;
                }
            }

            else if (userOption == 3) {                                         // If user chooses to have game statistics
                System.out.println("Number of player wins: " + playerWin);
                System.out.println("Number of dealer wins: " + dealerWin);
                System.out.println("Number of tie games: " + tie);
                System.out.println("Total # of games played is: " + numGames);
                percent =  ((double) (playerWin) / (double) (numGames) * 100);   // % of player wins is (#player wins/# of games played) * 100
                long percentWin = Math.round(percent);
                System.out.println("Percentage of Player wins: " + percentWin + "%");
            }

            else if (userOption ==4) {
                return;                                                         // If the user chooses 4 it stops the code
            }
          }
        }
    }



