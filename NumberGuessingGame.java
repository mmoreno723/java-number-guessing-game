import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int userGuess = Integer.parseInt(guessField.getText());
                String result = guess(userGuess);

                resultLabel.setText(result);

                attempts++;

                if (result.contains("correct")) {
                    hasGuessedCorrectly = true;
                    guessField.setEditable(false);
                    guessButton.setEnabled(false);
                    resultLabel.setText("Congratulations! You guessed it in " + attempts + " attempts!");
                }
            }
        });
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
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new NumberGuessingGame().setVisible(true);
        }
    });
}

}