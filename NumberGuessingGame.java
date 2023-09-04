import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NumberGuessingGame extends JFrame {
    private int randomNumber;
    private int attempts = 1;
    private boolean hasGuessedCorrectly;
    

    private JTextField guessField;
    private JButton guessButton;
    private JLabel resultLabel;

    private Scoreboard scoreboard = new Scoreboard();

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
        resultLabel = new JLabel("Make a guess. Your score is " + attempts);

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

                    String initials = JOptionPane.showInputDialog(null, "Enter your initials: ", "Game Over", JOptionPane.PLAIN_MESSAGE);
                    scoreboard.addScore(initials, attempts);
                    resultLabel.setText("Congratulations! You guessed it in " + attempts + " attempts!");
                    playGame();
                }
            }
        });
    }


public String guess(int userGuess) {
    if (userGuess < randomNumber) {
        return "Too low! Your score is: " + attempts;
    } else if (userGuess > randomNumber) {
        return "Too high! Your score is: " + attempts;
    } else {
        return "That's it! You're correct! Your score is: " + attempts;
    }
}

private void displayScoreboard() {
    List<String> initialsList = scoreboard.getInitials();
    List<Integer> scoresList = scoreboard.getScores();

    StringBuilder scoreboardText = new StringBuilder("Scoreboard:\n");
    for (int i = 0; i < initialsList.size(); i++) {
        scoreboardText.append(initialsList.get(i)).append(": ").append(scoresList.get(i)).append("\n");
    }

    JOptionPane.showMessageDialog(null, scoreboardText.toString(), "Scoreboard", JOptionPane.PLAIN_MESSAGE);
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            NumberGuessingGame game = new NumberGuessingGame();
            game.setVisible(true);

        }
    });
}

private void playGame() {
    randomNumber = new Random().nextInt(100) + 1;
    attempts = 0;
    hasGuessedCorrectly = false;

    guessField.setEditable(true);
    guessButton.setEnabled(true);
    resultLabel.setText("Make a guess. Your score is: " + attempts);
    guessField.setText("");

    boolean playAgain = false;

    do {
        int playAgainOption = JOptionPane.showConfirmDialog(null, "Play Again?", "Play Again", JOptionPane.YES_NO_OPTION);
        if (playAgainOption != JOptionPane.YES_OPTION) {
            playAgain = true;
            displayScoreboard();
        } else {
            displayScoreboard();
            randomNumber = new Random().nextInt(100) + 1;
            attempts = 0;
            resultLabel.setText("Make a guess. Your score is " + attempts);
        }
    } while (playAgain);
}
}

class Scoreboard {
    private List<String> initials;
    private List<Integer> scores;

    public Scoreboard() {
        initials = new ArrayList<>();
        scores = new ArrayList<>();
    }

    public void addScore(String initials, int score) {
        this.initials.add(initials);
        this.scores.add(score);
    }

    public List<String> getInitials() {
        return initials;
    }

    public List<Integer> getScores() {
        return scores;
    }
}