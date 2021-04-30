import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String text = tokens[0];
            int index = Integer.parseInt(tokens[1]);
            int secondIndex = Integer.parseInt(tokens[2]);
            if (text.equals("Shoot")) {
                if (numbers.size() > index && index >= 0) {
                    int shoot=numbers.get(index);
                    shoot-=secondIndex;
                    if (shoot <= 0) {
                        numbers.remove(index);
                    } else {
                        numbers.set(index, shoot);
                    }
                }
            } else if (text.equals("Add")) {
                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, secondIndex);
                    }else{
                        System.out.println("Invalid placement!");
                        break;
                    }
                } else if (text.equals("Strike")) {
                int leftRadius = Math.max(index - secondIndex, -1);
                int rightRadius = Math.min(index + leftRadius, numbers.size() - 1);
                if (leftRadius >= 0 && rightRadius < numbers.size() - 1) {
                    numbers.remove(index);
                    numbers.subList(leftRadius, rightRadius - leftRadius + 1).clear();
                } else {
                        System.out.println("Strike missed!");
                    }

                }
                command = scanner.nextLine();

        }
            for (Integer number : numbers) {
                //  number = number.replaceAll("\\,\\s+", "");
                if (!(numbers.indexOf(number) == numbers.size() - 1)) {
                    System.out.print(number + "|");
                } else {
                    System.out.print(number);
                }
            }

    }
}
/*import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovingTarget_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String printTargets = scanner.nextLine();
        String[] partsTargets = printTargets.split("\\s+");

        List<Integer> targets = new ArrayList<>();
        for (String currentSection : partsTargets) {
            int sectionInt = Integer.parseInt(currentSection);
            targets.add(sectionInt);
        }

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] command = input.split("\\s+");
            String argument = command[0];
            int index = Integer.parseInt(command[1]);

            switch (argument) {
                case "Shoot":
                    int power = Integer.parseInt(command[2]);
                    if (isValid(targets, index)) {
                        int shootSection = targets.get(index);
                        shootSection -= power;
                        if (shootSection <= 0) {
                            targets.remove(index);
                        } else {
                            targets.set(index, shootSection);
                        }
                    }
                    break;
                case "Add":
                    int value = Integer.parseInt(command[2]);
                    if (isValid(targets, index)) {
                        targets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(command[2]);
                    int leftRadius = Math.max(index - radius, -1);
                    int rightRadius = Math.min(index + leftRadius, targets.size() - 1);
                    if (leftRadius >= 0 && rightRadius < targets.size() - 1) {
                        targets.remove(index);
                        targets.subList(leftRadius, rightRadius - leftRadius + 1).clear();
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(targets.toString().replaceAll("[\\[\\],]", "")
                .replaceAll(" ", "|"));
    }

    private static boolean isValid(List<Integer> targets, Integer index) {
        return index >= 0 && index < targets.size();
    }
}*/
