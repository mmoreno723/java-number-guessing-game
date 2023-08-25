import java.util.Random;

public class NumberGuessingGame {
    private int randomNumber;
    private Random random;

    public NumberGuessingGame() {
        random = new.Random();
        randomNumber = random.nextInt(100) + 1;
    }
}