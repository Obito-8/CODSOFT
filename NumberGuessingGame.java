import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 7;
        int totalRounds = 0;
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println(" Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = maxAttempts;
            boolean isCorrect = false;

            System.out.println("\nRound " + (totalRounds + 1));
            System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == numberToGuess) {
                    System.out.println(" Correct! You guessed the number!");
                    totalScore += attemptsLeft * 10;
                    isCorrect = true;
                    break;
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try a smaller number.");
                } else {
                    System.out.println("Too low! Try a bigger number.");
                }
                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!isCorrect) {
                System.out.println(" You've used all attempts. The number was: " + numberToGuess);
            }

            totalRounds++;

            System.out.print("\nDo you want to play another round? (yes/no): ");
            scanner.nextLine();
            String response = scanner.nextLine();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\n Game Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Your Final Score: " + totalScore);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
