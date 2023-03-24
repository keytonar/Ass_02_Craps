import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int WINNING_SCORE = 7;
    private static final int LOSING_SCORE = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int point = 0;
        int score = 0;
        boolean isPlaying = true;

        while (isPlaying) {
            System.out.println("Press enter to roll the dice...");
            scanner.nextLine();

            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            int total = dice1 + dice2;

            System.out.printf("You rolled %d + %d = %d\n", dice1, dice2, total);

            if (point == 0) {
                switch (total) {
                    case 7:
                    case 11:
                        System.out.println("You win!");
                        isPlaying = false;
                        break;
                    case 2:
                    case 3:
                    case 12:
                        System.out.println("You lose!");
                        isPlaying = false;
                        break;
                    default:
                        point = total;
                        System.out.printf("Your point is %d\n", point);
                        break;
                }
            } else {
                if (total == point) {
                    System.out.println("You win!");
                    isPlaying = false;
                } else if (total == LOSING_SCORE) {
                    System.out.println("You lose!");
                    isPlaying = false;
                }
            }
        }
    }
}
