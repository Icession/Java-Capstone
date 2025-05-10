import java.util.Random;

public class NumberGame extends Game{
    private int targetNumber; //the number the player trying to guess
    private int attempts; //the number the player is attempting;
    private int min; //the minimum number
    private int max; //the maximum number
    private Random random = new Random();


    public NumberGame(int attempts, int min, int max){
        this.attempts = attempts;
        this.min = min;
        this.max = max;
        generateNum();
    }
    

    public void generateNum(){
        targetNumber = random.nextInt(max - min + 1) + min;
    }

    String checkGuess(int guess){
        attempts++;
        if(guess < targetNumber) return "Too low!";
        else if (guess > targetNumber) return "Too high!";
        else if(guess == targetNumber){
             Score score = new Score();
            score.countScore(attempts);
            return "You guessed the number!";
        } else {
            return "Invalid guess";
        }
    }
    @Override
    public int getAttempts(){
        return attempts;
    }

    @Override
    public void resetGame() {
        attempts = 0;
        generateNum();
    }
}
