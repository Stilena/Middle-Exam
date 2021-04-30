import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWinn_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       int[] numbers = Arrays.stream(scanner.nextLine().split( " "))
       .mapToInt(e->Integer.parseInt(e))
       .toArray();
        String command = scanner.nextLine();
        int countOfTheShotTarget = 0;
        while (!command.equals("End")) {
            int index = Integer.parseInt(command);
            if (index <= numbers.length - 1) {
                for (int i = 0; i < numbers.length-1; i++) {
                    int currentDigit = numbers[index];
                    numbers[index]=-1;
                    if (numbers[i]!=-1 && i != currentDigit) {
                        if (numbers[i] > currentDigit) {
                            numbers[i] -= currentDigit;
                        } else if (numbers[i] <= currentDigit) {
                            numbers[i] += currentDigit;
                        }
                     }
               }
            countOfTheShotTarget++;
            }
            command = scanner.nextLine();
        }
            System.out.printf("Shot targets: %d", countOfTheShotTarget);
        System.out.print(" -> ");
        for (int number : numbers) {
            System.out.print(number+ " ");
        }
    }
}