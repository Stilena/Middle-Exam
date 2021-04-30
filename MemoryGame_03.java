import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        int count = 0;
        while (!command.equals("end")) {
            String[] tokens = command.split(" ");
            int indexOne = Integer.parseInt(tokens[0]);
            int indexTwo = Integer.parseInt(tokens[1]);
                count++;

                if (indexOne < 0 || indexTwo < 0 || indexOne > numbers.size() - 1 || indexTwo > numbers.size() - 1) {
                    for (int j = 0; j <count ; j++) {
                        String add = "-" + count + "a";
                        numbers.add(numbers.size() / 2, add);
                    }
                    System.out.println("Invalid input! Adding additional elements to the board");

                }else if (numbers.get(indexOne).equals(numbers.get(indexTwo))) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", numbers.get(indexOne));
                    if (indexOne>indexTwo){
                        numbers.remove(indexOne);
                        numbers.remove(indexTwo);
                    }else {
                        numbers.remove(indexTwo);
                        numbers.remove(indexOne);
                    }

                }else if(!numbers.get(indexOne).equals(numbers.get(indexTwo))){
                    System.out.println("Try again!");
                }

            if (numbers.size() <= 0) {
                System.out.printf("You have won in %d turns!", count);
                break;

            }

            command = scanner.nextLine();
    }
        if (numbers.size() > 0) {
            System.out.println("Sorry you lose :(");
        }
        for (String number : numbers) {
            System.out.print(number + " ");
        }

        }
    }

/*package FUNDAMENTALS.MID_EXAM.I;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME03_MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequence = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();
        int count = 0;

        while (!"end".equals(input)) {
            String[] tokens = input.split(" ");
            int firstIndex = Integer.parseInt(tokens[0]);
            int secondIndex = Integer.parseInt(tokens[1]);
            count++;

            if (firstIndex == secondIndex || firstIndex < 0 ||
            secondIndex < 0 || firstIndex >= sequence.size() ||
            secondIndex >= sequence.size()) {
                System.out.println("Invalid input! Adding additional elements to the board");
                int index = sequence.size() / 2;
                String element = "-" + count + "a";
                sequence.add(index, element);
                sequence.add((index + 1), element);

            } else if (sequence.get(firstIndex).equals(sequence.get(secondIndex))) {
                System.out.printf("Congrats! You have found matching elements - %s!%n", sequence.get(firstIndex));
                sequence.set(firstIndex, "delete");
                sequence.remove(secondIndex);
                sequence.remove("delete");

            } else if (!sequence.get(firstIndex).equals(sequence.get(secondIndex))) {
                System.out.println("Try again!");

            }

            if (sequence.size() <= 0) {
                System.out.printf("You have won in %d turns!", count);
                break;
            }

            input = scanner.nextLine();
        }

        if (sequence.size() > 0) {
            System.out.println("Sorry you lose :(");
        }
        for (String s : sequence) {
            System.out.print(s + " ");
        }

    }
}
}*/