import java.util.Random;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true)
        {
            System.out.println("Press enter to roll the dice...");
            scanner.nextLine();

            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            int sum = dice1 + dice2;

            System.out.println("You rolled: " + dice1 + " + " + dice2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12)
            {
                System.out.println("Craps! You lose.");
                if (!playAgain(scanner))
                {
                    break;
                }
            } else if (sum == 7 || sum == 11)
            {
                System.out.println("Natural! You win.");
                if (!playAgain(scanner))
                {
                    break;
                }
            }
            else
            {
                int point = sum;
                System.out.println("Point is " + point);
                while (true)
                {
                    System.out.println("Press enter to roll the dice...");
                    scanner.nextLine();

                    dice1 = random.nextInt(6) + 1;
                    dice2 = random.nextInt(6) + 1;
                    sum = dice1 + dice2;

                    System.out.println("You rolled: " + dice1 + " + " + dice2 + " = " + sum);

                    if (sum == point)
                    {
                        System.out.println("You made the point! You win.");
                        if (!playAgain(scanner))
                        {
                            break;
                        }
                    }
                    else if (sum == 7) {
                        System.out.println("Seven! You lose.");
                        if (!playAgain(scanner))
                        {
                            break;
                        }
                    }
                    else
                    {
                        System.out.println("Trying for point...");
                    }
                }
            }
        }
    }

    private static boolean playAgain(Scanner scanner)
    {
        System.out.println("Do you want to play again? (Y/N)");
        String input = scanner.nextLine().toUpperCase();
        return input.equals("Y");
    }
}
