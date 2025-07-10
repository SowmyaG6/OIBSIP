import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 100;
    public static final int MAX_ATTEMPTS = 10;
    public static final int MAX_ROUNDS = 3;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int totalScore = 0;

        System.out.println("WELCOME TO NUMBER GUESSING GAME\n");
        System.out.println("Total Number of Rounds: " + MAX_ROUNDS);
        System.out.println("Number of Attempts for each round: " + MAX_ATTEMPTS + "\n");

        for (int i = 1; i <= MAX_ROUNDS; i++) {
            int number = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            int currentAttempts = 0;
            System.out.printf("Round %d: Guess the number between %d and %d in %d attempts.\n", i, MIN_RANGE, MAX_RANGE, MAX_ATTEMPTS);

            boolean guessedCorrectly = false;

            while (currentAttempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int guessNumber = sc.nextInt();
                currentAttempts++;

                if (guessNumber == number) {
                    int score = MAX_ATTEMPTS - currentAttempts + 1;
                    totalScore += score;
                    System.out.printf("✅ Congrats! You guessed the number in %d attempt(s). Round Score: %d\n\n", currentAttempts, score);
                    guessedCorrectly = true;
                    break;
                } else if (guessNumber < number) {
                    System.out.printf("🔼 The number is greater than %d. Attempts left: %d\n", guessNumber, MAX_ATTEMPTS - currentAttempts);
                } else {
                    System.out.printf("🔽 The number is less than %d. Attempts left: %d\n", guessNumber, MAX_ATTEMPTS - currentAttempts);
                }
            }

            if (!guessedCorrectly) {
                System.out.printf("❌ You lost Round %d. The correct number was: %d\n\n", i, number);
            }
        }

        System.out.printf("🏁 Game Over! Your Total Score: %d\n", totalScore);
        sc.close();
    }
}