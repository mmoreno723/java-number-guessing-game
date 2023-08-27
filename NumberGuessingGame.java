import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private int randomNumber;
    private Random random;

    public NumberGuessingGame() {
        random = new Random();
        randomNumber = random.nextInt(100) + 1;
    }
}

public String guess(int userGuess) {
    if (userGuess < randomNumber) {
        return "Too low!";
    } else if (userGuess > randomNumber) {
        return "Too high!";
    } else {
        return "That's it! You're correct!";
    }
}

public static void main(String[] args) {
    NumberGuessingGame game = new NumberGuessingGame();
    Scanner scanner = new Scanner(System.in);

    int attempts = 0;
    boolean hasGuessedCorrectly = false;

    while (!hasGuessedCorrectly) {
        System.out.print("Enter your guess: ");
        int userGuess = scanner.nextInt();
        scanner.nextLine();

        String result = game.guess(userGuess);
        System.out.println(result);

        attempts++;

        if (result.contains("correct")) {
            hasGuessedCorrectly = true;
            System.out.println("You guessed it in " + attempts + " attempts!");
        }
    }
    scanner.close();
}