import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] tokens = command.split("\\s+");
            String currentCommand = tokens[0];
            if (currentCommand.equals("swap")) {
                int index = Integer.parseInt(tokens[1]);
                int secondIndex = Integer.parseInt(tokens[2]);
                int temp = 0;
                temp=numbers[index];
                numbers[index] = numbers[secondIndex];
                numbers[secondIndex] = temp;
            } else if (currentCommand.equals("multiply")) {
                int index = Integer.parseInt(tokens[1]);
                int secondIndex = Integer.parseInt(tokens[2]);
                numbers[index] =  numbers[index] * numbers[secondIndex];
            } else if (currentCommand.equals("decrease")) {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] -= 1;
                }
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < numbers.length ; i++) {
            if (i<numbers.length-1){
                System.out.print(numbers[i]+", ");
            }else{
                System.out.print(numbers[i]);
            }

        }
    }
}
