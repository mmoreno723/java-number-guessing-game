import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class NumberGuessingGame extends JFrame {
    private int randomNumber;
    private int attempts;
    private boolean hasGuessedCorrectly;

    private JTextField guessField;
    private JButton guessButton;
    private JLabel resultLabel;

    public NumberGuessingGame() {
        // Initalize Game Variables
        randomNumber = new Random().nextInt(100) + 1;
        attempts = 0;
        hasGuessedCorrectly = false;

        // Setting Up JFrame
        setTitle("Java Number Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLayout(new FlowLayout());

        // Creating Components
        guessField = new JTextField(10);
        guessButton = new JButton("Guess");
        resultLabel = new JLabel("Make a guess: ");

        // Adding components to the frame
        add(resultLabel);
        add(guessField);
        add(guessButton);

        // Add an action listener to the guess button
        
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
}