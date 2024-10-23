import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean continuePlaying = true;

        while (continuePlaying) {
            System.out.println("\nRolling the dice...");
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;
            System.out.printf("Die 1: %d, Die 2: %d, Sum: %d\n", die1, die2, sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                int point = sum;
                System.out.printf("The point is now %d. Trying for point...\n", point);

                boolean pointMade = false;
                while (!pointMade) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.printf("Die 1: %d, Die 2: %d, Sum: %d\n", die1, die2, sum);

                    if (sum == point) {
                        System.out.println("Made the point! You win.");
                        pointMade = true;
                    } else if (sum == 7) {
                        System.out.println("Got a seven. You lose.");
                        pointMade = true;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            boolean validResponse = false;
            while (!validResponse) {
                System.out.print("Do you want to play again? (yes/no): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("yes")) {
                    validResponse = true;
                } else if (response.equalsIgnoreCase("no")) {
                    validResponse = true;
                    continuePlaying = false;
                } else {
                    System.out.println("Please enter 'yes' or 'no'.");
                }
            }
        }
        scanner.close();
    }
}
