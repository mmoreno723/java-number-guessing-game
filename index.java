import java.util.Random;

public class NumberGuessingGame {
    private int randomNumber;
    private Random random;

    public NumberGuessingGame() {
        random = new.Random();
        randomNumber = random.nextInt(100) + 1;
    }
}

public String guess(int userGuess) {
    if (userGuess < randomNumber) {
        return "Too low!";
    } else if (userGuess > randomNumber) {
        return "Too high!"
    } else {
        return "That's it! You're correct!";
    }
}